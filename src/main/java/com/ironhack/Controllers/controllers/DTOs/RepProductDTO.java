package com.ironhack.Controllers.controllers.DTOs;


import javax.validation.constraints.*;

public class RepProductDTO {

    @NotEmpty
    private Long representativeId;
    @NotEmpty
    private Long productId;

    public RepProductDTO(Long representativeId, Long productId) {
        this.representativeId = representativeId;
        this.productId = productId;
    }

    public Long getRepresentativeId() {
        return representativeId;
    }

    public void setRepresentativeId(Long representativeId) {
        this.representativeId = representativeId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
