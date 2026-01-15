package com.example.product_management_system.repo;

import com.example.product_management_system.model.Order_Header;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderHeaderRepo extends JpaRepository<Order_Header, Integer>
{

}

