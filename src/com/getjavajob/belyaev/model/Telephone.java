package com.getjavajob.belyaev.model;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;

public class Telephone implements Comparable<Telephone>, ModelInterface {

    private int countryCode;
    private int cityCode;
    private int number;
    private boolean mobile;
    private int clientId;

    public Telephone() {

    }

    public Telephone(int countryCode, int cityCode, int number, boolean mobile, int clientId) {
        this.countryCode = countryCode;
        this.cityCode = cityCode;
        this.number = number;
        this.mobile = mobile;
        this.clientId = clientId;
    }

    public int getCityCode() {
        return cityCode;
    }

    public int getClientId() {
        return clientId;
    }
    
    public int getCountryCode() {
        return countryCode;
    }

    public int getNumber() {
        return number;
    }

    public boolean getMobile() {
        return mobile;
    }

    public void setCountryCode(int countryCode) throws Exception {
        this.countryCode = countryCode;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public void setCityCode(int cityCode) throws Exception {
        this.cityCode = cityCode;
    }

    public void setMobile(boolean mobile) {
        this.mobile = mobile;
    }

    public void setNumber(int number) throws Exception {
        this.number = number;
    }

    public String showNumber(){
        return String.valueOf(countryCode) + " " +String.valueOf(cityCode) + " " + String.valueOf(number) + " " + String.valueOf(mobile);
    }
    @Override
    public int hashCode() {
        return this.cityCode + this.cityCode * 15 + this.number * 3;
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
        Telephone r = (Telephone) obj;
        if (hashCode() != r.hashCode()) {
            return false;
        }
        if (((Telephone) obj).getCityCode() == cityCode && (((Telephone) obj).getCountryCode() == countryCode) && (((Telephone) obj).getNumber() == number)) {
            return true;
        }
        if ((cityCode == 0 && countryCode == 0 && number == 0)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Telephone o) {
        if (this.hashCode() < o.hashCode()) {
            return -1;
        } else if (this.hashCode() == o.hashCode()) {
            return 0;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return ("+" + String.valueOf(countryCode) + "(" + String.valueOf(cityCode) +")" + String.valueOf(number) + " (" + ((mobile)?"Mobile)":"Not mobile"));
    }
    
    
}
