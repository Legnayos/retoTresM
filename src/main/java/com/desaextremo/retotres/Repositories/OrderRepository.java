package com.desaextremo.retotres.Repositories;

import com.desaextremo.retotres.Entities.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, Integer> {
    @Query("{'salesMan.zone': ?0}")
    public List<Order> findByZona(String zona);

    public List<Order> findAllBySalesMan_Zone(String zona);
}
