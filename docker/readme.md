# Kafka within Docker

## Topic 생성
```bash
#TOPIC_NAME1="order.create"
#TOPIC_NAME2="order.cancel"
docker exec docker-kafka-0-1 kafka-topics.sh --create --topic "order.create" --bootstrap-server localhost:9092
docker exec docker-kafka-0-1 kafka-topics.sh --create --topic "order.cancel" --bootstrap-server localhost:9092
```
