package com.example.springbootdemo.repo;


import com.example.springbootdemo.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface CustomerRepo extends JpaRepository<Customers, Integer> {
}
