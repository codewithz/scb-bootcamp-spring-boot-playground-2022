package com.scb.rpg.springplayground.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scb.rpg.springplayground.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
