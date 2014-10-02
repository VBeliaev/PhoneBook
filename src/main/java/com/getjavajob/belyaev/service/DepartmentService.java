package com.getjavajob.belyaev.service;

import com.getjavajob.belyaev.exeption.DataNotFound;
import com.getjavajob.belyaev.exeption.WrongDataEntered;
import com.getjavajob.belyaev.model.Department;
import com.getjavajob.belyaev.model.Employe;
import com.getjavajob.belyaev.validator.Validator;

import java.util.*;


public class DepartmentService{
    private  TreeSet<Department> departmentBase = new TreeSet<>();

    public void setDepartmentBase(TreeSet<Department> departmentBase) {
        this.departmentBase = departmentBase;
    }

    public TreeSet<Department> getDepartmentBase() {
        return departmentBase;
    }

    public void addDepartment(String name) throws WrongDataEntered {

        Department department = new Department(name);
        if (new Validator().validate(department)) {
            departmentBase.add(department);
        } else {
            throw new WrongDataEntered("Failed at DepartmentValidation");
        }
    }

    public Department getDepartament(String depart) throws WrongDataEntered {
        for (Department department : departmentBase) {
            if (department.getDepartmentName().equals(depart)) {
                return department;
            }
        }
        throw new WrongDataEntered("ThereIsNoSuchDepartment");
    }

    public void setDepartmetChief(Department department , Employe employe) {
        department.setChief(employe);
    }

    public void setAllChiefsById(EmployeService employeService){
        for(Department department: departmentBase){
            try {
                department.setChief(employeService.get(department.getChiefID()));
            } catch (DataNotFound dataNotFound) {
                dataNotFound.printStackTrace();
            }
        }
    }

    public void add(Department department) throws WrongDataEntered {
        if(new Validator().validate(department)){
            departmentBase.add(department);
        }else{
            throw new WrongDataEntered("Department validate failure");
        }
    }
}

