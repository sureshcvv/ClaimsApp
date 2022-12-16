package com.miracle.claims.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.miracle.claims.beans.Claim;
import com.miracle.claims.repository.ClaimsRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Service
@Slf4j
public class ClaimsServiceImpl implements ClaimsService {

	@Autowired
	ClaimsRepository claimsRepository;

	@Autowired
	ClaimsSequenceGeneratorService claimsSeqGeneratorSvc;

	// get the list of all
	@Override
	public ResponseEntity<List<Claim>> getAllClaims() {
		List<Claim> list = claimsRepository.findAll();
		log.info("test log");
		return new ResponseEntity<List<Claim>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	// post
	@Override
	public ResponseEntity<Claim> createClaims(Claim claim) {
		claim.setServiceProviderClaimId(claimsSeqGeneratorSvc.generateSequence(Claim.SEQUENCE_NAME));
		Claim newClaim = claimsRepository.save(claim);
		return new ResponseEntity<Claim>(newClaim, new HttpHeaders(), HttpStatus.OK);
	}

	// put
	@Override
	public ResponseEntity<Claim> updateClaims(Long claimId, Claim claim) {
		try {
			Claim claims = claimsRepository.findByServiceProviderClaimId(claimId);
			System.out.println("this is service pro" + claims.getServiceProviderClaimId());
			// log.info("this is the output" + claims.getClaimId());
			claims.setClaimId(claim.getClaimId());
			claims.setFacilityId(claim.getFacilityId());
			claims.setDocumentType(claim.getDocumentType());
			claims.setClaimStatus(claim.getClaimStatus());
			claims.setPalletQuantity(claim.getPalletQuantity());
			claims.setClaimedAmount(claim.getClaimedAmount());
			claims.setClaimType(claim.getClaimType());
			claimsRepository.save(claims);
			return new ResponseEntity<Claim>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}

	// delete
	@Override
	public String deleteClaims(Long ServiceProviderClaimId) {
		claimsRepository.deleteByServiceProviderClaimId(ServiceProviderClaimId);
		return "claim deleted with id : " + ServiceProviderClaimId;
	}

	@Override
	public Claim getClaim(Long serverProviderClaimId) {
		Claim claim = claimsRepository.findByServiceProviderClaimId(serverProviderClaimId);
		return claim;
	}
	@Override
	public ResponseEntity<List<Claim>> getFacilityClaim(String facilityId) {
		// TODO Auto-generated method stub
		List<Claim> list = new ArrayList<>();
		if(facilityId == null) {
			claimsRepository.findAll().forEach(list::add);
		}else {
			claimsRepository.findByFacilityId(facilityId).forEach(list::add);
		}		
		return new ResponseEntity<>(list,new HttpHeaders(), HttpStatus.OK); 

	}

	@Override
	public ResponseEntity<List<Claim>> getClaimsByStatus(String claimStatus) {
		List<Claim> list = new ArrayList<>(); 
		if(claimStatus == null) {
			claimsRepository.findAll().forEach(list::add);
		}else {
			claimsRepository.findByStatus(claimStatus).forEach(list::add);
		}
		return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<List<Claim>> getClaimsByType(String claimType) {
		List<Claim> list = new ArrayList<>();
		if(claimType == null) {	
			claimsRepository.findAll().forEach(list::add);
		}
		else {
			claimsRepository.findByType(claimType).forEach(list::add);
		}	
		return new ResponseEntity<List<Claim>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<List<Claim>> getClaimsByDocumentType(String documentType) {
		List<Claim> list = new ArrayList<>();
		if(documentType == null) {	
			claimsRepository.findAll().forEach(list::add);
		}
		else {
			claimsRepository.findByDocType(documentType).forEach(list::add);
		}	
		return new ResponseEntity<List<Claim>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	public Claim getClaimByCreator(String creatorId) {
		return claimsRepository.findByCreatorId(creatorId);
	}
	@Override
	public Claim getCustomerClaim(String claimId) {
		return claimsRepository.findByCustomerClaimId(claimId);
	}
	@Override
	public ResponseEntity<List<Claim>> getAllClaimsByStatus(){
		List<Claim> list = new ArrayList<>(); 
		claimsRepository.findClaimsbyStatus();
		System.out.println(list);
		return new ResponseEntity<List<Claim>>(list, new HttpHeaders(), HttpStatus.OK);

	}
	@Override
	public ResponseEntity<List<Claim>> getClaimsByCreateDate(Date createdDate) {
		List<Claim> list = new ArrayList<>();
		if(createdDate == null) {	
			claimsRepository.findAll().forEach(list::add);
		}
		else {
			claimsRepository.findByCreateDate(createdDate).forEach(list::add);
		}	
		return new ResponseEntity<List<Claim>>(list, new HttpHeaders(), HttpStatus.OK);
	}
//	@Override
//	public ResponseEntity<List<Claim>> getClaimsByClaimedAmountAndStatus(String claimedAmount, String claimStatus){
//		List<Claim> list = new ArrayList<>();
//		claimsRepository.findByClaimedAmountandStatus(claimedAmount,claimStatus);
//		return new ResponseEntity<List<Claim>>(list, new HttpHeaders(), HttpStatus.OK);
//	}

	public ResponseEntity<List<Claim>> getClaimsByClosedDate(String closedDate) {
		List<Claim> list = new ArrayList<>();
		if(closedDate == null) {	
			claimsRepository.findAll().forEach(list::add);
		}
		else {
			claimsRepository.findByClosedDate(closedDate).forEach(list::add);
		}	
		return new ResponseEntity<List<Claim>>(list, new HttpHeaders(), HttpStatus.OK);
	}

}
	



