package com.javamentor.sbcrudex.controller;

import com.javamentor.sbcrudex.model.Role;
import com.javamentor.sbcrudex.model.User;
import com.javamentor.sbcrudex.service.RoleService;
import com.javamentor.sbcrudex.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class RestUserController {
    private UserService userService;

    private RoleService roleService;

    public RestUserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @RequestMapping(value = "/rest/admin/add", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, headers = "Accept=application/json")
    public User addNewUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @RequestMapping(value = "/rest/admin/update", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, headers = "Accept=application/json")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @RequestMapping(value = "/rest/admin/getListUsers", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE, headers = "Accept=application/json")
    public List<User> getListUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/rest/admin/getUserById/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE, headers = "Accept=application/json")
    public User getUserById(@PathVariable("id") int id) {
        return userService.getUserById(id);
    }

    @RequestMapping(value = "/rest/admin/getRoleByName/{name}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE, headers = "Accept=application/json")
    public Role getRoleByName(@PathVariable("name") String name) {
        return roleService.getRoleName(name);
    }

    @RequestMapping(value = "/rest/admin/delete/{id}", method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE, headers = "Accept=application/json")
    public void deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
    }

}
