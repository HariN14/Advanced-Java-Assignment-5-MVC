package com.lms.resttemplate;

import com.lms.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class AuthorTemplateImpl implements AuthorTemplate{

    @Autowired
    private RestTemplate restTemplate;

    private String URL = "http://localhost:7070/lms/authors";

    @Override
    public List<Author> getAuthors() {
        ResponseEntity<Author[]> responseEntity = restTemplate.getForEntity(URL,Author[].class);
        return Arrays.asList(responseEntity.getBody());
    }
}
