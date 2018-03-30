import java.sql.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SQLiteJDBC {

    public static void main(String[] args) {
        // the path to the sqlite file, here it is at the root of current project
        String url = "jdbc:sqlite:vinz.sqlite";
        System.out.println("open connection to " + url);
        Scanner in = new Scanner(System.in);
        String command = "";
        // try (with resource)-like syntax, with raise an error if the connection goes wrong
        try(Connection connection = DriverManager.getConnection(url)) {
            // get all inspections
            System.out.println("Welcome to the CAR system (Crappy Automobile Repository)");
            System.out.println("========================================================");

            command = in.next();
            List<String> commandList = Arrays.asList(command.split("\\s* \\s*"));
            //System.out.println(commandList.get(0));

            while (!(commandList.get(0).equals("exit")) && !(commandList.get(0).equals("quit"))){
                commandList = Arrays.asList(command.split("\\s*,\\s*"));
                //System.out.println("'"+commandList+"'");
                //System.out.println("'"+commandList.get(0)+"'");
                //System.out.println("'"+commandList.get(1)+"'");

                switch(commandList.get(0)){
                    case "vehicle":
                        if (commandList.size() == 11) {
                            try{
                                String nowneremail = commandList.get(1);
                                String nownerpword = commandList.get(2);
                                String newvin = commandList.get(3);
                                String newmake = commandList.get(4);
                                String newmodel = commandList.get(5);
                                String newfuel = commandList.get(6);
                                String nodo = commandList.get(7);
                                String nfirstRego = commandList.get(8);
                                String nwofexpire = commandList.get(9);
                                String ncartype = commandList.get(10);
                                addVehicle(connection, nowneremail, nownerpword, newvin, newmake, newmodel, newfuel, nodo, nfirstRego, nwofexpire, ncartype);
                            }catch(SQLException e){
                                System.err.println("Error: vehicle already exists");
                            }
                        }else{
                            System.err.println("Error: please use correct syntax");
                            System.out.println("Please register vehicles parameters in the format:\nvehicle,user_email,user_password,vehicle_num,make,model,fuel_type,odometer_reading,first_rego_date,wof_expiry_date,vehicle_tpye");
                        }
                        break;
                    case "owner":
                        if (commandList.size() == 5) {
                            try{
                                String newEmail = commandList.get(1);
                                String newfirstname = commandList.get(2);
                                String newlastname = commandList.get(3);
                                String newpassword = commandList.get(4);
                                addOwner(connection, newEmail, newfirstname, newlastname, newpassword);
                            }catch(SQLException e){
                                System.err.println("Error: owner already exists");
                            }
                        }else{
                            System.err.println("Error: please use correct syntax");
                            System.out.println("Please register as an owner with the format:\nowner,user_email,first_name,last_name,password");
                        }
                        break;
                    case "returnall":
                        ResultSet set = selectAllOwners(connection);
                        while(set.next()) {
                            printOwner(set);
                        }

                        break;
                }
                command = in.next();
            }

            } catch (SQLException e) {
            System.out.println(e.getMessage());
            }
        }


    public static ResultSet selectAllOwners(Connection connection) throws SQLException {
        assert null != connection;
        PreparedStatement statement = connection.prepareStatement("select * from owner");
        ResultSet resultSet = statement.executeQuery();
        return resultSet;
        }

    public static boolean checkUser(Connection connection,String email,String password) throws SQLException {
        assert null != connection;
        PreparedStatement statement = connection.prepareStatement("select password from owner where email='"+email+"'");
        ResultSet resultSet = statement.executeQuery();
        //statement.close();
        if(resultSet.getString(1).equals(password)){
            System.out.println("User Authenticated");
            resultSet.close();
            return true;
        }
        System.out.println("Access Denied");
        resultSet.close();
        return false;
    }

    public static void addOwner(Connection connection, String email, String firstname, String lastname, String password) throws
            SQLException {
        Scanner in = new Scanner(System.in);
        assert null != connection && null != email && null != firstname && null != lastname && null != password;

        try{
            String insert = "insert into owner(email, firstname,lastname,password) values (?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(insert);
            // use indexes of wildcard ("?") starting from 1
            statement.setString(1, email);
            statement.setString(2, firstname);
            statement.setString(3, lastname);
            statement.setString(4, password);
            // print the result of the insert statement, 0 means nothing has been inserted
            statement.executeUpdate();
            System.out.println("Owner registered with details\n Name: " + firstname + " " + lastname + "\n Email:" + email + "\n Password:" + password);
        } catch (SQLException e){
            System.err.println("ERROR: The email address "+email+" has already been taken");
        }
    }

    public static void printOwner(ResultSet set) throws SQLException {
        assert null != set;
        // rows must be retrieved by names
        System.out.print(set.getString("firstname") + ", ");
        System.out.print(set.getString("lastname") + ", ");
        // or by index (starts at index 1 for columns)
        System.out.print(set.getString(1));
        System.out.println();
        }

    public static void addVehicle(Connection connection,String nowneremail,String nownerpword,String newvin,String newmake,String newmodel,String newfuel,String nodo,String nfirstRego,String nwofexpire,String ncartype) throws
            SQLException {
        Scanner in = new Scanner(System.in);
        assert null != connection && null != nowneremail && null != nownerpword && null != newvin && null != newmake && null != newmodel && null != newfuel && null != nfirstRego && null != nwofexpire && null != ncartype;

        if(checkUser(connection,nowneremail,nownerpword)){

           // try {
                String insert = "insert into vehicle(vinNum, make,model, fuelType,odometer,firstRego,wofExpiry,carType,ownerEmail) values (?,?,?,?,?,?,?,?,?)";
                PreparedStatement statement = connection.prepareStatement(insert);
                // use indexes of wildcard ("?") starting from 1
                statement.setString(1, newvin);
                statement.setString(2, newmake);
                statement.setString(3, newmodel);
                statement.setString(4, newfuel);
                statement.setString(5, nodo);
                statement.setString(6, nfirstRego);
                statement.setString(7, nwofexpire);
                statement.setString(8, ncartype);
                statement.setString(9, nowneremail);

                // print the result of the insert statement, 0 means nothing has been inserted
                statement.executeUpdate();
                System.out.println("Owner registered with details\n Name: " + nowneremail + " " + newvin + "\n Email:" + newmake + "\n Password:" + newfuel);
            //} catch (SQLException e) {
              //  System.err.println("ERROR: with some code stuff");
            //}
        }
    }
}
