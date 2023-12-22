package com.wiss.m223.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private AuthenticationEntryPoint unauthorizedHandler;
    private final static String[] EVERYONE = { "/public", "/api/auth/**" };
    // private final static String[] EVERYONE = { "/public", "/private", "/admin" };
    private final static String[] SECURE = { "/question" };
    private final static String[] ROLES = { "MODERATOR", "ADMIN" };

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        // Erstellen Sie eine Instanz von DaoAuthenticationProvider
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        // Setzen Sie den UserDetailsService für den DaoAuthenticationProvider
        authProvider.setUserDetailsService(userDetailsService);

        // Setzen Sie den PasswordEncoder für den DaoAuthenticationProvider
        authProvider.setPasswordEncoder(passwordEncoder());

        // Rückgabe des konfigurierten DaoAuthenticationProviders als Bean
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Jede Request wird durch das SecurityChain durchgenommen before es zum controler kommt.
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            // CSRF-Schutz deaktivieren
            .csrf(csrf -> csrf.disable())
            // CORS-Konfiguration mit den Standardoptionen verwenden
            .cors(Customizer.withDefaults())
            // Konfiguration für die Behandlung von Ausnahmen während der Authentifizierung
            .exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizedHandler))
            // Sitzungsmanagement konfigurieren (zustandslose Anwendung)
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            // Autorisierung für verschiedene Arten von Anfragen konfigurieren
            .authorizeHttpRequests(auth -> auth
                // Öffentliche Ressourcen, die für jeden zugänglich sind
                .requestMatchers(EVERYONE).permitAll()
                // Alle anderen Anfragen erfordern Authentifizierung
                .anyRequest().authenticated()
            );
        // Benutzerdefinierten AuthenticationProvider hinzufügen
        http.authenticationProvider(authenticationProvider());
        // Benutzerdefinierten Filter vor dem Standard-Filter hinzufügen
        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        // Rückgabe der konfigurierten HttpSecurity-Instanz
        return http.build();
    }
}