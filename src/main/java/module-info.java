module com.example.hibernatelayered {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires java.naming;

    opens com.example.hibernatelayered to javafx.fxml;
    exports com.example.hibernatelayered;
    exports com.example.hibernatelayered.controller;
    opens com.example.hibernatelayered.entity;
    opens com.example.hibernatelayered.dto;
    opens com.example.hibernatelayered.controller to javafx.fxml;
}