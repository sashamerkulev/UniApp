package ru.merkulyevsasha.uniapp.presentation.dto;

import java.util.Date;

/**
 * Created by sasha_merkulev on 28.02.2018.
 */

public class LibraryItemUI {

    private int id;
    private String author;
    private String title;
    private String subject;
    private String course;
    private Date date;

    public LibraryItemUI(int id, String author, String title, String subject, String course, Date date) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.subject = subject;
        this.course = course;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
