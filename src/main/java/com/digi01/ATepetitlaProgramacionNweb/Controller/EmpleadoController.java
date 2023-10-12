/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digi01.ATepetitlaProgramacionNweb.Controller;

import com.digi01.ATepetitlaProgramacionNweb.DAO.EmpleadoDAOImplements;
import com.digi01.ATepetitlaProgramacionNweb.DAO.EmpresaDAOImplementacion;
import com.digi01.ATepetitlaProgramacionNweb.JPA.Empleado;
import com.digi01.ATepetitlaProgramacionNweb.JPA.Empresa;
import com.digi01.ATepetitlaProgramacionNweb.Util.Util;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author digis
 */
@Controller
@RequestMapping("/empleado")
public class EmpleadoController {

    private EmpleadoDAOImplements empleadoDAOImplements;
    private EmpresaDAOImplementacion empresaDAOImplementacion;

    public EmpleadoController() {
    }

    @Autowired
    public EmpleadoController(EmpleadoDAOImplements empleadoDAOImplements, EmpresaDAOImplementacion empresaDAOImplementacion) {
        this.empleadoDAOImplements = empleadoDAOImplements;
        this.empresaDAOImplementacion = empresaDAOImplementacion;
    }

    @GetMapping("Listado")
    public String getALL(Model model) {
        List<Empleado> empleados = empleadoDAOImplements.getall();
        model.addAttribute("empleados", empleados);

        return "ListaEmpleado";
    }

    @GetMapping("form/{id}")
    public String Update(@PathVariable int id, Model model) {
        List<Empresa> empresas = empresaDAOImplementacion.getAll();
        model.addAttribute("empresas", empresas);
        
        if (id == 0) {//Agregar
            model.addAttribute("empleado", new Empleado());
            return "formEmpleado";
        }else{
            Empleado empleado= empleadoDAOImplements.getbyid(id);
            model.addAttribute("empleado", empleado );
        }

        return "formEmpleado";
    }

    @GetMapping("/forhm{id}")
    public String Updatse(@PathVariable int id, Model model) {
        List<Empresa> empresas = empresaDAOImplementacion.getAll();
        model.addAttribute("empresas", empresas);
        if (id == 0) {//Agregar
            model.addAttribute("empleado", new Empleado());
            return "formEmpleado";
        }else{
            Empleado empleado= empleadoDAOImplements.getbyid(id);
            model.addAttribute("empleado", empleado );
        }
        return "formEmpleado";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable int id, Model model){
        Empleado empleado=empleadoDAOImplements.getbyid(id);        
        empleadoDAOImplements.delet(empleado);
        return "redirect:/empleado/Listado";
    }
    
    @PostMapping("/form")
    public String add(@Valid @ModelAttribute("empleado") Empleado empleado, 
            BindingResult bindingResul,
            @RequestParam("imagenFile") MultipartFile imagenFile,
            Model model) {
        boolean si= bindingResul.hasErrors();
        
        if(bindingResul.hasErrors()){
            model.addAttribute("empleado", empleado);
            return "formEmpleado";
        }
        String base4=Util.converBase64(imagenFile);
        empleado.setFoto(base4);               
        // empleado.getEmpresa().setIdempresa(1);
        if (empleado.getIdempleado() > 0) {
            empleadoDAOImplements.update(empleado);
            return "redirect:/empleado/Listado";

        } else {
            empleadoDAOImplements.add(empleado);
            
        }
        return "redirect:/empleado/Listado";
    }

}
