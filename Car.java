package coom.bz;

public class Car {
    private String mark, model;

    public Car(String mark, String model) {
        this.mark = mark;
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
