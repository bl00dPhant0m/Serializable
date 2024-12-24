package ru.bl00dphant0m.serializable.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Phone {
    private String model;
    private Double coast;
}
