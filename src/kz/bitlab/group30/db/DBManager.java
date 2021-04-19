package kz.bitlab.group30.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBManager {

    private static Connection connection;

    static {

        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/group30_db?serverTimezone=UTC", "root", "");

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static ArrayList<Items> getAllItems(){
        ArrayList<Items> items = new ArrayList<>();
        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT it.id, it.name, it.price, it.amount, it.country_id, co.name AS country_name, co.code " +
                    "FROM items it " +
                    "LEFT OUTER JOIN countries co ON co.id = it.country_id " +
                    "ORDER BY it.price DESC ");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){

                items.add(new Items(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("price"),
                        resultSet.getInt("amount"),
                        new Countries(
                                resultSet.getLong("country_id"),
                                resultSet.getString("country_name"),
                                resultSet.getString("code")
                        )
                ));

            }

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return items;
    }

    public static void addItem(Items item){
        try{

            PreparedStatement statement = connection.prepareStatement("INSERT INTO items(name, price, amount, country_id) VALUES (?, ?, ?, ?)");
            statement.setString(1, item.getName());
            statement.setDouble(2, item.getPrice());
            statement.setInt(3, item.getAmount());
            statement.setLong(4, item.getCountry().getId());

            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Items getItem(Long id){

        Items item = null;

        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT it.id, it.name, it.price, it.amount, it.country_id, co.name AS country_name, co.code " +
                    "FROM items it " +
                    "LEFT OUTER JOIN countries co ON co.id = it.country_id " +
                    "WHERE it.id = ?");
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                item = new Items(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("price"),
                        resultSet.getInt("amount"),
                        new Countries(
                                resultSet.getLong("country_id"),
                                resultSet.getString("country_name"),
                                resultSet.getString("code")
                        )
                );
            }

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return item;

    }

    public static void saveItem(Items item){
        try{

            PreparedStatement statement = connection.prepareStatement("UPDATE items SET name = ?, price = ?, amount = ?, country_id = ? WHERE id = ?");
            statement.setString(1, item.getName());
            statement.setDouble(2, item.getPrice());
            statement.setInt(3, item.getAmount());
            statement.setLong(4, item.getCountry().getId());
            statement.setLong(5, item.getId());

            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void deleteItem(Items item){
        try{

            PreparedStatement statement = connection.prepareStatement("DELETE FROM items WHERE id = ?");
            statement.setLong(1, item.getId());

            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Countries> getAllCountries(){

        ArrayList<Countries> countries = new ArrayList<>();

        try{

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM countries ORDER BY name ASC");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){

                countries.add(new Countries(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("code")
                ));

            }

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return countries;
    }

    public static Countries getCountry(Long id){

        Countries country = null;

        try{

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM countries WHERE id = ?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){

                country = new Countries(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("code")
                );

            }

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return country;
    }

}
