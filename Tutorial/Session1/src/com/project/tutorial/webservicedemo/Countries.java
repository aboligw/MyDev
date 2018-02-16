package com.project.tutorial.webservicedemo;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(wsdlLocation = "WEB-INF/wsdl/CountriesService.wsdl")
public class Countries {
    List<Country> list = new ArrayList<Country>();

    public Countries() {
        super();
    }

    @WebMethod(exclude = true)
    public void setList(List<Country> list) {
        this.list = list;
    }

    @WebMethod
    public List<Country> getList() {
        if (list.isEmpty()) {
            list.add(new Country("KR", "Korea"));
            list.add(new Country("IN", "India"));
        }
        return list;
    }

    @WebMethod
    public boolean addCntry(@WebParam(name = "arg0") Country x) {
        return list.add(x);
    }

}
