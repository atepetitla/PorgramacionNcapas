/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.digi01.ATepetitlaProgramacionNweb.DAO;

import com.digi01.ATepetitlaProgramacionNweb.JPA.Direccion;
import com.digi01.ATepetitlaProgramacionNweb.JPA.UsuarioDireccion;
import java.util.List;

/**
 *
 * @author digis
 */
public interface IUsuariosDireccion {
     List<UsuarioDireccion> getall();
     UsuarioDireccion GetById(int idusuarioeditable);
}
