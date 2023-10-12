/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digi01.ATepetitlaProgramacionNweb.service;

import com.digi01.ATepetitlaProgramacionNweb.EntityApi.NumerosOperacion;
import com.digi01.ATepetitlaProgramacionNweb.EntityApi.Resultado;

/**
 *
 * @author digis
 */
public class DemoImplements implements Idemo{

    @Override
    public Resultado suma(NumerosOperacion numerosOperacion) {
        return new Resultado(numerosOperacion.getNumero1() + numerosOperacion.getNumero2());
    }

    @Override
    public Resultado resta(NumerosOperacion numerosOperacion) {
        return new Resultado(numerosOperacion.getNumero1() - numerosOperacion.getNumero2());
    }

    @Override
    public Resultado Multiplicacion(NumerosOperacion numerosOperacion) {
        return new Resultado(numerosOperacion.getNumero1() * numerosOperacion.getNumero2());
    }

    @Override
    public Resultado divicion(NumerosOperacion numerosOperacion) {
        return new Resultado(numerosOperacion.getNumero1() / numerosOperacion.getNumero2());
    }

    @Override
    public Resultado hola(NumerosOperacion nombre) {
        return new Resultado("hola "+nombre.getnombre());
    }

   
    

    
}
