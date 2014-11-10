package com.getjavajob.phonebook.xmlDao.Sax;

import com.getjavajob.phonebook.model.Department;
import com.getjavajob.phonebook.model.Employe;
import com.getjavajob.phonebook.model.Telephone;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Виталий on 02.11.2014.
 */
class SAXHandler extends DefaultHandler {

    List<Employe> empList = new ArrayList<>();
    List<Department> depList = new ArrayList<>();
    List<Telephone> telList = new ArrayList<>();
    Employe emp = null;
    Department dep = null;
    Telephone tel = null;
    String content = null;

    @Override
    //Triggered when the start of tag is found.
    public void startElement(String uri, String localName,
                             String qName, Attributes attributes)
            throws SAXException {

        switch (qName) {
            //Create a new Employee object when the start tag is found
            case "employee":
                emp = new Employe();
                emp.setId(Integer.parseInt(attributes.getValue("id")));
                break;
            case "department":
                dep = new Department();
                dep.setDepartmentName((attributes.getValue("dName")));
                break;

            case "telephone":
                tel = new Telephone();
                tel.setStringNumber((attributes.getValue("telephone")));
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName,
                           String qName) throws SAXException {
        switch (qName) {
            //Add the employee to list once end tag is found
            case "employee":
                empList.add(emp);
                break;
            //For all other end tags the employee has to be updated.
            case "eName":
                emp.setName(content);
                break;
            case "eSurname":
                emp.setSurname(content);
                break;
            case "eProject":
                emp.setProjectName(content);
                break;
            case "eEmail":
                emp.setEmail(content);
                break;
            case "eDepartment":
                emp.getDepartment().setDepartmentName(content);
                break;
            case "ePhone":
                emp.addTelephone(new Telephone().fromString(content, emp.getId()));
                break;

            case "department":
                depList.add(dep);
                break;
            //For all other end tags the department has to be updated.
            case "dName":
                dep.setDepartmentName(content);
                break;
            case "dChief":
                dep.setChiefID(Integer.parseInt(content));
                break;

            case "telephone":
                telList.add((tel));
                break;
            case "tId":
                tel.setClientId(Integer.parseInt(content));
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        content = String.copyValueOf(ch, start, length).trim();
    }
}
