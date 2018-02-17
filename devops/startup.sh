#!/bin/bash
nohup java -jar target/spring-petclinic-1.5.1.jar > startup.log 2>&1 &
echo $! > petclinic.pid
while [ -z "$(tail startup.log | grep 'Started PetClinicApplication in')" ]; do
	echo "Deploying process"
	sleep 1
done 