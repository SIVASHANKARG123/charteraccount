package com.example.springbootdemo.service;


import com.example.springbootdemo.entity.Retailer;
import com.example.springbootdemo.repo.RetailerRepo;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CustRetailServices {


private RetailerRepo retailerRepo;

public CustRetailServices(RetailerRepo retailerRepo){
    this.retailerRepo = retailerRepo;
}

    public int calculatePoints(Double amount) {
        int points = 0;
        if (amount > 100) {
            points += (amount.intValue() - 100) * 2;
            points += 50;
        } else if (amount > 50) {
            points += (amount.intValue() - 50) * 1;
        }
        return points;
    }

    public Map<String, Object> getCustomerRewards(Integer cusId) {
        LocalDateTime threeMonthsAgo = LocalDateTime.now().minusMonths(3);
        LocalDateTime now = LocalDateTime.now();

        List<Retailer> transactions = retailerRepo.findByCustomerIdAndDateBetween(cusId, threeMonthsAgo, now);


        Map<String, Integer> monthlyPoints = transactions.stream()
                .collect(Collectors.groupingBy(
                        transaction -> transaction.getPurchaseDate().getMonth().toString() + "-" + transaction.getPurchaseDate().getYear(),
                        Collectors.summingInt(transaction -> calculatePoints(transaction.getReItemPrice()))
                ));

        int totalPoints = monthlyPoints.values().stream().mapToInt(Integer::intValue).sum();


        return Map.of(
                "cusId", cusId,
                "monthlyRewards", monthlyPoints,
                "totalPoints", totalPoints
        );
    }

}
