package com.test.api.user;

import com.test.model.UserDTO;
import com.test.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RequiredArgsConstructor
public class UserResource {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserResource.class);

    private final UserService userService;

    @PostMapping
    public @ResponseBody ResponseEntity saveUser(@RequestBody UserDTO userDTO){
        try{
            UserDTO dto = userService.save(userDTO);
            return ResponseEntity.status(200).body(dto);
        }catch (Exception e){
            LOGGER.error("ERROR {}", e.getMessage());
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping
    public @ResponseBody ResponseEntity listAllUser(){
        try{
            List<UserDTO> list = userService.findAll();
            return ResponseEntity.status(200).body(list);
        }catch (Exception e){
            LOGGER.error("ERROR {}", e.getMessage());
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity findUserById(@PathVariable("id") Long id){
        try{
            UserDTO userDTO = userService.findOne(id);
            return ResponseEntity.status(200).body(userDTO);
        }catch (Exception e){
            LOGGER.error("ERROR {}", e.getMessage());
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUserById(@PathVariable("id") Long id){
        try{
            userService.delete(id);
            return ResponseEntity.status(200).build();
        }catch (Exception e){
            LOGGER.error("ERROR {}", e.getMessage());
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping("/{id}")
    public @ResponseBody ResponseEntity updateUserById(@PathVariable("id") Long id, @RequestBody UserDTO userDTO){
        try{
            userDTO.setId(id);
            UserDTO dtoUpdate = userService.update(userDTO);
            return ResponseEntity.status(200).body(dtoUpdate);
        }catch (Exception e){
            LOGGER.error("ERROR {}", e.getMessage());
            return ResponseEntity.status(500).build();
        }
    }
}
