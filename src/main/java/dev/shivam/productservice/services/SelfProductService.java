package dev.shivam.productservice.services;

import dev.shivam.productservice.models.Product;
import org.springframework.stereotype.Service;

@Service("selfProductService")
public class SelfProductService implements ProductService {

    @Override
    public String getProductById(Long id) {
        return "Hello from SelfProduct service";
    }
}
