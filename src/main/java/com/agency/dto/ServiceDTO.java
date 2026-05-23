package com.agency.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


public class ServiceDTO {

    @NotBlank(message= "Service name is required")
    private String serviceName;

    @NotBlank(message= "Description is required")
    private String description;

    @NotNull(message="Price is required")
    @Positive(message="Price should be positive or greater then 0")
    private Double price;


    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
