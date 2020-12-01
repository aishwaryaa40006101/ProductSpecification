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
public class ProductSpecificationList implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<ProductSpecification> prodSpecList;

}
