package com.getjavajob.phonebook.model;

import com.getjavajob.phonebook.dataBaseDao.DepartmentDao;
import com.getjavajob.phonebook.service.DepartmentService;

public class Department  implements ModelInterface{
    private String departmentName;
    private Employe chief;
    private int chiefID;

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public Department() {
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setChiefID(int chiefID) {
        this.chiefID = chiefID;
    }

    public int getChiefID() {
        return chiefID;
    }

    public Employe getChief() {
        return chief;
    }

    public void setChief(Employe chief) {
        this.chief = chief;
    }

    @Override
    public int hashCode() {
        return this.departmentName.hashCode();
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
        Department d = (Department) obj;
        if (hashCode() != d.hashCode()) {
            return false;
        }
        if (((Department) obj).getDepartmentName().equals(departmentName) && ((Department) obj).getChief().equals(chief)) {
            return true;
        }
        if (this.getDepartmentName().equals("") && (this.getChief().equals(new Employe()))){
            return false;
        }
        return true;
    }

    
}
