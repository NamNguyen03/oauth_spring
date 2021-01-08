package com.namNguyen03.authorizationServer.service;

import com.namNguyen03.authorizationServer.model.AccessToken;

public interface OAuth2Service {
	AccessToken getAccessToken(String clientId, String clientSecret, String redirectUri, String code,String state);
}
