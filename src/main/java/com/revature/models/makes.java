package com.revature.models;

public class makes {

    private String make_name;
    private String make_country;
    private String make_CEO;

    public makes() {
    }

    public makes(String make_name, String make_country, String make_CEO) {
        this.make_name = make_name;
        this.make_country = make_country;
        this.make_CEO = make_CEO;
    }

    public String getMake_name() {
        return make_name;
    }

    public void setMake_name(String make_name) {
        this.make_name = make_name;
    }

    public String getMake_country() {
        return make_country;
    }

    public void setMake_country(String make_country) {
        this.make_country = make_country;
    }

    public String getMake_CEO() {
        return make_CEO;
    }

    public void setMake_CEO(String make_CEO) {
        this.make_CEO = make_CEO;
    }

    @Override
    public String toString() {
        return "makes{" +
                "make_name='" + make_name + '\'' +
                ", make_country='" + make_country + '\'' +
                ", make_CEO='" + make_CEO + '\'' +
                '}';
    }
}
