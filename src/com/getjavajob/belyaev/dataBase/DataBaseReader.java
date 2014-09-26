package com.getjavajob.belyaev.dataBase;

import com.getjavajob.belyaev.model.Employe;
import com.getjavajob.belyaev.service.DepartmentService;
import com.getjavajob.belyaev.service.EmployeService;
import com.getjavajob.belyaev.daoInterfaces.Read;
import com.getjavajob.belyaev.exeption.DataNotFound;
import com.getjavajob.belyaev.model.Department;
import com.getjavajob.belyaev.model.Telephone;
import com.getjavajob.belyaev.service.TelephoneService;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBaseReader implements Read {

    private Connection con = new Connect().connect();

    @Override
    public void read(EmployeService employeBase, DepartmentService departmentBase, TelephoneService telephoneBase) throws FileNotFoundException, IOException, Exception {
        readDepartment(departmentBase);
        try (Statement s = con.createStatement()) {
            ResultSet rs = s.executeQuery("Select * from Employe");
            while (rs.next()) {
                String name = rs.getString("firstName");
                String surname = rs.getString("surname");
                String ProcName = rs.getString("projectName");
                String department = rs.getString("department");
                String email = rs.getString("email");
                int id = rs.getInt("id");
                TreeSet<Telephone> clientSet = new TreeSet<>();
                try (PreparedStatement ps = con.prepareStatement("Select * from Telephone where clientid = ?")) {
                    ps.setInt(1, id);
                    ResultSet telList = ps.executeQuery();
                    while (telList.next()) {
                        Telephone telephone = new Telephone();
                        telephone.setCountryCode(telList.getInt("codeCountry"));
                        telephone.setCityCode(telList.getInt("codeCity"));
                        telephone.setNumber(telList.getInt("phoneNumber"));
                        telephone.setMobile(telList.getBoolean("mobile"));
                        telephone.setClientId(telList.getInt("clientid"));
                        clientSet.add(telephone);
                        telephoneBase.getTelephoneBase().add(telephone);
                    }
                }
                Department dep = findByName(department, departmentBase);
                employeBase.getEmployeBase().add(new Employe(name, surname, ProcName, dep, clientSet, email, id));
            }

        } catch (DataNotFound ex) {
            Logger.getLogger(DataBaseReader.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void readDepartment(DepartmentService departmentBase) throws SQLException {
        try (Statement s = con.createStatement()) {
            ResultSet rs = s.executeQuery("Select * from Department");
            while (rs.next()) {
                String department = rs.getString("department");
                int chiefid = rs.getInt("chief_id");
                departmentBase.getDepartmentBase().add(new Department(department, chiefid));
            }
        }
    }

    private Department findByName(String departmentName, DepartmentService departmentBase) throws DataNotFound {
        for (Department dep : departmentBase.getDepartmentBase()) {
            if (dep.getDepartmentName().equals(departmentName)) {
                return dep;
            }
        }
        throw new DataNotFound("department wasn't found");
    }
}
