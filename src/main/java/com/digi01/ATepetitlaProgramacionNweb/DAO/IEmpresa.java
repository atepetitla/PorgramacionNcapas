/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.digi01.ATepetitlaProgramacionNweb.DAO;

import com.digi01.ATepetitlaProgramacionNweb.JPA.Empresa;
import java.util.List;

/**
 *
 * @author digis
 */
public interface IEmpresa {
    List<Empresa> getAll();
    void delete(Empresa empresa);
    Empresa getbyid(int idempresa);
    void update(Empresa empresa);
    void add(Empresa empresa);
}
