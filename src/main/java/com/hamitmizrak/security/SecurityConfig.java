package com.hamitmizrak.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

// LOMBOK
@RequiredArgsConstructor

// SECURITY
@Configuration
@EnableWebSecurity

// H2-Console
/*@ConditionalOnProperty(
        value = "spring.h2.console.enabled",
        havingValue = "true",
        matchIfMissing = false
)*/
public class SecurityConfig {

    // Application Properties
   /*
   @Value("${spring.security.user}")
    private String user;

    @Value("${spring.security.password}")
    private String password="root";

    @Value("${spring.security.roles}")
    private String roles;
    */

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().
                requestMatchers(new AntPathRequestMatcher("/h2-console/**"))
                .requestMatchers(new AntPathRequestMatcher("/swagger-ui/**"))
                .requestMatchers(new AntPathRequestMatcher( "/favicon.ico"))
                .requestMatchers(new AntPathRequestMatcher( "/css/**"))
                .requestMatchers(new AntPathRequestMatcher( "/js/**"))
                .requestMatchers(new AntPathRequestMatcher( "/img/**"))
                .requestMatchers(new AntPathRequestMatcher( "/lib/**"));
    }

    // Database Üzerinden Olmadan Authentication
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(PasswordEncoder passwordEncoder){
        // Admin Kullanıcı
        UserDetails admin= User
                .withDefaultPasswordEncoder()
                .username("admin")
                .password("root")
                .roles("ROLES_ADMIN")
                .build();

        // Writer Kullanıcı
        UserDetails writer= User
                .withDefaultPasswordEncoder()
                .username("writer")
                .password("root")
                .roles("ROLES_WRITER")
                .build();

        return new InMemoryUserDetailsManager(admin,writer);
    }

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);
        http.authorizeHttpRequests(authorize ->
                        authorize
                                .requestMatchers(new MvcRequestMatcher(introspector, "/")).permitAll()
                                .requestMatchers(new MvcRequestMatcher(introspector, "/index")).permitAll()
                                .requestMatchers(new MvcRequestMatcher(introspector, "/login")).permitAll()
                                .requestMatchers(new MvcRequestMatcher(introspector, "/logout")).permitAll()
                                .requestMatchers(new MvcRequestMatcher(introspector, "/index")).permitAll()
                                .requestMatchers(new MvcRequestMatcher(introspector, "/swagger-ui/**")).permitAll()
                                .requestMatchers(new MvcRequestMatcher(introspector, "/user-service/**")).permitAll()
                                .anyRequest().authenticated())
                //.httpBasic(Customizer.withDefaults());
                .formLogin(Customizer.withDefaults())
                .logout().logoutUrl("/logout44").invalidateHttpSession(true); // var olan session kapatmaya yarar;
        return http.build();
    }

    // Database Üzerinden
    /*@Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailsServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return  daoAuthenticationProvider;
    }

    @Autowired
    @SneakyThrows // throws Exception
    public void myDatabaseAddUserRolles(AuthenticationManagerBuilder authenticationManagerBuilder){
        authenticationManagerBuilder.authenticationProvider(authenticationProvider());
    }
*/

} //end class