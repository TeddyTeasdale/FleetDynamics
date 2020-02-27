package com.example.fleetdynamics;

public class Job
{
    private String customerFName;
    private String customerSName;
    private int jobId;
    private String JobLocation;

    public Job(String customerFName, String customerSName, int jobId, String jobLocation)
    {
        this.customerFName = customerFName;
        this.customerSName = customerSName;
        this.jobId = jobId;
        this.JobLocation = jobLocation;
    }

    public String getCustomerFName() {
        return customerFName;
    }

    public void setCustomerFName(String customerFName) {
        this.customerFName = customerFName;
    }

    public String getCustomerSName() {
        return customerSName;
    }

    public void setCustomerSName(String customerSName) {
        this.customerSName = customerSName;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getJobLocation() {
        return JobLocation;
    }

    public void setJobLocation(String jobLocation) {
        JobLocation = jobLocation;
    }
}
