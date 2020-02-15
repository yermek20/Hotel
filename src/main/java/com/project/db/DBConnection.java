package com.project.db;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@Component
@Scope("singleton")
public class DBConnection {

    private Connection connection;

    public DBConnection(){

        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring_two?serverTimezone=UTC", "root", "");

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public boolean addHotel(Hotels hotel){

        boolean result = false;

        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO hotels (name , country, stars) " +
                    "VALUES (?, ?, ?)");

            statement.setString(1, hotel.getName());
            statement.setString(2, hotel.getCountry());
            statement.setInt(3, hotel.getStars());

            result = statement.executeUpdate()>0;

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return result;

    }
    public boolean editHotel(Hotels hotels){
        boolean result = false;
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE hotels SET name=?,country=?,stars=? WHERE id=?");

            statement.setString(1,hotels.getName());
            statement.setString(2,hotels.getCountry());
            statement.setInt(3,hotels.getStars());
            statement.setLong(4,hotels.getId());

            result = statement.executeUpdate()>0;
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<Hotels> getAllHotels(){
        ArrayList<Hotels> hotels = new ArrayList<>();
        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM hotels");

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){

                hotels.add(
                        new Hotels(
                                resultSet.getLong("id"),
                                resultSet.getString("name"),
                                resultSet.getString("country"),
                                resultSet.getInt("stars")
                        )
                );

            }

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return hotels;
    }

    public Hotels getHotel(Long id){
        Hotels hotel = null;
        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM hotels WHERE id = ? ");

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){

                hotel = new Hotels(
                    resultSet.getLong("id"),
                    resultSet.getString("name"),
                    resultSet.getString("country"),
                    resultSet.getInt("stars")
                );
            }

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return hotel;
    }

    public boolean deleteHotel(Long id){

        boolean result = false;

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE FROM hotels WHERE id = ?"
            );
            statement.setLong(1, id);
            result = statement.executeUpdate()>0;
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

}
