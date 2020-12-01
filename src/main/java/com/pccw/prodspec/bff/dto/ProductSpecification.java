package com.pccw.prodspec.bff.dto;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@AllArgsConstructor
public class ProductSpecification implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id = null;
	private String href = null;
	private String brand = null;
	private String description = null;
	private Boolean isBundle = null;
	private OffsetDateTime lastUpdate = null;
	private String lifecycleStatus = null;
	private String name = null;
	private String productNumber = null;
	private String version = null;
	private List<ProductSpecificationCharacteristic> productSpecCharacteristic = null;
	private TimePeriod validFor = null;
	private String baseType = null;
	private String schemaLocation = null;
	private String type = null;

}
