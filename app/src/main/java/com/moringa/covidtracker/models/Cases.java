
package com.moringa.covidtracker.models;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cases implements Serializable
{

    @SerializedName("Afghanistan")
    @Expose
    private Afghanistan afghanistan;
    private final static long serialVersionUID = 8897921132904884361L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Cases() {
    }

    /**
     * 
     * @param afghanistan
     */
    public Cases(Afghanistan afghanistan) {
        super();
        this.afghanistan = afghanistan;
    }

    public Afghanistan getAfghanistan() {
        return afghanistan;
    }

    public void setAfghanistan(Afghanistan afghanistan) {
        this.afghanistan = afghanistan;
    }

}
