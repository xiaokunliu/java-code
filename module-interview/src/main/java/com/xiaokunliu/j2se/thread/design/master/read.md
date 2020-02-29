##### Master And Worker 模式

常用的并行计算模式,核心思想是由两类进程进行协作工作,Master进程和Worker进程,Master负责接收和分配任务,
Worker负责处理子任务,当各个子进程处理完成之后,会将结果返回给Master,由Master做总结和归纳
