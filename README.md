# DBMS-Lab-Replication

## Execution
```
git clone https://github.com/lomayd/DBMS-Lab-Replication.git

cd ./DBMS-Lab-Replication

[Write down "MYSQL_ROOT_PASSWORD" in docker-compose.yml]

docker-compose up -d

[Configure MySQL Master-Slave DB Replication (Setting method is in docker-compose.yml)]

[Write down "spring.master.password", "spring.slave.password" in /src/main/resources/application.yml]

sudo chmod 777 ./gradlew

./gradlew build

java -jar build/libs/DBMS-Lab-Replication-0.0.1-SNAPSHOT.jar 
```

## Contents
- Master DB For Read, Write Transaction(Insert, Update, Delete)
- Slave DB For Read Transaction(Select)
