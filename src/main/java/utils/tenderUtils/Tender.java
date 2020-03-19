package utils.tenderUtils;

import java.util.ArrayList;

public class Tender {
    private String number;
    private String date;
    private String endDate;
    private String name;
    private String startCost;
    private ArrayList category;
    private String ref;

    Tender(ArrayList tendersCategories) {
        this.number = "44389700";
        this.date = "19.03.2020";
        this.endDate = "30.03.2020";
        this.name = "Строительство офиса врача общей практики";
        this.startCost = "Р 3 977 131";
        this.category = tendersCategories;
        this.ref = "https://...";
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
