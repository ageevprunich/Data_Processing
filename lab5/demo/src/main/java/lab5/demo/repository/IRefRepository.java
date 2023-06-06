package lab5.demo.repository;

import lab5.demo.Entity.Refugees;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface IRefRepository extends JpaRepository<Refugees,Integer>{

}
