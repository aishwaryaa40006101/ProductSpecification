package com.pccw.prodspec.bff.clientservice;

import java.util.List;

import com.pccw.prodspec.bff.dto.ProductSpecification;

/**
 * @author 20023424
 *
 */
public interface ProductSpecificationClientService {

	/**
	 * List or find ProductSpecification objects.
	 * 
	 * @return List<ProductSpecification>
	 */
	public List<ProductSpecification> listProductSpecifications(String fields, Integer offset, Integer limit);

	/**
	 * ProductSpecification Creates a ProductSpecification.
	 * 
	 * @param productSpec
	 * @return ProductSpecification
	 */
	public ProductSpecification createProductSepcification(ProductSpecification productSpec);

	/**
	 * Retrieves a ProductSpecification by ID.
	 * 
	 * @param id
	 * @param fields
	 * @return ProductSpecification
	 */
	public ProductSpecification retrieveProductSpecificationById(String id, String fields);

	/**
	 * Updates partially a ProductSpecification.
	 * 
	 * @param id
	 * @param productSpec
	 * @return ProductSpecification
	 */
	public ProductSpecification updateProductSepcification(String id, ProductSpecification productSpec);

	/**
	 * Deletes a ProductSpecification.
	 * 
	 * @param id
	 */

	void deleteProductSpecification(String id);

}
