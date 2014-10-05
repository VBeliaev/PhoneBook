

package com.getjavajob.phonebook.validator;

import com.getjavajob.phonebook.model.Department;
import com.getjavajob.phonebook.model.Employe;
import com.getjavajob.phonebook.model.ModelInterface;
import com.getjavajob.phonebook.model.Telephone;
import java.util.HashMap;
import java.util.Map;


public class Validator {
    
    private Map<Class,ValidInterface> valid = new HashMap<>();
    
   
    public Validator() {
       valid.put(Employe.class, new EmployeValidator());
       valid.put(Department.class, new DepartmentValidator());
       valid.put(Telephone.class, new PhoneValidator());
       
    }
    
    public boolean validate(ModelInterface modelInterface){
        ValidInterface validInterface = valid.get(modelInterface.getClass());
        return validInterface.validate(modelInterface);
    }
    
    
    
    
    

    

    

     

    

   
}
