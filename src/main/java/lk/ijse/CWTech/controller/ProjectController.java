package lk.ijse.CWTech.controller;

import lk.ijse.CWTech.dto.ProjectDTO;
import lk.ijse.CWTech.service.ProjectService;
import lk.ijse.CWTech.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author : Chanuka Weerakkody
 * @since : 20.1.1
 **/
@RestController
@RequestMapping("api/v1/project")
@CrossOrigin
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllProject(){
        return new ResponseUtil(200,"Success",projectService.getAllProject());
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveProject(@ModelAttribute ProjectDTO projectDTO){
        projectService.saveProject(projectDTO);
        return new ResponseUtil(200,"Success",projectDTO);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateProject(@RequestBody ProjectDTO projectDTO){
        projectService.updateProject(projectDTO);
        return new ResponseUtil(200,"Success",projectDTO);
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteProject(@RequestParam String id){
        projectService.deleteProject(id);
        return new ResponseUtil(200,"Success",id);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchProject(@PathVariable String id){
        return new ResponseUtil(200,"Success",projectService.searchProject(id));
    }
}
