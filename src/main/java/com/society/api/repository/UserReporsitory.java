package com.society.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.society.api.model.User;

@Repository
public interface UserReporsitory  extends JpaRepository<User,Long>{

}
