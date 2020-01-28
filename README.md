# Sample SpringBoot on Openshift

* [Sample SpringBoot application with Kafka](https://www.confluent.io/blog/apache-kafka-spring-boot-application/)
* [Installing Kafka with homebrew](https://www.mongodb.com/blog/post/mongodbs-official-brew-tap-now-open-and-flowing)
* [Spring Cloud Kubernetes sample](https://www.baeldung.com/spring-boot-deploy-openshift)

## Running MongoDB locally

```
$ brew services start mongodb-community
$ brew services stop mongodb-community
```

You can run the MongoDB shell - mongo

## Running Kafka locally

```
==> zookeeper
To have launchd start zookeeper now and restart at login:
  brew services start zookeeper
Or, if you don't want/need a background service you can just run:
  zkServer start
==> kafka
To have launchd start kafka now and restart at login:
  brew services start kafka
Or, if you don't want/need a background service you can just run:
  zookeeper-server-start /usr/local/etc/kafka/zookeeper.properties & kafka-server-start /usr/local/etc/kafka/server.properties
```

## Testing

```
curl -X POST "http://localhost:9000/kafka/publish?name=marcelo&age=48"
```