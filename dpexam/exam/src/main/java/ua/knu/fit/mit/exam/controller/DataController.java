package ua.knu.fit.mit.exam.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;
import ua.knu.fit.mit.exam.entity.CyberData;
import ua.knu.fit.mit.exam.repository.DataRepository;

import java.util.List;

@RestController
@RequestMapping("/api/cyberdata")
@Slf4j
public class DataController {
    @Autowired
    DataRepository dataRepository;

    @GetMapping("/get")
    public List<CyberData> getData(){
        List<CyberData> cyberDataList;
        log.info("[CYBERDATA CONTROLLER] Before Get request");
        cyberDataList =dataRepository.findAll();
        log.info("[CYBERDATA CONTROLLER] After Get request was found {} data", cyberDataList.size());
        return cyberDataList;
    }
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CyberData postData(@RequestBody CyberData cyberData){
        log.info("[CYBERDATA CONTROLLER] Before POST request");
        dataRepository.save(cyberData);
        log.info("[CYBERDATA CONTROLLER] After POST request, added {} data", cyberData.getLogin());
        return cyberData;
    }
    @PutMapping("/update/{id}")
    public CyberData putData(@PathVariable(name = "id") long id, @RequestBody CyberData newData){
        log.info("[CYBERDATA CONTROLLER] PUT method");
        CyberData updateData = dataRepository.findById(id)
                .orElseThrow(()->{
                    log.error("[CYBERDATA CONTROLLER] PUT was failed, no found data with such id {}",id);
                    return new ResourceAccessException("No find data with id: "+id);
                });
        updateData.setLogin(newData.getLogin());
        updateData.setPassword_length(newData.getPassword_length());
        updateData.setPersonal_key(newData.getPersonal_key());
        updateData.setPassword(newData.getPassword());
        dataRepository.save(updateData);
        log.info("[CYBERDATA CONTROLLER] PUT method success, data with id {} changed",id);
        return updateData;
    }
    @DeleteMapping("/delete/{id}")
    public void deleteData(@PathVariable(name = "id") long id){
        log.info("[CYBERDATA CONTROLLER] DELETE method");
        CyberData deleted_data= dataRepository.findById(id)
                .orElseThrow(()->{
                    log.error("[CYBERDATA CONTROLLER] DELETE was failed, no found data with such id {}",id);
                    return new ResourceAccessException("No find data with id: "+id);
                });
        dataRepository.deleteById(id);
        log.info("[CYBERDATA CONTROLLER] DELETE method complete. Data {} with id {} was deleted",deleted_data.getLogin(),id);
    }

}
