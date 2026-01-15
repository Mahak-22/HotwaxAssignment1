package com.example.product_management_system.repo;

import com.example.product_management_system.model.Contact_Mech;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactMechRepo extends JpaRepository<Contact_Mech, Integer>
{

}
