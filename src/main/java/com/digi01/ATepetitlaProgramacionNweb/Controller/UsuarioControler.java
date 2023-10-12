/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digi01.ATepetitlaProgramacionNweb.Controller;

import com.digi01.ATepetitlaProgramacionNweb.DAO.ColoniaDaoImplementacion;
import com.digi01.ATepetitlaProgramacionNweb.DAO.DireccionDAOImplementacion;
import com.digi01.ATepetitlaProgramacionNweb.DAO.EStadoDAOImplementacion;
import com.digi01.ATepetitlaProgramacionNweb.DAO.MunicipioDAOimplementacion;
import com.digi01.ATepetitlaProgramacionNweb.DAO.PaisDAOImplementacion;
import com.digi01.ATepetitlaProgramacionNweb.DAO.UsuarioDAOImplementacion;
import com.digi01.ATepetitlaProgramacionNweb.DAO.UsuarioDireccionDAO;
import com.digi01.ATepetitlaProgramacionNweb.JPA.Colonia;
import com.digi01.ATepetitlaProgramacionNweb.JPA.Direccion;
import com.digi01.ATepetitlaProgramacionNweb.JPA.Direccion;
import com.digi01.ATepetitlaProgramacionNweb.JPA.Estado;
import com.digi01.ATepetitlaProgramacionNweb.JPA.Municipio;
import com.digi01.ATepetitlaProgramacionNweb.JPA.Pais;
import com.digi01.ATepetitlaProgramacionNweb.JPA.Rol;
import com.digi01.ATepetitlaProgramacionNweb.JPA.Usuario;
import com.digi01.ATepetitlaProgramacionNweb.JPA.UsuarioDireccion;
import com.digi01.ATepetitlaProgramacionNweb.Util.Util;
import jakarta.persistence.EntityManager;
import jakarta.validation.Valid;
import java.io.IOException;
import java.util.List;
import org.apache.tomcat.util.codec.binary.Base64;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author digis
 */
@Controller
@RequestMapping("/usuario")
public class UsuarioControler {
//public static UsuarioDAOImplementacion =UsuarioDAOImplementacion;

    private static UsuarioDAOImplementacion usuarioDAOImplementacion;
    private static DireccionDAOImplementacion direccionDAOImplementacion;

    private static ColoniaDaoImplementacion coloniaDaoImplementacion;
    private static MunicipioDAOimplementacion municipioDAOimplementacion;
    private static EStadoDAOImplementacion eStadoDAOImplementacion;
    private static PaisDAOImplementacion paisDAOImplementacion;

    //private static  UsuarioDAOImplementacion= UsuarioDAOImplementacion;
    @Autowired//inyeccion
    public UsuarioControler(UsuarioDAOImplementacion usuarioDAOImplementation,
            DireccionDAOImplementacion direccionDAOImplementacion,
            ColoniaDaoImplementacion coloniaDaoImplementacion,
            MunicipioDAOimplementacion municipioDAOimplementacion,
            EStadoDAOImplementacion eStadoDAOImplementacion,
            PaisDAOImplementacion paisDAOImplementacion) {
        this.usuarioDAOImplementacion = usuarioDAOImplementation;
        this.direccionDAOImplementacion = direccionDAOImplementacion;
        this.coloniaDaoImplementacion = coloniaDaoImplementacion;
        this.municipioDAOimplementacion = municipioDAOimplementacion;
        this.eStadoDAOImplementacion = eStadoDAOImplementacion;
        this.paisDAOImplementacion = paisDAOImplementacion;
    }

    public UsuarioControler() {
    }

    @GetMapping("/listado")
    public String listaUsuario(Model model, Usuario usuario) {
        usuario.setNombre("");
        usuario.setApellidopaterno("");
        usuario.setApellidomaterno("");
        List<Usuario> usuariobuscar = usuarioDAOImplementacion.getAll(usuario);
        model.addAttribute("usuarios", usuariobuscar);
        model.addAttribute("usuariobuscar", new Usuario());
        List<Direccion> direcciones = direccionDAOImplementacion.GetAll();

        model.addAttribute("direcciones", direcciones);

        return "listaUsuario";

    }

