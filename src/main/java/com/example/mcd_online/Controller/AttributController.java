package com.example.mcd_online.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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

        String name = null;
        String entite = null;
        String is_primary = null;
        ObjectMapper obj = new ObjectMapper();
        try {
            JsonNode json_node = obj.readTree(eq);
            name = json_node.get("nom").asText();
            is_primary = json_node.get("is_primary").asText();
            if (Integer.parseInt(is_primary) == 0) {
                entite = json_node.get("id_entite").asText();
                return obj.writeValueAsString(this.service.storeAttribut(name, false, entite));
            } else {
                entite = json_node.get("id_entite").asText();
                return obj.writeValueAsString(this.service.storeAttribut(name, true, entite));
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/deleteAttribut")
    public String deleteRelation(@RequestParam String id) {
        try {
            this.service.deleteAttribut(id);
            return ("success");
        } catch (Exception e) {
            e.printStackTrace();
            return ("eeeeeerror");
        }

    }

}
