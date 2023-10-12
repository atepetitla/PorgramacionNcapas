/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.digi01.ATepetitlaProgramacionNweb.DAO;

import com.digi01.ATepetitlaProgramacionNweb.JPA.Colonia;
import com.digi01.ATepetitlaProgramacionNweb.JPA.Direccion;
import com.digi01.ATepetitlaProgramacionNweb.JPA.Direccion;
import com.digi01.ATepetitlaProgramacionNweb.JPA.Estado;
import com.digi01.ATepetitlaProgramacionNweb.JPA.Municipio;
import com.digi01.ATepetitlaProgramacionNweb.JPA.Pais;
import com.digi01.ATepetitlaProgramacionNweb.JPA.Usuario;
import java.util.List;

/**
 *
 * @author digis
 */
public interface IDireccion {
    void add(Direccion direccion);
    
    Direccion GetById(int idusuarioeditable);
    Direccion GetByIddir(int id);
    List<Direccion> GetAll();
    List<Pais> GetAllpais();
    List<Colonia> GetAllcolonia();
    List<Municipio>getmunicio();
    List<Estado>getmestado();
    void Update(Direccion direccion);
}
