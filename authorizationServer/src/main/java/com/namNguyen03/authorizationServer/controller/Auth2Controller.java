package com.namNguyen03.authorizationServer.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.namNguyen03.authorizationServer.model.AccessToken;
import com.namNguyen03.authorizationServer.service.OAuth2Service;


@RestController
@RequestMapping("/oauth")
public class Auth2Controller {
	 	private static final String CLIENT_ID = "mobile";
	    private static final String CLIENT_SECRET = "pin";
	    private static final String REDIRECT_URI = "http://localhost:8081/oauth/callback";

	    @Autowired
	    private OAuth2Service oAuth2Service;

		@GetMapping("/callback")
	    public void oauthCallback(@RequestParam Map<String, String> requestParam, HttpServletResponse res ) throws IOException {
	        if (requestParam == null || requestParam.isEmpty()) {
	            Map<String, Object> response = new HashMap<>();
	            response.put("error", "invalid_response_type");
	            response.put("error_description", "Server not supported for response_type = token");
	            res.sendRedirect("/erro");
	        } else if (requestParam.containsKey("error")) {
	            Map<String, Object> error = new HashMap<>();
	            error.put("error", requestParam.get("error"));
	            error.put("error_description", requestParam.get("error_description"));
	            res.sendRedirect("/erro");
	        }
	        AccessToken accessToken = oAuth2Service.getAccessToken(CLIENT_ID, CLIENT_SECRET, REDIRECT_URI, requestParam.get("code"), requestParam.get("state"));
            res.sendRedirect("/get_profile?token="+ accessToken.getAccessToken());
		}
		
		@GetMapping()
		public void get(HttpServletResponse response) throws IOException{
			response.sendRedirect("http://localhost:8080/oauth/authorize?client_id=mobile&response_type=code&redirect_uri=http://localhost:8081/oauth/callback&scope=WRITE");
		}

		
		
}
