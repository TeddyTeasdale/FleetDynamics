package com.example.fleetdynamics;

// Author Teddy Teasdale

import java.io.Serializable;

public class Job implements Serializable
{
    private int jobId;
    private String customerName;
    private String JobLocation;
    private Vehicle vehicle;
    private String type;

    public Job(int jobId ,String customerName, String jobLocation, Vehicle vehicle, String type)
    {
        this.jobId = jobId;
        this.customerName = customerName;
        JobLocation = jobLocation;
        this.vehicle = vehicle;
        this.type = type;

    }

    public Job()
    {
        this.jobId = 0;
        this.customerName = "";
        JobLocation = "";
        this.vehicle = new Vehicle();
        this.type = null;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
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

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
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
