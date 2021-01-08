package com.namNguyen03.resourceServer.service;

import com.namNguyen03.resourceServer.model.AccessToken;

public interface OAuth2Service {
    AccessToken getAccessToken(String clientId, String clientSecret, String redirectUri, String code, String state);

}
