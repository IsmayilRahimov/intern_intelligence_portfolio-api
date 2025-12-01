package org.example.intern_intelligence_portfolioapi.service;

import org.example.intern_intelligence_portfolioapi.entity.User;

public interface AuthService {

    String register(User user);

    String login(String username, String password);

}
