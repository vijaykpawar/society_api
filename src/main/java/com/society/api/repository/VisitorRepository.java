package com.society.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.society.api.model.Visitor;

/**
 * Created by vijay pawar
 */

@Repository
public interface VisitorRepository extends JpaRepository<Visitor, Long> {

}
