package com.mindhub.semfilgaming.Configuration;

/*@Configuration
public class WebAuthentication extends GlobalAuthenticationConfigurerAdapter {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(inputName-> {
            Client client = clientRepository.findByClientEmail(inputName);
            if (client != null) {
                if(client.getRol()!= ADMIN) {
                    return new User(client.getClientEmail(), client.getPassword(),
                            AuthorityUtils.createAuthorityList("CLIENT"));
                }else{
                    return new User(client.getClientEmail(), client.getPassword(),
                            AuthorityUtils.createAuthorityList("ADMIN"));
                }
            } else {
                throw new UsernameNotFoundException("Unknown user: " + inputName);
            }
        });
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}*/
