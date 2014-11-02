

package com.getjavajob.phonebook.service;

import com.getjavajob.phonebook.dataBaseDao.TelephoneDao;
import com.getjavajob.phonebook.model.Telephone;
import com.getjavajob.phonebook.validator.Validator;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Виталий
 */
@Service
public class TelephoneService {



    @Autowired
    private TelephoneDao telephoneDao;
    @Autowired
    private Validator validator;

    public TelephoneService (TelephoneDao telephoneDao) {
        this.telephoneDao = telephoneDao;
    }

    @Transactional
    public Telephone add(Telephone telephone) throws ServiceException {
        if (validator.validate(telephone)) {
            return telephoneDao.add(telephone);
        } else {
            throw new ServiceException("Fall at telephonetAdd");
        }
    }

    @Transactional
    public Telephone get(String name) throws ServiceException {
        try {
            return telephoneDao.get(name);
        } catch (Exception e) {
            throw new ServiceException("Fall at telephoneGet", e);
        }
    }

    @Transactional
    public Telephone update(Telephone telephone) throws ServiceException {
        if (validator.validate(telephone)) {
            return telephoneDao.update(telephone);
        } else {
            throw new ServiceException("Fall at telephoneUpdate");
        }
    }

    @Transactional
    public void delete(String name) throws ServiceException {
        try {
            telephoneDao.delete(name);
        } catch (Exception e) {
            throw new ServiceException("Fall at telephoneDelete", e);
        }
    }

    @Transactional
    public List<Telephone> getAll() throws ServiceException {
        try {
            return telephoneDao.getAll();
        } catch (Exception e) {
            throw new ServiceException("Fall at telephoneGetAll");
        }
    }

    {
    /*

    private  TreeSet<Telephone> telephoneBase = new TreeSet<>();

    public  TreeSet<Telephone> getTelephoneBase() {
        return telephoneBase;
    }

    public  void add(int country, int city, int number, boolean isMobile, Employe employe) throws WrongDataEntered {
        Telephone tel = new Telephone(country, city, number, isMobile, employe.getId());
        if (new Validator().validate(tel)) {
            employe.addTelephone(tel);
            telephoneBase.add(tel);
        }else{
            throw new WrongDataEntered("Phone validate failure");
        }
    }

    public void add(String phone, int id) throws WrongDataEntered {
        Telephone telephone = new Telephone().fromString(phone, id);
        if(new Validator().validate(telephone)){
            telephoneBase.add(telephone);
        }else{
            throw new WrongDataEntered("Phone validate failure");
        }
    }

    public  void add(Telephone telephone) throws WrongDataEntered {
        if(new Validator().validate(telephone)) {
            telephoneBase.add(telephone);
        }else{
            throw new WrongDataEntered("Phone validate failure");
        }
    }

    public void add(TreeSet<Telephone> phones) throws WrongDataEntered {
        for(Telephone telephone: phones){
            add(telephone);
        }
    }
    */
    }// old code  delete at final rewiew
}
