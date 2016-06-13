package com.prashant.java.ws.rest.model.aws.dynamo;

import lombok.*;

/**
 * Created by yprasha on 6/9/16.
 */
@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TablePartitions {
    private String tableName;
    private Integer partitions;
}
