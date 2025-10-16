package com.example.microservice.service;

import com.example.microservice.constant.AppError;
import com.example.microservice.dto.UserDto;
import com.example.microservice.entity.User;
import com.example.microservice.exception.OrdersException;
import com.example.microservice.mapper.UserMapper;
import com.example.microservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserDto> findAll() { return userMapper.toListDto(userRepository.findAll()); }

    public UserDto findById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toDto)
                .orElseThrow(() -> new OrdersException(AppError.ERROR_GENERAL.getCode(), "USER NOT FOUND: " + id));
    }

    public UserDto save(UserDto userDto) {
        userDto.setCreatedAt(LocalDateTime.now());
        return userMapper.toDto(userRepository.save(userMapper.toEntity(userDto)));
    }

    public UserDto updateByUserId(Long id, UserDto dto) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new OrdersException(AppError.ERROR_GENERAL.getCode(), "USER NOT FOUND: " + id));

        if (StringUtils.hasText(dto.getName()))  user.setName(dto.getName().trim());
        if (StringUtils.hasText(dto.getEmail())) user.setEmail(dto.getEmail().trim());

        try {
            return userMapper.toDto(userRepository.save(user));
        } catch (Exception e) {
            throw new OrdersException(AppError.JPA_EXCEPTION.getCode(), "JPA_EXCEPTION updating user: " + id);
        }
    }

}
