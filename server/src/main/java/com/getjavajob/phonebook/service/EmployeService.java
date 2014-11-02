package com.getjavajob.phonebook.service;

import com.getjavajob.phonebook.dataBaseDao.EmployeDao;
import com.getjavajob.phonebook.model.Employe;
import com.getjavajob.phonebook.validator.Validator;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeService {

    @Autowired
    private EmployeDao employeDao;
    @Autowired
    private Validator validator;
    private  static int globalTempId = 0;
    public EmployeService(EmployeDao employeDao) {
        this.employeDao = employeDao;
    }

    @Transactional
    public Employe add(Employe employe) throws ServiceException {
        if(validator.validate(employe)){
            return employeDao.add(employe);
        }else{
            throw new ServiceException("Fall at employeAdd");
        }
    }
    @Transactional
    public Employe get(int id) throws ServiceException {
        try{
            return employeDao.get(id);
        }catch (Exception e){
            throw new ServiceException( "Fall at employeGet",e);
        }
    }
    @Transactional
    public Employe update(Employe employe) throws ServiceException {
        if(validator.validate(employe)) {
            return employeDao.update(employe);
        }else{
            throw new ServiceException("Fall at employeUpdate");
        }
    }
    @Transactional
    public void delete(int id) throws ServiceException{
        try{
            employeDao.delete(id);
        }catch (Exception e){
            throw new ServiceException("Fall at employeDelete",e);
        }
    }
    @Transactional
    public List<Employe> getAll() throws ServiceException{
        try {
            return employeDao.getAll();
        }catch (Exception e){
            throw new ServiceException("Fall at employeGetAll");
        }
    }

    public void search(String searchString) {
        String[] splitString = searchString.split(" ");
        List<Employe> employeBase = getAll();
        if (splitString.length == 1) {
            String pattern = "";
            pattern = pattern.concat(splitString[0]);
            pattern = pattern.concat("([a-zA-Z])*");
            for (Employe emp : employeBase) {
                if (emp.getName().matches(pattern) || emp.getSurname().matches(pattern)) {
                    System.out.println((emp.getName() + " " + emp.getSurname()));
                }
            }
        } else if (splitString.length == 2) {
            String pattern1 = "";
            String pattern2 = "";
            pattern1 = pattern1.concat(splitString[0]);
            pattern2 = pattern2.concat(splitString[1]);
            pattern1 = pattern1.concat("([a-zA-Z])*");
            pattern2 = pattern2.concat("([a-zA-Z])*");
            for (Employe emp : employeBase) {
                if (emp.getName().matches(pattern1) && emp.getSurname().matches(pattern2) || (emp.getName().matches(pattern2) && emp.getSurname().matches(pattern1))) {
                    System.out.println((emp.getName() + " " + emp.getSurname()));
                }
            }
        }
    }

    public static int getGlobalTempId() {
        return globalTempId;
    }

    public static void setGlobalTempId(int id){
        globalTempId=id;
    }


    {
/*
    private  TreeSet<Employe> employeBase = new TreeSet<>();

    private  static int globalTempId = 0;

    public  TreeSet<Employe> getEmployeBase() {
        return employeBase;
    }

    public void setEmployeBase(TreeSet<Employe> employeBase) {
        this.employeBase = employeBase;
    }

    public static int getGlobalTempId() {
        return globalTempId;
    }

    public static void setGlobalTempId(int id){
        globalTempId=id;
    }

    /*public  void add(Employe employe) throws WrongDataEntered {
        if(new Validator().validate(employe)) {
            employeBase.add(employe);
        }else{
            throw new WrongDataEntered("Employe validate failure");
        }
    }

    public void add(String name, String surname, String project, Department department, String email) throws WrongDataEntered {
        Employe employe = new Employe(name, surname, project, department, email);
        if (new Validator().validate(employe)) {
            employeBase.add(employe);
        } else {
            throw new WrongDataEntered("Employe validate failure");
        }
    }

     public void add(Telephone telephone) throws DataNotFound, WrongDataEntered {
        if(validator.validate(telephone)) {
            get(telephone.getClientId()).addTelephone(telephone);
        }else{
            throw new WrongDataEntered("Phone validate failure");
        }
    }
    */
    } // old code  delete at final rewiew









}
