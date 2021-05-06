package com.medic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medic.model.Shoppingcart;
import com.medic.model.ShoppingcartID;


@Repository
public interface ShoppingcartRepository extends JpaRepository<Shoppingcart, ShoppingcartID>{

}
