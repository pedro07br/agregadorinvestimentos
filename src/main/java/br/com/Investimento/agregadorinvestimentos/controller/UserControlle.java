package br.com.Investimento.agregadorinvestimentos.controller;


import br.com.Investimento.agregadorinvestimentos.controller.dto.CreateAccountDto;
import br.com.Investimento.agregadorinvestimentos.controller.dto.CreaterUserDto;
import br.com.Investimento.agregadorinvestimentos.controller.dto.UpdateUserDto;
import br.com.Investimento.agregadorinvestimentos.entity.User;
import br.com.Investimento.agregadorinvestimentos.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserControlle {

    private UserService userService;

    public UserControlle(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody CreaterUserDto createrUserDto) {
        User userCreated = userService.createUserAndReturnUser(createrUserDto);
        return ResponseEntity
                .created(URI.create("/v1/users/" + userCreated.getUserId()))
                .body(userCreated);
    }


    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") String userId) {
        var user = userService.getUserById(userId);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<User>> listUsers() {
       var users = userService.listUsers();

       return ResponseEntity.ok(users);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Void> updateUserById(@PathVariable("userId") String userId,
                                               @RequestBody UpdateUserDto updateUserDto){
        userService.updateUserById(userId, updateUserDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteById(@PathVariable("userId") String userId){
        userService.deleteById(userId);
        return  ResponseEntity.noContent().build();
    }

    @PostMapping("/{userId}/account")
    public ResponseEntity<Void> deleteById(@PathVariable("userId") String userId,
                                           @RequestBody CreateAccountDto createAccountDto){
        userService.createAccount(userId, createAccountDto);
        return  ResponseEntity.ok().build();
    }
}
