package com.sisvuelo.aplication.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class DataBaseWebSecurity extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

   @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username, password, estado from TB_USUARIO where username=?")
                .authoritiesByUsernameQuery("select u.username, r.nombre from TB_USUARIO u " +
                        "inner join TB_ROL r on u.ID_ROL=r.ID " +
                        "where u.username = ?");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/resources/**,", "/templates/**", "/static/**" , "/layout/**", "/vendors/**").permitAll()
                .antMatchers("/cliente/empresa/**", "/logout","/cliente/natural/**").permitAll()
                .antMatchers("/usuario/**").hasAnyAuthority("Administrador", "DBA")
                .antMatchers("/rol/**").hasAnyAuthority("Administrador", "DBA")
                .antMatchers("/vuelo/**").hasAnyAuthority("AdminVuelo", "Pasajero","Administrador")
                .antMatchers("/aeropuerto/**").hasAnyAuthority("Administrador","AdminAeropuerto")
                .antMatchers("/aerolinea/**").hasAnyAuthority("Administrador","AdminAerolinea")
                .antMatchers("/precio/**").hasAnyAuthority("Administrador","AdminAerolinea")
                .antMatchers("/reserva/**").hasAnyAuthority("Administrador","AdminAerolinea")
                .antMatchers("/estatusReserva/**").hasAnyAuthority("Administrador","AdminAerolinea")
                .antMatchers("/capacidad/**").hasAnyAuthority("Administrador","AdminAerolinea")
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login")
                .permitAll();


    }




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

  /*  @Override
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


