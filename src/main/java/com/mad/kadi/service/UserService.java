package com.mad.kadi.service;

import java.util.List;

import com.mad.kadi.dto.UserDto;

public interface UserService {

	
	
	UserDto createUser(UserDto userDto);

    UserDto getUserById(Long userId);

    List<UserDto> getAllUser();

    UserDto updateUser(UserDto userDto);

    String deleteByUserId(Long userId);

}
