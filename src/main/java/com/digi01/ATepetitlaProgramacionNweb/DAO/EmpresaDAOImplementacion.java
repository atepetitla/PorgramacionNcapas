/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digi01.ATepetitlaProgramacionNweb.DAO;

import com.digi01.ATepetitlaProgramacionNweb.JPA.Empresa;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author digis
 */
@Repository
public class EmpresaDAOImplementacion implements IEmpresa{
    private EntityManager entityManager;

    public EmpresaDAOImplementacion(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    
    @Override
    public List<Empresa> getAll() {
        TypedQuery<Empresa> query= entityManager.createQuery("FROM Empresa", Empresa.class);
        List<Empresa> empresas= query.getResultList();
        return empresas;
    }

   

    @Override
    public Empresa getbyid(int idempresa) {
       TypedQuery<Empresa> query=entityManager.createQuery("FROM Empresa WHERE idempresa=:id", Empresa.class);
      //query.setParameter(idempresa, this)
      query.setParameter("id", idempresa);
      
       return  query.getSingleResult();
    }

    
    @Override
    @Transactional
    public void add(Empresa empresa) {
            entityManager.persist(empresa);
            //return empresa.getIdempresa();
    }

    @Override
    @Transactional
    public void delete(Empresa empresa) {
        entityManager.remove(empresa);
    }

    @Override
    @Transactional
    public void update(Empresa empresa) {
        entityManager.merge(empresa);
    }
    
    

   
}
