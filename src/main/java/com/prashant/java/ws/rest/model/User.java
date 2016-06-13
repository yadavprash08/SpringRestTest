package com.prashant.java.ws.rest.model;

import lombok.Builder;
import lombok.Data;

/**
 * Created by yprasha on 6/3/16.
 */
@Builder
@Data
public class User {

    private final String userId;
    private final String userName;
    private final String passwordHash;
    private final String passwordKey;
}
