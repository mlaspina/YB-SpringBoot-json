package com.yugabyte.springdemo.model;

import javax.persistence.*;
import java.util.UUID;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.Type;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.yugabyte.springdemo.model.Details;



@Entity
@Table(name = "mygrocerylistjson")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class GroceryItem {

    @Id
    private String id;
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private Details details;

    public GroceryItem() {
        this.id = UUID.randomUUID().toString();
    }

    public GroceryItem(String id, String name, int quantity, String category) {
        super();
        this.id = id;
        this.details = new Details(name, quantity, category);
    }

    public String getId() {
        return id;
    }

    public void setId (String id){
        this.id = id;
    }

    public String getName () {
        return this.details.getName();
    }

    public void setName (String name){
        this.details.setName(name);
    }

    public int getItemQuantity () {
        return this.details.getQuantity();
    }

    public void setItemQuantity ( int quantity){

        this.details.setQuantity(quantity);
    }

    public String getCategory () {

        return this.details.getCategory();
    }

    public void setCategory (String category){
        this.details.setCategory(category);
    }
}


