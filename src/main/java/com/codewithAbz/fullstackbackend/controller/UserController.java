package com.codewithAbz.fullstackbackend.controller;

import com.codewithAbz.fullstackbackend.exception.UserNotFoundException;
import com.codewithAbz.fullstackbackend.model.User;
import com.codewithAbz.fullstackbackend.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
/*
@RestController: This annotation is part of the Spring Framework and is used to indicate that the class defines a RESTful controller.
In the context of a Spring Boot application, it combines @Controller and @ResponseBody, indicating that the return value of methods
should be directly serialized to the HTTP response body.
* */
@CrossOrigin("http://localhost:3000") // We add this line to connect to the frontend
@Validated // This annotation is used at the class level to indicate that the class and its methods should be validated. In this case, it's often used in conjunction with method-level validation using @Valid.

public class UserController {

    @Autowired
    private UserRepository userRepository;

    /*
    * @Autowired: This annotation is used for automatic dependency injection. In this case,
    * it injects an instance of the UserRepository interface into the userRepository field.
    * Dependency injection is a design pattern in which the object's dependencies are injected into it rather than the
    * object creating them itself.
    *
    * */

    /*
    * @PostMapping("/user"): This annotation maps HTTP POST requests to the specified URI ("/user") to the newUser method.
    * It indicates that this method will handle requests for creating a new user.
    * */
//    @PostMapping("/user") // Send data to DB
//    User newUser(@RequestBody User newUser){
//        return  userRepository.save(newUser);
//    }

    /*
    * User newUser(@RequestBody User newUser): This method is responsible for handling HTTP POST requests.
    * It takes a User object as the request body, which is deserialized from the incoming JSON data.
    *
    * The @RequestBody annotation is used to indicate that the newUser parameter should be bound to the body of the HTTP request.
    *
    * userRepository.save(newUser): This line saves the provided User object (newUser) to the database using the save method
    * of the UserRepository. The UserRepository is presumably an interface that extends Spring Data JPA's JpaRepository
    * or a similar interface, providing CRUD (Create, Read, Update, Delete) operations for the User entity.
     * */


    @PostMapping("/user")
    public ResponseEntity<?> newUser(@Valid @RequestBody User newUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Log validation errors
            bindingResult.getAllErrors().forEach(error -> {
                System.out.println(error.getDefaultMessage());
            });

            // You might want to return a ResponseEntity with a meaningful response or throw an exception
            return ResponseEntity.badRequest().body("Validation error");
        }

        User savedUser = userRepository.save(newUser);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping("/users") // Returns all the users
    List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    User getUserById(@PathVariable Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }
    /*
    * •	@GetMapping("/{id}"): Handles HTTP GET requests at the specified endpoint ("/api/users/{id}").
•	@PathVariable Long id: Extracts the value of the "id" variable from the request path.
•	userRepository.findById(id): Retrieves a user from the repository by ID.
•	.orElseThrow(() -> new UserNotFoundException(id)): Throws a UserNotFoundException if the user with the given ID is not found.
    *
    * */

    @PutMapping("/user/{id}")
    User updateUser(@RequestBody User newUser, @PathVariable Long id){
        return  userRepository.findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    return userRepository.save(user);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }

    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id){
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }

        userRepository.deleteById(id);
        return "User with id "+id+" has been deleted successfully ";
    }
}
