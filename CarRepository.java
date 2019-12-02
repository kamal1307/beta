package coom.bz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarRepository {

    private List<Car> carList = new ArrayList<>();
    private Connection connection;

    public List<Car> readCars() throws SQLException {
        connection = ConnectionDB.getConnection();
        String query = "SELECT * " +
                "FROM Car";
        PreparedStatement st = connection.prepareStatement(query);
        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            Car c =
                    new Car(
                            rs.getString("mark"), rs.getString("model")
                    );
            carList.add(c);
        }
        return carList;
    }

    public void insertCar(String mark, String model)
            throws SQLException {
        connection = ConnectionDB.getConnection();
        String sql = "INSERT INTO Car (mark, model) VALUES (?, ?)";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, mark);
        statement.setString(2, model);

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("A new car was inserted successfully!");
        }// ajoutter exception
    }

    public void deleteCar(String model) throws SQLException {
        connection = ConnectionDB.getConnection();
        String sql = "DELETE FROM Car WHERE model=?";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, model);

        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("A car was deleted successfully!");
        }
    }

    public void updateCar(String mark, String model, int carId) throws SQLException {
        connection = ConnectionDB.getConnection();
        String sql = "UPDATE Car SET  mark =?, model=? WHERE carId=?";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, mark);
        statement.setString(2, model);
        statement.setInt(3, carId);
        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("An existing user was updated successfully!");
        }
    }


    public List<Car> getList() {
        return carList;
    }
}
