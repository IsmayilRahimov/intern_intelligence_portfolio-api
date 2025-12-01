package org.example.intern_intelligence_portfolioapi.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@Data
@AllArgsConstructor
public class JwtUser {

    private Long id;
    private String username;
    private String password;
    private List<GrantedAuthority> authorities;
}
