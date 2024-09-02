/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Gigabyte
 */
public class Programme {
    
    
    private String programmeID;
    private String programmeName;
    private int numberOfTutorialGroup;
    private int yearsOfStudy;
    private static int numberOfProgramme;

    
       public Programme() {
            this.programmeID = "";
        this.programmeName = "";
        this.numberOfTutorialGroup = 0;
        this.yearsOfStudy = 0;
           numberOfProgramme++;
           
    }
       
    
      public Programme(String programmeID, String programmeName, int numberOfTutorialGroup, int yearsOfStudy) {
        this.programmeID = programmeID;
        this.programmeName = programmeName;
        this.numberOfTutorialGroup = numberOfTutorialGroup;
        this.yearsOfStudy = yearsOfStudy;
        numberOfProgramme++;
    }

 

    public String getProgrammeID() {
        return programmeID;
    }

    public void setProgrammeID(String programmeID) {
        this.programmeID = programmeID;
    }

    public String getProgrammeName() {
        return programmeName;
    }

    public void setProgrammeName(String programmeName) {
        this.programmeName = programmeName;
    }

    public int getNumberOfTutorialGroup() {
        return numberOfTutorialGroup;
    }

    public void setNumberOfTutorialGroup(int numberOfTutorialGroup) {
        this.numberOfTutorialGroup = numberOfTutorialGroup;
    }

    public int getYearsOfStudy() {
        return yearsOfStudy;
    }

    public void setYearsOfStudy(int yearsOfStudy) {
        this.yearsOfStudy = yearsOfStudy;
    }

    public static int getNumberOfProgramme() {
        return numberOfProgramme;
    }

    public static void setNumberOfProgramme(int numberOfProgramme) {
        Programme.numberOfProgramme = numberOfProgramme;
    }

  
        
    
    
    @Override
    public String toString() {
       return "--------"+programmeID+"---------\n"+
                   "Programme Information\n"+
                "--------------------------------\n"+
           "  Programme ID: " + programmeID + "\n" +
           "  Programme Name: " + programmeName + "\n" +
           "  Number Of Tutorial Group: " + numberOfTutorialGroup + "\n" +
           "  Years Of Study: " + yearsOfStudy + "\n";
    
    
}}
