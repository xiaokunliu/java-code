##### maven 细节小结
> 依赖管理
* dependencyManagement
    * 只能出现在pom文件中
    * 统一版本号
    * 声明 (子POM里用到再引)

* dependency之scope说明(优化pom的jar，什么时候用，哪些需要进行打包到项目中，哪些不需要打包)
    * compile: 在项目中需要进行编译并且会打包到项目中，默认方式
    * test：在项目中仅仅起到测试作用，线上不需要引用jar包
    * provided：在项目中需要编译，但是实际项目中不需要依赖，也就是不会打包到项目中
    * runtime：在项目中不需要进行编译，但是程序运行时需要依赖的jar包，这个会打包到项目中
    * system：对于一些第三方依赖的jar，非开源的maven仓库依赖的jar包，比如第三方服务的jar

> 依赖传递性
* maven项目模块依赖传递


* scope的依赖传递


> 版本号管理



> maven 生命周期与插件化开发



