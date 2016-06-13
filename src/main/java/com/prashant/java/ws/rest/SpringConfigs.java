package com.prashant.java.ws.rest;

import com.amazonaws.auth.AWSCredentialsProviderChain;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBStreams;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBStreamsClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by yprasha on 6/9/16.
 */
@Configuration
public class SpringConfigs {

    @Bean
    public AmazonDynamoDB dynamoDB(){
        AmazonDynamoDB dynamoDB = new AmazonDynamoDBClient();
        dynamoDB.setRegion(Region.getRegion(Regions.US_EAST_1));
        return dynamoDB;
    }

    @Bean
    public AmazonDynamoDBStreams amazonDynamoDBStreams(){
        AmazonDynamoDBStreams amazonDynamoDBStreams = new AmazonDynamoDBStreamsClient();
        amazonDynamoDBStreams.setRegion(Region.getRegion(Regions.US_EAST_1));
        return amazonDynamoDBStreams;
    }
}
