/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digi01.ATepetitlaProgramacionNweb.EntityApi;

/**
 *
 * @author digis
 */
public class Resultado {
    
     private Double respuesta;
      private String Saludo;

    public Resultado(String Saludo) {
        this.Saludo = Saludo;
    }


    public String getSaludo() {
        return Saludo;
    }

    public void setSaludo(String Saludo) {
        this.Saludo = Saludo;
    }
    public Resultado(Double respuesta) {
        this.respuesta = respuesta;
    }
    

    public Double getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Double respuesta) {
        this.respuesta = respuesta;
    }
}
