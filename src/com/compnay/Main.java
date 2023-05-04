package com.compnay;

import helper.FruitsQuery;
import helper.JDBC;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) throws Exception {
        JDBC.makeConnection();

//        int rowsAffected = FruitsQuery.insert("cherries", 1);
//
//        if(rowsAffected > 0){
//            System.out.println("Insert Successful");
//        }
//        else{
//            System.out.println("Inset Failed");
//        }
//
//        rowsAffected = FruitsQuery.update(1, "Apple1");
//
//        if(rowsAffected > 0){
//            System.out.println("Update Successful");
//        }
//        else{
//            System.out.println("Update Failed");
//        }
//
//        rowsAffected = FruitsQuery.delete(8);
//
//        if(rowsAffected > 0){
//            System.out.println("Delete Successful");
//        }
//        else{
//            System.out.println("Delete Failed");
//        }

        FruitsQuery.select(3);


        //launch(args);
        JDBC.closeConnection();
    }
}
