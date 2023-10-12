/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.digi01.ATepetitlaProgramacionNweb.DAO;

import com.digi01.ATepetitlaProgramacionNweb.JPA.Rol;
import com.digi01.ATepetitlaProgramacionNweb.JPA.Usuario;
import com.digi01.ATepetitlaProgramacionNweb.JPA.UsuarioDireccion;
import java.util.List;

/**
 *
 * @author digis
 */
public interface IUsuario {

    //llamada del metodo
     List<Usuario> getAll(Usuario usuario);
    List<Rol> getallrol();
    
    int Add(Usuario usuario);
    void changestatus(int idusuario, boolean status);
    Usuario GetById(int idusuarioeditable);

    int Update(Usuario usuario);

     void deleteById(UsuarioDireccion usuarioDireccion);
     String getbyidimagen(int id);
}
