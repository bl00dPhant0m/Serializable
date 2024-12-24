package ru.bl00dphant0m.serializable;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.bl00dphant0m.serializable.model.DTO.User;
import ru.bl00dphant0m.serializable.model.Phone;
import ru.bl00dphant0m.serializable.model.Student;
import ru.bl00dphant0m.serializable.service.RestTemplateSerializableService;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class SerializableApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(SerializableApplication.class, args);


        RestTemplateSerializableService serializableService = context.getBean("restTemplateSerializableService", RestTemplateSerializableService.class);
        try {
            serializableService.serializeStudentToJSON(Student.builder()
                    .phone(new Phone("Samsung", 100_000.1))
                    .langueges(List.of("Java", "C++", "HTML"))
                    .name("Tom")
                    .build()
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            List<User> users = serializableService.desirializableRestTemplate();
            users.forEach(user -> System.out.println(user +"\n"));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

}
