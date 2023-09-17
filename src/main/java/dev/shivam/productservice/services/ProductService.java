package dev.shivam.productservice.services;

import dev.shivam.productservice.dtos.GenericProductDTO;
import dev.shivam.productservice.models.Product;

public interface ProductService {

    GenericProductDTO getProductById(Long id);

    GenericProductDTO createProduct(GenericProductDTO product);
}
