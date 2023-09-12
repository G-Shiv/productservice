package dev.shivam.productservice.services;

import dev.shivam.productservice.dtos.FakeStoreProductDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {

    @Value("${productservice.url}")
    private String productServiceURL;

    private RestTemplateBuilder restTemplateBuilder;

    @Override
    public String getProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.getForEntity(productServiceURL, FakeStoreProductDTO.class, id);
        return "Here is the id: " + id;
    }
}
