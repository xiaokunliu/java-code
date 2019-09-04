#!/usr/bin/env bash

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"
BASE_DIR="$DIR/../"
cd $BASE_DIR
pwd
# restart server
pid="$(ps -aux | grep admin-1.0.0.jar | grep -v grep | awk '{print $2}')"
kill -9 $pid
nohup java -classpath ".:/lib/*" -jar admin-1.0.0.jar -Dlog4j2.contextSelector=org.apache.logging.log4j.core.async.AsyncLoggerContextSelector --server.port=9000 &
tail -f nohup.out