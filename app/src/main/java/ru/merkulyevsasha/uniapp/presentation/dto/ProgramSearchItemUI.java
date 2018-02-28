package ru.merkulyevsasha.uniapp.presentation.dto;

/**
 * Created by sasha_merkulev on 27.02.2018.
 */

public class ProgramSearchItemUI {

    public static int HEADER_VIEW_TYPE = 0;
    public static int ITEM_VIEW_TYPE = 1;

    private int id;
    private String course;
    private String degree;
    private String year;
    private String name;
    private int viewHolderType;

    public static ProgramSearchItemUI createHeader(){
        ProgramSearchItemUI result = new ProgramSearchItemUI();
        result.setViewHolderType(HEADER_VIEW_TYPE);
        return result;
    }

    public ProgramSearchItemUI(){
        viewHolderType = ITEM_VIEW_TYPE;
    }

    public ProgramSearchItemUI(int id, String course, String degree, String year, String name) {
        this();
        this.id = id;
        this.course = course;
        this.degree = degree;
        this.year = year;
        this.name = name;
    }

    public int getViewHolderType() {
        return viewHolderType;
    }

    public void setViewHolderType(int viewHolderType) {
        this.viewHolderType = viewHolderType;
    }

    public static int getHeaderViewType() {
        return HEADER_VIEW_TYPE;
    }

    public static void setHeaderViewType(int headerViewType) {
        HEADER_VIEW_TYPE = headerViewType;
    }

    public static int getItemViewType() {
        return ITEM_VIEW_TYPE;
    }

    public static void setItemViewType(int itemViewType) {
        ITEM_VIEW_TYPE = itemViewType;
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
