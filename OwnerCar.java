package coom.bz;

public class OwnerCar {
    private String  name, firstName, address;
    private int ownerCarId;
    private String mark, model;

    public OwnerCar(String name, String firstName, String address, int ownerCarId, String mark, String model) {
        this.name = name;
        this.firstName = firstName;
        this.address = address;
        this.ownerCarId = ownerCarId;
        this.mark = mark;
        this.model = model;
    }

    @Override
    public String toString() {
        return "OwnerCar{" +
                "name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", address='" + address + '\'' +
                ", ownerCarId=" + ownerCarId +
                ", mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