    @PostMapping("/listado")
    public String listaUsuarios(Model model, @ModelAttribute("usuariobuscar") Usuario usuariobuscar) {
        int id = 0;
        List<Usuario> usuarios = usuarioDAOImplementacion.getAll(usuariobuscar);
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("usuariobuscar", usuariobuscar);
        UsuarioDireccion us = new UsuarioDireccion();
        Direccion dire = new Direccion();
        Usuario user = new Usuario();

        List<Direccion> direcciones = direccionDAOImplementacion.GetAll();
        model.addAttribute("direcciones", direcciones);

        return "listaUsuario";

    }

    @GetMapping("/h")
    public String listaPrueba(Model model) {
        List<Direccion> direcciones = direccionDAOImplementacion.GetAll();
        model.addAttribute("direcciones", direcciones);

        return "Listadireccion";
    }

    @GetMapping("/form/{idusuario}")
    public String Update(@PathVariable int idusuario, Model model) {
        List<Rol> roles = usuarioDAOImplementacion.getallrol();
        List<Pais> paises = paisDAOImplementacion.getall();
        model.addAttribute("roles", roles);
        model.addAttribute("paises", paises);
        if (idusuario == 0) {//agregar
            model.addAttribute("estados", null);
            model.addAttribute("municipio", null);
            model.addAttribute("colonia", null);
            model.addAttribute("usuariodireccion", new UsuarioDireccion());
            return "formusuarioactualizar";
//    return "Listadireccion";
        } else {//actualizar;

            UsuarioDireccion usuarioDireccion = new UsuarioDireccion();
            usuarioDireccion.setUsuario(usuarioDAOImplementacion.GetById(idusuario));
            usuarioDireccion.setDireccion(direccionDAOImplementacion.GetById(idusuario));
            model.addAttribute("imagen", usuarioDAOImplementacion.getbyidimagen(idusuario));
            if (usuarioDireccion.getDireccion().getIddireccion() == 0) {

            } else {
                model.addAttribute("estados", eStadoDAOImplementacion.getByIdPais(usuarioDireccion.getDireccion().getColonia().getMunicipio().getEstado().getPais().getIdpais()));
                model.addAttribute("municipio", municipioDAOimplementacion.getByIdEstado(usuarioDireccion.getDireccion().getColonia().getMunicipio().getEstado().getIdestado()));
                model.addAttribute("colonia", coloniaDaoImplementacion.GetByIdMunicipio(usuarioDireccion.getDireccion().getColonia().getMunicipio().getIdmunicipio()));

            }
            // model.addAttribute("colonia", usuarioDireccion.getDireccion().getColonia().getIdcolonia());
            model.addAttribute("usuariodireccion", usuarioDireccion);
            //mode.addAttribute("Municipios", municiDAOImpl.getByIDEstado(alumnodirecciom.getDireccion().GetColonia().GetMuni().GetEstado.GetIDEstado) )

//          para usuario sin direccion  
//Usuario usuario = usuarioDAOImplementacion.GetById(idusuario);
//            model.addAttribute("usuariodireccion", usuario);
            //getByID --> precargar elforumalrio JPQL
            // precargarlo con el model 
            return "formusuarioactualizar";
        }
    }
//sin validacion del sistema.

