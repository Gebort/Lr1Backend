package edu.festu.ivankuznetsov.springsamplebo941pia.security

import edu.festu.ivankuznetsov.springsamplebo941pia.service.AccountService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain


@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val accountService: AccountService
) {


    fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService<UserDetailsService?>(accountService).passwordEncoder(passwordEncoder())
    }

    @Bean
    fun passwordEncoder(): BCryptPasswordEncoder? {
        return BCryptPasswordEncoder()
    }

    @Bean
    @Throws(Exception::class)
    fun filterChain(httpSecurity: HttpSecurity): SecurityFilterChain? {
        return httpSecurity.csrf().disable()
            .cors().disable().formLogin()
            .and()
            .authorizeHttpRequests { authorization: AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry ->
                authorization
                    .antMatchers(HttpMethod.GET, "/public/books", "/login**", "/h2-console","/logout**")
                    .permitAll()
                    .antMatchers(HttpMethod.GET, "/public/books").hasRole("USER")
                    .antMatchers(HttpMethod.GET, "/**").hasRole("ADMIN")
            }.httpBasic(Customizer.withDefaults()).build()
    }

}
