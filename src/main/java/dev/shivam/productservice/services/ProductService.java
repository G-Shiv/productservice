package dev.shivam.productservice.services;

import dev.shivam.productservice.dtos.GenericProductDTO;
import dev.shivam.productservice.models.Product;

import java.util.List;

public interface ProductService {

    GenericProductDTO getProductById(Long id);

    GenericProductDTO createProduct(GenericProductDTO product);

    List<GenericProductDTO> getAllProducts();
}
