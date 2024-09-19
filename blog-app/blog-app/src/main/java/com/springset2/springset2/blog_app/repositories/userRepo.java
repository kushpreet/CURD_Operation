package com.springset2.springset2.blog_app.repositories;

import com.springset2.springset2.blog_app.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepo extends JpaRepository<User,Integer> {
}
