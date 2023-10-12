/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digi01.ATepetitlaProgramacionNweb.DAO;

import com.digi01.ATepetitlaProgramacionNweb.JPA.Rol;
import com.digi01.ATepetitlaProgramacionNweb.JPA.Usuario;
import com.digi01.ATepetitlaProgramacionNweb.JPA.UsuarioDireccion;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.format.annotation.DateTimeFormat;
import static org.springframework.jdbc.core.JdbcOperationsExtensionsKt.query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author digis
 */
@Repository
public class UsuarioDAOImplementacion implements IUsuario {

    private EntityManager entityManager;

    @Autowired //Inyección de dependencias.
    public UsuarioDAOImplementacion(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Usuario> getAll(Usuario usuario) {

        TypedQuery<Usuario> query = entityManager.createQuery("FROM Usuario u WHERE TRIM(LOWER(u.nombre)) LIKE :nombreusuario " +
                  "AND TRIM(LOWER(u.apellidopaterno)) LIKE :paterno " +        "AND TRIM(LOWER(u.apellidomaterno)) LIKE :materno", Usuario.class);
        query.setParameter("nombreusuario", ('%'+usuario.getNombre())+'%');
        query.setParameter("paterno", ('%'+usuario.getApellidopaterno())+'%');
        query.setParameter("materno", ('%'+usuario.getApellidomaterno())+'%');
        
        List<Usuario> usuarios = query.getResultList();

        return usuarios;
    }

    @Override
    @Transactional
    public int Add(Usuario usuario) {
        //@DateTimeFormat(pattern = "yyyy-MM-dd");
        // usuario.setFechanacimiento(new Date());
        entityManager.persist(usuario);
        return usuario.getIdusuario();
    }

    @Override
    public Usuario GetById(int idusuarioeditable) {
        TypedQuery<Usuario> query = entityManager.createQuery("FROM Usuario where idusuario=:idusuarioeditable", Usuario.class);
        query.setParameter("idusuarioeditable", idusuarioeditable);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public int Update(Usuario usuario) {
        entityManager.merge(usuario);
        return usuario.getIdusuario();
    }

//    @Override
//    @Transactional
//    public void Delete(Usuario usuario) {
//        entityManager.remove(usuario.setIdusuario(1));
//    }
//    
//    
//    @Override
//    public int getId(int idusuarioEliminar) {
//        TypedQuery<Usuario> query = entityManager.createQuery("delete from Usuario  where idusuario=:idusuarioEliminar", Usuario.class);
//         query.setParameter("idusuarioEliminar", idusuarioEliminar);
//         int numero=query.getFirstResult();
//         return numero;
//    }
   
   
    
  

//    @Override
//     @Transactional
//    public void deleteById(Usuario usuario) {
//        entityManager.remove(usuario);
//    }

    @Override
    public List<Rol> getallrol() {
        TypedQuery<Rol> query = entityManager.createQuery("FROM Rol", Rol.class);
        List<Rol> roles = query.getResultList();

        return roles;
    }

    @Override
    @Transactional
    public void deleteById(UsuarioDireccion usuarioDireccion) {
        entityManager.remove(usuarioDireccion);
    }

    @Override
    @Transactional
    public void changestatus(int idusuario, boolean status) {
        Usuario usuario= entityManager.find(Usuario.class, idusuario);
        
        char stastus= (status)? 'Y':'N';
        usuario.setStatus(stastus);
        entityManager.merge(usuario);
    }

    @Override
    public String getbyidimagen(int id) {
         TypedQuery<Usuario> query = entityManager.createQuery("FROM Usuario where idusuario=:idusuarioeditable", Usuario.class);
        query.setParameter("idusuarioeditable", id);
        Usuario user= new Usuario();
        user= query.getSingleResult();
        return user.getImagen();
    }

}
