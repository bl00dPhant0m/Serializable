package ru.bl00dphant0m.serializable.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.bl00dphant0m.serializable.model.DTO.User;
import ru.bl00dphant0m.serializable.model.Student;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

@Service
public class RestTemplateSerializableService {
    private RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper mapper = new ObjectMapper();

    private final String API_URL = "https://jsonplaceholder.typicode.com/users";

    public String serializeStudentToStringJSON(Student student) throws JsonProcessingException {
        return mapper.writeValueAsString(student);
    }

    public Path serializeStudentToJSON(Student student) throws IOException {
        String path = "json/student.json";
        mapper.writeValue(new File(path),student);
        return new File(path).toPath();
    }

    public List<User> desirializableRestTemplate() throws JsonProcessingException {

        String JSON = restTemplate.getForObject(API_URL, String.class);
        return mapper.readValue(JSON, new TypeReference<List<User>>() {});
    }


}
