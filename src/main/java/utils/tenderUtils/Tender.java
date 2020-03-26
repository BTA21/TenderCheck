package utils.tenderUtils;

import java.util.ArrayList;

public class Tender {
    private String number;
    private String date;
    private String endDate;
    private String name;
    private String startCost;
    private String place;
    private ArrayList category;
    private String ref;

    Tender(ArrayList tendersCategories) {
        this.number = "44389700";
        this.date = "19.03.2020";
        this.endDate = "30.03.2020";
        this.name = "Строительство офиса врача общей практики";
        this.startCost = "Р 3 977 131";
        this.place = "Уфа";
        this.category = tendersCategories;
        this.ref = "https://...";
    }

    public Tender(String number, String date, String endDate, String name, String startCost, String place, ArrayList categories, String ref){
        this.number = number;
        this.date = date;
        this.endDate = endDate;
        this.name = name;
        this.startCost = startCost;
        this.place = place;
        this.category = categories;
        this.ref = ref;
    }

    public String getPlace() {
        return place;
    }

    public String getRef() {
        return ref;
    }

    public String getNumber() {
        return number;
    }

    public String getDate() {
        return date;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getName() {
        return name;
    }

    public String getStartCost() {
        return startCost;
    }

    public ArrayList getCategory() {
        return category;
    }

    public String toString(){
        return this.number + " " + this.date + " " + this.endDate + " " + this.name + " " + this.startCost + " " + this.category;
    }
}
