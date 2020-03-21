package com.xiaokunliu.interview.j2ee;

import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

interface Server extends Remote {
    //rmi 服务

    /**
     * 远程调用方法会通过网络进行传输，而当网络不可靠的时候，需要抛出RemoteException异常来报告远程调用过程中的错误
     *
     * @param name
     * @return
     * @throws RemoteException
     */
    String queryString(String name) throws RemoteException;
}


interface RMIServer extends Remote {

    void passMessage(RMIClient client, String message);
}

// 客户端的远程服务同样要继承Remote
interface RMIClient extends Remote {

    // 定义一个允许远程调用的方法
    void showServerInfo(String message) throws RemoteException;
}

/**
 * project:java-code
 * file:RMI
 * package:com.xiaokunliu.j2ee
 * date:2018/10/2 上午10:40
 * author:keithl
 */
public class RMI {

    // RMI： Remote Method Invoke，远程方法调用，仅是用于两个程序/系统之间都是用java代码实现的业务,封装两个端进行通讯的网络细节

    /**
     * RMI也是需要通过JNDI查找资源并访问远程服务对象
     */

    // 远程访问：网络中的一台计算机可以使用另一台计算机的服务，对象或者方法，效果就像使用本地的服务，对象和方法一样
    // 远程访问通常是面向接口编程

    /**
     * RMI的作用和意义
     *  1。解决网络信息交换问题，采用合适的IO进行网络读写，若在复杂的网络信息交换，一般还需要封装自己的通信协议
     *  2。多线程问题，处理线程同步，安全，死锁等问题
     *  RMI对Socket进行良好的封装，可以直接使用在本地的Java程序调用远程Java方法
     */

    // RMI编程

    // RMI提供接口调用的服务方，需要继承Remote类

    // RMI 原理：底层是依然是依赖socket网络进行通信的，RMI隐藏socket通信细节
    // 客户端调用Java远程对象方法实际是通过调用Java方法的代理类Stub，RMI技术使用代理模式完成编程
    /**
     *  1。本地客户端调用远程服务对象的方法 -- 调用Stub对象的方法
     *  2。Stub对象实际上就是远程服务对象在客户端的代理，Stub对象会对调用请求进行编码，保证远程调用请求可以在网络上传输，所以这一步要求远程调用的方法参数都是可以序列化的
     *  3。通过底层网络传输将请求传递到Skeleton
     *  4。Skeleton收到Stub通过网络传输过来的调用请求之后，Skeleton对请求进行解码，将请求转换为满足远程服务对象要求的请求
     *  5。Skeleton将解码后的请求发送到远程服务对象，让远程服务对象负责处理调用请求
     *  6。Skeleton收到远程服务对象的执行结果（就是方法返回值）后，再次对执行结果进行编码，因此这一步也需要要求RMI方法返回的结果必须都是可序列化的
     *  7。通过底层网络传输将处理结果送到Stub。
     *  8。Stub解码处理结果
     *  9。Stub将解码后的符合本地客户端要求的结果传送到本地客户端
     */

    // 当客户端调用服务端方法之后，服务端会对客户端的方法进行调用 -- 回调
}

class Message implements Serializable {
    // 进行数据库存储或者网络传输必须要实现序列化
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}


// ================================================================================================================

// 客户端没有进行JNDI绑定，服务端得通过传递参数的方式进行调用客户端方法，即客户端调用远程服务端的方法时候，应当将自身对象实例当作参数进行传递，

// 实现接口暴露远程服务
class ServerImpl extends UnicastRemoteObject implements Server {

    // 默认构造却必须抛出异常
    public ServerImpl() throws RemoteException {

    }

    public static void main(String[] args) throws Exception {
        // 创建远程服务类实例
        Server server = new ServerImpl();
        // 注册远程服务端口
        // 1. 命令行中使用jdk注册RMI服务的工具rmiregistry
//            rmiregistry <port>
        LocateRegistry.createRegistry(1099);
        // 将远程服务实例绑定为远程服务
        Naming.rebind("rmi://:1099/keithl", server);

    }

    @Override
    public String queryString(String name) {
        return null;
    }

    /**
     * 服务端
     * 开发远程服务调用的接口：
     *     1. 定义远程服务接口,并且接口返回值必须有一个要求就是实现序列化接口
     *     2. 编写接口实现类，并继承UnicastRemoteObject基类
     *     3. 编写运行程序的main，即程序入口并通过JNDI绑定服务
     */
}

class Client {
    // RMI 客户端

    public static void main(String[] args) throws Exception {
        // 通过jdni查找服务
        Server server = (Server) Naming.lookup("rmi://1099/keithl");

        // 调用远程方法
        server.queryString("xiaoxiao");
    }
}

// 使用客户端提供远程方法给服务端进行回调，一般是两个服务之间的相互调用

class RMIServerImpl extends UnicastRemoteObject implements RMIServer {

    public RMIServerImpl() throws RemoteException {

    }

    public static void main(String[] args) throws Exception {
        RMIServer server = new RMIServerImpl();
        // 注册远程服务端口
        // 1. 命令行中使用jdk注册RMI服务的工具rmiregistry
//            rmiregistry <port>
        LocateRegistry.createRegistry(1099);
        // 将远程服务实例绑定为远程服务
        Naming.rebind("rmi://127.0.0.1:1099/keithl", server);
    }

    @Override
    public void passMessage(RMIClient client, String message) {
        System.out.println("the client pass message is " + message);
        try {
            // 回调客户端方法
            client.showServerInfo("the server message from postMessage method");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ClientImpl implements RMIClient {

    public static void main(String[] args) throws Exception {
        // 客户端没有固定IP，无须执行绑定，
        RMIClient client = new ClientImpl();
        // 将远程服务对象暴露出来
        UnicastRemoteObject.exportObject(client, 1099);
        RMIServer server = (RMIServer) Naming.lookup("rmi://127.0.0.1:1099/keithl");
        // 调用服务端端口
        server.passMessage(client, "client message ....");
    }

    @Override
    public void showServerInfo(String message) {
        System.out.println(String.format("call server info:%s", message));
    }
}


