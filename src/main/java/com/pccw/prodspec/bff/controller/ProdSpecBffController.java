package com.pccw.prodspec.bff.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.pccw.prodspec.bff.clientserviceimpl.ProductSpecificationRestClientServiceImpl;
import com.pccw.prodspec.bff.constants.Constants;
import com.pccw.prodspec.bff.dto.ProductSpecification;
import com.pccw.prodspec.bff.exception.CustomException;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 20023424 This class is RestController class in ProductSpec BFF
 *
 */
@Slf4j
@RestController
public class ProdSpecBffController {

	@Autowired
	ProductSpecificationRestClientServiceImpl prodSpecService;

	RestTemplate restTemplate;

	@ApiOperation(value = Constants.SWAGGER_MSG_LISTPRODSPECS, response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = Constants.SUCCESSFUL_MSG) })
	@RequestMapping(value = "/productSpecification/{fields}/{offset}/{limit}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductSpecification>> listProductSpecifications(@PathVariable("fields") String fields,
			@PathVariable("offset") Integer offset, @PathVariable("limit") Integer limit) {

		List<ProductSpecification> prodSpec = new ArrayList<>();

		try {
			prodSpec = prodSpecService.listProductSpecifications(fields, offset, limit);
		} catch (CustomException ce) {
			log.error(ce.getDetails());
			throw ce;
		}

		return new ResponseEntity<>(prodSpec, HttpStatus.OK);

	}

	@ApiOperation(value = Constants.SWAGGER_MSG_SAVE, response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = Constants.SUCCESSFUL_MSG) })
	@PostMapping(value = "/productSpecification", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductSpecification> createProductSpecification(@RequestBody ProductSpecification prodSpec) {
		ProductSpecification prodSpecRes = null;
		try {
			prodSpecRes = prodSpecService.createProductSepcification(prodSpec);
		} catch (CustomException ce) {
			log.error(ce.getDetails());
			throw ce;
		}

		return new ResponseEntity<>(prodSpecRes, HttpStatus.OK);

	}

	
	@ApiOperation(value = Constants.SWAGGER_MSG_UPDATEPRODSPEC, response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = Constants.SUCCESSFUL_MSG) })
	@PostMapping(value = "/productSpecification/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductSpecification> retrieveProductSpecificationById(@PathVariable("id") String id,
			@RequestBody ProductSpecification prodSpec) {
		ProductSpecification prodSpecRes = null;
		try {
			prodSpecRes = prodSpecService.updateProductSepcification(id, prodSpec);
		} catch (CustomException ce) {
			log.error(ce.getDetails());
			throw ce;
		}

		return new ResponseEntity<>(prodSpecRes, HttpStatus.OK);

	}

	@ApiOperation(value = Constants.SWAGGER_MSG_UPDATEPRODSPEC, response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = Constants.SUCCESSFUL_MSG) })
	@PostMapping(value = "/productSpecification/{id}/{fields}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductSpecification> retrieveProductSpecificationByIdAndFields(@PathVariable("id") String id,
			@RequestBody ProductSpecification prodSpec) {
		ProductSpecification prodSpecRes = null;
		try {
			prodSpecRes = prodSpecService.updateProductSepcification(id, prodSpec);
		} catch (CustomException ce) {
			log.error(ce.getDetails());
			throw ce;
		}

		return new ResponseEntity<>(prodSpecRes, HttpStatus.OK);

	}

	@ApiOperation(value = Constants.SWAGGER_MSG_UPDATEPRODSPEC, response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = Constants.SUCCESSFUL_MSG) })
	@DeleteMapping(value = "/productSpecification/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String retrieveProductSpecificationById(@PathVariable("id") String id) {
		try {
			//prodSpecService.deleteProductSpecification(id);
			return "success";
		} catch (CustomException ce) {
			log.error(ce.getDetails());
			throw ce;
		}
	}
}
