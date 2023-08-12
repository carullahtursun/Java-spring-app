package carulla.CommentsApp.controllers;

import carulla.CommentsApp.entities.User;
import carulla.CommentsApp.repos.UserRepository;
import carulla.CommentsApp.services.UserService;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {


    private UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }


    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUser();
    }

    @PostMapping
    public User createUser(@RequestBody User newUser){
        return userService.saveOneUSer(newUser);

    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId){
        return userService.getOneUser(userId);
    }

    @PutMapping("/{userId}")
    public User putUserById (@PathVariable Long userId , @RequestBody User newUser){
       return userService.updateUser(userId,newUser);

    }

    @DeleteMapping("/{userId}")
    public void deleteUserById(@PathVariable Long userId){
        userService.deleteOneUser(userId);
    }

}
