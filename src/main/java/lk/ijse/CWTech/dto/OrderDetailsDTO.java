package lk.ijse.CWTech.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author : Chanuka Weerakkody
 * @since : 20.1.1
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class OrderDetailsDTO {
    private String oid;
    private String projectId;
    private String cusName;
    private double price;
}
