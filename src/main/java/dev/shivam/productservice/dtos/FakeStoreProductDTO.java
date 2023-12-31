package dev.shivam.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FakeStoreProductDTO {
    private Long id;
    private String title;
    private String category;
    private double price;
    private String description;
    private String image;
}
