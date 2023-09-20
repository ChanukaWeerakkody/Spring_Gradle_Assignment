package lk.ijse.CWTech.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @author : Chanuka Weerakkody
 * @since : 20.1.1
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class OrdersDTO {
    private String oid;
/*
    @JsonFormat(pattern = "yyyy-MM-dd")
*/
    private String date;
    private TechLeadDTO techLead;
    private List<OrderDetailsDTO> orderDetails;

}
