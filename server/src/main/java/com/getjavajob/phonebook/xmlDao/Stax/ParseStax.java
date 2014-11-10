package com.getjavajob.phonebook.xmlDao.Stax;

/**
 * Created by Виталий on 02.11.2014.
 */
import com.getjavajob.phonebook.model.Department;
import com.getjavajob.phonebook.model.Employe;
import com.getjavajob.phonebook.model.Telephone;

import java.util.ArrayList;
import java.util.List;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class ParseStax {
    public static void main(String[] args) throws XMLStreamException {
        List<Employe> empList = null;
        List<Department> depList = null;
        List<Telephone> telList = null;
        Employe currEmp = null;
        Department currDep = null;
        Telephone currTel = null;
        String tagContent = null;
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader =
                factory.createXMLStreamReader(
                        ClassLoader.getSystemResourceAsStream("xml/employee.xml"));

        while(reader.hasNext()){
            int event = reader.next();

            switch(event){
                case XMLStreamConstants.START_ELEMENT:
                    if ("employee".equals(reader.getLocalName())){
                        currEmp = new Employe();
                        currEmp.setId(Integer.parseInt(reader.getAttributeValue(0)));
                    }
                    if("employees".equals(reader.getLocalName())){
                    empList = new ArrayList<>();
                }
                    if ("department".equals(reader.getLocalName())){
                        currDep = new Department();
                        currDep.setDepartmentName((reader.getAttributeValue(0)));
                    }
                    if("depatrments".equals(reader.getLocalName())){
                        depList = new ArrayList<>();
                    }
                    if ("telephone".equals(reader.getLocalName())){
                        currTel = new Telephone();
                        currTel.setStringNumber((reader.getAttributeValue(0)));
                    }
                    if("telephones".equals(reader.getLocalName())){
                        telList = new ArrayList<>();
                    }
                    break;

                case XMLStreamConstants.CHARACTERS:
                    tagContent = reader.getText().trim();
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    switch(reader.getLocalName()){
                        case "employe":
                            empList.add(currEmp);
                            break;
                        //For all other end tags the employee has to be updated.
                        case "eName":
                            currEmp.setName(tagContent);
                            break;
                        case "eSurname":
                            currEmp.setSurname(tagContent);
                            break;
                        case "eProject":
                            currEmp.setProjectName(tagContent);
                            break;
                        case "eEmail":
                            currEmp.setEmail(tagContent);
                            break;

                        case "department":
                            depList.add(currDep);
                            break;
                        //For all other end tags the department has to be updated.
                        case "dName":
                            currDep.setDepartmentName(tagContent);
                            break;
                        case "dChief":
                            currDep.setChiefID(Integer.parseInt(tagContent));
                            break;

                        case "telephone":
                            telList.add((currTel));
                            break;
                        case "tId":
                            currTel.setClientId(Integer.parseInt(tagContent));
                            break;
                    }
                    break;

                case XMLStreamConstants.START_DOCUMENT:
                    empList = new ArrayList<>();
                    break;
            }

        }

        //Print the employee list populated from XML
        for ( Employe emp : empList){
            System.out.println(emp);
        }

    }
}
