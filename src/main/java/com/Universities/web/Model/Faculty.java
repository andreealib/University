package com.Universities.web.Model;

/**
 * Created by Lei Florin on 18.09.2015.
 *
 * <br>Faculty model class.
 */
public class Faculty {
    private long idfaculty;
    private String name;
    private String city;
    private String info;

    /**
     * Constructors, getters and setters.
     */

    public Faculty() { }

    public Faculty(long idfaculties, String name, String city, String info) {
        this.idfaculty = idfaculties;
        this.name = name;
        this.city = city;
        this.info = info;
    }

    public long getIdfaculty() {
        return idfaculty;
    }

    public void setIdfaculty(long idfaculty) {
        this.idfaculty = idfaculty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
