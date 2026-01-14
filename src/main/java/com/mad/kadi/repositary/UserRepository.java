package com.mad.kadi.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mad.kadi.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
