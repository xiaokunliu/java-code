#### 面向切面编程AOP
##### AOP基础概念

> 通知Advice(定义切面的what和when)

* 前置通知（Before）：在目标方法被调用之前调用通知功能；
* 后置通知（After）：在目标方法完成之后调用通知，此时不会关心方法的输出是什么；
* 返回通知（After-returning）：在目标方法成功执行之后调用通知；
* 异常通知（After-throwing）：在目标方法抛出异常后调用通知；
* 环绕通知（Around）：通知包裹了被通知的方法，在被通知的方法调用之前和调用之后执行自定义的行为

```text
// spring内部执行的核心代码
```
> 连接点join point

```text
连接点是在应用执行过程中能够插入切面的一个点。这个点可以是调用方法时、抛出异常时、甚至修改一个字段时。切面代码可以利用这些点插入到应用的正常流程之中，并添加新的行为
```

> 切点pointcut(定义切面的where)

```text
切点的定义会匹配通知所要织入的一个或多个连接点。我们通常使用明确的类和方法名称，或是利用正则表达式定义所匹配的类和方法名称来指定这些切点。
有些AOP框架允许我们创建动态的切点，可以根据运行时的决策（比如方法的参数值）来决定是否应用通知.
```

> 切面

```text
切面是通知和切点的结合。通知和切点共同定义了切面的全部内容——它是什么，在何时和何处完成其功能
```

> 引入

```text
引入允许我们向现有的类添加新方法或属性 
```

> 织入

```text
织入是把切面应用到目标对象并创建新的代理对象的过程.切面在指定的连接点被织入到目标对象中。在目标对象的生命周期里有多个点可以进行织入.
## 织入过程
编译期：切面在目标类编译时被织入。这种方式需要特殊的编译器。AspectJ的织入编译器就是以这种方式织入切面的
类加载期：切面在目标类加载到JVM时被织入。这种方式需要特殊的类加载器（ClassLoader），它可以在目标类被引入应用之前增强该目标类的字节码。AspectJ 5的加载时织入（load-timeweaving，LTW）就支持以这种方式织入切面
运行期：切面在应用运行的某个时刻被织入。一般情况下，在织入切面时，AOP容器会为目标对象动态地创建一个代理对象。Spring AOP就是以这种方式织入切面的
```

##### Spring对AOP的支持

1. 基于代理的经典Spring AOP
2. 纯POJO切面
3. @AspectJ注解驱动的切面
4. 注入式AspectJ切面（适用于Spring各版本）

```text
## 切点表达式
execution(* com.dtreess.spring.core.aop.Performance.perform(..))
*:返回任意类型
com.dtreess.spring.core.aop.Performance:方法所属类
perform:类下定义的方法
(..):方法参数,切点要选择任意的perform()方法，无论该方法的入参是什么

## 使用within()指示器限制切点范围,仅包括 com.dtreess.spring.core.aop下的所有类会被拦截
execution(* com.dtreess.spring.core.aop.Performance.perform(..)) && within( com.dtreess.spring.core.aop.*) 

## 指定bean,指定aop_bean下的名称进行拦截
execution(* com.dtreess.spring.core.aop.Performance.perform(..)) and bean('aop_bean') 

## 非操作,除了bean之外的都拦截
execution(* com.dtreess.spring.core.aop.Performance.perform(..)) and !bean('aop_bean') 
```

