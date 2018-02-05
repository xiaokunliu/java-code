#### 用户和用户组管理
##### 用户管理

> 用户帐号添加

```shell
useradd [option] [username]
# 执行上述命令后会做的事情
1. 在/etc/passwd文件中新增一行记录
2. 在/home目录下创建新用户的主目录,并将/etc/skel目录中的文件复制到该目录中

option:
-g:用于添加用户帐号时指定用户的私有组
-d:指定用户的主目录,若不存在,则同时使用-m选项来创建主目录
-m:使用者目录不存在,则自动建立
-u:指定用户的用户号
```

> 修改用户帐号

```shell
# 不要使用这个命令修改用户密码,因为会保存在/etc/shadow是明文,应当使用passwd 来修改密码
usermod [option] username
option:
-d:修改用户登入的目录
-l:变更用户登录时的名称为login_name
-s:指定用户登录的shell,如果不设置,这选用系统预设的shell
```

> 删除用户帐号命令

```shell
userdel -r username
-r:表示删除用户的同时也将存储在/home目录下的该用户目录和文佳一起删除
```

> 用户口令管理命令

```shell
passwd [option] username
# 一般只使用passwd username
```

##### 用户组管理
> 用户组添加命令

```shell
groupadd [option] groupname     # 可以在/etc/group的目录中查看到GID为666的用户组groupname
option:
-r:加入组GID号,且GID号低于499的系统帐号
-f:表示新增一个已经存在的用户组帐号时,系统会出现错误新溪,然后结束
-o GID:运行的GID不唯一
-g GID:GID必须唯一并且为非负数
```

> 用户组修改命令

```shell
groupmod [option] groupname 
# option
-g GID:用户指定新的GID
-o GID:重复使用GID
-n:为群组改名
```

> 用户组删除命令

```shell
groupdel groupname
# 删除用户组之前如果该用户组下有用户,必须先删除用户再删除用户组
```

##### 文件和目录操作

> 文件清单

```shell
ls [option] [file or dir]
option:
-a:显示指定目录下的所有子目录与文件,包括隐藏文件
-A:同-a,但是不显示'.'和'..'
-c:按文件的修改时间排序
-l:每行列出详细信息,依次是:文件类型与权限、链接数、文件属性、文件属组、文件大小、最近修改时间、名字
-i:在输出的第一列中显示文件的i节点号
```

> 文件复制

```shell
cp [option] [source] [dest]
option:
-f:删除已经存在的目标文件而不提示
-r:将递归复制该目录下的所有子目录和文件,此时目标文件必须为一个目录名
```

> 文件移动

```shell
mv [option] [source] [dest]
option:
-p:移动时保持权限
```

<!--TODO-->