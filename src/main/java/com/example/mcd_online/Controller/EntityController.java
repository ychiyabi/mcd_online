package com.example.mcd_online.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mcd_online.Entity.Entite;
import com.example.mcd_online.Service.EntityService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.mcd_online.Repository.*;

@RestController
public class EntityController {
    @Autowired 
 private EntiteRepository repository;
    @GetMapping("/")
    public String getSpecificEntity(){
        ObjectMapper obj=new ObjectMapper();
        
        /* entity.setName("teste");
        entity.setDescription("teste");
        this.repository.save(entity);
        Entite entite=this.repository.findById(entity.getId()); */
        EntityService service=new EntityService();
        Entite entite=service.getEntity(service.insertEntite());
        try{
            return obj.writeValueAsString(entite);
        }catch(Exception e){
            e.printStackTrace();
            return "Error";
        }
        
    }
    
}
