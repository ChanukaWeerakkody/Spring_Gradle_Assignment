package lk.ijse.CWTech.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * @author : Chanuka Weerakkody
 * @since : 20.1.1
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class Orders {
    @Id
    private String oid;

    private String date;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "id",referencedColumnName = "techLeadId",nullable = false)
    private TechLead techLead;

    @OneToMany(mappedBy = "orders" , cascade = CascadeType.ALL)
    private List<OrderDetails> orderDetails;



}
