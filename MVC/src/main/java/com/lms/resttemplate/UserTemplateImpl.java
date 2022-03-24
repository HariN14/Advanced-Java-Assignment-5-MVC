package com.lms.resttemplate;

import com.lms.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserTemplateImpl implements UserTemplate{

    @Autowired
    private RestTemplate restTemplate;

    private String URL = "http://localhost:7070/lms/user";

    @Override
    public User getUser(String userId) {
        String url = URL + "/" + userId;
        ResponseEntity<User> response = restTemplate.getForEntity(url,User.class);
        return response.getBody();
    }

    @Override
    public void addUser(User user) {
        restTemplate.postForEntity(URL, user, String.class);
    }

    @Override
    public void updateUser(User user) {
        restTemplate.put(URL, User.class);
    }
}
