package dev.shivam.productservice.services;

import dev.shivam.productservice.dtos.GenericProductDTO;
import dev.shivam.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductService")
public class SelfProductService implements ProductService {

    @Override
    public GenericProductDTO getProductById(Long id) {
//        return "Hello from SelfProduct service";
        return null;
    }

    @Override
    public GenericProductDTO createProduct(GenericProductDTO product) {
        return null;
    }

    @Override
    public List<GenericProductDTO> getAllProducts() {
        return null;
    }

    @Override
    public GenericProductDTO deleteProduct(Long id) {
        return null;
    }

    @Override
    public GenericProductDTO updateProductById(GenericProductDTO product, Long id) {
        return null;
    }
}
