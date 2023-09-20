package lk.ijse.CWTech.service;

import lk.ijse.CWTech.dto.OrdersDTO;
import lk.ijse.CWTech.entity.OrderDetails;

import java.util.List;

/**
 * @author : Chanuka Weerakkody
 * @since : 20.1.1
 **/

public interface PurchaseOrderService {
    void purchaseOrder(OrdersDTO dto);
    void deleteOrder(String oid);
    void updateOrder(OrdersDTO dto);
    OrdersDTO searchOrder(String oid);
    List<OrderDetails> getAllOrder();
}
