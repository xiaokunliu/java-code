package com.xiaokunliu.j2ee;

/**
 * project:keithl
 * file:JTA
 * package:com.xiaokunliu.database
 * date:2018/8/12 下午5:05
 * author:keithl
 */
public class JTA {

    /**
     * JTA:Java Transaction API,提供事务划分标准的接口，尤其是应用程序执行两个需要依赖于不同数据库的操作时，则需要将两个操作当作一个全局的事务
     * JTA提供的接口：由3个接口UserTransaction/Transaction/TransactionManager组成
     * 事务具备ACID，原子性，一致性，隔离性和持久性
     * 原子性：事务是应用中最小执行单位，即是应用中不可再分的最小逻辑执行体
     * 一致性：在同一个事务下的所有操作，要么全部成功，要么全部失败，不存在部分成功和失败的情况，这样才能保证数据库的数据一致性
     * 隔离性：各个事务是相互独立的，也就是说并发执行的事务之间不能看到对方的中间状态，且不能相互影响
     * 持久性：事务一旦提交，对数据做的任何改变都要记录到永久的存储器中，也就是持久化磁盘文件上，或者是保存到物理数据库中
     *
     * 事务隔离性：所谓隔离性也就意味着数据库如何处理并发操作的问题，当多个操作或者是事务操作同一个数据时，可能引起的访问冲突和数据库的不一致性
     * 1. TRANSACTION_NONE:对事务和数据不进行任何隔离级别设置
     * 2. TRANSACTION_READ_UNCOMMITTED:允许事务A读取另一个事务B未提交的数据，即事务B的操作更新到数据库中，但是未提交，此时事务A可以读取未提交的数据，如果事务B回滚则会变成脏读
     * 3. TRANSACTION_READ_COMMITTED:事务读取到的数据都是已经提交的数据，但是存在不可重复读，即事务A在步骤n1读取数据库的数据，然后在步骤n2再次读取数据库，在n1-n2过程事务B更新（update）了数据库并提交，那么会导致事务A前后读取出来的数据不一致，也就是说要保证事务A不可重复读取
     * 4. TRANSACTION_REPEATABLE_READ:可重复读取的隔离，即上述的事务B进行update前后读取的数据都是一致性，但是如果事务B存在insert或者delete操作将出现数据不一致，导致幻读
     * 5. TRANSACTION_SERIALIZABLE:代表真正的可串行化的事务，不会出现脏读，不可重复读，幻读
     *
     * 事务属性：用于控制事务的作用域
     * @Transactional(propagation=Propagation.REQUIRED) ：如果有事务, 那么加入事务, 没有的话新建一个(默认情况下)
    　　@Transactional(propagation=Propagation.NOT_SUPPORTED) ：容器不为这个方法开启事务
    　　@Transactional(propagation=Propagation.REQUIRES_NEW) ：不管是否存在事务,都创建一个新的事务,原来的挂起,新的执行完毕,继续执行老的事务
    　　@Transactional(propagation=Propagation.MANDATORY) ：必须在一个已有的事务中执行,否则抛出异常
    　　@Transactional(propagation=Propagation.NEVER) ：必须在一个没有的事务中执行,否则抛出异常(与Propagation.MANDATORY相反)
    　　@Transactional(propagation=Propagation.SUPPORTS) ：如果其他bean调用这个方法,在其他bean中声明事务,那就用事务.如果其他bean没有声明事务,那就不用事务.
     *
     * JavaEE应用中的事务：
     * 局部事务：Local Transaction Processing，仅操作一个数据库
     * 分布式事务：Distributed Transaction Processing，DTP
     *
     * 分布事务的核心点：就是保证程序操作对多个数据库的动作可以作为一个整体，要么全部提交，要么全部回滚，这样才能保证业务逻辑跨越多个数据库资源的时候能让
     * 多个数据库的数据保持一致
     *
     * 分布式事务解决方案是使用XA规范
     * 应用程序AP，事务管理器TM，资源管理RM，通信资源管理器CRM
     * 事务管理器TM：事务中间件，应用服务器
     * 资源管理器RM：数据库
     * 通信资源管理器CRM：消息中间件
     *
     * XA规范的理论基础 -- 两阶段提交（2 Phase Commit），2PC
     *  1. 应用程序面向事务管理器编程，应用程序调用事务管理器的预提交
     *  2. 事务管理器通知参与全局事务的每个数据库，告诉它们准备开始提交的事务 -- 第一个阶段从现在开始
     *  3. 参与全局事务的各个数据库进行局部事务的预提交
     *  4. 事务管理器收集到各个数据库预提交的结果
     *  5. 第二阶段开始，事务管理器收集到所有参与全局事务预提交的结果之后作出相应的判断，即如果操作中所有都成功，则事务管理器则发送所有实际提交的命令到数据库中执行命令，如果其中一个
     *  失败，则发送回滚命令到各个数据库中执行回滚操作
     *
     *  JTS：Java事务服务（Java Transaction Service）来实现事务管理器，由JTA调用底层ITS进行处理，是面向JTA方法调用
     *  目的：使用JTS来保证JTA全局事务多数据库的一致性
     *
     *  EJB事务管理
     *      容器管理事务（CMT）：使用容器管理事务策略
     *      Bean事务管理（BMT）：BMT事务管理策略可由开发者来决定业务方法中的事务边界，开发者可通过代码灵活指定事务划分的细节
     *
     *  事务超时设置
     */
}
