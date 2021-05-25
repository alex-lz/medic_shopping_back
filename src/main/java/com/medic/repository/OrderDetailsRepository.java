package com.medic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medic.model.OrderDetails;
import com.medic.model.OrderDetailsID;


@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, OrderDetailsID>{

}
