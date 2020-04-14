package com.example.database.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.database.entities.Grade;

public interface GradeRepository extends JpaRepository<Grade, Integer> {

}
