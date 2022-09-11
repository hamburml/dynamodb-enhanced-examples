1. Build https://github.com/hamburml/quarkus-amazon-services/tree/feature/DynamoDbEnhancedModule locally (mvn install)
2. docker run --rm --publish 8000:8000 amazon/dynamodb-local:1.19.0 -jar DynamoDBLocal.jar -inMemory -sharedDb
3. build dynamodb-enhanced-brokentest (this does not use dynamodb-enhanced module -> get noClassDefFound Error when in test or dev-mode)
4. build dynamodb-enhanced-test (error is gone)