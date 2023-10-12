/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digi01.ATepetitlaProgramacionNweb.DAO;

import com.digi01.ATepetitlaProgramacionNweb.JPA.Direccion;
import com.digi01.ATepetitlaProgramacionNweb.JPA.Usuario;
import com.digi01.ATepetitlaProgramacionNweb.JPA.UsuarioDireccion;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author digis
 */
@Repository
public class UsuarioDireccionDAO implements IUsuariosDireccion{
 private EntityManager entityManager;

    @Autowired //Inyección de dependencias.
    public UsuarioDireccionDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Override
    public List<UsuarioDireccion> getall() {
        TypedQuery<UsuarioDireccion> query = entityManager.createQuery("FROM UsuarioDireccion", UsuarioDireccion.class);
        List<UsuarioDireccion> usuariosdireccion = query.getResultList();

        return usuariosdireccion;
    }

    @Override
    public UsuarioDireccion GetById(int idusuarioeditable) {
        TypedQuery<UsuarioDireccion> query = entityManager.createQuery("FROM Direccion where id=:idusuarioeditable", UsuarioDireccion.class);
        query.setParameter("idusuarioeditable", idusuarioeditable);
        return query.getSingleResult();
    }
    
}
