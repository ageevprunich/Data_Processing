package lab5.demo.repository;

import lab5.demo.Entity.Refugees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RefService {
    @Autowired
    private IRefRepository repo;

    public List<Refugees> listAll(){
        return repo.findAll();
    }

    public void save(Refugees refugees){
        repo.save(refugees);
    }

    public Refugees get(Integer id){
        return repo.findById(id).get();
    }
    public void delete(Integer id){
        repo.deleteById(id);
    }
}
