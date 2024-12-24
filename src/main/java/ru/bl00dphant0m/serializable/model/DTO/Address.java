package ru.bl00dphant0m.serializable.model.DTO;

import lombok.Data;

@Data
public class Address {
    private String street;
    private String city;
    private String suite;
    private String zipcode;
    private Geo geo;
}
