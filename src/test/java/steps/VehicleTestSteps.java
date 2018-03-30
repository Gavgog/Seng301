package steps;

import java.SQLiteJDBC;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.sqlite.SQLiteJDBCLoader;

import java.sql.*;

public class VehicleTestSteps {

    @Given ("^I am connected to the WOF database$")
    public void i_am_connected_to_the_WOF_database () throws SQLException {
        String url = "jdbc:sqlite:vinz.sqlite";
        Connection connection = DriverManager.getConnection(url);
    }

    @Given("^The Owner with the email \"([^\"]*)\" exists$")
    public void theOwnerWithEmailExists(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
            String url = "jdbc:sqlite:vinz.sqlite";
            String enter_email = arg1;
            Connection connection = DriverManager.getConnection(url);
            assert null != connection;
            PreparedStatement statement = connection.prepareStatement("select email from owner where email='"+enter_email+"'");
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.getString(1).equals(enter_email)){
                resultSet.close();

            }else{
                throw new PendingException();
            }
            resultSet.close();


    }

    @When("^I Create a new vehicle with vinNum \"([^\"]*)\"$")
    public void iCreateANewVehicleWithVinNum(String arg1) throws Throwable {
        SQLiteJDBC sqllitejdbc = new SQLiteJDBC();
        throw new PendingException();
    }

    @Then("^Next time I retrive information from the table vehicle, it will contain a vehicle with vinNum \"([^\"]*)\"$")
    public void nextTimeIRetriveInformationFromTheTableVehicleItWillContainAVehicleWithVinNum(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

}
