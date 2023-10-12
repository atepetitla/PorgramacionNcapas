/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digi01.ATepetitlaProgramacionNweb.DAO;

import com.digi01.ATepetitlaProgramacionNweb.JPA.Municipio;
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
public class MunicipioDAOimplementacion implements IMunicipio {

    private EntityManager entityManager;

    @Autowired
    public MunicipioDAOimplementacion(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Municipio> getAll() {
        TypedQuery<Municipio> query = entityManager.createQuery("from Municipio", Municipio.class);
        List<Municipio> direcciones = query.getResultList();
        return direcciones;
    }

    @Override
    public List<Municipio> getByIdEstado(int idestado) {

        TypedQuery<Municipio> query = entityManager.createQuery("FROM  Municipio WHERE estado.idestado= :id", Municipio.class);
        query.setParameter("id", idestado);
        List<Municipio> direcciones = query.getResultList();
        return direcciones;
    }

}
