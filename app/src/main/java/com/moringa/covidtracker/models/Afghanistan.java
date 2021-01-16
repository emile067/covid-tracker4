
package com.moringa.covidtracker.models;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Afghanistan implements Serializable
{

    @SerializedName("All")
    @Expose
    private All all;
    private final static long serialVersionUID = -3959795509234349171L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Afghanistan() {
    }

    /**
     * 
     * @param all
     */
    public Afghanistan(All all) {
        super();
        this.all = all;
    }

    public All getAll() {
        return all;
    }

    public void setAll(All all) {
        this.all = all;
    }

}
