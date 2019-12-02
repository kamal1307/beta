package coom.bz;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
            System.out.println("coucou");

        OwnerRepository d = new OwnerRepository();
        CarRepository c = new CarRepository();
  try {
 c.insertCar( "Lotus", "spider");
 } catch (SQLException e) {
 e.printStackTrace();
 }
 // c.updateCar(con,"BMW","110D",4);
 // c.deleteCar(con, "spider");
 c.readCars();
        for (int i = 0; i < c.getList().size(); i++) {
            System.out.println(c.getList().get(i));
        }
d.insertOwner("jean","jack","rue du commerce",4);
// d.deleteOwner(con,"Omario");
// d.updateOwner(con,"rue de la duchesse","cams");
// d.readOwners(con);
        for (int i = 0; i < d.getOwnerList().size(); i++) {
            System.out.println(d.getOwnerList().get(i));
        }
        d.allOwnersCars();
        for (int i = 0; i < d.getOwnerCarList().size(); i++) {
            System.out.println(d.getOwnerCarList().get(i));
        }

        System.out.println("fermeture réussi");



    }

}

