/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digi01.ATepetitlaProgramacionNweb.DAO;

import com.digi01.ATepetitlaProgramacionNweb.JPA.Pais;
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
public class PaisDAOImplementacion implements IPais {

    @Autowired
    private EntityManager entityManager;

    public PaisDAOImplementacion(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    

    @Override
    public List<Pais> getall() {
        TypedQuery<Pais> query = entityManager.createQuery("from Pais", Pais.class);
        List<Pais> direcciones = query.getResultList();
        return direcciones;
    }
}
