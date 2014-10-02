package com.getjavajob.belyaev.service;

import com.getjavajob.belyaev.exeption.DataNotFound;
import com.getjavajob.belyaev.exeption.WrongDataEntered;
import com.getjavajob.belyaev.model.Department;
import com.getjavajob.belyaev.model.Employe;
import com.getjavajob.belyaev.model.Telephone;
import com.getjavajob.belyaev.validator.Validator;

import java.util.TreeSet;

public class EmployeService {

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

    public  void add(Employe employe) throws WrongDataEntered {
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

    public  Employe get(int id) throws DataNotFound {
        if(id==0){
            return new Employe();
        }
        for (Employe emp : employeBase) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        throw new DataNotFound("Threr is no such id");
    }

    public void search(String searchString) {
        String[] splitString = searchString.split(" ");
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

    public void add(Telephone telephone) throws DataNotFound, WrongDataEntered {
        if(new Validator().validate(telephone)) {
            get(telephone.getClientId()).addTelephone(telephone);
        }else{
            throw new WrongDataEntered("Phone validate failure");
        }
    }

}
