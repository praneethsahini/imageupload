package com.pr.imageupload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@RestController
@EnableAutoConfiguration
@SpringBootApplication
public class ImageuploadApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImageuploadApplication.class, args);
	}

//	public static void main(String[] args) {
//		String url = "jdbc:mysql://localhost:3306/image_upload_db?createDatabaseIfNotExist=true&autoReconnect=true&useSSL=false";
//		String username = "root";
//		String password = "root";
//
//		try {
//			Connection connection = DriverManager.getConnection(url,username,password);
//			System.out.println("Connection successful!");
//			// Perform necessary DDL operations or other database tasks here
//			connection.close();
//		} catch (SQLException e) {
//			System.out.println("Connection failed! Error: " + e.getMessage());
//		}
//	}

}
