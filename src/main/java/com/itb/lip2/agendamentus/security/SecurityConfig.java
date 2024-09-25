package com.itb.lip2.agendamentus.security;

import com.itb.lip2.agendamentus.filter.CustomAuthenticationFilter;
import com.itb.lip2.agendamentus.filter.CustomAuthorizationFilter;
import com.itb.lip2.agendamentus.service.UsuarioService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    private final UsuarioService usuarioService;



    public SecurityConfig(UserDetailsService userDetailsService, UsuarioService usuarioService) {
        this.userDetailsService = userDetailsService;
        this.usuarioService = usuarioService;

    }



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManagerBean(), usuarioService);
        customAuthenticationFilter.setFilterProcessesUrl("/agendamentus/api/v1/login");
        http.cors();
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(STATELESS).
                and().authorizeRequests().antMatchers("/h2/**","/agendamentus/api/v1/login/**","/agendamentus/api/v1/users/**", "/agendamentus/api/v1/logout/**").permitAll();
        http.authorizeRequests().
                        antMatchers("/agendamentus/api/v1/clientes/**").hasAnyAuthority("ROLE_CLIENTE").
                antMatchers("/agendamentus/api/v1/funcionarios/**").hasAnyAuthority("ROLE_FUNCIONARIO").
                anyRequest().authenticated();
        http.addFilter(customAuthenticationFilter);
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

    }

    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }
}