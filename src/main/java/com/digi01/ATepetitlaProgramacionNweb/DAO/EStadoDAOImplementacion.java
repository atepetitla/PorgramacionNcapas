package com.digi01.ATepetitlaProgramacionNweb.DAO;

import com.digi01.ATepetitlaProgramacionNweb.DAO.IEstado;
import com.digi01.ATepetitlaProgramacionNweb.JPA.Estado;
import com.digi01.ATepetitlaProgramacionNweb.JPA.Municipio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author digis
 */
@Repository
public class EStadoDAOImplementacion implements IEstado {

    private EntityManager entityManager;

    @Autowired
    public EStadoDAOImplementacion(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Estado> getall() {
        TypedQuery<Estado> query = entityManager.createQuery("From Estado", Estado.class);
        List<Estado> direcciones = query.getResultList();
        return direcciones;
    }

//    @Override
//    public List<Estado> getByIdPais(int idpais) {
////        
////         TypedQuery<Usuario> query = entityManager.createQuery("FROM Usuario where idusuario=:idusuarioeditable", Usuario.class);
////        query.setParameter("idusuarioeditable", idusuarioeditable);
////        return query.getSingleResult();
////        TypedQuery<Estado> query = entityManager.createQuery("from Estado where pais.idpais= :id", Estado.class);
////        query.setParameter("id", idpais);
////        List<Estado> direcciones = query.getResultList();
////        return direcciones;
//    
//}

    @Override
    public List<Estado> getByIdPais(int idpais) {
        TypedQuery<Estado> query=entityManager.createQuery("FROM Estado WHERE Pais.idpais= :id", Estado.class);
        query.setParameter("id", idpais);
        List<Estado> direcciones= query.getResultList();
        return direcciones;
       
    }
}