    /*  @PostMapping("/form")
    public String Update(@ModelAttribute UsuarioDireccion usuariodireccion) {
        // actualización
        if (usuariodireccion.getUsuario().getIdusuario() > 0) {
            usuarioDAOImplementacion.Update(usuariodireccion.getUsuario());

            return "redirect:/usuario/listado";
        } else {
            int idusuario = usuarioDAOImplementacion.Add(usuariodireccion.getUsuario());
            usuariodireccion.getDireccion().setUsuario(new Usuario(idusuario));
            //usuariodireccion.getDireccion();
            direccionDAOImplementacion.add(usuariodireccion.getDireccion());
            ///System.out.println("hhs");
            return "redirect:/usuario/listado";
        }
    }*/
    @PostMapping("/form")
    public String Update(@Valid @ModelAttribute("usuariodireccion") UsuarioDireccion usuariodireccion,
            BindingResult bindingResult,
            @RequestParam("imagenFile") MultipartFile imagenFile,
            Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("usuariodireccion", usuariodireccion);
            return "formusuarioactualizar";
        }
        String imagenBase64 = Util.converBase64(imagenFile);
        usuariodireccion.getUsuario().setImagen(imagenBase64);
//        try {
//            if (!imagenFile.isEmpty()) {
//                byte[] bytes = imagenFile.getBytes();
//                String imagenBase64 = Base64.encodeBase64String(bytes);
//
//                usuariodireccion.getUsuario().setImagen(imagenBase64);
//            } else {
//                usuariodireccion.getUsuario().setImagen(null);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        if (usuariodireccion.getUsuario().getIdusuario() > 0) {//actualizar
            usuariodireccion.getUsuario().setStatus('Y');
            int idusuario = usuarioDAOImplementacion.Update(usuariodireccion.getUsuario());
            
          
             if(usuariodireccion.getDireccion().getIddireccion()>0){
                // Direccion direccion=direccionDAOImplementacion.GetByIddir(usuariodireccion.getDireccion().getIddireccion());
                  usuariodireccion.getDireccion().setUsuario(new Usuario(idusuario));
                  direccionDAOImplementacion.add(usuariodireccion.getDireccion());
                   return "redirect:/usuario/listado";
             }else{
                  Direccion direccion=direccionDAOImplementacion.GetByIddir(usuariodireccion.getDireccion().getIddireccion());
                 direccionDAOImplementacion.Update(direccion);
             }
//                     usuariodireccion.getDireccion().setUsuario(new Usuario(idusuario));
//            direccionDAOImplementacion.Update(usuariodireccion.getDireccion());

            return "redirect:/usuario/listado";
        } else {//agregar
            usuariodireccion.getUsuario().setStatus('Y');
            int idusuario = usuarioDAOImplementacion.Add(usuariodireccion.getUsuario());
            usuariodireccion.getDireccion().setUsuario(new Usuario(idusuario));
            //usuariodireccion.getDireccion();
            direccionDAOImplementacion.add(usuariodireccion.getDireccion());
            ///System.out.println("hhs");
            return "redirect:/usuario/listado";
        }
    }

    @GetMapping("/changeStatus")
    @ResponseBody
    public void changeStatus(@RequestParam("idusuario") int idusuario, @RequestParam("status") boolean status) {
        usuarioDAOImplementacion.changestatus(idusuario, status);

    }

    @GetMapping("/GetEstadoByPais")
    @ResponseBody
    public List<Estado> getestado(@RequestParam("IdPais") int IdPais) {
        List<Estado> estados = eStadoDAOImplementacion.getByIdPais(IdPais);
        return estados;
    }

    @GetMapping("/GetMunicipioByEstado")
    @ResponseBody
    public List<Municipio> getMunicipio(@RequestParam("IdEstado") int IdEstado) {
        List<Municipio> municipios = municipioDAOimplementacion.getByIdEstado(IdEstado);
        return municipios;
    }

    @GetMapping("/GetColoniaByMunicipio")
    @ResponseBody
    public List<Colonia> getColonia(@RequestParam("IdMunicipio") int IdMunicipio) {
        List<Colonia> colonias = coloniaDaoImplementacion.GetByIdMunicipio(IdMunicipio);
        return colonias;
    }

    @GetMapping("/delete/{idusuario}")
    public String Delete(@PathVariable int idusuario, Model model) {

        Usuario usuario = usuarioDAOImplementacion.GetById(idusuario);

        model.addAttribute("usuario", usuario);
        //usuarioDAOImplementacion.deleteById(usuario);
        //getByID --> precargar elforumalrio JPQL
        // precargarlo con el model 
        //model.addAttribute("usuario", usuario);
        //getByID --> precargar elforumalrio JPQL
        // precargarlo con el model 

        return "redirect:/usuario/listado";
    }

}
