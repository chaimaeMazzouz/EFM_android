package com.example.roomdatabase;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Produit {
    @PrimaryKey (autoGenerate = false)
    private Integer id;
    private String description;
    @ColumnInfo (name = "Montant")
    private Double Montant;
    private boolean typeOperation;

    public Produit() { }

    public Produit(Integer id, String description, Double Montant,boolean typeOperation) {
        this.id = id;
        this.description = description;
        this.Montant = Montant;
        this.typeOperation =typeOperation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer code) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getMontant() {
        return Montant;
    }

    public void setMontant(Double Montant) {
        this.Montant = Montant;
    }
    public boolean getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(boolean typeOperation) {
        this.typeOperation = typeOperation;
    }


    @NonNull
    @Override
    public String toString() {
        return "id = "+id+", description = "+description+", Montant = "+Montant+", typeOperation = "+typeOperation;
    }
}
