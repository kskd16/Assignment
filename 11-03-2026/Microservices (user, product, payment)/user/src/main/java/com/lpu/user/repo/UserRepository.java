package com.lpu.user.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.lpu.user.entity.User;


public interface UserRepository extends JpaRepository<User, Integer> {

}
