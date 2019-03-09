package com.test.service;

import com.test.entity.User;
import com.test.mapper.ObjectMapper;
import com.test.model.UserDTO;
import com.test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl implements  UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public UserDTO save(UserDTO userDTO) {
        User user = objectMapper.convertToEntity(userDTO);
        User userNew = userRepository.save(user);
        return objectMapper.convertToDto(userNew);
    }

    @Override
    public UserDTO findOne(Long id) {
        return objectMapper.convertToDto(userRepository.findOne(id));
    }

    @Override
    public List<UserDTO> findAll() {
        List<UserDTO> users = new ArrayList<>();
        Iterable<User> iterable = userRepository.findAll();
        iterable.forEach(user -> {
            users.add(objectMapper.convertToDto(user));
        });
        return users;
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        User user = userRepository.findOne(userDTO.getId());
        user.setEmail(userDTO.getEmail());
        user.setNome(userDTO.getNome());
        user.setSexo(userDTO.getSexo());
        user.setTelefone(userDTO.getTelefone());
        User userUpdate = userRepository.save(user);
        return objectMapper.convertToDto(userUpdate);
    }
}
