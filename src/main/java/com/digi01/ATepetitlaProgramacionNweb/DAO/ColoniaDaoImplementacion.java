/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digi01.ATepetitlaProgramacionNweb.DAO;

import com.digi01.ATepetitlaProgramacionNweb.JPA.Colonia;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author digis
 */@Repository
public class ColoniaDaoImplementacion  implements IColonia{
private EntityManager entitymanager;
@Autowired
    public ColoniaDaoImplementacion(EntityManager entitymanager) {
        this.entitymanager = entitymanager;
    }

    @Override
    public List<Colonia> GetALL() {
        TypedQuery<Colonia> query=entitymanager.createQuery("from Colonia", Colonia.class);
        List<Colonia> direcciones=query.getResultList();
        return direcciones;
    }

    @Override
    public List<Colonia> GetByIdMunicipio(int idmunicipio) {
        TypedQuery<Colonia> query= entitymanager.createQuery("FROM Colonia WHERE municipio.idmunicipio= :id",Colonia.class);
        query.setParameter("id", idmunicipio);
        List<Colonia> direcciones=query.getResultList();
        return direcciones;
    }
    
    
}
