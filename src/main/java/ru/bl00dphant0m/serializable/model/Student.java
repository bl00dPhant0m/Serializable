package ru.bl00dphant0m.serializable.model;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Student {
    private String name;
    private List<String> langueges = new ArrayList<>();
    private Phone phone;
}
