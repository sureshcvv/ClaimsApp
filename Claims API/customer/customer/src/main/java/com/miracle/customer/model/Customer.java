package com.miracle.customer.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Getter
@Setter
@Document(collection = "customer")
@JsonInclude(value = Include.NON_NULL)
public class Customer {
	@Id
//	@Field("_id")
	private String _id;

	@ApiModelProperty(required = true, value = "customer id", name = "customerId", dataType = "Integer", example = "1234")
	@Field("customer_id")
	private Integer customerId;
	
	@ApiModelProperty(required = true, value = "name", name = "name", dataType = "String", example = "1234")
	@Field("name")
	private String name;
	
	@ApiModelProperty(required = true, value = "address line 1", name = "addressLine1", dataType = "String", example = "1415 North Raymond Avenue")
	@Field("address_line_1")
	private String addressLine1;

	@ApiModelProperty(required = false, value = "address line 2", name = "addressLine2", dataType = "String", example = "Suite 100")
	@Field("address_line_2")
	private String addressLine2;

	@ApiModelProperty(required = false, value = "address line 3", name = "addressLine3", dataType = "String", example = "")
	@Field("address_line_3")
	private String addressLine3;
	
	@ApiModelProperty(required = true, value = "city", name = "city", dataType = "String", example = "Anaheim")
	@Field("city")
	private String city;
	
	@ApiModelProperty(required = true, value = "state", name = "state", dataType = "String", example = "CA")
	@Field("state")
	private String state;
	
	@ApiModelProperty(required = true, value = "postal code", name = "postalCode", dataType = "String", example = "92801")
	@Field("postal_code")
	private String postalCode;
	
	@ApiModelProperty(required = true, value = "country", name = "country", dataType = "String", example = "United States")
	@Field("country")
	private String country;

	@ApiModelProperty(required = true, value = "phone", name = "phone", dataType = "String", example = "(714) 449-2880")
	@Field("phone")
	private String phone;

	@ApiModelProperty(required = true, value = "fax", name = "fax", dataType = "String", example = "18473037674")
	@Field("fax")
	private String fax;
	
	@ApiModelProperty(required = true, value = "email", name = "email", dataType = "String", example = "18473037674")
	@Field("email")
	private String email;
	
	@ApiModelProperty(required = true, value = "creatorId", name = "creatorId", dataType = "String", example = "18473037674")
	@Field("creator_id")
	private String creatorId;
	
	@ApiModelProperty(required = true, value = "lastUpdatorId", name = "lastUpdatorId", dataType = "String", example = "18473037674")
	@Field("last_updator_id")
	private String lastUpdatorId;
	
	@ApiModelProperty(required = true, value = "createDate", name = "createDate", dataType = "String", example = "")
	@Field("create_date")
	private String createDate;
	
	@ApiModelProperty(required = true, value = "lastUpdateDate", name = "lastUpdateDate", dataType = "String", example = "")
	@Field("last_update_date")
	private String lastUpdateDate;

	@Override
	public String toString() {
		return "Customer [_id=" + _id + ", customerId=" + customerId + ", name=" + name + ", addressLine1="
				+ addressLine1 + ", addressLine2=" + addressLine2 + ", addressLine3=" + addressLine3 + ", city=" + city
				+ ", state=" + state + ", postalCode=" + postalCode + ", country=" + country + ", phone=" + phone
				+ ", fax=" + fax + ", email=" + email + ", creatorId=" + creatorId + ", lastUpdatorId=" + lastUpdatorId
				+ ", createDate=" + createDate + ", lastUpdateDate=" + lastUpdateDate + "]";
	}
}
