#!/usr/bin/env bash

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"
BASE_DIR="$DIR/../"
cd $BASE_DIR

if [[ $1 = 'sit' ]]; then
    echo "package jar to sit"
    git status
    git pull && git checkout develop && git pull origin develop
    mvn clean package -Psit -DskipTests
    scp -r $BASE_DIR/src/main/resources/templates/* root@47.92.255.177:/root/Projects/tpp_backend/tpp_admin_static
    scp -r $BASE_DIR/target/admin-1.0.0.jar $BASE_DIR/target/lib root@47.92.255.177:/root/Projects/tpp_backend/tpp_admin
elif [[ $1 = 'prod' ]]; then
    echo "package jar to prod"
    git status
    git pull && git checkout master && git pull origin master
    mvn clean package -Pprod -DskipTests
    scp -r $BASE_DIR/src/main/resources/templates_prod/* root@47.112.98.195:/root/Projects/wasabi_backend/admin/static
    scp -r $BASE_DIR/target/admin-1.0.0.jar $BASE_DIR/target/lib root@47.112.98.195:/root/Projects/wasabi_backend/admin
else
    git status
    git pull && git checkout develop && git pull origin develop
    echo "package jar to local"
    mvn clean package -Plocal
fi