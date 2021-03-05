# false-sharing

## Build
```shell script
mvn clean package
docker build -t false-sharing .
```

## Run
Benchmark class affected by false-sharing:
```shell script
 docker run --cap-add SYS_ADMIN \
  false-sharing \
  java -jar -XX:-RestrictContended /opt/app/app.jar \
  FalseSharingBenchmark
```

Benchmark class with @Contended annotation:
```shell script
 docker run --cap-add SYS_ADMIN \
  false-sharing \
  java -jar -XX:-RestrictContended /opt/app/app.jar \
  ContendedBenchmark
```

Run all benchmarks:
```shell script
 docker run --cap-add SYS_ADMIN \
  false-sharing \
  java -jar -XX:-RestrictContended /opt/app/app.jar
```