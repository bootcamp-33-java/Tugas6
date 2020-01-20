/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author BWP
 */
public class Jobs {

    private String jobId, jobTitle;
    private int minSal,maxSal;
    
    public Jobs(String jobId, String jobTitle, int minSal, int maxSal) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.minSal = minSal;
        this.maxSal = maxSal;
    }

    public Jobs() {
    }

    public String getJobId() {
        return jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public int getMinSal() {
        return minSal;
    }

    public int getMaxSal() {
        return maxSal;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setMinSal(int minSal) {
        this.minSal = minSal;
    }

    public void setMaxSal(int maxSal) {
        this.maxSal = maxSal;
    }

    
    
}
