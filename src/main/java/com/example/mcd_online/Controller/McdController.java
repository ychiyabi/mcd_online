package com.example.mcd_online.Controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mcd_online.Service.McdService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class McdController {
    @Autowired
    McdService service;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(value = "/generateMcd", consumes = "application/json", produces = "application/json")
    public UUID generateMCD(@RequestBody String eq) {
        String mcd_name = new String();
        ObjectMapper object_mapper = new ObjectMapper();
        try {
            JsonNode json_node = object_mapper.readTree(eq);
            mcd_name = json_node.get("mcd_name").asText();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.service.generateBlankMcd(mcd_name);
    }
}
