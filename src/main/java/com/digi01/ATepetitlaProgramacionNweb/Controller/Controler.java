/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digi01.ATepetitlaProgramacionNweb.Controller;

import static com.fasterxml.jackson.databind.util.ClassUtil.name;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author digis
 */
@Controller
public class Controler {
    /*@GetMapping("/")
    public String holamundo(@RequestParam(name = "name", required = false,
            defaultValue = "World") String name,
            Model model) {
        model.addAttribute("name", name);
        return "holamundo";
    }*/

    

    @GetMapping("/")
    public String suma (){
        
        return "Login";
    }
}
