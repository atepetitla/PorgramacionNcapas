/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digi01.ATepetitlaProgramacionNweb.Api;

import com.digi01.ATepetitlaProgramacionNweb.DAO.UsuarioDAOImplementacion;
import com.digi01.ATepetitlaProgramacionNweb.JPA.Rol;
import com.digi01.ATepetitlaProgramacionNweb.JPA.Usuario;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author digis
 */
@RestController
@RequestMapping("/rest")
public class UsuarioResController {

    private UsuarioDAOImplementacion usuarioDAOImplementacion;

    public UsuarioResController(UsuarioDAOImplementacion usuarioDAOImplementacion) {
        this.usuarioDAOImplementacion = usuarioDAOImplementacion;
    }

    @GetMapping("/getall")
    public List<Usuario> getAll(@RequestBody Usuario usuario) {
       //usuario = new Usuario("", "", "");
        usuario = new Usuario(usuario.getNombre(), usuario.getApellidopaterno(), usuario.getApellidomaterno());
        return usuarioDAOImplementacion.getAll(usuario);
    }

    @GetMapping("/getbyid/{id}")
    public Usuario getById(@PathVariable int id) {
       Usuario usuario = new Usuario("", "", "");
        return usuarioDAOImplementacion.GetById(id);
    }
    
    @PostMapping("/add")
    public Usuario add(@RequestBody Usuario usuario){
        
        usuario = new Usuario(usuario.getUsername(),
        usuario.getNombre(),
        usuario.getApellidopaterno(),
        usuario.getApellidomaterno(),
        usuario.getEmail(),
        usuario.getPassword(),
        usuario.getSexo(),
        usuario.getTelefono(),
        usuario.getCelular(),
        usuario.getCurp(),
        usuario.getStatus(),
        usuario.getImagen(),
        usuario.getFechanacimiento(),
        new Rol(usuario.getRol().getIdrol()));
        
        
        int valor=usuarioDAOImplementacion.Add(usuario);
        //return usuarioDAOImplementacion.GetById(4);
        return usuarioDAOImplementacion.GetById(valor);
    }

}
