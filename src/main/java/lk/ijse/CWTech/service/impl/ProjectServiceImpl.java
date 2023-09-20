package lk.ijse.CWTech.service.impl;

import lk.ijse.CWTech.dto.ProjectDTO;
import lk.ijse.CWTech.entity.Project;
import lk.ijse.CWTech.repo.ProjectRepo;
import lk.ijse.CWTech.service.ProjectService;
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
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    private ProjectRepo projectRepo;

    @Override
    public void saveProject(ProjectDTO dto) {
       if(!projectRepo.existsById(dto.getProjectId())){
            Project project = new Project(dto.getProjectId(), dto.getCusName(), dto.getDate(),dto.getPrice());
            projectRepo.save(project);
        }else{
            throw new RuntimeException("Project id is already exists!");
        }
    }

    @Override
    public void deleteProject(String id) {
        if (projectRepo.existsById(id)){
            projectRepo.deleteById(id);
        }else {
            throw new RuntimeException("Project id is not found to delete!");
        }
    }

    @Override
    public void updateProject(ProjectDTO dto) {
        if(projectRepo.existsById(dto.getProjectId())){
            Project project = new Project(dto.getProjectId(), dto.getCusName(), dto.getDate(),dto.getPrice());
            projectRepo.save(project);
        }else {
            throw new RuntimeException("Project id is not found to update!");
        }
    }

    @Override
    public ProjectDTO searchProject(String id) {
        if(projectRepo.existsById(id)){
            Project project = projectRepo.findById(id).get();
            return new ProjectDTO(project.getProjectId(), project.getCusName(), project.getDate(), project.getPrice());
        }else {
            throw new RuntimeException("No project : "+id+" is found!");
        }
    }

    @Override
    public List<ProjectDTO> getAllProject() {
        List<Project> all = projectRepo.findAll();
        List<ProjectDTO> arrayList =new ArrayList<>();
        for (Project project : all) {
            arrayList.add(new ProjectDTO(project.getProjectId(), project.getCusName(), project.getDate(), project.getPrice()));
        }
        return arrayList;
    }
}
