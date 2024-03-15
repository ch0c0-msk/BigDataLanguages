package service;

public class Car {
    private String model;
    private String registrationNumber;
    private int condition;
    private boolean isAvailable;

    public Car(String model, String registrationNumber) {
        this.model = model;
        this.registrationNumber = registrationNumber;
        this.condition = 100;
        this.isAvailable = true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getModel() {
        return model;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }
}




