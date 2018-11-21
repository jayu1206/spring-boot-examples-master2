package com.springboot.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rest.dto.UserMongoDbContactDTO;
import com.springboot.rest.dto.UserMongoDbDTO;
import com.springboot.rest.dto.UserUpdateDTO;
import com.springboot.rest.dto.UserUpdatePatchDTO;
import com.springboot.rest.response.SuccessResponse;
import com.springboot.rest.service.UserMongoDbService;

/**
 * @author Jay Gagnani
 * @since 2018-11-24
 */
@RestController
@RequestMapping("/api/user/mongodb")
public class UserMongoDbController {

    @Autowired
    private UserMongoDbService userMongoDbService;

    @PostMapping
    public ResponseEntity<UserMongoDbDTO> addUser(@Valid @RequestBody UserMongoDbDTO userDTO) {
        return ResponseEntity.ok(userMongoDbService.addUser(userDTO));
    }

    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public ResponseEntity<List<UserMongoDbContactDTO>> getAllUser() {
        return ResponseEntity.ok(userMongoDbService.getAllUsers());
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<UserMongoDbDTO> getUser(@RequestParam String id) {
        return ResponseEntity.ok(userMongoDbService.getUser(id));
    }
    
    

    @PutMapping
    public ResponseEntity<UserMongoDbDTO> updateUser(@Valid @RequestBody UserUpdateDTO userUpdateDTO, @RequestParam String id) {
        return ResponseEntity.ok(userMongoDbService.updateUser(userUpdateDTO, id));
    }
    
    @PatchMapping
    public ResponseEntity<UserMongoDbDTO> updatePatchUser(@Valid @RequestBody UserUpdatePatchDTO userUpdateDTO, @RequestParam String id) {
        return ResponseEntity.ok(userMongoDbService.updatePatchUser(userUpdateDTO, id));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUser(@RequestParam String id) {
        userMongoDbService.deleteUser(id);
        return ResponseEntity.ok(new SuccessResponse("deleted"));
    }
}
