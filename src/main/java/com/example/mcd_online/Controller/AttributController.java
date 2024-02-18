package com.example.mcd_online.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mcd_online.Service.AttributService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class AttributController {
    @Autowired
    private AttributService service;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(value = "/insertAttribut", consumes = "application/json", produces = "application/json")
    public String store(@RequestBody String eq) {

        ObjectMapper obj = new ObjectMapper();
        try {
            JsonNode json_node = obj.readTree(eq);
            String name = json_node.get("name").asText();
            String type = json_node.get("type").asText();
            boolean is_primary = json_node.get("is_primary").asBoolean();
            String entite = json_node.get("entite").asText();
            return obj.writeValueAsString(this.service.storeAttribut(name, type, is_primary, entite));
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }

    }

}
