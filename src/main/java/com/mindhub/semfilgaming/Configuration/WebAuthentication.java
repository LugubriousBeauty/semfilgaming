package com.mindhub.semfilgaming.Configuration;

import com.mindhub.semfilgaming.Models.Client;
import com.mindhub.semfilgaming.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebAuthentication extends GlobalAuthenticationConfigurerAdapter {

    @Autowired
    public ClientService clientService;


    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(inputName-> {
            Client client = clientService.getClientByEmail(inputName);
            if (client != null) {
                if(!client.isEnabled()) {
                    throw new DisabledException("User not enabled");
                }
                String authority = "CLIENT";
                if(client.isAdmin()) authority = "ADMIN";

                return new User(client.getClientEmail(), client.getPassword(), AuthorityUtils.createAuthorityList(authority));

            }
            throw new UsernameNotFoundException("Unknown user");

        });
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
