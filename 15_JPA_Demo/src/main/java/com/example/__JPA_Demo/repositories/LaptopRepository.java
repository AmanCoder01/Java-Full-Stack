package com.example.__JPA_Demo.repositories;

import com.example.__JPA_Demo.entity.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepository extends JpaRepository<Laptop,Long> {
}
