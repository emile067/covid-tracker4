
package com.moringa.covidtracker.models;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cases implements Serializable
{

    @SerializedName("All")
    @Expose
    private All all;
    private final static long serialVersionUID = 7915959593811425948L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Cases() {
    }

    /**
     * 
     * @param all
     */
    public Cases(All all) {
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
