
package entity;


public class Course {
    private String courseID;
    private String courseName;
    private int creditHour;
    private int courseLimit;
    private double courseFee;
    private static int numberOfCourse;
   
    public double getCourseFee() {
        return courseFee;
    }

    public void setCourseFee(double courseFee) {
        this.courseFee = courseFee;
    }

   
    public double calculateCourseFee() {
       
       
        return creditHour * courseFee;
    }
    
    public Course(){
        courseID="";
        courseName="";
        
        numberOfCourse=0;
        
    }

   public double calculateAverageFee(){
       double averageCost=0.0;
       
       
       
       averageCost=calculateCourseFee()/numberOfCourse;
       
       return averageCost;
   }
    
    public Course(String courseID,String courseName){
        this.courseID=courseID;
        this.courseName=courseName;
        numberOfCourse++;
    }

    public String getCourseID() {
        return courseID;
    }

    public Course(String courseID, String courseName, int creditHour, int courseLimit, double courseFee) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.creditHour = creditHour;
        this.courseLimit = courseLimit;
        this.courseFee = courseFee;
        numberOfCourse++;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCreditHour() {
        return creditHour;
    }

    public void setCreditHour(int creditHour) {
        this.creditHour = creditHour;
    }

    public int getCourseLimit() {
        return courseLimit;
    }

    public void setCourseLimit(int courseLimit) {
        this.courseLimit = courseLimit;
    }

    @Override
    public String toString() {
        return "------------"+courseID+"------------\n"+
                   "\tCourse Information\n"+
                "--------------------------------\n"+
           "  Course ID: " + courseID + "\n" +
           "  Course Name: " + courseName + "\n" +
           "  Credit Hours: " + creditHour + "\n" +
           "  Course Limit: " + courseLimit + "\n"+
           "  Course Fees: " + courseFee + "0\n";
    }
    
   

    public static int getNumberOfCourse() {
        return numberOfCourse;
    }
    
    
}

