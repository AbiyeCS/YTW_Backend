package com.codewithAbz.fullstackbackend.repository;

import com.codewithAbz.fullstackbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> { // the first value is obvs the model, the second value is the type of the primary key
}
