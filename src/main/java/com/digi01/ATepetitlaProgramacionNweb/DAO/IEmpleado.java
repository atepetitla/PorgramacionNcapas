/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.digi01.ATepetitlaProgramacionNweb.DAO;

import com.digi01.ATepetitlaProgramacionNweb.JPA.Empleado;
import java.util.List;

/**
 *
 * @author digis
 */
public interface IEmpleado {
    List<Empleado> getall();
    void add(Empleado empleado);
    void update (Empleado empleado);
    Empleado getbyid(int idempleadoc);
    void delet(Empleado empleado);
    
}
