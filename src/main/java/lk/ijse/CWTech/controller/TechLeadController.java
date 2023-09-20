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
        techLeadService.saveTechLead(techLeadDTO);
        return new ResponseUtil(200,"Success",techLeadDTO);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateTechLead(@RequestBody TechLeadDTO techLeadDTO){
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
