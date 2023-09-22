package lk.ijse.CWTech.controller;

import lk.ijse.CWTech.dto.TechLeadDTO;
import lk.ijse.CWTech.service.TechLeadService;
import lk.ijse.CWTech.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author : Chanuka Weerakkody
 * @since : 20.1.1
 **/
@RestController
@RequestMapping("api/v1/tech_lead")
@CrossOrigin
public class TechLeadController {
    @Autowired
    TechLeadService techLeadService;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllTechLead(){
        return new ResponseUtil(200,"Success",techLeadService.getAllTechLead());
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveTechLead(@ModelAttribute TechLeadDTO techLeadDTO){
        if(techLeadDTO.getTechLeadId()==null || !techLeadDTO.getTechLeadId().matches("\"^(T)[-]?[0-9]{3}$\"")){
            throw new RuntimeException("Invalid id");
        }else if(techLeadDTO.getName()==null || !techLeadDTO.getName().matches("^[A-z ]{5,30}$")){
            throw new RuntimeException("Invalid name");
        }else if(techLeadDTO.getAddress()==null || !techLeadDTO.getAddress().matches("^[A-z 0-9 \\/\\,]{2,50}[A-z 0-9]{1,50}$")){
            throw new RuntimeException("Invalid address");
        }else if(techLeadDTO.getSalary() == 0){
            throw new RuntimeException("Invalid salary");
        }

        techLeadService.saveTechLead(techLeadDTO);
        return new ResponseUtil(200,"Success",techLeadDTO);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateTechLead(@RequestBody TechLeadDTO techLeadDTO){

        if(techLeadDTO.getName()==null || !techLeadDTO.getName().matches("^[A-z ]{5,30}$")){
            throw new RuntimeException("Invalid name");
        }else if(techLeadDTO.getAddress()==null || !techLeadDTO.getAddress().matches("^[A-z 0-9 \\/\\,]{2,50}[A-z 0-9]{1,50}$")){
            throw new RuntimeException("Invalid address");
        }else if(techLeadDTO.getSalary() == 0){
            throw new RuntimeException("Invalid salary");
        }

        techLeadService.updateTechLead(techLeadDTO);
        return new ResponseUtil(200,"Success",techLeadDTO);
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteTechLead(@RequestParam String id){
        techLeadService.deleteTechLead(id);
        return new ResponseUtil(200,"Success",id);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchTechLead(@PathVariable String id){
        return new ResponseUtil(200,"Success",techLeadService.searchTechLead(id));
    }
}
