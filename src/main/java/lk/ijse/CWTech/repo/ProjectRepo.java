package lk.ijse.CWTech.repo;

import lk.ijse.CWTech.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : Chanuka Weerakkody
 * @since : 20.1.1
 **/

public interface ProjectRepo extends JpaRepository<Project,String> {
}
