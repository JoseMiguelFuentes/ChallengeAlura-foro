// package com.alura.foro.api.security;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.web.SecurityFilterChain;

// @EnableWebSecurity
// @Configuration
// @EnableMethodSecurity(securedEnabled = true)
// public class SecurityConfigurations {



//   @Bean
//   public SecurityFilterChain filterChain( HttpSecurity http ) throws Exception{

//     return http.csrf().disable().sessionManagement().sessionCreationPolicy( SessionCreationPolicy.STATELESS ).and().build();
//   }



  
// }
