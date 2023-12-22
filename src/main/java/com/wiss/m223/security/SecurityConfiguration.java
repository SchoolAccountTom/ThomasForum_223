/* package com.wiss.m223.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	@Bean
	public UserDetailsService users(@Autowired PasswordEncoder pwEnc) {
		UserDetails user = User.builder().username("user").password(pwEnc.encode("top")).roles("USER").build();
		UserDetails admin = User.builder().username("admin").password(pwEnc.encode("secret")).roles("USER", "ADMIN").build();
		return new InMemoryUserDetailsManager(user, admin);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// Security Filter Chain
	private static final String[] EVERYONE = { "/public" };
	private static final String[] ADMIN = { "/admin" };

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable()).cors(Customizer.withDefaults())
				.authorizeHttpRequests(auth -> auth.requestMatchers(EVERYONE).permitAll() // Allow everyone to visit the 'Public' page without auth
				.requestMatchers(ADMIN).hasRole("ADMIN") // User has to have ADMIN Role to access 'Admin' page
				.anyRequest().authenticated())  // Any other Roles only need authentication to visit protected sites
				.formLogin(Customizer.withDefaults());
		return http.build();
	}
}
 */