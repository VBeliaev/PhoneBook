package com.getjavajob.belyaev.model;

import com.getjavajob.belyaev.service.DepartmentService;

public class Department extends DepartmentService  implements Comparable<Department>, ModelInterface{
    private String departmentName = "";
    private Employe chief ;
    private int chiefID;

    public Department() {
    }

    public Department(String departmentName, int chiefID) {
        this.departmentName = departmentName;
        this.chiefID = chiefID;
    }

    public Department(String name) {
        this.departmentName=name;

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
    public void setVoidChief() {
        this.chief = new Employe();
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

    @Override
    public int compareTo(Department o) {
      if(this.hashCode()<o.hashCode()){
          return -1;
      }else if ( this.hashCode()==o.hashCode()){
          return 0;
      }else{
          return 1;
      }
    }
    
}
