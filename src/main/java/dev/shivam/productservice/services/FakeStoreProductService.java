package dev.shivam.productservice.services;

import dev.shivam.productservice.dtos.FakeStoreProductDTO;
import dev.shivam.productservice.dtos.GenericProductDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {

    @Value("${productsearch.url}")
    private String productSearchURL;

    @Value("${product.url}")
    private String productURL;

    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public GenericProductDTO getProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO> response =
                restTemplate.getForEntity(productSearchURL, FakeStoreProductDTO.class, id);

        FakeStoreProductDTO fakeStoreProductDTO = response.getBody();
        GenericProductDTO genericProductDTO = getGenericProductDTO(fakeStoreProductDTO);

        return genericProductDTO;
    }

    @Override
    public GenericProductDTO createProduct(GenericProductDTO product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<GenericProductDTO> response =
                restTemplate.postForEntity(productURL, product, GenericProductDTO.class);

        return response.getBody();
    }

    @Override
    public List<GenericProductDTO> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO[]> response =
                restTemplate.getForEntity(productURL, FakeStoreProductDTO[].class);

        List<GenericProductDTO> genericProductDTOList = new ArrayList<>();

        for (FakeStoreProductDTO fakeStoreProductDTO : response.getBody()){
            GenericProductDTO genericProductDTO = getGenericProductDTO(fakeStoreProductDTO);
            genericProductDTOList.add(genericProductDTO);
        }

        return genericProductDTOList;
    }

    private static GenericProductDTO getGenericProductDTO(FakeStoreProductDTO fakeStoreProductDTO) {
        GenericProductDTO genericProductDTO = new GenericProductDTO();
        genericProductDTO.setId(fakeStoreProductDTO.getId());
        genericProductDTO.setTitle(fakeStoreProductDTO.getTitle());
        genericProductDTO.setDescription(fakeStoreProductDTO.getDescription());
        genericProductDTO.setCategory(fakeStoreProductDTO.getCategory());
        genericProductDTO.setPrice(fakeStoreProductDTO.getPrice());
        genericProductDTO.setImage(fakeStoreProductDTO.getImage());
        return genericProductDTO;
    }
}
