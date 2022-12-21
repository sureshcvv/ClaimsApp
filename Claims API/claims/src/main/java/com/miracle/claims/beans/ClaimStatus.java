package com.miracle.claims.beans;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document
public class ClaimStatus {

    @Id
    private String _id;

    @ApiModelProperty(required = true, value = "claim status", name = "claimStatus", dataType = "String", example = "open")
    @Field("claim_status")
    private String claimStatus;
}
