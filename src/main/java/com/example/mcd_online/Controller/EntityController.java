package com.example.mcd_online.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.mcd_online.Entity.Entite;
import com.example.mcd_online.Service.EntityService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class EntityController {

    @Autowired
    EntityService service;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(value = "/insertEntity", consumes = "application/json", produces = "application/json")
    public String storeEntity(@RequestBody String eq) {
        ObjectMapper obj = new ObjectMapper();
        String entity_name = new String();
        String mcd_uid = new String();
        Integer id_entity = null;
        try {
            JsonNode json_node = obj.readTree(eq);
            entity_name = json_node.get("entity").asText();
            mcd_uid = json_node.get("mcd").asText();
            id_entity = service.insertEntite(entity_name, mcd_uid);
            Entite entite = this.service.getEntity(id_entity);
            return obj.writeValueAsString(entite);
        } catch (Exception e) {
            e.printStackTrace();
            return ("error");
        }

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("getEntityById/{id_entity}")
    public String getEntity(String id_entity) {
        ObjectMapper obj = new ObjectMapper();
        try {
            Entite entite = this.service.getEntity(Integer.parseInt(id_entity));
            return obj.writeValueAsString(entite);
        } catch (Exception e) {
            e.printStackTrace();
            return ("error");
        }

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getEntitesByMcd")
    public String getEntitesByMcd(@RequestParam String mcd_uid) {
        ObjectMapper obj = new ObjectMapper();
        List<Entite> entites = this.service.getEntities(mcd_uid);
        try {
            return obj.writeValueAsString(entites);
        } catch (Exception e) {
            e.printStackTrace();
            return ("error");
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/deleteEntity")
    public String deleteEntity(@RequestParam String id) {
        try {
            this.service.deleteEntity(id);
            return ("success");
        } catch (Exception e) {
            e.printStackTrace();
            return ("eeeeerror");
        }
    }

}
