package com.assignment1.wasteless.Data.Repository;

import com.assignment1.wasteless.Presentation.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
