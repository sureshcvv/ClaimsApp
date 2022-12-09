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
	@Field("INTERNAL_ID")
	private Integer customerId;
	
	@ApiModelProperty(required = true, value = "name", name = "name", dataType = "String", example = "1234")
	@Field("NAME")
	private String name;
	
	@ApiModelProperty(required = true, value = "address line 1", name = "addressLine1", dataType = "String", example = "1415 North Raymond Avenue")
	@Field("ADDRESS_LINE_1")
	private String addressLine1;

	@ApiModelProperty(required = false, value = "address line 2", name = "addressLine2", dataType = "String", example = "Suite 100")
	@Field("ADDRESS_LINE_2")
	private String addressLine2;

	@ApiModelProperty(required = false, value = "address line 3", name = "addressLine3", dataType = "String", example = "")
	@Field("ADDRESS_LINE_3")
	private String addressLine3;
	
	@ApiModelProperty(required = true, value = "city", name = "city", dataType = "String", example = "Anaheim")
	@Field("CITY")
	private String city;
	
	@ApiModelProperty(required = true, value = "state", name = "state", dataType = "String", example = "CA")
	@Field("STATE")
	private String state;
	
	@ApiModelProperty(required = true, value = "postal code", name = "postalCode", dataType = "String", example = "92801")
	@Field("POSTAL_CODE")
	private String postalCode;
	
	@ApiModelProperty(required = true, value = "country", name = "country", dataType = "String", example = "United States")
	@Field("COUNTRY")
	private String country;

	@ApiModelProperty(required = true, value = "phone", name = "phone", dataType = "String", example = "(714) 449-2880")
	@Field("PHONE")
	private String phone;

	@ApiModelProperty(required = true, value = "fax", name = "fax", dataType = "String", example = "18473037674")
	@Field("FAX")
	private String fax;
	
	@ApiModelProperty(required = true, value = "email", name = "email", dataType = "String", example = "18473037674")
	@Field("EMAIL")
	private String email;
	
	@ApiModelProperty(required = true, value = "creatorId", name = "creatorId", dataType = "String", example = "18473037674")
	@Field("CREATOR_ID")
	private String creatorId;
	
	@ApiModelProperty(required = true, value = "lastUpdatorId", name = "lastUpdatorId", dataType = "String", example = "18473037674")
	@Field("LAST_UPDATOR_ID")
	private String lastUpdatorId;
	
	@ApiModelProperty(required = true, value = "createDate", name = "createDate", dataType = "String", example = "")
	@Field("CREATE_DATE")
	private String createDate;
	
	@ApiModelProperty(required = true, value = "lastUpdateDate", name = "lastUpdateDate", dataType = "String", example = "")
	@Field("LAST_UPDATE_DATE")
	private String lastUpdateDate;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return addressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public String getLastUpdatorId() {
		return lastUpdatorId;
	}

	public void setLastUpdatorId(String lastUpdatorId) {
		this.lastUpdatorId = lastUpdatorId;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	@Override
	public String toString() {
		return "Customer [_id=" + _id + ", internalId=" + customerId + ", name=" + name + ", addressLine1="
				+ addressLine1 + ", addressLine2=" + addressLine2 + ", addressLine3=" + addressLine3 + ", city=" + city
				+ ", state=" + state + ", postalCode=" + postalCode + ", country=" + country + ", phone=" + phone
				+ ", fax=" + fax + ", email=" + email + ", creatorId=" + creatorId + ", lastUpdatorId=" + lastUpdatorId
				+ ", createDate=" + createDate + ", lastUpdateDate=" + lastUpdateDate + "]";
	}
}
/**
{
    "INTERNAL_ID" : NumberInt(45),
    "NAME" : "ConAgra",
    "ADDRESS_LINE_1" : "5645 N 90TH STREETs",
    "ADDRESS_LINE_2" : "MAILSTOP 90-180",
    "ADDRESS_LINE_3" : "",
    "CITY" : "OMAHA",
    "STATE" : "NE",
    "POSTAL_CODE" : NumberInt(68134),
    "COUNTRY" : "USA",
    "PHONE" : "847-303-2722",
    "FAX" : "18473037674",
    "EMAIL" : "",
    "CREATOR_ID" : "POCSLV",
    "LAST_UPDATER_ID" : "POCSLV",
    "CREATE_DATE" : "01-JAN-00 12.59.59.000000000 AM",
    "LAST_UPDATE_DATE" : "01-JAN-00 09.59.59.000000000 PM"
}
**/