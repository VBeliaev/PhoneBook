package com.getjavajob.belyaev.dataBase;

import com.getjavajob.belyaev.model.Department;
import com.getjavajob.belyaev.service.DepartmentService;
import com.getjavajob.belyaev.model.Employe;
import com.getjavajob.belyaev.service.EmployeService;
import com.getjavajob.belyaev.model.Telephone;
import com.getjavajob.belyaev.daoInterfaces.Write;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBaseWriter implements Write {

    private Connection con = new Connect().connect();
    private DepartmentService departmentBase;
    private EmployeService employeBase;

    
    public void write(EmployeService employeBase, DepartmentService departmentBase) {
        this.employeBase = employeBase;
        this.departmentBase = departmentBase;
        try {
            writeEmploye();
            writeDepartment();
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void writeEmploye() throws SQLException {
        for (Employe emp : employeBase.getEmployeBase()) {

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
        for (Department dep : departmentBase.getDepartmentBase()) {
            try (PreparedStatement ps = con.prepareStatement("Insert into Employe (department,chief_id) values(?, ? ) ;")) {
                ps.setString(1, dep.getDepartmentName());
                ps.setInt(2, dep.getChiefID());
                ps.executeUpdate();
            }
        }
    }
}
