package com.example.__JPA_Demo.repositories;

import com.example.__JPA_Demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
