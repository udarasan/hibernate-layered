package com.example.hibernatelayered.bo.custom;

import com.example.hibernatelayered.bo.SuperBO;
import com.example.hibernatelayered.dto.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CustomerBO extends SuperBO {

    public List<CustomerDTO> getAllCustomers()  throws Exception ;
    public boolean addCustomer(CustomerDTO dto) throws Exception ;

    public boolean updateCustomer(CustomerDTO dto)  throws Exception  ;

    public boolean deleteCustomer(String id) throws Exception ;

}
