package com.example.mcd_online.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.mcd_online.Event.LoginEvent;

@Controller
public class AutheticationController {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @GetMapping("/getGithubUser")
    public ModelAndView gitHubToken(@RegisteredOAuth2AuthorizedClient("github") OAuth2AuthorizedClient client) {

        OAuth2AccessToken token = client.getAccessToken();
        LoginEvent event = new LoginEvent(client, client.getPrincipalName(), token.getTokenValue());
        this.applicationEventPublisher.publishEvent(event);
        ModelAndView mv = new ModelAndView("authsuccess");
        mv.getModel().put("token", token.getTokenValue());
        return mv;
    }

    @GetMapping("/getGoogleUser")
    public ModelAndView getGoogleToken(@RegisteredOAuth2AuthorizedClient("google") OAuth2AuthorizedClient client) {
        OAuth2AccessToken token = client.getAccessToken();
        LoginEvent event = new LoginEvent(client, client.getPrincipalName(), token.getTokenValue());
        this.applicationEventPublisher.publishEvent(event);
        ModelAndView mv = new ModelAndView("authsuccess");
        mv.getModel().put("token", token.getTokenValue());
        return mv;
    }
}
