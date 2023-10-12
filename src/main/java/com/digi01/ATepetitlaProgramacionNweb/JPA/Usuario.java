/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digi01.ATepetitlaProgramacionNweb.JPA;

import java.io.Serializable;
import java.util.Date;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author digis
 */
@Entity
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ")
    //@SequenceGenerator(name = "SEQ", sequenceName = "usuario_SEQ")
//)   @GeneratedValue(strategy = GenerationType.AUTO )
    private int idusuario;

    @NotEmpty(message = "Ingresa datos validacion servidor")
    // private int hola;
    private String username;
    @NotEmpty(message = "Ingresa datos")
    private String nombre;
    @NotEmpty(message = "Ingresa datos")
    private String apellidopaterno;
    @NotEmpty(message = "Ingresa datos")
    private String apellidomaterno;
    @NotEmpty(message = "Ingresa datos de correo")
    @Email(message = "Ingresa un correo valido")
    private String email;
    
    @NotEmpty(message = "Ingresa datos")
    @Size(min = 8, message = "Password minimo de 8")
    private String password;

    @NotEmpty(message = "Ingresa datos")
    private String sexo;
    
    @NotEmpty(message = "Ingresa datos")
    @Size(min = 10, max = 10, message = "Telefono a diez digitos")
    private String telefono;
    
    @NotEmpty(message = "Ingresa datos")
    @Size(min = 10, max = 10, message = "Celular a diez digitos")
    private String celular;

    @NotEmpty(message = "Ingresa datos")
    @Size(min = 18, max = 18, message = "El curp es de 18 caracteres")
    private String Curp;
    
    @NotNull
    private char status;
    
    @Lob
    private String imagen;
    // private int idrol;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechanacimiento;
    
    
    @ManyToOne
    @JoinColumn(name = "idrol")
    private com.digi01.ATepetitlaProgramacionNweb.JPA.Rol rol;

    public Usuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public Usuario(String username, String nombre, String apellidopaterno, String apellidomaterno, String email, String password, String sexo, String telefono, String celular, String Curp, char status, String imagen, Date fechanacimiento, Rol rol) {
        this.username = username;
        this.nombre = nombre;
        this.apellidopaterno = apellidopaterno;
        this.apellidomaterno = apellidomaterno;
        this.email = email;
        this.password = password;
        this.sexo = sexo;
        this.telefono = telefono;
        this.celular = celular;
        this.Curp = Curp;
        this.status = status;
        this.imagen = imagen;
        this.fechanacimiento = fechanacimiento;
        this.rol = rol;
    }
    

    public Usuario(String nombre, String apellidopaterno, String apellidomaterno) {
        this.nombre = nombre;
        this.apellidopaterno = apellidopaterno;
        this.apellidomaterno = apellidomaterno;
    }

   

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }
    

   

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    

    public String getCurp() {
        return Curp;
    }

    public void setCurp(String Curp) {
        this.Curp = Curp;
    }

    public Usuario(String username, String nombre, String apellidopaterno, String apellidomaterno, String email, String password, String sexo, String telefono, String celular, Date fechanacimiento, Rol rol) {
        this.username = username;
        this.nombre = nombre;
        this.apellidopaterno = apellidopaterno;
        this.apellidomaterno = apellidomaterno;
        this.email = email;
        this.password = password;
        this.sexo = sexo;
        this.telefono = telefono;
        this.celular = celular;
        this.fechanacimiento = fechanacimiento;
        this.rol = rol;
    }

    public Usuario() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidopaterno() {
        return apellidopaterno;
    }

    public void setApellidopaterno(String apellidopaterno) {
        this.apellidopaterno = apellidopaterno;
    }

    public String getApellidomaterno() {
        return apellidomaterno;
    }

    public void setApellidomaterno(String apellidomaterno) {
        this.apellidomaterno = apellidomaterno;
    }

}
