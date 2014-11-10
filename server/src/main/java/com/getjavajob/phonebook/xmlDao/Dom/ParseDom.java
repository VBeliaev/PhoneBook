/*package com.getjavajob.phonebook.xmlDao.Dom;

import com.getjavajob.phonebook.model.Department;
import com.getjavajob.phonebook.model.Employe;
import com.getjavajob.phonebook.model.Telephone;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import sun.plugin.dom.core.Element;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Виталий on 02.11.2014.
 */
/*
public class ParseDom {

    public void read() throws Exception {
        //Get the DOM Builder Factory
        DocumentBuilderFactory factory =
                DocumentBuilderFactory.newInstance();

        //Get the DOM Builder
        DocumentBuilder builder = factory.newDocumentBuilder();

        //Load and Parse the XML document
        //document contains the complete XML as a Tree.
        Document document =
                builder.parse(
                        ClassLoader.getSystemResourceAsStream("xml/employee.xml"));


        List<Employe> empList = new ArrayList<>();

        //Iterating through the nodes and extracting the data.
        NodeList nodeList = document.getDocumentElement().getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {

            //We have encountered an <employee> tag.
            Node node = nodeList.item(i);
            if (node instanceof Element) {
                Employe emp = new Employe();
                Department dep = new Department();
                Telephone tel = new Telephone();
                dep.setDepartmentName(node.getAttributes().getNamedItem("dName").getNodeValue());
                tel.setStringNumber(node.getAttributes().getNamedItem("telepone").getNodeValue());
                emp.setId(Integer.parseInt(node.getAttributes().getNamedItem("id").getNodeValue()));
                NodeList childNodes = node.getChildNodes();
                for (int j = 0; j < childNodes.getLength(); j++) {
                    Node cNode = childNodes.item(j);

                    //Identifying the child tag of employee encountered.
                    if (cNode instanceof Element) {
                        String content = cNode.getLastChild().
                                getTextContent().trim();
                        switch (cNode.getNodeName()) {
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
                                emp.getDepartments().add(new Department(content));
                                break;
                            case "ePhone":
                                emp.addTelephone(new Telephone().fromString(content, emp.getId()));
                                break;
                            //For all other end tags the department has to be updated.
                            case "dName":
                                dep.setDepartmentName(content);
                                break;
                            case "dChief":
                                dep.setChiefID(Integer.parseInt(content));
                                break;
                            case "tId":
                                tel.setClientId(Integer.parseInt(content));
                                break;
                        }
                        }
                    }
                }
               // empList.add(emp);
            }

        }
        //Printing the Employee list populated.
       // for (Employe emp : empList) {
        //    System.out.println(emp);
        //}

    }*/