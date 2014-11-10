package com.getjavajob.phonebook.exec;


import com.getjavajob.phonebook.exeption.DataNotFound;
import com.getjavajob.phonebook.model.Department;
import com.getjavajob.phonebook.service.DepartmentService;
import com.getjavajob.phonebook.model.Employe;
import com.getjavajob.phonebook.service.EmployeService;
import com.getjavajob.phonebook.exeption.WrongDataEntered;
import com.getjavajob.phonebook.model.Telephone;
import com.getjavajob.phonebook.service.TelephoneService;
//import com.getjavajob.phonebook.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Виталий
 */
@Component
public class Menu {
    
    private Scanner scanner = new Scanner(System.in);
    private DepartmentService departmentService;
     @Autowired
    private EmployeService employeService;
    private TelephoneService telephoneService;
    
    public Menu() {
        
    }
    
    public void callMenu() {
    }
    /**
        String choice;
        do {
            System.out.println("1 - Enter department");
            System.out.println("2 - Enter Employe");
            System.out.println("3 - Set department chief");
            System.out.println("4 - Save All to database");
            System.out.println("5 - Take All from database");
            System.out.println("6 -");
            System.out.println("0- Exit");
            choice = scanner.nextLine();
            try {
                toDo(choice);
            } catch (WrongDataEntered | Exception ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DataNotFound dataNotFound) {
                dataNotFound.printStackTrace();
            }
        } while (!choice.equals("0"));
        
    }
    
    private void toDo(String choice) throws WrongDataEntered, Exception, DataNotFound {
        
        switch (choice) {
            case "1":
                enterDepartament();
                break;
            case "2":
                enterEmploye();
                break;
            case "3":
                setDepartmetChief();
                break;
            case "4":
                //new DataBaseWriter().write(employeService, departmentService);
                break;
            case "5":
                //new DataBaseReader().read(employeService, departmentService, telephoneService);
                break;
            case "6":
                
                break;
            default:
                break;
        }
    }
    
    private void enterDepartament() throws WrongDataEntered {
        System.out.println("Enter department name");
        String name = scanner.nextLine();
        //departmentService.addDepartment(name);
    }
    
    private void enterEmploye() throws WrongDataEntered {
        System.out.println("Enter employe name:");
        String name = scanner.nextLine();
        System.out.println("Enter employe surname:");
        String surname = scanner.nextLine();
        System.out.println("Enter project:");
        String projet = scanner.nextLine();
        Department department = getDepartament();
        System.out.println("Enter email:");
        String email = scanner.nextLine();
        Employe employe = new Employe();
        String ch;
        do {
            System.out.println("Enter CountryCode");
            int country = scanner.nextInt();
            System.out.println("Enter CityCode");
            int city = scanner.nextInt();
            System.out.println("Enter Number");
            int number = scanner.nextInt();
            System.out.println("is it mobile (Y/N)");
            boolean isMobile = (scanner.nextLine().equals("y") || scanner.nextLine().equals("Y"));
            Telephone tel = new Telephone();
            if (new Validator().validate(tel)) {
                telephoneService.add(tel);
                employe.addTelephone(tel);
            }else{
                System.out.println("Number validate failed and wasn't added ");
            }
            System.out.println("Enter more phone? (Y/N)");
            ch = scanner.nextLine();
        } while (ch.equals("Y") || ch.equals("y"));
        
        if (new Validator().validate(employe)) {
           employeService.add(employe);
        } else {
            throw new WrongDataEntered("Failed at Employe Validation");
        }
    }
    
    private Department getDepartament() throws WrongDataEntered {
        System.out.println("Enter departmentName:");
        String depart = scanner.nextLine();
        return  null; //departmentService.getDepartament(depart);
    }

    private void setDepartmetChief() throws WrongDataEntered, DataNotFound {
        Department department = getDepartament();
        System.out.println("Enter employe id:");
        int id = scanner.nextInt();
       // departmentService.setDepartmetChief(department, employeService.get(id));
    } */
}
