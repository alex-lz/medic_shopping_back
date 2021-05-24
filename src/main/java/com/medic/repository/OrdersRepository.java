package com.medic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medic.model.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long>{

}
