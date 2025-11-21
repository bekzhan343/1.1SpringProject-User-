package com.example1._SpringProjects.Repository;

import com.example1._SpringProjects.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
