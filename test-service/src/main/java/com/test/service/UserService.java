package com.test.service;

import com.test.model.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO save(UserDTO userDTO);

    UserDTO findOne(Long id);

    List<UserDTO> findAll();

    void delete(Long id);

    UserDTO update(UserDTO userDTO);
}
