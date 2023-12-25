package com.codewithAbz.fullstackbackend.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long id){
        super("Could not find the user with id: "+ id);
    }

    /*
    * Within the Exception folder we add a UserNotFoundException that extends a runtime exception,
    * we pass the message to the parent class RuntimeException within the class constructor.

•	UserNotFoundException is a custom exception class that extends RuntimeException.
•	It is thrown in the UserController when a user with a specified ID is not found in the repository.
•	The exception message is constructed with the provided user ID.

    *
    * */
}
