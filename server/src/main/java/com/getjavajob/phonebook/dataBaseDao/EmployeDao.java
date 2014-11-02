package com.getjavajob.phonebook.dataBaseDao;

import com.getjavajob.phonebook.exeption.DAOException;
import com.getjavajob.phonebook.model.Department;
import com.getjavajob.phonebook.model.Employe;
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
public class EmployeDao {
    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public List<Employe> getAll() throws SQLException, DAOException {
        Session session = sessionFactory.getCurrentSession();
        try {
            return (List<Employe>) session.createCriteria(Employe.class);
        } catch (Exception e) {
            throw new DAOException("Failed at getAll Employe", e);
        }
    }

    @Transactional
    public Employe add(Employe employe) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        try {
            int id = (Integer) session.save(employe);
            employe.setId(id);
            return employe;
        } catch (Exception e) {
            throw new DAOException("Failed at add Employe", e);
        }
    }

    @Transactional
    public void delete(int id) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.delete(get(id));
        } catch (Exception e) {
            throw new DAOException("Failed at delete Employe", e);
        }
    }

    @Transactional
    public Employe get(int id) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        try {
            return (Employe) session.get(Employe.class, id);
        } catch (Exception e) {
            throw new DAOException("Failed at get Employe", e);
        }
    }

    @Transactional
    public Employe update(Employe employe) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.update(employe);
            return employe;
        } catch (Exception e) {
            throw new DAOException("Failed at update Employe", e);
        }
    }
}
