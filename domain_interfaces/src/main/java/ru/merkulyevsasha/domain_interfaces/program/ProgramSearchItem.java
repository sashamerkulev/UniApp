package ru.merkulyevsasha.domain_interfaces.program;

/**
 * Created by sasha_merkulev on 27.02.2018.
 */

public class ProgramSearchItem {

    private int id;
    private String course;
    private String degree;
    private String year;
    private String name;

    public ProgramSearchItem(int id, String course, String degree, String year, String name) {
        this.id = id;
        this.course = course;
        this.degree = degree;
        this.year = year;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
