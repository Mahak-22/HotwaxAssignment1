package com.example.product_management_system.repo;

import com.example.product_management_system.model.Order_Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepo extends JpaRepository<Order_Item, Integer>
{
    Order_Item findByOrderItemSeqIdAndOrderHeader_OrderId(int orderItemSeqId, int orderId);

}
