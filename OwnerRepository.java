package coom.bz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OwnerRepository {
    private List<Owner> ownerList = new ArrayList<>();
    private List<OwnerCar> ownerCarList = new ArrayList<>();
    private Connection connection;

    public List<Owner> readOwners() throws SQLException {
        connection = ConnectionDB.getConnection();
        String query = "SELECT * " +
                "FROM Ownerr";
        PreparedStatement st = connection.prepareStatement(query);
        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            Owner own =
                    new Owner(
                            rs.getString("name"),rs.getString("firstName"),
                            rs.getString("address"), rs.getInt("ownerCarId")
                    );
            ownerList.add(own);
        }
        return ownerList;
    }

    public List<OwnerCar> allOwnersCars() throws SQLException {
        connection = ConnectionDB.getConnection();
        String query = "SELECT * " +
                "FROM Ownerr o" +
                " join Car c" +
                " on o.ownerCarId = c.carId";

        PreparedStatement st = connection.prepareStatement(query);

        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            OwnerCar ful = new OwnerCar( rs.getString("name"),rs.getString("firstName"),
                    rs.getString("address"), rs.getInt("ownerCarId"),
                    rs.getString("mark"),rs.getString("model"));
            ownerCarList.add(ful);
        }
        return ownerCarList;
    }

    public void insertOwner(String name, String firstName, String address, int ownerCarId)
            throws SQLException {
        connection = ConnectionDB.getConnection();

        String sql = "INSERT INTO Ownerr (name, firstName, address, ownerCarId ) VALUES (?, ?, ?, ?)";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        statement.setString(2, firstName);
        statement.setString(3, address);
        statement.setInt(4, ownerCarId);

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("A new user was inserted successfully!");
        }
    }

    public void deleteOwner(String name) throws SQLException {
        connection = ConnectionDB.getConnection();
        String sql = "DELETE FROM Ownerr WHERE name=?";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);

        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("A user was deleted successfully!");
        }
    }

    public void updateOwner(String address, String name) throws SQLException {
        connection = ConnectionDB.getConnection();
        String sql = "UPDATE Ownerr SET  address=? WHERE name=?";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,address);
        statement.setString(2,name);

        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("An existing user was updated successfully!");
        }
    }

    public List<OwnerCar> getOwnerCarList() {
        return ownerCarList;
    }

    public List<Owner> getOwnerList() {
        return ownerList;
    }
}
