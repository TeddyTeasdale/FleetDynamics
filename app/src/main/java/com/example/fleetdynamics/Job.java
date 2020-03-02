package com.example.fleetdynamics;

public class Job
{
    private String customerName;
    private String JobLocation;
    private String vehicle;
    private String type;

    public Job(String customerName, String jobLocation, String vehicle, String type)
    {
        this.customerName = customerName;
        JobLocation = jobLocation;
        this.vehicle = vehicle;
        this.type = type;

    }

    public Job()
    {
        this.customerName = "";
        JobLocation = "";
        this.vehicle = "";
        this.type = null;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getJobLocation() {
        return JobLocation;
    }

    public void setJobLocation(String jobLocation) {
        JobLocation = jobLocation;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString()
    {
        return "" + this.customerName +"" +this.JobLocation +" "+ this.type + " " + this.vehicle;
    }
}
