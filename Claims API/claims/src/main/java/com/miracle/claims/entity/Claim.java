package com.miracle.claims.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "claim")
@JsonInclude(value = Include.NON_NULL)
public class Claim {

	@Transient
	public static final String SEQUENCE_NAME = "claim_id_sequence";

	@Id
//	@Field("_id")
	private String _id;

	@ApiModelProperty(required = true, value = "customer claim id", name = "claimId", dataType = "String", example = "1234")
	@Field("claim_id")
	private String claimId;

	@ApiModelProperty(required = true, value = "facility id", name = "facilityId", dataType = "String", example = "78402")
	@Field("facility_id")
	private String facilityId;

	@ApiModelProperty(required = true, value = "pallet quantity", name = "palletQuantity", dataType = "Integer", example = "100")
	@Field("pallet_quantity")
	private Integer palletQuantity;

	@ApiModelProperty(required = true, value = "document type", name = "documentType", dataType = "String", example = "RAIL")
	@Field("document_type")
	private String documentType;

	@ApiModelProperty(required = true, value = "claim amount", name = "claimedAmount", dataType = "String", example = "1234")
	@Field("claimed_amount")
	private String claimedAmount;

	@ApiModelProperty(required = false, value = "service provider claim id", name = "serviceProviderClaimId", dataType = "Long", example = "1100")
	@Field("service_provider_claim_id")
	public long serviceProviderClaimId;

	@ApiModelProperty(required = true, value = "claim status", name = "claimStatus", dataType = "String", example = "open")
	@Field("claim_status")
	private String claimStatus;

	@ApiModelProperty(required = true, value = "claim type", name = "claimType", dataType = "String", example = "WAREHOUSE")
	@Field("claim_type")
	private String claimType;

	@ApiModelProperty(required = true, value = "creator id", name = "creatorId", dataType = "String", example = "mpundir")
	@Field("creator_id")
	private String creatorId;

	@ApiModelProperty(required = false, value = "last update id", name = "lastUpdateId", dataType = "String", example = "mpundir")
	@Field("last_update_id")
	private String lastUpdateId;

	@ApiModelProperty(required = false, value = "claim closed date", name = "closedDate", dataType = "String", example = "16-NOV-2022 03.12.36.898000000 PM")
	@Field("closed_date")
	private String closedDate;

	@ApiModelProperty(required = false, value = "create date", name = "createDate", dataType = "String", example = "16-OCT-2022 03.12.36.898000000 PM")
	@Field("create_date")
	private String createDate;

	@ApiModelProperty(required = false, value = "last update date", name = "lastUpdateDate", dataType = "String", example = "10-NOV-2022 03.12.36.898000000 PM")
	@Field("last_update_date")
	private String lastUpdateDate;

	public String getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public String getLastUpdateId() {
		return claimId;
	}

	public void setLastUpdateId(String lastUpdateId) {
		this.lastUpdateId = lastUpdateId;
	}

	public String getClosedDate() {
		return closedDate;
	}

	public void setClosedDate(String closedDate) {
		this.closedDate = closedDate;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getLastUpdateDate() {
		return claimId;
	}

	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}


	public String getClaimId() {
		return claimId;
	}

	public void setClaimId(String claimId) {
		this.claimId = claimId;
	}

	public String getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(String facilityId) {
		this.facilityId = facilityId;
	}

	public int getPalletQuantity() {
		return palletQuantity;
	}

	public void setPalletQuantity(int palletQuantity) {
		this.palletQuantity = palletQuantity;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getClaimedAmount() {
		return claimedAmount;
	}

	public void setClaimedAmount(String claimedAmount) {
		this.claimedAmount = claimedAmount;
	}

	public Long getServiceProviderClaimId() {
		return serviceProviderClaimId;
	}

	public void setServiceProviderClaimId(Long serviceProviderClaimId) {
		this.serviceProviderClaimId = serviceProviderClaimId;
	}

	public String getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	public String getClaimType() {
		return claimType;
	}

	public void setClaimType(String claimType) {
		this.claimType = claimType;
	}

	@Override
	public String toString() {
		return "Claim [id=" + _id + ", claimId=" + claimId + ", facilityId=" + facilityId + ", palletQuantity="
				+ palletQuantity + ", documentType=" + documentType + ", claimedAmount=" + claimedAmount
				+ ", serviceProviderClaimId=" + serviceProviderClaimId + ", claimStatus=" + claimStatus + ", claimType="
				+ claimType + ", creatorId=" + creatorId + ", closedDate=" + closedDate + ",lastUpdateId="
				+ lastUpdateId +  "createDate=" + createDate +"]";
	}



}
