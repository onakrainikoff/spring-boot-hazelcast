# spring-boot-hazelcast

## Run cluster

### Cluster Embedded Local machine
```
mvn clean install
MEMBER_NAME=node1 MEMBER_PORT=5701 CLUSTER_MEMBERS=127.0.0.1:5702,127.0.0.1:5703 java -Dhazelcast.diagnostics.enabled=false -jar target/spring-boot-hazelcast-1.0.local.jar --server.port=8081  --add-modules java.se --add-exports java.base/jdk.internal.ref=ALL-UNNAMED --add-opens java.base/java.lang=ALL-UNNAMED --add-opens java.base/java.nio=ALL-UNNAMED --add-opens java.base/sun.nio.ch=ALL-UNNAMED --add-opens java.management/sun.management=ALL-UNNAMED --add-opens jdk.management/com.sun.management.internal=ALL-UNNAMED
MEMBER_NAME=node2 MEMBER_PORT=5702 CLUSTER_MEMBERS=127.0.0.1:5701,127.0.0.1:5703 java -Dhazelcast.diagnostics.enabled=false -jar target/spring-boot-hazelcast-1.0.local.jar --server.port=8082  --add-modules java.se --add-exports java.base/jdk.internal.ref=ALL-UNNAMED --add-opens java.base/java.lang=ALL-UNNAMED --add-opens java.base/java.nio=ALL-UNNAMED --add-opens java.base/sun.nio.ch=ALL-UNNAMED --add-opens java.management/sun.management=ALL-UNNAMED --add-opens jdk.management/com.sun.management.internal=ALL-UNNAMED
MEMBER_NAME=node3 MEMBER_PORT=5703 CLUSTER_MEMBERS=127.0.0.1:5701,127.0.0.1:5702 java -Dhazelcast.diagnostics.enabled=false -jar target/spring-boot-hazelcast-1.0.local.jar --server.port=8083  --add-modules java.se --add-exports java.base/jdk.internal.ref=ALL-UNNAMED --add-opens java.base/java.lang=ALL-UNNAMED --add-opens java.base/java.nio=ALL-UNNAMED --add-opens java.base/sun.nio.ch=ALL-UNNAMED --add-opens java.management/sun.management=ALL-UNNAMED --add-opens jdk.management/com.sun.management.internal=ALL-UNNAMED
```

### Cluster Embedded docker compose
```
mvn clean install -Ddocker_host=localhost
cd cluster-embeded-docker-compose
docker-compose up -d
```
Management Center:
```
http://localhost:8080
user: admin
pass: q1w2e3r4
```

