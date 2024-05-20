package com.example.mcd_online.Controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mcd_online.Entity.Mcd;
import com.example.mcd_online.Service.McdService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class McdController {
    @Autowired
    McdService service;

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true", allowedHeaders = "*")
    @PostMapping(value = "/generateMcd", consumes = "application/json", produces = "application/json")
    public UUID generateMCD(@RequestBody String eq,
            @RegisteredOAuth2AuthorizedClient("google") OAuth2AuthorizedClient client,
            @AuthenticationPrincipal OAuth2User user) {
        String mcd_name = new String();
        ObjectMapper object_mapper = new ObjectMapper();
        try {
            JsonNode json_node = object_mapper.readTree(eq);
            mcd_name = json_node.get("mcd_name").asText();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.service.generateBlankMcd(mcd_name, user.getAttribute("email"));
    }

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true", allowedHeaders = "*")
    @GetMapping("/getListMcd")
    public String listOfMcd(@RegisteredOAuth2AuthorizedClient("google") OAuth2AuthorizedClient client,
            @AuthenticationPrincipal OAuth2User user) {
        ObjectMapper object_mapper = new ObjectMapper();
        String response;
        List<Mcd> maListe;
        try {
            maListe = this.service.listOfMcd(user.getAttribute("email"));
            response = object_mapper.writeValueAsString(maListe);
        } catch (Exception e) {
            e.printStackTrace();
            response = new String("error");
        }
        return response;
    }
}
