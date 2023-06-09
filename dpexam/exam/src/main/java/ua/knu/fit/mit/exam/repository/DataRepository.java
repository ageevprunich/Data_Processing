package ua.knu.fit.mit.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ua.knu.fit.mit.exam.entity.CyberData;
@RepositoryRestResource(collectionResourceRel = "cyberdata",path = "cyberdata")
public interface DataRepository extends JpaRepository<CyberData,Long> {
}
