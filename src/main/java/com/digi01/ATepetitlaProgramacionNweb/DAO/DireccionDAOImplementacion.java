/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digi01.ATepetitlaProgramacionNweb.DAO;

import com.digi01.ATepetitlaProgramacionNweb.JPA.Colonia;
import com.digi01.ATepetitlaProgramacionNweb.JPA.Direccion;
import com.digi01.ATepetitlaProgramacionNweb.JPA.Direccion;
import com.digi01.ATepetitlaProgramacionNweb.JPA.Estado;
import com.digi01.ATepetitlaProgramacionNweb.JPA.Municipio;
import com.digi01.ATepetitlaProgramacionNweb.JPA.Pais;
import com.digi01.ATepetitlaProgramacionNweb.JPA.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author digis
 */
@Repository
public class DireccionDAOImplementacion implements IDireccion {

    private EntityManager entityManager;

    @Autowired //Inyeccion
    public DireccionDAOImplementacion(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Direccion> GetAll() {
        TypedQuery<Direccion> query = entityManager.createQuery("from Direccion", Direccion.class);
        List<Direccion> direcciones = query.getResultList();
        return direcciones;
    }

    @Override
    public List<Colonia> GetAllcolonia() {
        TypedQuery<Colonia> query = entityManager.createQuery("from Colonia", Colonia.class);

        List<Colonia> direcciones = query.getResultList();
        return direcciones;
    }

    @Override
    public List<Pais> GetAllpais() {
        TypedQuery<Pais> query = entityManager.createQuery("from Pais", Pais.class);

        List<Pais> direcciones = query.getResultList();
        return direcciones;
    }

    @Override
    public List<Municipio> getmunicio() {
        TypedQuery<Municipio> query = entityManager.createQuery("from Municipio", Municipio.class);

        List<Municipio> direcciones = query.getResultList();
        return direcciones;
    }

    @Override
    public List<Estado> getmestado() {
        TypedQuery<Estado> query = entityManager.createQuery("from Estado", Estado.class);

        List<Estado> direcciones = query.getResultList();
        return direcciones;
    }

    @Override
    @Transactional
    public void add(Direccion direccion) {
        entityManager.persist(direccion);
    }

    @Override
    public Direccion GetById(int idusuarioeditable) {
        TypedQuery<Direccion> query = entityManager.createQuery("FROM Direccion where usuario.idusuario=:idusuarioeditable", Direccion.class);
        Direccion direccion;
        try {
            query.setParameter("idusuarioeditable", idusuarioeditable);
            direccion = query.getSingleResult();
        } catch (Exception e) {
            direccion = new Direccion();
        }

        return direccion;
    }

    @Override
    @Transactional
    public void Update(Direccion direccion) {
        entityManager.merge(direccion);
    }

    @Override
    public Direccion GetByIddir(int id) {
        TypedQuery<Direccion> query = entityManager.createQuery("FROM Direccion where iddireccion=:id", Direccion.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}
