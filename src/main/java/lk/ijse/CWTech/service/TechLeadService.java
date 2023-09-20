package lk.ijse.CWTech.service;

import lk.ijse.CWTech.dto.TechLeadDTO;

import java.util.List;

/**
 * @author : Chanuka Weerakkody
 * @since : 20.1.1
 **/

public interface TechLeadService {
    void saveTechLead(TechLeadDTO dto);
    void deleteTechLead(String id);
    void updateTechLead(TechLeadDTO dto);
    TechLeadDTO searchTechLead(String id);
    List<TechLeadDTO> getAllTechLead();
}
