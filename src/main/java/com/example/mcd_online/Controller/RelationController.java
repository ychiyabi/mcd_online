package com.example.mcd_online.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.mcd_online.Entity.Relation;
import com.example.mcd_online.Service.RelationService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class RelationController {

    @Autowired
    private RelationService service;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(value = "/insertRelation", consumes = "application/json", produces = "application/json")
    public Relation storeRelation(@RequestBody String eq) {

        ObjectMapper obj = new ObjectMapper();
        String car_one = null;
        String car_two = null;
        String entity_one = null;
        String entity_two = null;
        String name = null;

        try {
            JsonNode json_node = obj.readTree(eq);
            name = json_node.get("name").asText();
            car_one = json_node.get("car_one").asText();
            car_two = json_node.get("car_two").asText();
            entity_one = json_node.get("entity_one").asText();
            entity_two = json_node.get("entity_two").asText();
            return service.storeRelation(name, entity_one, entity_two, car_one, car_two);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
