package com.revature.models;

public class models {

    private String model_make_fk;
    private String model_name;
    private short model_year;

    private makes make;

    //no-args constructor
    public models() {
    }

    //all-args for selects (obj instead of fk)
    public models(makes make, String model_name, short model_year) {
        this.make = make;
        this.model_name = model_name;
        this.model_year = model_year;
    }

    //all-args for inserts (fk instead of obj)
    public models(String model_make_fk, String model_name, short model_year) {
        this.model_make_fk = model_make_fk;
        this.model_name = model_name;
        this.model_year = model_year;
    }

    public String getModel_make_fk() {
        return model_make_fk;
    }

    public void setModel_make_fk(String model_make_fk) {
        this.model_make_fk = model_make_fk;
    }

    public String getModel_name() {
        return model_name;
    }

    public void setModel_name(String model_name) {
        this.model_name = model_name;
    }

    public short getModel_year() {
        return model_year;
    }

    public void setModel_year(short model_year) {
        this.model_year = model_year;
    }

    public makes getMake() {
        return make;
    }

    public void setMake(makes make) {
        this.make = make;
    }

    @Override
    public String toString() {
        return "models{" +
                "model_make_fk='" + model_make_fk + '\'' +
                ", model_name='" + model_name + '\'' +
                ", model_year=" + model_year +
                ", make=" + make +
                '}';
    }
}
