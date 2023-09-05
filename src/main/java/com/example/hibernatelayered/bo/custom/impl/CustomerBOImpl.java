package com.example.hibernatelayered.bo.custom.impl;

import com.example.hibernatelayered.bo.custom.CustomerBO;
import com.example.hibernatelayered.dao.DAOFactory;
import com.example.hibernatelayered.dao.custom.CustomerDAO;
import com.example.hibernatelayered.dto.CustomerDTO;
import com.example.hibernatelayered.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerBOImpl implements CustomerBO {

    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    @Override
    public List<CustomerDTO> getAllCustomers() throws Exception {
        List<CustomerDTO> allCustomers= new ArrayList<>();
        List<Customer> all = customerDAO.getAll();
        for (Customer c : all) {
            allCustomers.add(new CustomerDTO(c.getId(),c.getName(),c.getAddress()));
        }
       return allCustomers;
    }

    @Override
    public boolean addCustomer(CustomerDTO dto) throws Exception {
        return customerDAO.add(new Customer(dto.getId(), dto.getName(), dto.getAddress()));
    }

    @Override
    public boolean updateCustomer(CustomerDTO dto) throws Exception {
        return customerDAO.update(new Customer(dto.getId(),dto.getName(),dto.getAddress()));
    }


    @Override
    public boolean deleteCustomer(String id) throws Exception {
        return customerDAO.delete(id);
    }

}
