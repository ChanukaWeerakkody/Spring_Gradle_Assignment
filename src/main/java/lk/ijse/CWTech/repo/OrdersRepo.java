package lk.ijse.CWTech.repo;

import lk.ijse.CWTech.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : Chanuka Weerakkody
 * @since : 20.1.1
 **/

public interface OrdersRepo extends JpaRepository<Orders,String> {
}
