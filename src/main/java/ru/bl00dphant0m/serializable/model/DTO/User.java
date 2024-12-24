package ru.bl00dphant0m.serializable.model.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class User {
    private String name;
    @JsonProperty(value = "username")
    private String userName;
    private String email;
    private String phone;
    private Address address;
    private Company company;
    private String website;
}
