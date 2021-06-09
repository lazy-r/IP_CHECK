#!/bin/bash
mvn -U -am clean package
docker rm -f ip_test
docker rmi -f ip_test:v1
docker build -t ip_test:v1 .
docker run -d --name="ip_test" -p 9090:9090 ip_test:v1
docker cp ./ip2region.db ip_test:/
