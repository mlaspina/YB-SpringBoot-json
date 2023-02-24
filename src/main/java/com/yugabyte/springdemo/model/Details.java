package com.yugabyte.springdemo.model;

import javax.persistence.*;
import java.util.UUID;
import java.util.List;
import org.hibernate.annotations.*;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.fasterxml.jackson.annotation.*;
import java.io.Serializable;


public class Details implements Serializable  {
    public Details(String name, int quantity, String category) {
        this.name = name;
        this.quantity = quantity;
        this.category = category;
    }

    public Details() {};

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("name")
    private String name;

    public String getName() {
        return name;
    }
    @JsonProperty("quantity")
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @JsonProperty("category")
    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
