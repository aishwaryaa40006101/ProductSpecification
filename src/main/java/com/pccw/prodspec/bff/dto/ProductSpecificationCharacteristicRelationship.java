package com.pccw.prodspec.bff.dto;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@AllArgsConstructor
public class ProductSpecificationCharacteristicRelationship implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id = null;
	private String href = null;
	private Integer charSpecSeq = null;
	private String name = null;
	private String relationshipType = null;
	private TimePeriod validFor = null;
	private String baseType = null;
	private String schemaLocation = null;
	private String type = null;
}
