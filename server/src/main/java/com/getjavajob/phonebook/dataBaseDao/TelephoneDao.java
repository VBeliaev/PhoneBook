package com.getjavajob.phonebook.dataBaseDao;

import com.getjavajob.phonebook.exeption.DAOException;
import com.getjavajob.phonebook.model.Department;
import com.getjavajob.phonebook.model.Telephone;
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
public class TelephoneDao {
    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    public TelephoneDao() {
    }

    @Transactional
    public List<Telephone> getAll() throws SQLException, DAOException {
        Session session = sessionFactory.getCurrentSession();
        try {
            return (List<Telephone>)session.createCriteria(Telephone.class);
        }catch (Exception e){
            throw new DAOException("Failed at getAll Telephone",e);
        }
    }

    @Transactional
    public Telephone add(Telephone telephone) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        try {
            return (Telephone)session.save(telephone);
        } catch (Exception e) {
            throw new DAOException("Failed at add Telephone",e);
        }
    }

    @Transactional
    public void delete(String phone) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.delete(get(phone));
        }catch (Exception e){
            throw new DAOException("Failed at delete Telephone",e);
        }
    }

    @Transactional
    public Telephone get(String phone) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        try{
            return (Telephone)session.get(Telephone.class,phone);
        }catch (Exception e){
            throw new DAOException("Failed at get Telephone",e);
        }
    }

    @Transactional
    public Telephone update(Telephone telephone) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        try{
            session.update(telephone);
            return telephone;
        }catch (Exception e){
            throw new DAOException("Failed at update Telephone",e);
        }
    }
}
