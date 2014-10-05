package com.getjavajob.phonebook.csvDao;


import com.getjavajob.phonebook.daoInterfaces.Write;
import com.getjavajob.phonebook.model.Department;
import com.getjavajob.phonebook.model.Employe;
import com.getjavajob.phonebook.model.Telephone;
import com.getjavajob.phonebook.service.DepartmentService;
import com.getjavajob.phonebook.service.EmployeService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Виталий on 27.09.2014.
 */
public class CsvWriter implements Write {

    private DepartmentService departmentService;
    private EmployeService employeService;

    @Override
    public void write(EmployeService employeService, DepartmentService departmentService) {
        this.departmentService=departmentService;
        this.employeService=employeService;

    }

    private void writeEmployer(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("Employe.emp"))){
            for(Employe employe: employeService.getEmployeBase()){
                bw.write(employe.getId() + " " + employe.getName() + " " + employe.getSurname() + " " + " " + employe.getProjectName() +" " + employe.getDepartment().getDepartmentName() + " " + employe.getEmail());
                for(Telephone telephone: employe.getTelephone()){
                    bw.write(" " + telephone.toString());
                }
                 bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void wrireDepartment(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("Department.csv"))){
            for (Department department :  departmentService.getDepartmentBase()){
                bw.write(department.getDepartmentName()+ " " + department.getChief().getName() + " " + department.getChief().getId());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
