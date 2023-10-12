/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digi01.ATepetitlaProgramacionNweb.JPA;

import jakarta.validation.Valid;

/**
 *
 * @author digis
 */
public class EmpresaEmpleado {
 
    @Valid
    private Empresa empresa;
    
    @Valid Empleado empleado;

    public EmpresaEmpleado() {
    }

    public EmpresaEmpleado(Empresa empresa, Empleado empleado) {
        this.empresa = empresa;
        this.empleado = empleado;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
    
    
    
}
