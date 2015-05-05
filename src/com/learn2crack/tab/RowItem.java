package com.learn2crack.tab;

import java.io.Serializable;

import android.R.integer;

public class RowItem implements Serializable  {

	private int taskId;
	private String taskName;
	private String projectId;
	private String assignedTo;
	private String assignedBy;
	private String plannedCompletionDate;
	private String completionDate;
	private String addedOn;
    private int nameIcon;
    private int delIcon;
    private int doneIcon;

    public RowItem(	 int taskId1,
	 String taskName1,
	 String projectId1,
	 String assignedTo1,
	 String assignedBy1,
	 String plannedCompletionDate1,
	 String completionDate1,
	 String addedOn1,
     int nameIcon1,
     int delIcon1,
     int doneIcon1) {
    	
    	taskId=taskId1;
    	taskName=taskName1;
    	projectId=projectId1;
    	assignedTo=assignedTo1;
    	assignedBy=assignedBy1;
    	plannedCompletionDate =plannedCompletionDate1;
    	completionDate = completionDate1;
    	addedOn = addedOn1;
        nameIcon = nameIcon1;
        delIcon = delIcon1;
        doneIcon = doneIcon1;


    }

    public int getTaskId() {
        return taskId;
    }
    
    public String getTaskName() {
        return taskName;
    }
    
    public String getProjectId() {
        return projectId;
    }
    
    public String getAssignedTo() {
        return assignedTo;
    }
    
    public String getPlannedCompletionDate() {
        return plannedCompletionDate;
    }
    
    public String getCompletionDate() {
        return completionDate;
    }

    public String getAddedOn() {
        return addedOn;
    }
    
    public int getNameIcon() {
        return nameIcon;
    }
    
    public int getDelIcon() {
        return delIcon;
    }
    
    public int getDoneIcon() {
        return doneIcon;
    }



}
