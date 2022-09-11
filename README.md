1. Build https://github.com/hamburml/quarkus-amazon-services/tree/feature/DynamoDbEnhancedModule locally (mvn install)
2. docker run --rm --publish 8000:8000 amazon/dynamodb-local:1.19.0 -jar DynamoDBLocal.jar -inMemory -sharedDb
3. build dynamodb-enhanced-brokentest (this does not use dynamodb-enhanced module -> get noClassDefFound Error when in test or dev-mode)
4. build dynamodb-enhanced-test (error is gone)

Why with quarkus 1.11.2.Final you ask? With 1.12.0.Final it does not build anymore :( 

import com.oracle.svm.core.annotate.AutomaticFeature;
import com.oracle.svm.reflect.hosted.ReflectionFeature;

Cant be found anymore...