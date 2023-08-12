package carulla.CommentsApp.services;

import carulla.CommentsApp.entities.User;
import carulla.CommentsApp.repos.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User saveOneUSer(User newUser) {
        return userRepository.save(newUser);

    }

    public User getOneUser(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public User updateUser(Long userId, User newUser) {
        Optional<User> user =userRepository.findById(userId);
        if (user.isPresent()){
            User founUser =user.get();
            founUser.setUserName(newUser.getUserName());
            founUser.setPassword(newUser.getPassword());
            userRepository.save(founUser);
            return founUser;
        }
        else return null;
    }

    public void deleteOneUser(Long userId) {
        userRepository.deleteById(userId);
    }


}
