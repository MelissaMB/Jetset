package com.sisvuelo.aplication.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class DataBaseWebSecurity extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

   @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select email, password, estado from TB_USUARIO where email=?")
                .authoritiesByUsernameQuery("select u.email, r.nombre from TB_USUARIO u " +
                        "inner join TB_ROL r on u.ID_ROL=r.ID " +
                        "where u.email = ?");
    }

   /* @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
                .anyRequest().authenticated();
    }*/

   /* @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()


                // Los recursos estáticos no requieren autenticación
                .antMatchers("/resources/**",
                        "/templates/**",
                        "/static/**").permitAll()
                // Las vistas públicas no requieren autenticación
                .antMatchers("/").permitAll()

                // Asignar permisos a URLs por ROLES
                .antMatchers("/rol/**").hasAnyAuthority("ADMIN")


                // Todas las demás URLs de la Aplicación requieren autenticación
                .anyRequest().authenticated()

                // El formulario de Login no requiere autenticacion
                .and().formLogin().permitAll();


    }*/

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated();
    }

  /*  @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/", "/rol/create", "/rol/list").permitAll()

                .anyRequest().authenticated();
    }*/


}


