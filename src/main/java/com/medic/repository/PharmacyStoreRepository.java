package com.medic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medic.model.PharmacyStore;
import com.medic.model.PharmacyStoreID;


@Repository
public interface PharmacyStoreRepository extends JpaRepository<PharmacyStore, PharmacyStoreID>{

}
