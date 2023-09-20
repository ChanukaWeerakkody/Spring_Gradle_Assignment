package lk.ijse.CWTech.service.impl;

import lk.ijse.CWTech.dto.OrderDetailsDTO;
import lk.ijse.CWTech.dto.OrdersDTO;
import lk.ijse.CWTech.dto.TechLeadDTO;
import lk.ijse.CWTech.entity.OrderDetails;
import lk.ijse.CWTech.entity.Orders;
import lk.ijse.CWTech.entity.TechLead;
import lk.ijse.CWTech.repo.OrderDetailsRepo;
import lk.ijse.CWTech.repo.OrdersRepo;
import lk.ijse.CWTech.repo.ProjectRepo;
import lk.ijse.CWTech.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : Chanuka Weerakkody
 * @since : 20.1.1
 **/
@Service
@Transactional
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    /*public ModelMapper modelMapper(){
        return new ModelMapper();
    }*/

    @Autowired
    private OrderDetailsRepo orderDetailsRepo;

    @Autowired
    private ProjectRepo projectRepo;

    @Autowired
    private OrdersRepo ordersRepo;


    @Override
    public void purchaseOrder(OrdersDTO dto) {
        Orders orders = new Orders();
        orders.setOid(dto.getOid());
        orders.setDate(dto.getDate());

        TechLeadDTO techLead = dto.getTechLead();
        TechLead techLeadEntity = new TechLead(techLead.getTechLeadId(), techLead.getName(), techLead.getAddress(), techLead.getSalary());
        orders.setTechLead(techLeadEntity);

        List<OrderDetailsDTO> orderDetailsDtoList = dto.getOrderDetails();
        List<OrderDetails> orderDetailsList = orderDetailsDtoList.stream()
                .map(orderDetailsDto -> {

                    OrderDetails orderDetails = new OrderDetails();
                    orderDetails.setOid(orderDetailsDto.getOid());
                    orderDetails.setProjectId(orderDetailsDto.getProjectId());
                    orderDetails.setCusName(orderDetailsDto.getCusName());
                    orderDetails.setPrice(orderDetailsDto.getPrice());
                    return orderDetails;
                })
                .collect(Collectors.toList());
        orders.setOrderDetails(orderDetailsList);


        if(!ordersRepo.existsById(dto.getOid())){
            ordersRepo.save(orders);
            if(dto.getOrderDetails().size() < 1)throw new RuntimeException("No items added!");

        }else {
            throw new RuntimeException("Purchase order failed!");
        }

    }

    @Override
    public void deleteOrder(String oid) {
        if(ordersRepo.existsById(oid)){
            ordersRepo.deleteById(oid);
        }else {
            throw new RuntimeException("Order delete failed!");
        }
    }

    @Override
    public void updateOrder(OrdersDTO dto) {
        /*Orders orders = mapper.map(dto, Orders.class);
        if(ordersRepo.existsById(dto.getOid())){
            mapper.map(dto, Orders.class);
            if(dto.getOrderDetails().size() < 1)throw new RuntimeException("No items found!");


            for (OrderDetails od : orders.getOrderDetails()) {
                Item item = itemRepo.findById(od.getItemCode()).get();
                OrderDetails previous = orderDetailsRepo.findById(new OrderItem_PK(od.getOid(), od.getItemCode()));

                int newQty = od.getQty();
                int prevQty = previous.getQty();
                if(newQty > prevQty){
                    int dif=newQty-prevQty;
                    item.setQtyOnHand(item.getQtyOnHand()-dif);

                }else if(newQty < prevQty) {
                    int dif =prevQty -newQty;
                    item.setQtyOnHand(item.getQtyOnHand()+dif);
                }
                itemRepo.save(item);
            }
            //delete the old order
            ordersRepo.deleteById(dto.getOid());

            //finally update order
            ordersRepo.save(orders);

        }else{
            throw new RuntimeException("Order update failed!");
        }*/
    }

    @Override
    public OrdersDTO searchOrder(String oid) {
        /*if(ordersRepo.existsById(oid)){
            return mapper.map(ordersRepo.findById(oid),OrdersDTO.class);
        }else{
            throw new RuntimeException("Search Order Failed!");
        }*/
        return null;
    }

    @Override
    public List<OrderDetails> getAllOrder() {
      return null;
    }
}
