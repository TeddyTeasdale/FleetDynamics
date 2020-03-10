package com.example.fleetdynamics;

public class Vehicle
{
    private String model;
    private String reg;

    public Vehicle(String model, String reg)
    {
        this.model = model;
        this.reg = reg;
    }

    public Vehicle()
    {
        this.model = "";
        this.reg = "";
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }
}
