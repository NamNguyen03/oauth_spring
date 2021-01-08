package com.namNguyen03.resouceServer.service;

import com.namNguyen03.resouceServer.model.AccessToken;

public interface OAuth2Service {
    AccessToken getAccessToken(String clientId, String clientSecret, String redirectUri, String code, String state);
}
