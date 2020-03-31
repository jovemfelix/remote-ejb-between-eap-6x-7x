# Build

```shell
mvn clean package
```

## Deploy

```shell
# deploy no EAP-6.4 (that is started with offset 100)
mvn jboss-as:deploy -f server-side/pom.xml -Djboss-as.port=10099
```

