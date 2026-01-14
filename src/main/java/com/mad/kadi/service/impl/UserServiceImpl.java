package com.mad.kadi.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mad.kadi.dto.UserDto;
import com.mad.kadi.entity.User;
import com.mad.kadi.repositary.UserRepository;
import com.mad.kadi.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = modelMapper.map(userDto, User.class);
		User savedUser = userRepository.save(user);
		return modelMapper.map(savedUser, UserDto.class);
	}

	@Override
	public UserDto getUserById(Long userId) {
		return userRepository.findById(userId).map(user -> modelMapper.map(user, UserDto.class)).orElse(null);
	}

	@Override
	public List<UserDto> getAllUser() {
		return userRepository.findAll().stream().map(user -> modelMapper.map(user, UserDto.class)).toList();
	}

	@Override
	public UserDto updateUser(UserDto userDto) {
		User existUserInfo = userRepository.findById(userDto.getUserId()).orElse(null);
		existUserInfo.setFirstName(userDto.getFirstName());
		existUserInfo.setLastName(userDto.getLastName());
		existUserInfo.setEmailId(userDto.getEmailId());
		User updatedUser = userRepository.save(existUserInfo);
		return modelMapper.map(updatedUser, UserDto.class);
	}

	@Override
	public String deleteByUserId(Long userId) {
		if (userRepository.existsById(userId)) {
			userRepository.deleteById(userId);
			return "User with id " + userId + " deleted successfully..";
		} else {
			return "User with id " + userId + " not found..";
		}
	}

}
