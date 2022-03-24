package com.lms.resttemplate;

import com.lms.model.User;

public interface UserTemplate {

    User getUser(String userId);

    void addUser(User user);

    void updateUser(User user);
}
