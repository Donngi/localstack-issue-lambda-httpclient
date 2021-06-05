# README

## How to
Start localstack.

```
$ docker-compose up
```

Compile java with maven.

```
$ mvn clean package
```

Deploy a lambda function to localstack.

```
$ aws lambda create-function --function-name=SampleFunction --runtime=java11 --role=dummy --handler=org.example.Handler --zip-file fileb://target/localstack-issue-lambda-httpclient-1.0-SNAPSHOT.jar --endpoint-url=http://localhost:4566
```

Invoke function.

```
$ aws lambda invoke --function-name SampleFunction --payload '{}' --cli-binary-format raw-in-base64-out --endpoint-url=http://localhost:4566 result.log
```