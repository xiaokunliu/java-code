#### Docker基础小结

#### 环境准备
* VirtualBox -- 傻瓜式安装
* Vagrant   -- 傻瓜式安装
* box镜像下载
    * vagrant: https://app.vagrantup.com/ 
    * ubuntu：http://cloud-images.ubuntu.com/
    * centos：https://cloud.centos.org/centos/7/
* 配置与启动
```text
## build Vagrantfile
vagrant init 

## config Vagrantfile
Vagrant.configure("2") do |config|
  config.vm.box = "ubuntu/trusty64"
  config.vm.network = "public_network"
  config.vm.provider "virtualbox" do |vb|
        vb.memory = "2048"
        vb.name = "keithl-ubuntu"
        vb.cpus = 2
  end
end

## download box 

## start linux with box
vagrant box add ubuntu/trusty64 ./virtualbox.box
vagrant up

## 进入box
vagrant ssh

## 退出
exit

## 关闭
vagrant halt

## 基于现有的镜像创建一个新的镜像
vagrant package --output docker-ubuntu.box

## 再基于上面的镜像创建box并启动
vagrant box add ubuntu/docker-ubuntu ./docker-ubuntu.box
vagrant up
```

##### Docker三大核心概念
* Docker 镜像
* Docker 容器
* Docker 仓库

##### Docker操作镜像


##### Docker操作容器


##### Docker仓库使用


##### Docker持久化


##### Docker容器网络互联


##### 基于Dockerfile构建镜像

