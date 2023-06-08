# Kafka within Docker

## 0-1. Docker-compose(Kafka, Zookeeper) 실행
``` bash
docker-compose-v1.exe -f .\kafka-compose.yml up
```
## 0-2. Docker-compose(Kafka, Zookeeper) 종료
``` bash
docker-compose-v1.exe -f .\kafka-compose.yml down
```
## 1. Order Topic 생성
```bash
#TOPIC_NAME1="order.create"
#TOPIC_NAME2="order.cancel"
docker exec kafka-0 kafka-topics.sh --create --topic "order.create" --bootstrap-server localhost:9092
docker exec kafka-0 kafka-topics.sh --create --topic "order.cancel" --bootstrap-server localhost:9092
```
