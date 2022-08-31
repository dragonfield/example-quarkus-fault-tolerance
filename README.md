# example-quarkus-fault-tolerance
Quarkus の [SmallRye Fault Tolerance](https://ja.quarkus.io/guides/smallrye-fault-tolerance) のタイムアウトのサンプルです。

## 起動方法
以下のコマンドで Quarkus を起動します。

```
./mvnw quarkus:dev
```

## 実行方法
delay にスリープさせる秒数を指定して実行します。5 秒以上スリープさせた場合、Timeout が発動します。

```
curl -v http://localhost:8080/timeout?delay=4
```
