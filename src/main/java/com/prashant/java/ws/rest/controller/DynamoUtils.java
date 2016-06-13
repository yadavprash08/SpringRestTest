package com.prashant.java.ws.rest.controller;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBStreams;
import com.amazonaws.services.dynamodbv2.model.DescribeStreamRequest;
import com.amazonaws.services.dynamodbv2.model.DescribeStreamResult;
import com.amazonaws.services.dynamodbv2.model.DescribeTableResult;
import com.amazonaws.services.dynamodbv2.model.StreamSpecification;
import com.prashant.java.ws.rest.model.aws.dynamo.TablePartitions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by yprasha on 6/9/16.
 */
@RestController
public class DynamoUtils {

    @Resource
    private AmazonDynamoDB amazonDynamoDB;

    @Resource
    private AmazonDynamoDBStreams amazonDynamoDBStreams;

    @RequestMapping("/partitions")
    public TablePartitions partitions(@RequestParam(value = "table") String tableName) {
        DescribeTableResult tableDescription = amazonDynamoDB.describeTable(tableName);
        String streamArn = tableDescription.getTable().getLatestStreamArn();
        StreamSpecification streamSpecification = tableDescription.getTable().getStreamSpecification();

        DescribeStreamResult streamDescription = amazonDynamoDBStreams
                .describeStream(new DescribeStreamRequest().withStreamArn(streamArn));

        Integer partitions = streamDescription.getStreamDescription().getShards().size();

        return TablePartitions.builder().tableName(tableName).partitions(partitions).build();
    }

}
