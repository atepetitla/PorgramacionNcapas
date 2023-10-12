/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.digi01.ATepetitlaProgramacionNweb.service;

import com.digi01.ATepetitlaProgramacionNweb.EntityApi.NumerosOperacion;
import com.digi01.ATepetitlaProgramacionNweb.EntityApi.Resultado;

/**
 *
 * @author digis
 */
public interface Idemo {
    
    Resultado suma(NumerosOperacion numerosOperacion);
    Resultado resta(NumerosOperacion numerosOperacion);
    Resultado Multiplicacion(NumerosOperacion numerosOperacion);
    Resultado divicion(NumerosOperacion numerosOperacion);
    Resultado hola(NumerosOperacion nombre);
    
    
    
}
