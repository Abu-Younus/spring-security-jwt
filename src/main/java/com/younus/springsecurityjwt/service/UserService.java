package com.younus.springsecurityjwt.service;

import com.younus.springsecurityjwt.domain.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    UserDto saveUser(UserDto userDto);
}
