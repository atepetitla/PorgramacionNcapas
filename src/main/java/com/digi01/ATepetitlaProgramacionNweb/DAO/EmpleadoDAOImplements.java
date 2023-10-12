/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digi01.ATepetitlaProgramacionNweb.DAO;

import com.digi01.ATepetitlaProgramacionNweb.JPA.Empleado;
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
public class EmpleadoDAOImplements implements IEmpleado{
private EntityManager entityManager;

    public EmpleadoDAOImplements(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Empleado> getall() {
        TypedQuery<Empleado> query= entityManager.createQuery("FROM Empleado", Empleado.class);
        List<Empleado> empleados=query.getResultList();
        return empleados;
    }

    @Override
    @Transactional
    public void add(Empleado empleado) {
      entityManager.persist(empleado);
      
    }

    @Override
    @Transactional
    public void update(Empleado empleado) {
        
        entityManager.merge(empleado);
    }

    @Override
    public Empleado getbyid(int idempleadoc) {
       TypedQuery<Empleado> query= entityManager.createQuery("FROM Empleado WHERE idempleado=:id", Empleado.class);
       query.setParameter("id",idempleadoc);
       Empleado empleado=query.getSingleResult();
       return empleado;
       
    }

    @Override
    @Transactional
    public void delet(Empleado empleado) {
        
        entityManager.remove(empleado);
    }
 
    
}
