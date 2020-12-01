package com.pccw.prodspec.bff;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner; 

import com.pccw.prodspec.bff.clientserviceimpl.ProductSpecificationRestClientServiceImpl;
import com.pccw.prodspec.bff.dto.ProductSpecification;
import com.pccw.prodspec.bff.dto.ProductSpecificationCharacteristic;
import com.pccw.prodspec.bff.dto.ProductSpecificationCharacteristicRelationship;
import com.pccw.prodspec.bff.dto.ProductSpecificationCharacteristicValue;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ProdSpecControllerTest {


	@Mock
	private RestTemplate restTemplate;
	@InjectMocks
	private ProductSpecificationRestClientServiceImpl pService;
	
	@BeforeEach
	public void init() {
		//MockitoAnnotations.openMocks(this);
		}
	

	ProductSpecification prodSpec = new ProductSpecification("prodSpec1",
			"href-link","prodspec-brand", "prod-spec-desc", true, OffsetDateTime.now(),
			"ok", "prod-spec-name", "prod-spec-prod-numb", "prod-version",
			prodSpecCharList(), null, "prod-base-type", "prod-shema-loc",
			"prod-type");
	ProductSpecification prodSpec1 = new ProductSpecification("prodSpec2",
			"href-link","prodspec-brand", "prod-spec-desc", true, OffsetDateTime.now(),
			"ok", "prod-spec-name", "prod-spec-prod-numb", "prod-version",
			prodSpecCharList(), null, "prod-base-type", "prod-shema-loc",
			"prod-type");
	ProductSpecificationCharacteristic prodSpecChar = new ProductSpecificationCharacteristic(
			true, "prod-spec-char-desc", true,
			true, 12, 1, "prodSpec-Char-name", "prod-spec-char-regex",
			"prod-spec-char-val-type", prodSpecCharRelList(),
			prodSpecCharValList(), null, "prodspecCharbaseType",
			"prodSpec-Schema-Loc", "prodSpecCharType");
	ProductSpecificationCharacteristicRelationship prodSpecCharRel = new ProductSpecificationCharacteristicRelationship(
			"prodSpecRelId1", "prodSpecChar", 20, "prodspeccharrel",
			"prodspeccharrelrelltype", null, "prodspecCharRelBaseType",
			"prod-spec-char-rel-schemaloc", "prod-spec-char-rel-type");
	ProductSpecificationCharacteristicValue prodSpecCharVal = new ProductSpecificationCharacteristicValue(
			true,"prodspeccharvall12", "prodSpecChar",  "12month", "amrprodreg",
			"kilo", "one",null,null, "thousand", "rupee", 
			"char");

	private List<ProductSpecificationCharacteristic> prodSpecCharList() {
		List<ProductSpecificationCharacteristic> prodSpecCharLists = new ArrayList<>();
		prodSpecCharLists.add(prodSpecChar);
		prodSpecCharLists.add(new ProductSpecificationCharacteristic(
				true,"prod-spec-char-1", true, true, 20,25,"prod-spec-char-desc", "prod-spec-char-regex",
				"prod-spec-char-val-type", prodSpecCharRelList(),
				prodSpecCharValList(), null, "prodspecCharbaseType",
				"prodSpec-Schema-Loc", "prodSpecCharType"));
		return prodSpecCharLists;
	}

	private List<ProductSpecificationCharacteristicRelationship> prodSpecCharRelList() {
		List<ProductSpecificationCharacteristicRelationship> prodSpecCharRelLists = new ArrayList<>();
		prodSpecCharRelLists.add(prodSpecCharRel);
		prodSpecCharRelLists
				.add(new ProductSpecificationCharacteristicRelationship(
						"prodSpecRelId2", "prodSpecChar", 20, "prodspeccharrel",
						"prodspeccharrelrelltype", null,
						"prodspecCharRelBaseType",
						"prod-spec-char-rel-schemaloc",
						"prod-spec-char-rel-type"));
		return prodSpecCharRelLists;
	}

	private List<ProductSpecificationCharacteristicValue> prodSpecCharValList() {
		List<ProductSpecificationCharacteristicValue> prodSpecCharValLists = new ArrayList<>();
		prodSpecCharValLists.add(prodSpecCharVal);
		prodSpecCharValLists.add(new ProductSpecificationCharacteristicValue(
				true,"prodspeccharvall10"," prodSpecChar", "12month",
				"amrprodreg", "kilo", "one", null, null,
				"simple", "bgm", "char"));
		return prodSpecCharValLists;
	}

	private List<ProductSpecification> populateProductSpecification() {
		List<ProductSpecification> podSpecs = new ArrayList<>();
		podSpecs.add(prodSpec);
		podSpecs.add(new ProductSpecification("prodSpec2", "prodspec-brand",
				"prod-spec-desc","ok", true, OffsetDateTime.now(), "ok",
				"prod-spec-name", "prod-spec-prod-numb", "prod-version",
				prodSpecCharList(), null, "prod-base-type", "prod-shema-loc",
				"prod-type"));

		return podSpecs;
	}
		   
	@Test
	public void getAllProdSpecTest()throws Exception {
        ResponseEntity<List<ProductSpecification>> prodEntity = new ResponseEntity<List<ProductSpecification>>(populateProductSpecification(),HttpStatus.OK);
        Mockito.when(restTemplate.exchange(
        		ArgumentMatchers.eq( "http://localhost:8083/productSpecification/name/0/2"),
            ArgumentMatchers.eq(HttpMethod.GET),
            ArgumentMatchers.<HttpEntity<List<ProductSpecification>>>any(),
            ArgumentMatchers.<ParameterizedTypeReference<List<ProductSpecification>>>any())
        ).thenReturn(prodEntity);
		 RestTemplate restTemp=new RestTemplate();

		ResponseEntity<ProductSpecification[]> result=restTemp.getForEntity("http://localhost:8083/productSpecification/name/0/2",ProductSpecification[].class);
  		assertEquals(200,result.getStatusCodeValue());
	
	}
	
	
	
	@Test
    public void postProductSpecTest() throws Exception {
      
		
			
			//ResponseEntity<ProductSpecification> responseEntityPerson = restTemp.postForEntity(http://localhost:8083/productSpecification, request, ProductSpecification.class);
					 RestTemplate restTemp=new RestTemplate();
					 HttpHeaders  headers = new HttpHeaders();
					    headers.setContentType(MediaType.APPLICATION_JSON);
					 HttpEntity<ProductSpecification> request = 
						      new HttpEntity<>(prodSpec,headers);
			ResponseEntity<String> result=restTemp.postForEntity("http://localhost:8081/productSpecification", request, String.class);

			assertNotNull(result.getStatusCodeValue());
		}
	
	@Test
	public void updateProdSpecByIdTest() {
		 RestTemplate restTemp=new RestTemplate();
		 HttpHeaders  headers = new HttpHeaders();
		    headers.setContentType(MediaType.APPLICATION_JSON);
		 HttpEntity<ProductSpecification> request = 
			      new HttpEntity<>(prodSpec1,headers);
ResponseEntity<String> result=restTemp.postForEntity("http://localhost:8081/productSpecification/1", request, String.class);

assertNotNull(result.getStatusCodeValue());
	}
	@Test
	public void updateProdSpecByIdAndFiledsTest() {
		 RestTemplate restTemp=new RestTemplate();
		 HttpHeaders  headers = new HttpHeaders();
		    headers.setContentType(MediaType.APPLICATION_JSON);
		 HttpEntity<ProductSpecification> request = 
			      new HttpEntity<>(prodSpec1,headers);
ResponseEntity<String> result=restTemp.postForEntity("http://localhost:8081/productSpecification/1/name", request, String.class);

assertNotNull(result.getStatusCodeValue());
	}
	
	@Test
	public void deleteProdSpecByIdTest() {
		 RestTemplate restTemp=new RestTemplate();
	//	restTemp.delete("http://localhost:8081/productSpecification/1");
		  
		 
	}
}
