package com.pccw.prodspec.bff.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@AllArgsConstructor
public class ProductSpecificationCharacteristic implements Serializable {
	private static final long serialVersionUID = 1L;

	private Boolean configurable = null;
	private String description = null;
	private Boolean extensible = null;
	private Boolean isUnique = null;
	private Integer maxCardinality = null;
	private Integer minCardinality = null;
	private String name = null;
	private String regex = null;
	private String valueType = null;
	private List<ProductSpecificationCharacteristicRelationship> productSpecCharRelationship = null;
	private List<ProductSpecificationCharacteristicValue> productSpecCharacteristicValue = null;
	private TimePeriod validFor = null;
	private String baseType = null;
	private String schemaLocation = null;
	private String type = null;
}
