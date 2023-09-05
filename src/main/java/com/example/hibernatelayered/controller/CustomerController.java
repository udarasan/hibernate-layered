package com.example.hibernatelayered.controller;

import com.example.hibernatelayered.bo.BOFactory;
import com.example.hibernatelayered.bo.custom.CustomerBO;
import com.example.hibernatelayered.dto.CustomerDTO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CustomerController {
    @FXML
    private TextField id;
    @FXML
    private TextField name;

    @FXML
    private TextField address;

    @FXML
    private TableView<CustomerDTO> tblcustomer;

    public void initialize() {
        tblcustomer.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblcustomer.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblcustomer.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));
        loadAllCustomers();
    }
    @FXML
    void delete(ActionEvent event) {
        String id = tblcustomer.getSelectionModel().getSelectedItem().getId();
        try {
            //Delete Customer
            customerBO.deleteCustomer(id);

            tblcustomer.getItems().remove(tblcustomer.getSelectionModel().getSelectedItem());
            tblcustomer.getSelectionModel().clearSelection();
            loadAllCustomers();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    CustomerBO customerBO= (CustomerBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CUSTOMER);
    @FXML
    public void save(ActionEvent event) {
        String sid= id.getText();
        String sname=name.getText();
        String saddress=address.getText();
        try {
            customerBO.addCustomer(new CustomerDTO(sid,sname,saddress));
            loadAllCustomers();
            new Alert(Alert.AlertType.CONFIRMATION,"Student Added Successful !", ButtonType.OK).show();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Student Added Not Successful!", ButtonType.OK).show();
        }


    }
    private void loadAllCustomers() {
        tblcustomer.getItems().clear();
        ObservableList<CustomerDTO> items= (ObservableList<CustomerDTO>) tblcustomer.getItems();
        try {
            /*Get all customers*/
            List<CustomerDTO> allCustomers = customerBO.getAllCustomers();
            System.out.println(allCustomers);

            for (CustomerDTO c : allCustomers) {
                items.add(new CustomerDTO(c.getId(), c.getName(), c.getAddress()));
                System.out.println(c.getAddress());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void update(ActionEvent event) {
        String sid= id.getText();
        String sname=name.getText();
        String saddress=address.getText();
        try {
            customerBO.updateCustomer(new CustomerDTO(sid,sname,saddress));
            loadAllCustomers();
            new Alert(Alert.AlertType.CONFIRMATION,"Student Added Successful !", ButtonType.OK).show();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Student Added Not Successful!", ButtonType.OK).show();
        }

    }
    @FXML
    void clickOn(MouseEvent event) {
        CustomerDTO customerDTO=tblcustomer.getSelectionModel().getSelectedItem();
        id.setText(customerDTO.getId());
        name.setText(customerDTO.getName());
        address.setText(customerDTO.getAddress());
    }
}
