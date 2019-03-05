package com.bbc.news.felix;

public class Food {

    int id;
    String name;
    boolean isLiquid;
    String units;
    int quantity;

    public Food(int id, String name, boolean isLiquid, String units, int quantity) {
        this.id = id;
        this.name = name;
        this.isLiquid = isLiquid;
        this.units = units;
        this.quantity = quantity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLiquid(boolean liquid) {
        isLiquid = liquid;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isLiquid() {
        return isLiquid;
    }

    public String getUnits() {
        return units;
    }
}
