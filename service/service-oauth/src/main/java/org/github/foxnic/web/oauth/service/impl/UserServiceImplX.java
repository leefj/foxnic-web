package org.github.foxnic.web.oauth.service.impl;

import org.github.foxnic.web.domain.oauth.User;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("UserServiceImplX")
public class UserServiceImplX extends UserServiceImpl {
    @Override
    public User getById(String id) {
        return super.getById(id);
    }
}
