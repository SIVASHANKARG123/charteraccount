package com.example.springbootdemo.repo;


import com.example.springbootdemo.entity.Retailer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RetailerRepo extends JpaRepository<Retailer,Integer> {
    List<Retailer> findByCustomerIdAndDateBetween(Integer cusId, LocalDateTime startDate, LocalDateTime endDate);

}
