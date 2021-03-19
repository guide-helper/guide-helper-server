How to run database in docker

```bash
 sudo docker build -t guide-helper-db .
 sudo docker run --name app-db -p3307:3306 -d guide-helper-db
 sudo docker start app-db
 sudo docker exec -it app-db /bin/bash
```