package com.getjavajob.phonebook.dataBaseDao;

import com.getjavajob.phonebook.exeption.DAOException;
import com.getjavajob.phonebook.exeption.DataNotFound;
import com.getjavajob.phonebook.model.Department;
import com.getjavajob.phonebook.service.DepartmentService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Виталий on 23.10.2014.
 */
@Repository
public class DepartmentDao {

    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public List<Department> getAll() throws SQLException, DAOException {
        Session session = sessionFactory.getCurrentSession();
        try {
            return (List<Department>)session.createCriteria(Department.class);
        }catch (Exception e){
            throw new DAOException("Failed at getAll Department",e);
        }
    }

    @Transactional
    public Department add(Department department) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        try {
            return (Department)session.save(department);
        } catch (Exception e) {
            throw new DAOException("Failed at add Department",e);
        }
    }
    @Transactional
    public void delete(String name) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.delete(get(name));
        }catch (Exception e){
            throw new DAOException("Failed at delete Department",e);
        }
    }

    @Transactional
    public Department get(String name) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        try{
            return (Department)session.get(Department.class,name);
        }catch (Exception e){
            throw new DAOException("Failed at get Department",e);
        }
    }

    @Transactional
    public Department update(Department department) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        try{
            session.update(department);
            return department;
        }catch (Exception e){
            throw new DAOException("Failed at update Department",e);
        }
    }


}
