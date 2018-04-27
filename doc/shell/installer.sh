#!/usr/bin/env bash
java -version

# linux
sdk install gradle 4.1

# macos
brew update && brew install gradle

# window
scoop install gradle

# 执行spring-boot并指定命令行参数
java -jar spring-demo.jar --spring.profiles.active=prod