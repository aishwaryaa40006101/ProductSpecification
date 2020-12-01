 package com.pccw.prodspec.bff.clientserviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.pccw.prodspec.bff.clientservice.ProductSpecificationClientService;
import com.pccw.prodspec.bff.constants.Constants;
import com.pccw.prodspec.bff.dto.ProductSpecification;
import com.pccw.prodspec.bff.dto.ProductSpecificationList;
import com.pccw.prodspec.bff.exception.CustomException;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 20023424 This class is the client service implementation class which
 *         interacts with bizComp service to return the expected result
 */
@Slf4j
@Service
public class ProductSpecificationRestClientServiceImpl implements ProductSpecificationClientService {
	@Autowired
	private Environment env;

	public HttpStatus status;
	@Override
	public List<ProductSpecification> listProductSpecifications(String fields, Integer offset, Integer limit) {
		List<ProductSpecification> productSpecLst = new ArrayList<>();
		ProductSpecificationList prodspecLst = null;
		try {
			RestTemplate restTemplate = new RestTemplate();
			final String uri = env.getProperty("prodspec.bizcomp.url") + ":" + env.getProperty("prodspec.bizcomp.port")
					+ "/" + Constants.PRODSPECSERVIC + "/{fields}/{offset}/{limit}";

			LinkedMultiValueMap<String, String> params = new LinkedMultiValueMap<>();
			params.add("fields", "name");
			params.add("offset", "2");
			params.add("limit", "0");
			HttpHeaders requestHeaders = new HttpHeaders();
			requestHeaders.set("Accept", MediaType.APPLICATION_JSON_VALUE);
			System.out.println("URI   " + encodeUri(uri, params));
			// ResponseEntity<ProductSpecificationList> response =
			// restTemplate.getForEntity(encodeUri(uri, params),
			// ProductSpecificationList.class, params);

			ResponseEntity<List<ProductSpecification>> response = restTemplate.exchange(encodeUri(uri, params),
					HttpMethod.GET, null, new ParameterizedTypeReference<List<ProductSpecification>>() {
					});
			// if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null)
			// prodspecLst = response.getBody();
			if (response.getStatusCode() == HttpStatus.OK)
				productSpecLst = response.getBody();
				status=response.getStatusCode();
		} catch (CustomException ce) {
			log.error(ce.getMessage());
			throw ce;
		}
		return productSpecLst;
	}

	@Override
	public ProductSpecification createProductSepcification(ProductSpecification productSpec) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductSpecification retrieveProductSpecificationById(String id, String fields) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductSpecification updateProductSepcification(String id, ProductSpecification productSpec) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProductSpecification(String id) {
		// TODO Auto-generated method stub
		
	}

	private String encodeUri(String rawUrl, LinkedMultiValueMap<String, String> params) {

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(rawUrl).queryParams(params);
		UriComponents uriComponents = builder.build().encode();
		return uriComponents.toString();
	}

	

}
