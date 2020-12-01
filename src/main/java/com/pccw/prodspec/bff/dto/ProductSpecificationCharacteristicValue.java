package com.pccw.prodspec.bff.dto;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@AllArgsConstructor
public class ProductSpecificationCharacteristicValue implements Serializable {

	private static final long serialVersionUID = 1L;

	private Boolean isDefault = null;
	private String rangeInterval = null;
	private String regex = null;
	private String unitOfMeasure = null;
	private String valueFrom = null;
	private String valueTo = null;
	private String valueType = null;
	private TimePeriod validFor = null;
	private Any value = null;
	private String baseType = null;
	private String schemaLocation = null;
	private String type = null;
}
