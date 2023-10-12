/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digi01.ATepetitlaProgramacionNweb.Controller;

import com.digi01.ATepetitlaProgramacionNweb.DAO.EmpresaDAOImplementacion;
import com.digi01.ATepetitlaProgramacionNweb.JPA.Empresa;
import jakarta.persistence.EntityManager;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author digis
 */
@Controller
@RequestMapping("/empresa")
public class EmpresaController {

    private EmpresaDAOImplementacion empresaDAOImplementacion;

//    public EmpresaController() {
//    }
    @Autowired//es la ineccion de dependencias
    public EmpresaController(EmpresaDAOImplementacion empresaDAOImplementacion) {
        this.empresaDAOImplementacion = empresaDAOImplementacion;
    }

    //traer todos los datos
    @GetMapping("empresalistado")
    public String getAll(Model model) {
        List<Empresa> empresas = empresaDAOImplementacion.getAll();
        model.addAttribute("empresas", empresas);
        return "EmpresaListado";
    }

    @GetMapping("form/{id}")
    public String Formulario(@PathVariable int id, Model model) {
        //  int empresa= empresaDAOImplementacion.getbyid(id)
        if (id == 0) {
            model.addAttribute("empresa", new Empresa());
            return "formularioEmpresa";
        } else {
            Empresa empresa = empresaDAOImplementacion.getbyid(id);
            model.addAttribute("empresa", empresa);

        }
        return "formularioEmpresa";
    }

    @GetMapping("delete/{idempresa}")
    public String delete(@PathVariable int idempresa, Model model) {
        Empresa empresa = empresaDAOImplementacion.getbyid(idempresa);
        model.addAttribute("empresa", empresa);
        empresaDAOImplementacion.delete(empresa);
        return "redirect:/empresa/empresalistado";
    }

    @PostMapping("/form")
    public String actualizar(@ModelAttribute("empresa") Empresa empresa, Model model) {

        if (empresa.getIdempresa() == 0) {
            empresaDAOImplementacion.add(empresa);
            return "redirect:/empresa/empresalistado";
        } else {
            empresaDAOImplementacion.update(empresa);
        }
        return "redirect:/empresa/empresalistado";
    }

}
