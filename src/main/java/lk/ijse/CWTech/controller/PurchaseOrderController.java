package lk.ijse.CWTech.controller;

import lk.ijse.CWTech.dto.OrdersDTO;
import lk.ijse.CWTech.service.PurchaseOrderService;
import lk.ijse.CWTech.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author : Chanuka Weerakkody
 * @since : 20.1.1
 **/
@RestController
@RequestMapping("api/v1/purchase_Order")
@CrossOrigin
public class PurchaseOrderController {
    @Autowired
    PurchaseOrderService purchaseOrderService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllItem(){
        return new ResponseUtil(200,"Success",purchaseOrderService.getAllOrder());
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil purchaseOrder(@RequestBody OrdersDTO ordersDTO){
        System.out.println(ordersDTO.toString());
        purchaseOrderService.purchaseOrder(ordersDTO);
        return new ResponseUtil(200,"Success",ordersDTO);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateOrder(@RequestBody OrdersDTO ordersDTO){
        purchaseOrderService.updateOrder(ordersDTO);
        return new ResponseUtil(200,"Success",ordersDTO);
    }
}
