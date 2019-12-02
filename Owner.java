package coom.bz;

public class Owner {

    private String name, firstName, address;
    private int ownerCarId;


    public Owner(String name, String firstName, String address, int ownerCarId) {
        this.name = name;
        this.firstName = firstName;
        this.address = address;
        this.ownerCarId = ownerCarId;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", address='" + address + '\'' +
                ", ownerCarId=" + ownerCarId +
                '}';
    }
}
