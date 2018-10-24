package eu.rafaelaznar.beans;

import com.google.gson.annotations.Expose;

public class pet {
    @Expose
    private String type;
    @Expose
    private String name;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }


}
