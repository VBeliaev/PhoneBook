package com.getjavajob.phonebook.dataBaseDao;


import com.getjavajob.phonebook.daoInterfaces.Write;
import com.getjavajob.phonebook.model.Department;
import com.getjavajob.phonebook.model.Employe;
import com.getjavajob.phonebook.model.Telephone;
import com.getjavajob.phonebook.service.DepartmentService;
import com.getjavajob.phonebook.service.EmployeService;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBaseWriter implements Write {

    private Connection con = new Connect().connect();
    private DepartmentService departmentService;
    private EmployeService employeService;

    
    public void write(EmployeService employeService, DepartmentService departmentService) {
        this.employeService = employeService;
        this.departmentService = departmentService;
        try {
            writeEmploye();
            writeDepartment();
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void writeEmploye() throws SQLException {
        for (Employe emp : employeService.getEmployeBase()) {

            try (PreparedStatement ps = con.prepareStatement("Insert into Employe (firstname, surname, projectName,department,email) values( ? , ? ,?, ?, ? ) ;")) {
                ps.setString(1, emp.getName());
                ps.setString(2, emp.getSurname());
                ps.setString(3, emp.getProjectName());
                ps.setString(4, emp.getDepartment().getDepartmentName());
                ps.setString(5, emp.getEmail());
                ps.executeUpdate();
                try (Statement s = con.createStatement()) {
                    ResultSet rs = s.executeQuery("Select last_insert_id()");
                    rs.next();
                    int lastInsertedId = Integer.parseInt(rs.getString("last_insert_id()"));
                    emp.setId(lastInsertedId);
                    Department dep = emp.getDepartment();
                    if(dep.getChief().equals(emp)){
                        dep.setChiefID(lastInsertedId);
                    }
                }
                for (Telephone telephone : emp.getTelephone()) {
                    try (PreparedStatement prepareStatement = con.prepareStatement("Insert into Telephone (clientid, codeCountry, phoneNumber,phoneNumber,mobile) values( ? , ? ,?, ?, ? ) ;")) {
                        prepareStatement.setInt(1, emp.getId());
                        prepareStatement.setInt(2, telephone.getCountryCode());
                        prepareStatement.setInt(3, telephone.getCityCode());
                        prepareStatement.setInt(4, telephone.getNumber());
                        prepareStatement.setBoolean(5, telephone.getMobile());

                    }
                }
            }
        }
    }

    private void writeDepartment() throws SQLException {
        for (Department dep : departmentService.getDepartmentBase()) {
            try (PreparedStatement ps = con.prepareStatement("Insert into Employe (department,chief_id) values(?, ? ) ;")) {
                ps.setString(1, dep.getDepartmentName());
                ps.setInt(2, dep.getChiefID());
                ps.executeUpdate();
            }
        }
    }
}
