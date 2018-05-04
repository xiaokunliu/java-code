#!/bin/bash

nohup java -server -Xms216M -Xmx512M -Djava.awt.headless=true -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:CMSInitiatingOccupancyFraction=75 -XX:+UseCMSInitiatingOccupancyOnly -XX:+HeapDumpOnOutOfMemoryError -XX:+DisableExplicitGC -jar cs-httprest.jar 8001 1>ok.log 2>error.log &