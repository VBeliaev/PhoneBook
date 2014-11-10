package com.getjavajob.phonebook.xmlDao.Sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.getjavajob.phonebook.model.Employe;

public class ParseSax {

    public void read() throws Exception {
        SAXParserFactory parserFactor = SAXParserFactory.newInstance();
        SAXParser parser = parserFactor.newSAXParser();
        SAXHandler handler = new SAXHandler();
        parser.parse(ClassLoader.getSystemResourceAsStream("xml/employee.xml"),
                handler);

        //Printing the list of employees obtained from XML
        for (Employe emp : handler.empList) {
            System.out.println(emp);
        }
    }
}
