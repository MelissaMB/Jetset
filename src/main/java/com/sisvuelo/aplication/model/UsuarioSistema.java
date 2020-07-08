package com.sisvuelo.aplication.model;

import javax.persistence.*;

@Entity
@Table(name = "TB_USUARIO_SISTEMA")
public class UsuarioSistema {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @Column(name = "ID_USUARIO_SISTEMA")
    private Integer id;
    @Column(name = "PRIMER_NOMRE", nullable = false, length = 100)
    private String primerNombre;
    @Column(name = "SEGUNDO_NOMBRE", nullable = true, length = 100)
    private String segundoNombre;
    @Column(name = "PRIMER_APELLIDO", nullable = false, length = 100)
    private String primerApellido;
    @Column(name = "SEGUNDO_APELLIDO", nullable =true, length = 100)
    private String segundoApellido;
    @Column(name = "sexo", nullable = false, length = 10)
    private String sexo;
    @Column(name = "email", nullable = false, length = 100)
    private String email;
    @Column(name = "descripcion", nullable = true, length = 250)
    private String descripcion;
    @ManyToOne(optional = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario", nullable = true)
    private Usuario usuario;

    public UsuarioSistema() {
    }

    public UsuarioSistema(Integer id, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String sexo, String email, String descripcion, Usuario usuario) {
        this.id = id;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.sexo = sexo;
        this.email = email;
        this.descripcion = descripcion;
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
