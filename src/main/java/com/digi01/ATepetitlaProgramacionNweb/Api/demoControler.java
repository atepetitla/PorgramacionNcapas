/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digi01.ATepetitlaProgramacionNweb.Api;

import com.digi01.ATepetitlaProgramacionNweb.EntityApi.NumerosOperacion;
import com.digi01.ATepetitlaProgramacionNweb.EntityApi.Resultado;
import com.digi01.ATepetitlaProgramacionNweb.service.DemoImplements;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author digis
 */
@RestController
@RequestMapping("/api")
public class demoControler {

    @PostMapping("/suma")
    public Resultado suma(@RequestBody NumerosOperacion numeros) {
        DemoImplements demoServiceImplementation = new DemoImplements();
        return demoServiceImplementation.suma(numeros);
    }

    @PostMapping("/resta")
    public Resultado resta(@RequestBody NumerosOperacion numeros) {
        DemoImplements demoServiceImplementation = new DemoImplements();
        return demoServiceImplementation.resta(numeros);
    }

    @PostMapping("/multipliacion")
    public Resultado multipliacion(@RequestBody NumerosOperacion numeros) {
        DemoImplements demoServiceImplementation = new DemoImplements();
        return demoServiceImplementation.suma(numeros);
    }

    @PostMapping("/hola")
    public Map<String, Object> saludo(@RequestBody NumerosOperacion nombre) {

        Map<String, Object> respo = new HashMap<>();
        respo.put("Saludo", "hola  " + nombre.getnombre());
        return respo;
    }

}
