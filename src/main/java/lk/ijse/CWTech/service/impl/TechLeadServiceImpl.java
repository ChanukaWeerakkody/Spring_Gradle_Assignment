package lk.ijse.CWTech.service.impl;

import lk.ijse.CWTech.dto.TechLeadDTO;
import lk.ijse.CWTech.entity.TechLead;
import lk.ijse.CWTech.repo.TechLeadRepo;
import lk.ijse.CWTech.service.TechLeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Chanuka Weerakkody
 * @since : 20.1.1
 **/
@Service
@Transactional
public class TechLeadServiceImpl implements TechLeadService {

    @Autowired
    private TechLeadRepo techLeadRepo;

    @Override
    public void saveTechLead(TechLeadDTO dto) {
        if(!techLeadRepo.existsById(dto.getTechLeadId())){
            TechLead techLead = new TechLead(dto.getTechLeadId(), dto.getName(), dto.getAddress(), dto.getSalary());
            techLeadRepo.save(techLead);
        }else {
            throw new RuntimeException("This tech lead id is already exists!");
        }
    }

    @Override
    public void deleteTechLead(String id) {
        if(techLeadRepo.existsById(id)){
            techLeadRepo.deleteById(id);
        }else {
            throw new RuntimeException("No tech lead is found!");
        }
    }

    @Override
    public void updateTechLead(TechLeadDTO dto) {
        if(techLeadRepo.existsById(dto.getTechLeadId())){
            TechLead techLead = new TechLead(dto.getTechLeadId(), dto.getName(), dto.getAddress(), dto.getSalary());
            techLeadRepo.save(techLead);
        }else {
            throw new RuntimeException("No tech lead is found!");
        }
    }

    @Override
    public TechLeadDTO searchTechLead(String id) {
        if (techLeadRepo.existsById(id)){
            TechLead techLead = techLeadRepo.findById(id).get();
            return new TechLeadDTO(techLead.getTechLeadId(),techLead.getName(),techLead.getAddress(), techLead.getSalary());
        }else {
            throw new RuntimeException("No tech lead is found!");
        }
    }

    @Override
    public List<TechLeadDTO> getAllTechLead() {
        List<TechLead> all = techLeadRepo.findAll();
        ArrayList<TechLeadDTO> arrayList = new ArrayList<>();
        for (TechLead techLead : all) {
            arrayList.add(new TechLeadDTO(techLead.getTechLeadId(),techLead.getName(),techLead.getAddress(), techLead.getSalary()));
        }
        return arrayList;
    }
}
