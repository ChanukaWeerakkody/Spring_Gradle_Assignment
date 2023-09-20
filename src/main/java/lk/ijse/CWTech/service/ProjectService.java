package lk.ijse.CWTech.service;

import lk.ijse.CWTech.dto.ProjectDTO;

import java.util.List;

/**
 * @author : Chanuka Weerakkody
 * @since : 20.1.1
 **/

public interface ProjectService {
    void saveProject(ProjectDTO dto);
    void deleteProject(String id);
    void updateProject(ProjectDTO dto);
    ProjectDTO searchProject(String id);
    List<ProjectDTO> getAllProject();
}
