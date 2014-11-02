package com.getjavajob.phonebook.model;

import com.getjavajob.phonebook.service.EmployeService;

import java.util.List;
import java.util.TreeSet;


public class Employe implements Comparable<Employe>, ModelInterface{
    private String name;
    private String surname;
    private String projectName;
    private List<Department> departments;
    private TreeSet<Telephone> telephone;
    private String email="";
    private int id = 0;

    public Employe() {
    }

    public Employe(String name, String surname, String projectName, List<Department> departments,TreeSet<Telephone> telephone, String email, int id){
        this.name =name;
        this.surname=surname;
        this.projectName =projectName;
        this.departments= departments;
        this.telephone = telephone;
        this.email= email;
        this.id=id;
    }

    public Employe(String name, String surname, String projectName, List<Department> departments, String email) {
        this.name = name;
        this.surname = surname;
        this.projectName = projectName;
        this.departments = departments;
        this.email = email;
        this.id = (EmployeService.getGlobalTempId()+1);
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getSurname() {
        return surname;
    }

    public int getId() {
        return id;
    }

    public TreeSet<Telephone> getTelephone() {
        return telephone;
    }
    
    public void setId(int id) {
        if(id< EmployeService.getGlobalTempId()){
            EmployeService.setGlobalTempId(id);
        }
        this.id = id;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setTelephone(TreeSet<Telephone> telephone) {
        this.telephone = telephone;
    }

    public void addTelephone(Telephone telephone){
        this.telephone.add(telephone);
    }

    @Override
    public int hashCode() {
        return this.id;
    }

   @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Employe e = (Employe) obj;
        if (hashCode() != e.hashCode()) {
            return false;
        }
        if (((Employe) obj).getName().equals(this.getName()) && ((Employe) obj).getSurname().equals(this.getSurname()) && ((Employe) obj).getDepartments().equals(this.getDepartments()) && ((Employe) obj).getProjectName().equals(this.getProjectName()) && ((Employe) obj).getTelephone().equals(this.getTelephone()) ) {
            return true;
        }
        if ((this.getName().equals("")) && (this.getSurname().equals("")) && (this.getDepartments()==null) && (this.getProjectName().equals("")) && (this.getTelephone().equals(new TreeSet<Telephone>())) ) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Employe o) {
       if(this.hashCode()<o.hashCode()){
           return -1;
       }else if(this.hashCode()==o.hashCode()){
           return 0;
       }else{
           return -1;
       }
    }
    
} 