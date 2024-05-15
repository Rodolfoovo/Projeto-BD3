package com.example.danielprojetodb3.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.example.danielprojetodb3.domain.model.Usuario;

public class JwtAutorizationFilter extends BasicAuthenticationFilter {

    private JwtUtil jwtUtil;
    private UserDetailsSecurityServer userDetailsSecurityServer;
    public JwtAutorizationFilter(AuthenticationManager authenticationManager,JwtUtil jwtUtil,
    UserDetailsSecurityServer userDetailsSecurityServer) {
        super(authenticationManager);
        this.jwtUtil = jwtUtil;
        this.userDetailsSecurityServer = userDetailsSecurityServer;
    }

    private UsernamePasswordAuthenticationToken getAuthenticationToken(String token){
        if(jwtUtil.isValidToken(token)){
            String email = jwtUtil.getuserName(token);
            Usuario usuario = (Usuario) userDetailsSecurityServer.loadUserByUsername(email);
            return new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
        }
        return null;
    }
    
}
