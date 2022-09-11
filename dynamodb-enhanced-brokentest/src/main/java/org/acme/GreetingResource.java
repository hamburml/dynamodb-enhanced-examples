package org.acme;

import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @Inject
    DynamoDbClient client;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        DynamoDbEnhancedClient client2 = DynamoDbEnhancedClient.builder().dynamoDbClient(client).build();

        TableSchema<Table> schema = TableSchema.fromClass(Table.class);

        DynamoDbTable<Table> myTable = client2.table("myTable", schema);
        myTable.createTable();

        Table item = new Table();
        item.setId("asdf");
        item.setValue("VALUE");
        myTable.putItem(item);
        myTable.deleteTable();

        return "Hello RESTEasy";
    }
}