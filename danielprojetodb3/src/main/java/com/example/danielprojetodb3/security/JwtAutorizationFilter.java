package com.example.danielprojetodb3.security;

import java.io.IOException;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.example.danielprojetodb3.domain.model.Usuario;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
    FilterChain chain) throws IOException, ServletException{
        String header = request.getHeader("Authorization");
        if(header != null && header.startsWith("Bearer ")){
            UsernamePasswordAuthenticationToken auth = getAuthenticationToken(header.substring(7));
            if(auth!=null && auth.isAuthenticated()){
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }
        chain.doFilter(request,response);

    }
    
}
