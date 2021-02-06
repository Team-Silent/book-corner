package bookcorner.finder;

import bookcorner.models.Book;
import bookcorner.models.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerFinder extends Finder<Customer> {
    @Override
    List<Customer> findAll() {
        String query = "Select * from Customers";
        return getCustomers(query);
    }

    @Override
    public Customer findByID(String id) {
        String query = "Select * from customers where Contact_Number = '" + id +"'";
        List<Customer> foundCustomers =getCustomers(query);
        if(foundCustomers.size()==0) return null;
        return getCustomers(query).get(0);
    }

    @Override
    List<Customer> findByProperty(String property, String value) {
        String query = "Select * from customers where"+ property +" = "+value;
        return getCustomers(query);
    }

    private List<Customer> getCustomers(String query) {
        List<Customer> customerArrayList = new ArrayList<>();
        databaseConnection.connect();
        ResultSet resultSet = databaseConnection.runQuery(query);
        try {

            while (resultSet.next()){
                Customer customer = getCustomerFromResult(resultSet);
                customerArrayList.add(customer);

            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        databaseConnection.disconnect();
        return customerArrayList;
    }

    private Customer getCustomerFromResult(ResultSet resultSet) throws SQLException {
        return new Customer(
                resultSet.getString("Contact_Number"),
                resultSet.getString("Name"),
                resultSet.getString("Address")
        );
    }



}
