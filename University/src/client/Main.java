/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;


import adt.*;
import entity.Course;
import entity.Programme;
import entity.TutorManagement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Gigabyte
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            
        
        LinkedHashMapInterface<String, TutorManagement> tutor = new LinkedHashMap<>(); //cast to linked hash map interface so can use method in hash map interface
        tutor.put("92ACC12345", new TutorManagement("92ACC12345", "amirah lee", "male", "amirah@gmail.com", "012-33210231", "accounting", "part-time", 1800));
        tutor.put("46ACC98723", new TutorManagement("46ACC98723", "iskandar tan", "male", "iskandar@gmail.com", "011-112890829", "accounting", "lecturer", 3200));
        tutor.put("25ACC76543", new TutorManagement("25ACC76543", "john smith", "male", "john@gmail.com", "012-3456789", "accounting", "professor", 9200));
        tutor.put("18ACC23456", new TutorManagement("18ACC23456", "emily johnson", "female", "emily@gmail.com", "016-7890123", "accounting", "lecturer", 4500));
        tutor.put("37ACC87654", new TutorManagement("37ACC87654", "david brown", "male", "david@gmail.com", "019-1234567", "accounting", "senior lecturer", 5300));
        tutor.put("58ACC43210", new TutorManagement("58ACC43210", "sarah davis", "female", "sarah@gmail.com", "013-9876543", "accounting", "professor", 7200));
        tutor.put("74ACC12345", new TutorManagement("74ACC12345", "michael wilson", "male", "michael@gmail.com", "011-4567890", "accounting", "lecturer", 4700));
        tutor.put("38CPS65432", new TutorManagement("38CPS65432", "nurul abdullah", "female", "abdullah@gmail.com", "016-9023212", "computer science", "senior lecturer", 6000));
        tutor.put("10CPS15678", new TutorManagement("10CPS15678", "aishah wong", "female", "aishah@gmail.com", "011-88923212", "computer science", "professor", 7250));
        tutor.put("89CPS67890", new TutorManagement("89CPS67890", "olivia miller", "female", "olivia@gmail.com", "017-2345678", "computer science", "part-time", 2900));
        tutor.put("42CPS56789", new TutorManagement("42CPS56789", "daniel lee", "male", "daniel@gmail.com", "014-8765432", "computer science", "senior lecturer", 6800));
        tutor.put("63CPS09876", new TutorManagement("63CPS09876", "sophia taylor", "female", "sophia@gmail.com", "018-7654321", "computer science", "senior lecturer", 6700));
        tutor.put("21CPS23456", new TutorManagement("21CPS23456", "william clark", "male", "william@gmail.com", "015-3216547", "computer science", "part-time", 1700));
        tutor.put("85CPS65432", new TutorManagement("85CPS65432", "emma anderson", "female", "emma@gmail.com", "019-6543210", "computer science", "lecturer", 3100));
  

        LinkedHashMapInterface<String, Course> courseManagement = new LinkedHashMap<>();
        LinkedHashMapInterface<Course, ListInterface<Programme>> courseProgramme = new LinkedHashMap<>();
        ListInterface<Programme> programme1=new ArrayList<>();
        ListInterface<Programme> programme2=new ArrayList<>();
        ListInterface<Programme> programme3=new ArrayList<>();
       
       
        Course c1 = new Course("BACS1013", "PROBLEM SOLVING AND PROGRAMMING", 3, 125,125.00);
        Course c2 = new Course("BAIT1043", "SYSTEMS ANALYSIS AND DESIGN", 3, 75,100.00);
        Course c6 = new Course("MPU3103", "PENGHAYATAN ETIKA DAN PERADABAN", 3, 60,75.00);

        programme1.add(new Programme("RSW", "Software Engineering", 3, 3));
        programme2.add(new Programme("RSD", "Software Systems Development", 3, 3));
        programme2.add(new Programme("RDS", "Data Science", 3, 3));
        programme3.add(new Programme("RIS", "Information Security", 3, 3));
        programme3.add(new Programme("RMM", "Marketing", 3, 3));
        programme3.add(new Programme("RIT", "Internet Technology", 3, 3));
        courseManagement.put("BACS1013", c1);
        courseManagement.put("BAIT1043", c2);
        courseManagement.put("BACS2063", new Course("BACS2063", "DATA STRUCTURES AND ALGORITHMS", 3, 10,75.00));
        courseManagement.put("BAIT2203", new Course("BAIT2203", "HUMAN COMPUTER INTERACTION", 3, 30,125.00));
        courseManagement.put("MPU3133", new Course("MPU3133", "FALSAFAH DAN ISU SEMASA", 3, 40,50.00));
        courseManagement.put("MPU3103",c6);
        courseProgramme.put(c2,programme1);
        courseProgramme.put(c1,programme2);
        courseProgramme.put(c6,programme3);
        

        menu(tutor,courseManagement, courseProgramme);
     
    }

    
    private static void menu(LinkedHashMapInterface<String, TutorManagement> tutor,LinkedHashMapInterface<String, Course> courseManagement, LinkedHashMapInterface<Course, ListInterface<Programme>> courseProgramme){
        
         Scanner scanner = new Scanner(System.in);
        boolean checkInteger;
        
        System.out.println("\n╔══════════════╗");
        System.out.println("║   Universiti Sains Malay  ║");
        System.out.println("╠══════════════╣");
        System.out.println("║   1. Tutor Management             ║");
        System.out.println("║   2. Course Management          ║");           //search tutorMenu inside got find/display all/filter
        System.out.println("║   0. Exit                  ║");
        System.out.println("╚══════════════╝\n");

        System.out.printf("Please Enter Your Choice(0-2): ");
        int choice = 0;

        do {
            try {
                checkInteger = true;
                choice = scanner.nextInt();
            } catch (InputMismatchException ex) {
                checkInteger = false;
                scanner.next();
            }
            if (!checkInteger || choice < 0 || choice > 5) {
                System.out.printf("Please re-input a valid choice (0-5): ");
            }
        } while (!checkInteger || choice < 0 || choice > 5);
        
        switch (choice) {
            case 1:
                tutorMenu(tutor,courseManagement, courseProgramme);
                break;
            case 2:
               courseMenu(tutor,courseManagement,courseProgramme);
                break;
            case 0:
                return;
            default:
                System.out.printf("Please re-input a valid choice(0-5): ");
                break;
        
                
    }
        
    }
    //Janice
     private static void tutorMenu(LinkedHashMapInterface<String, TutorManagement> tutor,LinkedHashMapInterface<String, Course> courseManagement, LinkedHashMapInterface<Course, ListInterface<Programme>> courseProgramme) {
        Scanner scanner = new Scanner(System.in);
        boolean checkInteger;
        
        System.out.println("\n╔══════════════╗");
        System.out.println("║   Tutor Management System  ║");
        System.out.println("╠══════════════╣");
        System.out.println("║   1. Add Tutor             ║");
        System.out.println("║   2. Remove Tutor          ║");           //search tutorMenu inside got find/display all/filter
        System.out.println("║   3. Search Menu           ║");       //find nia by character when write tutor ID not yet finish will appear relevant
        System.out.println("║   4. Amend Tutor Details   ║");
        System.out.println("║   5. Generate Report       ║");
        System.out.println("║   0. Exit                  ║");
        System.out.println("╚══════════════╝\n");

        System.out.printf("Please Enter Your Choice(0-5): ");
        int choice = 0;

        do {
            try {
                checkInteger = true;
                choice = scanner.nextInt();
            } catch (Exception ex) {
                checkInteger = false;
                scanner.next();
            }
            if (!checkInteger || choice < 0 || choice > 5) {
                System.out.printf("Please re-input a valid choice (0-5): ");
            }
        } while (!checkInteger || choice < 0 || choice > 5);
        
        switch (choice) {
            case 1:
                addTutor(tutor,courseManagement, courseProgramme);
                break;
            case 2:
                removeTutor(tutor,courseManagement, courseProgramme);
                break;
            case 3:
                searchMenu(tutor,courseManagement, courseProgramme);
                break;
            case 4:
                amendTutor(tutor,courseManagement, courseProgramme);
                break;
            case 5:
                reportMenu(tutor,courseManagement, courseProgramme);
                break;
            case 0:
                menu(tutor,courseManagement, courseProgramme);
                return;
            default:
                System.out.printf("Please re-input a valid choice(0-5): ");
                break;
        }
    }

    //choice 1: add tutor
    private static void addTutor(LinkedHashMapInterface<String, TutorManagement> tutor,LinkedHashMapInterface<String, Course> courseManagement, LinkedHashMapInterface<Course, ListInterface<Programme>> courseProgramme) {
        Scanner scanner = new Scanner(System.in);
        String confirmation = "";
        String tutorID;
        String name;
        String email;
        String phoneNo;
        String department;
        String continueChoice = "";
        int choice = 0;
        boolean checkInteger;
        String gender;
        String status;
        double salary;
        
        System.out.println("\n    Add Tutor Menu");
        System.out.printf("══════════════");

        do {
            
            System.out.printf("\nPlease Enter Tutor ID: ");
            do{ 
                choice = 3;                     //random num that refresh
                tutorID = validateTutorID();
                if (tutor.containsKey(tutorID)) {
                    System.out.println("\n════════════════════");
                    System.out.println("The Specific Tutor ID already existed");
                    System.out.println("════════════════════");
                    tutorInformationReview(tutorID, tutor.get(tutorID).getName(), tutor.get(tutorID).getGender(), tutor.get(tutorID).getEmail(), tutor.get(tutorID).getPhoneNumber(), tutor.get(tutorID).getDepartment(), tutor.get(tutorID).getStatus(), tutor.get(tutorID).getSalary());

                    System.out.printf("\nDo you wish to amend on the current tutorID or proceed with another tutorID? ");
                    System.out.println("\n╔═════════════════╗");
                    System.out.println("║                                  ║");
                    System.out.println("║   1. Amend tutor information     ║");
                    System.out.println("║   2. Proceed with other tutorID  ║");
                    System.out.println("║   0. Back to Menu                ║");
                    System.out.println("║                                  ║");
                    System.out.println("╚═════════════════╝");
                    System.out.printf("Please enter your choice: ");
                    do {
                        try {
                            checkInteger = true;
                            choice = scanner.nextInt();
                        } catch (Exception ex) {
                            checkInteger = false;
                            scanner.next();
                        }
                        if (!checkInteger || choice < 0 || choice > 2) {
                            System.out.printf("Please re-input a valid choice (0-2): ");
                        }
                    } while (!checkInteger || choice < 0 || choice > 2);

                    switch (choice) {
                        case 0:
                            tutorMenu(tutor,courseManagement, courseProgramme);
                            break;
                        case 1:
                            System.out.printf("\n");
                            break;
                        case 2:
                            System.out.printf("\nPlease re-enter another tutorID: ");
                            break;
                        default:
                            System.out.printf("Please re-input a valid choice (0-2): ");
                            break;
                    }
                }
            }while(choice == 2);

            name = validateTutorName();
            gender = validateTutorGender();
            email = validateTutorEmail();
            phoneNo = validateTutorPhoneNo();
            department = validateTutorDepartment(tutorID);
            status = validateTutorStatus();
            salary = validateTutorSalary(status);
            
            System.out.println("\n═════════════════");
            System.out.println("     Tutor Information Review");
            System.out.println("═════════════════");
            tutorInformationReview(tutorID, name, gender, email, phoneNo, department, status, salary);
            
            System.out.printf("Confirm add tutor(yes/no)? ");
            confirmation = validateContinueOperation();

            if (confirmation.equalsIgnoreCase("NO")) {
                tutorMenu(tutor,courseManagement, courseProgramme);
            } else if (confirmation.equalsIgnoreCase("YES")) {
                tutor.put(tutorID, new TutorManagement(tutorID, name, gender, email, phoneNo, department, status, salary));
            }
            

            if (tutor.containsKey(tutorID)) {
                if (choice == 1) {
                    System.out.println("\n═════════════");
                    System.out.println("Tutor Amended Successfully!!");
                    System.out.println("═════════════");
                } else{
                    System.out.println("\n═════════════");
                    System.out.println("Tutor Added Successfully!!");
                    System.out.println("═════════════");
                }
                tutorInformationReview(tutorID, tutor.get(tutorID).getName(), tutor.get(tutorID).getGender(), tutor.get(tutorID).getEmail(), tutor.get(tutorID).getPhoneNumber(), tutor.get(tutorID).getDepartment(), tutor.get(tutorID).getStatus(), tutor.get(tutorID).getSalary());
            } else if (!tutor.containsKey(tutorID)) {
                System.out.println("\n══════");
                System.out.println("System Error");
                System.out.println("══════");
                tutorMenu(tutor,courseManagement, courseProgramme);
            }

            System.out.printf("\nDo you wish to Continue? ");
            continueChoice = validateContinueOperation();
            
        } while (continueChoice.equalsIgnoreCase("YES"));
        tutorMenu(tutor,courseManagement, courseProgramme);
    }
    
    //choice 2: remove tutor
    private static void removeTutor(LinkedHashMapInterface<String, TutorManagement> tutor,LinkedHashMapInterface<String, Course> courseManagement, LinkedHashMapInterface<Course, ListInterface<Programme>> courseProgramme) {
        String tutorID;
        String continueChoice;
        String confirmDeleteRecord;

        System.out.println("\n    Remove Tutor Menu");
        System.out.println("════════════");

        do {
            System.out.printf("Please Enter Tutor ID: ");
            tutorID = validateTutorID();

            if (tutor.containsKey(tutorID)) {
                System.out.println("\n══════════════");
                System.out.println("       Tutor ID Found");
                System.out.println("══════════════");
                tutorInformationReview(tutorID, tutor.get(tutorID).getName(), tutor.get(tutorID).getGender(), tutor.get(tutorID).getEmail(), tutor.get(tutorID).getPhoneNumber(), tutor.get(tutorID).getDepartment(), tutor.get(tutorID).getStatus(), tutor.get(tutorID).getSalary());
                System.out.printf("\nDo you wish to Delete the Tutor Record? ");

                confirmDeleteRecord = validateContinueOperation();

                if (confirmDeleteRecord.equalsIgnoreCase("YES")) {
                    tutor.remove(tutorID);
                    if (!tutor.containsKey(tutorID)) {
                        System.out.println("\n════════════════════════");
                        System.out.println("       Tutor Record Deleted Successfully");
                        System.out.println("════════════════════════");
                        System.out.printf("\nDo you wish to Continue Delete other Tutor Record ? ");
                    } else if (tutor.containsKey(tutorID)) {
                        System.out.println("\n═══════════════════");
                        System.out.println("       Deletion unsuccessfully");
                        System.out.println("═══════════════════");
                        tutorMenu(tutor,courseManagement, courseProgramme);
                    }
                } else if (confirmDeleteRecord.equalsIgnoreCase("NO")) {
                    System.out.printf("\nDo you wish to Delete other Tutor Record ? ");
                }
            } else if (!tutor.containsKey(tutorID)) {
                System.out.println("\n══════════════");
                System.out.println("     Tutor ID Not Found");
                System.out.println("══════════════");
                System.out.printf("Do you wish to re-enter another Tutor ID? ");
            }

            continueChoice = validateContinueOperation();

        } while (continueChoice.equalsIgnoreCase("YES"));
        tutorMenu(tutor,courseManagement, courseProgramme);
    }
    
    //choice 3: search Menu
    private static void searchMenu(LinkedHashMapInterface<String, TutorManagement> tutor,LinkedHashMapInterface<String, Course> courseManagement, LinkedHashMapInterface<Course, ListInterface<Programme>> courseProgramme){
        boolean checkInteger;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n╔════════════════════════╗");
        System.out.println("║                   Search Menu                  ║");
        System.out.println("╠════════════════════════╣");
        System.out.println("║   1. Find Specific Tutor Information           ║");
        System.out.println("║   2. Display Tutor Information based on Filter ║");    //filter start by name first alpha / department / gender / branch
        System.out.println("║   3. Display all Tutor Information             ║");       //find nia by character when write tutor ID not yet finish will appear relevant
        System.out.println("║   0. Back to Menu                              ║");
        System.out.println("╚════════════════════════╝\n");
        
        System.out.printf("Please Enter Your Choice(0-3): ");
        int choice = 0;

        do {
            try {
                checkInteger = true;
                choice = scanner.nextInt();
            } catch (Exception ex) {
                checkInteger = false;
                scanner.next();
            }
            if (!checkInteger || choice < 0 || choice > 3) {
                System.out.printf("Please re-input a valid choice (0-3): ");
            }
        } while (!checkInteger || choice < 0 || choice > 3);

        switch (choice) {
            case 1:
                findTutor(tutor,courseManagement, courseProgramme);
                break;
            case 2:
                filterTutor(tutor,courseManagement, courseProgramme);
                break;
            case 3:
                displayAllTutor(tutor,courseManagement, courseProgramme);
                break;
            case 0:
                tutorMenu(tutor,courseManagement, courseProgramme);
            default:
                System.out.printf("Please re-input a valid choice(0-3): ");
                break;
        }
        
    }

    //choice 3.1:Find Specific Tutor
    private static void findTutor(LinkedHashMapInterface<String, TutorManagement> tutor,LinkedHashMapInterface<String, Course> courseManagement, LinkedHashMapInterface<Course, ListInterface<Programme>> courseProgramme) {
        String tutorID;
        String continueChoice;

        System.out.println("\n    Find Tutor Menu");
        System.out.println("════════════");

        do {
            System.out.printf("Please Enter Tutor ID: ");
            tutorID = validateTutorID();

            if (tutor.containsKey(tutorID)) {
                System.out.println("\n══════════════");
                System.out.println("       Tutor ID Found");
                System.out.println("══════════════");
                tutorInformationReview(tutorID, tutor.get(tutorID).getName(), tutor.get(tutorID).getGender(), tutor.get(tutorID).getEmail(), tutor.get(tutorID).getPhoneNumber(), tutor.get(tutorID).getDepartment(), tutor.get(tutorID).getStatus(), tutor.get(tutorID).getSalary());
                System.out.printf("\nDo you wish to Continue Searching ? ");

            } else if (!tutor.containsKey(tutorID)) {
                System.out.println("\n══════════════");
                System.out.println("     Tutor ID Not Found");
                System.out.println("══════════════");
                System.out.printf("Do you wish to re-enter another Tutor ID? ");
            }

            continueChoice = validateContinueOperation();

        } while (continueChoice.equalsIgnoreCase("YES"));
        searchMenu(tutor,courseManagement, courseProgramme);
    }
    
    //choice 3.2:Display based on filter
    private static void filterTutor(LinkedHashMapInterface<String, TutorManagement> tutor,LinkedHashMapInterface<String, Course> courseManagement, LinkedHashMapInterface<Course, ListInterface<Programme>> courseProgramme) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        boolean checkInteger;
        String gender = "";
        String status = "";
        double minSalary = 0;
        double maxSalary = 0;
        String department = "";
        int count = 0;
        String comfirmation = "";
        boolean checkDouble;

        do {
            System.out.println("\n   Filter Tutor based on Criteria Menu   ");
            System.out.println("══════════════════════");
            System.out.println("╔════════════╗");
            System.out.println("║   1. Department        ║");           //if got time only add filter name start by a etc
            System.out.println("║   2. Gender            ║");
            System.out.println("║   3. Status            ║");
            System.out.println("║   4. Salary Range      ║");
            System.out.println("║   0. Back to tutorMenu      ║");
            System.out.println("╚════════════╝");

            System.out.printf("Please enter the criteria to filter: ");

            do {
                try {
                    checkInteger = true;
                    choice = scanner.nextInt();
                } catch (Exception ex) {
                    checkInteger = false;
                    scanner.next();
                }
                if (!checkInteger || choice < 0 || choice > 4) {
                    System.out.printf("Please re-input a valid choice (0-4): ");
                }
            } while (!checkInteger || choice < 0 || choice > 4);

            switch (choice) {
                case 0:
                    searchMenu(tutor,courseManagement, courseProgramme);
                    break;
                case 1:
                    //cannot call validate class bcs that method contain if else comparison of tutorID need pass in tutorID
                    do {
                        department = scanner.nextLine().toLowerCase();

                        if (department.isEmpty()) {
                            System.out.printf("Please Enter Tutor Department: ");
                        } else if (!department.equalsIgnoreCase("accounting") && !department.equalsIgnoreCase("computer science")) {
                            System.out.printf("Please choose within Accounting and Computer Science: ");
                        }
                    } while (department.isEmpty() || (!department.equalsIgnoreCase("accounting") && !department.equalsIgnoreCase("computer science")));

                    System.out.println("\n   Tutor Information Filter By Department Menu");
                    System.out.println("═══════════════════════════");
                    break;
                case 2:
                    gender = validateTutorGender();

                    System.out.println("\n   Tutor Information Filter By Gender Menu");
                    System.out.println("═════════════════════════");
                    break;
                case 3:
                    status = validateTutorStatus();

                    System.out.println("\n   Tutor Information Filter By Status Menu");
                    System.out.println("═════════════════════════");
                    break;
                case 4:
                    do {
                        try {
                            System.out.printf("Please Enter Minimum Salary: ");
                            checkDouble = true;
                            minSalary = scanner.nextDouble();
                            System.out.printf("Please Enter Maximum Salary: ");
                            maxSalary = scanner.nextDouble();
                        } catch (Exception ex) {
                            checkDouble = false;
                            scanner.next();
                        }

                        if (minSalary == 0.0 && maxSalary == 0.0) {
                            System.out.println("\nPlease Enter Minimum and Maximum Salary");
                            System.out.println("═══════════════════");
                        } else if (minSalary >= maxSalary) {
                            System.out.println("\nPlease Enter Maximum Salary that is higher than Minimum Salary");
                            System.out.println("═══════════════════════════════");
                        } else if (checkDouble == false) {
                            System.out.println("\nPlease Enter only Integer or Double");
                            System.out.println("══════════════════");
                        }
                    } while (minSalary == 0.0 && maxSalary == 0.0 || minSalary >= maxSalary || checkDouble == false);

                    System.out.println("\n   Tutor Information Filter By Salary Range Menu");
                    System.out.println("═══════════════════════════");
                    break;
                default:
                    System.out.printf("Please re-input a valid choice (0-4): ");
                    break;
            }

            count = 0;
            tutorInformationMenuHeader();       //display the table header

            ListInterface<String> tutorIDList = tutor.getAllKeys();

            for (int i = 0; i < tutorIDList.size(); i++) {
                String tutorID = tutorIDList.get(i); // Retrieve each key as a String
                if (choice == 1 && tutor.get(tutorID).getDepartment().equalsIgnoreCase(department)) {
                    System.out.println(tutor.get(tutorID));
                    count++;
                } else if (choice == 2 && tutor.get(tutorID).getGender().equalsIgnoreCase(gender)) {
                    System.out.println(tutor.get(tutorID));
                    count++;
                } else if (choice == 3 && tutor.get(tutorID).getStatus().equalsIgnoreCase(status)) {
                    System.out.println(tutor.get(tutorID));
                    count++;
                } else if (choice == 4 && tutor.get(tutorID).getSalary() >= minSalary && tutor.get(tutorID).getSalary() <= maxSalary) {
                    System.out.println(tutor.get(tutorID));
                    count++;
                }
            }

            System.out.println("╠═══════════════════════════════════════════════════════════════════════════╣");
            System.out.printf("║                                                                                                                          Total Tutor Records: %-5d  ║\n", count);
            System.out.println("╚═══════════════════════════════════════════════════════════════════════════╝");

            System.out.printf("Do you wish to Continue Filter Tutor Information? ");
            comfirmation = validateContinueOperation();

            if (comfirmation.equalsIgnoreCase("NO")) {
                searchMenu(tutor,courseManagement, courseProgramme);
            }
        } while (comfirmation.equalsIgnoreCase("YES"));
    }
    
    
    //choice 3.3:Display all Tutor Information
    private static void tutorInformationMenuHeader(){
        System.out.println("╔═══════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                                                                  Tutor Information                                                                   ║");
        System.out.println("╠═══════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ Tutor ID   │      Name            │ Gender │          Email             │  Phone Number  │     Department     │     Status       │ Salary     ║");
        System.out.println("╟──────┼───────────┼────┼──────────────┼────────┼──────────┼─────────┼──────╢");
    }
    
    private static void displayAllTutor(LinkedHashMapInterface<String, TutorManagement> tutor,LinkedHashMapInterface<String, Course> courseManagement, LinkedHashMapInterface<Course, ListInterface<Programme>> courseProgramme){
        String confirmation;
        
        System.out.println("\n   Display all Tutor Information Menu");
        System.out.println("═════════════════════");
        tutorInformationMenuHeader();
        tutor.displayValues();
        System.out.println("╠═══════════════════════════════════════════════════════════════════════════╣");
        System.out.printf("║                                                                                                                          Total Tutor Records: %-5d  ║\n", tutor.size());
        System.out.println("╚═══════════════════════════════════════════════════════════════════════════╝");
        
        System.out.printf("Do you wish to go back to the tutorMenu? ");
        confirmation = validateContinueOperation();
        
        if(confirmation.equalsIgnoreCase("YES")){
            searchMenu(tutor,courseManagement, courseProgramme);
        }else if(confirmation.equalsIgnoreCase("NO")){
            System.exit(0);
        }
    }


    //choice 4: ammend Tutor
    private static void amendTutor(LinkedHashMapInterface<String, TutorManagement> tutor,LinkedHashMapInterface<String, Course> courseManagement, LinkedHashMapInterface<Course, ListInterface<Programme>> courseProgramme) {
        Scanner scanner = new Scanner(System.in);
        String tutorID = "";
        String name = "";
        String gender = "";
        String email = "";
        String phoneNo = "";
        String department = "";
        String status = "";
        double salary = 0;
        String proceedInput = "";
        String newTutorID = "";
        String ammendChoice = "";
        String ammendOtherChoice = "";
        String confirmation = "";
        String splitTutorID = "";
        int choice = 0;
        boolean checkInteger;
        String ammendCurrent = "";

        System.out.println("\n      Amend Tutor Menu");
        System.out.println("══════════════");

        do {
            ammendChoice = "";
            ammendOtherChoice = "";
            System.out.printf("Please Enter Tutor ID to Amend: ");

            do {
                tutorID = validateTutorID();

                if (tutor.containsKey(tutorID)) {

                    System.out.println("\n═══════");
                    System.out.println("Tutor ID Found");
                    System.out.println("════════");
                    tutorInformationReview(tutorID, tutor.get(tutorID).getName(), tutor.get(tutorID).getGender(), tutor.get(tutorID).getEmail(), tutor.get(tutorID).getPhoneNumber(), tutor.get(tutorID).getDepartment(), tutor.get(tutorID).getStatus(), tutor.get(tutorID).getSalary());
                    System.out.printf("\nDo you wish to amend this tutor's information? ");
                    ammendChoice = validateContinueOperation();

                    if (ammendChoice.equalsIgnoreCase("NO")) {
                        System.out.printf("Do you wish to ammend other tutor's information? ");
                        ammendOtherChoice = validateContinueOperation();

                        if (ammendOtherChoice.equalsIgnoreCase("NO")) {
                            tutorMenu(tutor,courseManagement, courseProgramme);
                        } else if (ammendOtherChoice.equalsIgnoreCase("YES")) {
                            System.out.printf("\nPlease Enter Tutor ID to Amend: ");
                        }
                    } else if (ammendChoice.equalsIgnoreCase("YES")) {
                        ammendOtherChoice = "";
                    }
                } else if (!tutor.containsKey(tutorID)) {
                    System.out.println("\n════════");
                    System.out.println("Tutor ID Not Found");
                    System.out.println("═════════\n");
                    System.out.printf("Please re-enter Tutor ID: ");
                }
            } while (!tutor.containsKey(tutorID) || ammendOtherChoice.equalsIgnoreCase("YES"));

            do {
                System.out.println("\n╔════════════╗");
                System.out.println("║   1. Tutor ID          ║");
                System.out.println("║   2. Name              ║");
                System.out.println("║   3. Gender            ║");
                System.out.println("║   4. Email             ║");
                System.out.println("║   5. Phone Number      ║");
                System.out.println("║   6. Status            ║");
                System.out.println("║   7. Salary            ║");
                System.out.println("║   8. All information   ║");
                System.out.println("║   0. Back to tutorMenu      ║");
                System.out.println("╚════════════╝");
                System.out.printf("Please enter the information to amend: ");

                do {
                    try {
                        checkInteger = true;
                        choice = scanner.nextInt();
                    } catch (Exception ex) {
                        checkInteger = false;
                        scanner.next();
                    }
                    if (!checkInteger || choice < 0 || choice > 8) {
                        System.out.printf("Please re-input a valid choice (0-8): ");
                    }
                } while (!checkInteger || choice < 0 || choice > 8);

                name = tutor.get(tutorID).getName();
                gender = tutor.get(tutorID).getGender();
                email = tutor.get(tutorID).getEmail();
                phoneNo = tutor.get(tutorID).getPhoneNumber();
                department = tutor.get(tutorID).getDepartment();
                status = tutor.get(tutorID).getStatus();
                salary = tutor.get(tutorID).getSalary();
                
                switch (choice) {
                    case 0:
                        tutorMenu(tutor,courseManagement, courseProgramme);
                        break;
                    case 1:
                        System.out.printf("\nPlease Enter New Tutor ID: ");
                        do {
                            newTutorID = validateTutorID();
                            splitTutorID = splitTutorID(newTutorID);

                            if (tutor.containsKey(newTutorID)) {
                                System.out.println("\n════════════════════");
                                System.out.println("The Specific Tutor ID already existed");
                                System.out.println("════════════════════");
                                tutorInformationReview(newTutorID, tutor.get(newTutorID).getName(), tutor.get(newTutorID).getGender(), tutor.get(newTutorID).getEmail(), tutor.get(newTutorID).getPhoneNumber(), tutor.get(newTutorID).getDepartment(), tutor.get(newTutorID).getStatus(), tutor.get(newTutorID).getSalary());
                                System.out.printf("Please enter another tutorID: ");
                            } else if (!splitTutorID.equalsIgnoreCase(departmentInShort(department))) {
                                System.out.printf("Please Enter Tutor ID that matched with the Department: ");
                            }
                        } while (tutor.containsKey(newTutorID) || !splitTutorID.equalsIgnoreCase(departmentInShort(department)));
                        break;
                    case 2:
                        name = validateTutorName();
                        break;
                    case 3:
                        gender = validateTutorGender();
                        break;
                    case 4:
                        email = validateTutorEmail();
                        break;
                    case 5:
                        phoneNo = validateTutorPhoneNo();
                        break;
                    case 6:
                        status = validateTutorStatus();
                        break;
                    case 7:
                        salary = validateTutorSalary(status);
                        break;
                    case 8:
                        System.out.printf("\nPlease Enter New Tutor ID: ");
                        do {
                            newTutorID = validateTutorID();
                            if (tutor.containsKey(newTutorID)) {
                                System.out.println("\n════════════════════");
                                System.out.println("The Specific Tutor ID already existed");
                                System.out.println("════════════════════");
                                tutorInformationReview(newTutorID, tutor.get(newTutorID).getName(), tutor.get(newTutorID).getGender(), tutor.get(newTutorID).getEmail(), tutor.get(newTutorID).getPhoneNumber(), tutor.get(newTutorID).getDepartment(), tutor.get(newTutorID).getStatus(), tutor.get(newTutorID).getSalary());
                                System.out.printf("Please enter another tutorID: ");
                            }
                        } while (tutor.containsKey(newTutorID));

                        name = validateTutorName();
                        gender = validateTutorGender();
                        email = validateTutorEmail();
                        phoneNo = validateTutorPhoneNo();
                        department = validateTutorDepartment(newTutorID);
                        status = validateTutorStatus();
                        salary = validateTutorSalary(status);
                        break;
                    default:
                        System.out.printf("Please re-input a valid choice (0-8): ");
                        break;
                }

                System.out.println("\n═════════════════");
                System.out.println("     Tutor Information Review");
                System.out.println("═════════════════");
                if (choice == 1 || choice == 8) {
                    tutorInformationReview(newTutorID, name, gender, email, phoneNo, department, status, salary);
                } else if (choice >= 2 && choice <= 7) {
                    tutorInformationReview(tutorID, name, gender, email, phoneNo, department, status, salary);
                }

                System.out.printf("Confirm amend tutor details(yes/no)? ");
                confirmation = validateContinueOperation();

                if (confirmation.equalsIgnoreCase("YES")) {
                    if (choice == 1 || choice == 9) {
                        tutor.remove(tutorID);
                        tutor.put(newTutorID, new TutorManagement(newTutorID, name, gender, email, phoneNo, department, status, salary));
                        tutorID = newTutorID;
                    } else if (choice >= 2 && choice <= 8) {
                        tutor.put(tutorID, new TutorManagement(tutorID, name, gender, email, phoneNo, department, status, salary));
                    }

                    if ((choice == 1 || choice == 9 && tutor.containsKey(newTutorID) && !tutor.containsKey(tutorID)) || (choice >= 2 && choice <= 8 && tutor.containsKey(tutorID))) {
                        System.out.println("\n════════════════════");
                        System.out.println("Tutor Information amend Successfully");
                        System.out.println("════════════════════");

                        if (choice == 1 || choice == 9) {
                            tutorInformationReview(newTutorID, tutor.get(newTutorID).getName(), tutor.get(newTutorID).getGender(), tutor.get(newTutorID).getEmail(), tutor.get(newTutorID).getPhoneNumber(), tutor.get(newTutorID).getDepartment(), tutor.get(newTutorID).getStatus(), tutor.get(newTutorID).getSalary());
                        } else if (choice >= 2 && choice <= 8) {
                            tutorInformationReview(tutorID, tutor.get(tutorID).getName(), tutor.get(tutorID).getGender(), tutor.get(tutorID).getEmail(), tutor.get(tutorID).getPhoneNumber(), tutor.get(tutorID).getDepartment(), tutor.get(tutorID).getStatus(), tutor.get(tutorID).getSalary());
                        }
                        
                        System.out.printf("\nDo you wish to Continue Amend Current Tutor Information ? ");
                        ammendCurrent = validateContinueOperation();
                    } else {
                        System.out.println("\n══════════");
                        System.out.println("Amend Unsuccessful");
                        System.out.println("═════════");
                    }
                }

            } while (ammendCurrent.equalsIgnoreCase("YES"));

            System.out.printf("\nDo you wish to Amend other Tutor Information ? ");
            proceedInput = validateContinueOperation();
        } while (proceedInput.equalsIgnoreCase("YES"));
        tutorMenu(tutor,courseManagement, courseProgramme);
    }

    //choice 5: Report tutorMenu
    private static void reportMenu(LinkedHashMapInterface<String, TutorManagement> tutor,LinkedHashMapInterface<String, Course> courseManagement, LinkedHashMapInterface<Course, ListInterface<Programme>> courseProgramme){
        boolean checkInteger;
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n╔════════════════════════╗");
        System.out.println("║                   Report Menu                  ║");
        System.out.println("╠════════════════════════╣");       //Employee Salary Summary by Status: Minimum and Maximum Compensation Analysis
        System.out.println("║   1. Employee Salary Summary by Status Report  ║");       //each status's min and max summarized and stated the total compensation fees 
        System.out.println("║   2. Department-wise Report                    ║");       
        System.out.println("║   3. Performance Evaluation Report             ║");  
        System.out.println("║   0. Back to Menu                              ║");
        System.out.println("╚════════════════════════╝\n");

        System.out.printf("Please Enter Your Choice(0-3): ");
        int choice = 0;

        do {
            try {
                checkInteger = true;
                choice = scanner.nextInt();
            } catch (Exception ex) {
                checkInteger = false;
                scanner.next();
            }
            if (!checkInteger || choice < 0 || choice > 3) {
                System.out.printf("Please re-input a valid choice (0-3): ");
            }
        } while (!checkInteger || choice < 0 || choice > 3);

        switch (choice) {
            case 1:
                tutorSalarySummaryReport(tutor,courseManagement, courseProgramme);
                break;
            case 2:
                departmentWiseReport(tutor,courseManagement, courseProgramme);
                break;
            case 3:
                performanceEvaluationReport(tutor,courseManagement, courseProgramme);
                break;
            case 0:
                tutorMenu(tutor,courseManagement, courseProgramme);
            default:
                System.out.printf("Please re-input a valid choice(0-3): ");
                break;
        }
    }
    
    
    //choice 5.1: Tutor Salary Summary by Status Report
    private static void tutorSalarySummaryReport(LinkedHashMapInterface<String, TutorManagement> tutor,LinkedHashMapInterface<String, Course> courseManagement, LinkedHashMapInterface<Course, ListInterface<Programme>> courseProgramme){
        LocalDateTime currentDateTime = LocalDateTime.now();
        ZoneId klZone = ZoneId.of("Asia/Kuala_Lumpur");
        ZonedDateTime klTime = currentDateTime.atZone(klZone);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = klTime.format(formatter);
        String tutorID = "";
        double totalCompensationFees = 0;
        String confirmation = "";
        
        System.out.println("\n\n   Tutor Salary Summary by Status Report");
        System.out.println("═════════════════════════");
        
        System.out.println("┌═══════════════════════════════════════════════════════════════════════════════┐");
        System.out.println("│      Status      │                           Minimum Salary                           │                           Maximum Salary                           │");
        System.out.println("│                  │══════════════════════════════════│══════════════════════════════════┤");
        System.out.println("│                  │  TutorID   |         Name         |    Department    |   Salary    │  TutorID   |         Name         |    Department    |   Salary    │");
        System.out.println("├═════════│══════════════════════════════════│══════════════════════════════════┤");
        
        
        ListInterface<String> tutorIDList = tutor.getAllKeys();
        ListInterface<String> statusList = new ArrayList<>();

        // Get all the status and store inside list to for loop by status
        for (int i = 0; i < tutorIDList.size(); i++) {
            tutorID = tutorIDList.get(i);
            TutorManagement currentTutor = tutor.get(tutorID);
            String status = currentTutor.getStatus().toLowerCase();
            totalCompensationFees += currentTutor.getSalary();
            // Add the status to the list if it's not already present
            if (!statusList.contains(status)) {
                statusList.add(status);
            }
        }

        for (int j = 0; j < statusList.size(); j++) {
            String status = statusList.get(j);
            
            // Initialize minSalary and maxSalary with extreme values
            double minSalary = Double.MAX_VALUE;
            double maxSalary = Double.MIN_VALUE;
            String minSalaryTutorID = "";
            String maxSalaryTutorID = "";
            
            for (int i = 0; i < tutorIDList.size(); i++) {
                tutorID = tutorIDList.get(i);
                TutorManagement currentTutor = tutor.get(tutorID);

                if (currentTutor.getStatus().equalsIgnoreCase(status)) {
                    double currentSalary = currentTutor.getSalary();

                    if (currentSalary < minSalary) {
                        minSalary = currentSalary;
                        minSalaryTutorID = tutorID;
                    }

                    if (currentSalary > maxSalary) {
                        maxSalary = currentSalary;
                        maxSalaryTutorID = tutorID;
                    }
                }
            } 

            System.out.printf("│ %-16s │ %10s | %-20s | %-16s | %-10.2f  │ %10s | %-20s | %-16s | %-10.2f  │\n", status, minSalaryTutorID, tutor.get(minSalaryTutorID).getName(), tutor.get(minSalaryTutorID).getDepartment(), minSalary, maxSalaryTutorID, tutor.get(maxSalaryTutorID).getName(), tutor.get(maxSalaryTutorID).getDepartment(), maxSalary);
        }
        
        
        System.out.println("├═══════════════════════════════════════════════════════════════════════════════┤");
        System.out.printf("│                                                                                                                          Total Compensation Fees: %-8.2f   │\n", totalCompensationFees);
        System.out.println("└═══════════════════════════════════════════════════════════════════════════════┘");
        System.out.println("This report is generated at: " + formattedDateTime);
        
        
        System.out.printf("\n\nDo you wish to Go Back to Report Menu? ");
        confirmation = validateContinueOperation();
        
        if(confirmation.equalsIgnoreCase("YES")){
            reportMenu(tutor,courseManagement, courseProgramme);
        }else if (confirmation.equalsIgnoreCase("NO")) {
            System.exit(0);
        }
    }
    
    //choice 5.2: Department-wise report
    private static void departmentWiseReport(LinkedHashMapInterface<String, TutorManagement> tutor,LinkedHashMapInterface<String, Course> courseManagement, LinkedHashMapInterface<Course, ListInterface<Programme>> courseProgramme){
        LocalDateTime currentDateTime = LocalDateTime.now();
        ZoneId klZone = ZoneId.of("Asia/Kuala_Lumpur");
        ZonedDateTime klTime = currentDateTime.atZone(klZone);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = klTime.format(formatter);
        String confirmation = "";
        String tutorID = "";
        int accCount = 0;
        int cpsCount = 0;
        ListInterface<String> tutorIDList = tutor.getAllKeys();

        System.out.println("\n\n   Department-wise Report");
        System.out.println("═════════════════");
        
        //accounting
        System.out.println("┌══════════════════════════════════┐");
        System.out.println("│                             Accounting                             │");
        System.out.println("│══════════════════════════════════┤");
        System.out.println("│   TutorID   |         Name         |      Status      |   Salary   │");
        System.out.println("├══════════════════════════════════┤");
        
        for(int i = 0; i < tutorIDList.size(); i++){
            tutorID = tutorIDList.get(i);     
            if(tutor.get(tutorID).getDepartment().equalsIgnoreCase("accounting")){
                tutor.get(tutorID);
                System.out.printf("│ %-11s | %-20s | %-16s | %-10.2f │\n",tutorID, tutor.get(tutorID).getName(), tutor.get(tutorID).getStatus(), tutor.get(tutorID).getSalary());
                accCount++;
            }        
        }
        System.out.println("├══════════════════════════════════┤");
        System.out.printf("│                                                Total Tutors: %-3d   │\n", accCount);
        System.out.println("└──────────────────────────────────┘");
        
        
        //computer science
        System.out.println("\n┌══════════════════════════════════┐");
        System.out.println("│                          Computer Science                          │");
        System.out.println("│══════════════════════════════════┤");
        System.out.println("│   TutorID   |         Name         |      Status      |   Salary   │");
        System.out.println("├══════════════════════════════════┤");
        
        for(int i = 0; i < tutorIDList.size(); i++){
            tutorID = tutorIDList.get(i);     
            if(tutor.get(tutorID).getDepartment().equalsIgnoreCase("computer science")){
                tutor.get(tutorID);
                System.out.printf("│ %-11s | %-20s | %-16s | %-10.2f │\n",tutorID, tutor.get(tutorID).getName(), tutor.get(tutorID).getStatus(), tutor.get(tutorID).getSalary());
                cpsCount++;
            }        
        }
        System.out.println("├══════════════════════════════════┤");
        System.out.printf("│                                                Total Tutors: %-3d   │\n", cpsCount);
        System.out.println("└──────────────────────────────────┘");
        
        System.out.println("\n   Summary: ");
        System.out.println("═══════");
        if(cpsCount > accCount){
            System.out.println("Computer Science Department is more popular than Accounting Department.");
        }else if(cpsCount < accCount){
            System.out.println("Accounting Department is more popular than Computer Science Department.");
        }else if(cpsCount == accCount){
            System.out.println("Accounting Department and Computer Science Department is equally popular among Tutors.");
        }
        
        System.out.println("\nThis report is generated at: " + formattedDateTime);

        System.out.printf("\n\nDo you wish to Go Back to Report Menu? ");
        confirmation = validateContinueOperation();

        if (confirmation.equalsIgnoreCase("YES")) {
            reportMenu(tutor,courseManagement, courseProgramme);
        } else if (confirmation.equalsIgnoreCase("NO")) {
            System.exit(0);
        }
        
    }
    
    //choice 5.3: Performance Evaluation Report
    private static void performanceEvaluationReport(LinkedHashMapInterface<String, TutorManagement> tutor,LinkedHashMapInterface<String, Course> courseManagement, LinkedHashMapInterface<Course, ListInterface<Programme>> courseProgramme){
        LocalDateTime currentDateTime = LocalDateTime.now();
        ZoneId klZone = ZoneId.of("Asia/Kuala_Lumpur");
        ZonedDateTime klTime = currentDateTime.atZone(klZone);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = klTime.format(formatter);
        String confirmation = "";
        
        System.out.println("\n\n   Tutor Performance Evaluation Report");
        System.out.println("════════════════════════");
        System.out.println("  Tutor With Good Performance");
        System.out.println("-------------------------------");

        System.out.println("\n Part-time Tutor with Good Performance(Salary > 2800): ");
        tutorInformationMenuHeader();
        findBestWorstTutor("part-time", 2800, tutor, "best");
        
        System.out.println("\n Lecturer Tutor with Good Performance(Salary > 4500): ");
        tutorInformationMenuHeader();
        findBestWorstTutor("lecturer", 4500, tutor, "best");
        
        System.out.println("\n Senior Lecturer Tutor with Good Performance(Salary > 6500): ");
        tutorInformationMenuHeader();
        findBestWorstTutor("senior lecturer", 6500, tutor, "best");
        
        System.out.println("\n Professor Tutor with Good Performance(Salary > 9000): ");
        tutorInformationMenuHeader();
        findBestWorstTutor("professor", 9000, tutor, "best");
        
        System.out.println("\n  Tutor With Bad Performance");
        System.out.println("-------------------------------");
        
        System.out.println("\n Part-time Tutor with Bad Performance(Salary < 2000): ");
        tutorInformationMenuHeader();
        findBestWorstTutor("part-time", 2000, tutor, "bad");

        System.out.println("\n Lecturer Tutor with Bad Performance(Salary < 3500): ");
        tutorInformationMenuHeader();
        findBestWorstTutor("lecturer", 3500, tutor, "bad");

        System.out.println("\n Senior Lecturer Tutor with Bad Performance(Salary < 5500): ");
        tutorInformationMenuHeader();
        findBestWorstTutor("senior lecturer", 5500, tutor, "bad");

        System.out.println("\n Professor Tutor with Bad Performance(Salary < 7500): ");
        tutorInformationMenuHeader();
        findBestWorstTutor("professor", 7500, tutor, "bad");
        
        System.out.println("This report is generated at: " + formattedDateTime);
        
        System.out.printf("\n\nDo you wish to Go Back to Report Menu? ");
        confirmation = validateContinueOperation();

        if (confirmation.equalsIgnoreCase("YES")) {
            reportMenu(tutor,courseManagement,courseProgramme);
        } else if (confirmation.equalsIgnoreCase("NO")) {
            System.exit(0);
        }
    }
    
    private static void findBestWorstTutor(String status, double salary, LinkedHashMapInterface<String, TutorManagement> tutor, String part){
        String tutorID = "";
        int count = 0;
        
        ListInterface<String> tutorIDList = tutor.getAllKeys();
        
        for (int i = 0; i < tutorIDList.size(); i++) {
            tutorID = tutorIDList.get(i);
            
            if (part.equalsIgnoreCase("best") && tutor.get(tutorID).getStatus().equalsIgnoreCase(status) && tutor.get(tutorID).getSalary() > salary) {
                System.out.println(tutor.get(tutorID));
                count++;
            } else if (part.equalsIgnoreCase("bad") && tutor.get(tutorID).getStatus().equalsIgnoreCase(status) && tutor.get(tutorID).getSalary() < salary) {
                System.out.println(tutor.get(tutorID));
                count++;
            }
        }

        System.out.println("╠═══════════════════════════════════════════════════════════════════════════╣");
        System.out.printf("║                                                                                                                          Total Tutor Records: %-5d  ║\n", count);
        System.out.println("╚═══════════════════════════════════════════════════════════════════════════╝");

    }
    
    
    //validation
    private static String validateTutorID() {
        Scanner scanner = new Scanner(System.in);
        String tutorID = "";

        do {
            tutorID = scanner.nextLine();
            if (tutorID.isEmpty()) {
                System.out.printf("Please Enter Tutor ID: ");
            } else if (!tutorID.matches("^(\\d{2})(ACC|CPS)(\\d{5})$")) {
                System.out.printf("Please enter Tutor ID in the format(XXACCXXXXX/XXCPSXXXXX): ");
            }
        } while (!tutorID.matches("^(\\d{2})(ACC|CPS)(\\d{5})$") || tutorID.isEmpty());
        return tutorID;
    }

    private static String validateTutorName() {
        Scanner scanner = new Scanner(System.in);
        String name = "";
        
        System.out.printf("Please Enter Tutor Name: ");
        do {
            name = scanner.nextLine().toLowerCase();
            if (name.isEmpty()) {
                System.out.printf("Please Enter Tutor Name: ");
            } else if (!name.matches("^[A-Za-z ]+$")) {
                System.out.printf("Tutor Name cannot contain digits, please enter a valid name: ");
            } else if (name.length() > 30) {
                System.out.printf("Please Enter Valid Name: ");
            }
        } while (name.isEmpty() || !name.matches("^[A-Za-z ]+$") || name.length() > 30);
        return name;
    }
    
    private static String validateTutorGender() {
        Scanner scanner = new Scanner(System.in);
        String gender = "";

        System.out.printf("Please Enter Tutor Gender: ");
        do {
            gender = scanner.nextLine().toLowerCase();
            if (gender.isEmpty()) {
                System.out.printf("Please Enter Tutor Gender: ");
            } else if (!gender.equalsIgnoreCase("MALE") && !gender.equalsIgnoreCase("FEMALE")) {
                System.out.printf("Please Enter only Male or Female: ");
            }
        } while (gender.isEmpty() || !gender.equalsIgnoreCase("MALE") && !gender.equalsIgnoreCase("FEMALE"));

        return gender;
    }

    private static String validateTutorEmail() {
        Scanner scanner = new Scanner(System.in);
        String email = "";
        
        System.out.printf("Please Enter Tutor Email Address: ");
        do {
            email = scanner.nextLine();
            if (email.isEmpty()) {
                System.out.printf("Please Enter Tutor Email Address: ");
            } else if (!email.matches("^[A-Za-z0-9._%+-]+@gmail\\.com$")) {
                System.out.printf("Please Enter Valid Email Address in the format (XXX@gmail.com): ");
            } else if (email.length() > 30) {
                System.out.printf("Please Enter Valid Email Address: ");
            }
        } while (email.isEmpty() || !email.matches("^[A-Za-z0-9._%+-]+@gmail\\.com$") || email.length() > 30);
        
        return email;
    }

    private static String validateTutorPhoneNo() {
        Scanner scanner = new Scanner(System.in);
        String phoneNo = "";
        
        System.out.printf("Please Enter Tutor Phone Number: ");
        do {
            phoneNo = scanner.nextLine();
            if (phoneNo.isEmpty()) {
                System.out.printf("Please Enter Tutor Phone Number: ");
            } else if (phoneNo.length() < 11) {
                System.out.printf("Please Enter Valid Phone Number in the format(01X-XXXXXXXX): ");
            } else if (!phoneNo.matches("^01[0-9]-\\d{8}$")) {
                System.out.printf("Please Enter Valid Phone Number in the format(01X-XXXXXXXX): ");
            }
        } while (phoneNo.isEmpty() || phoneNo.length() < 11 && !phoneNo.matches("^01[0-9]-\\d{8}$"));
        
        return phoneNo;
    }

    private static String validateTutorDepartment(String tutorID) {
        Scanner scanner = new Scanner(System.in);
        String department = "";
        String splitTutorID = splitTutorID(tutorID);
       
        System.out.printf("Please Enter Tutor Department: ");
        do {
            department = scanner.nextLine().toLowerCase();
            
            if (department.isEmpty()) {
                System.out.printf("Please Enter Tutor Department: ");
            } else if (!department.equalsIgnoreCase("accounting") && !department.equalsIgnoreCase("computer science")) {
                System.out.printf("Please choose within Accounting and Computer Science: ");
            } else if (!splitTutorID.equalsIgnoreCase(departmentInShort(department))) {        //check whether ID matched department eg CPS = Computer Science
                System.out.println("\n════════════════════════");
                System.out.println("Department does not match tutor ID's department.");
                System.out.println("════════════════════════");
                System.out.printf("Please re-enter department that matched the TutorID: ");
            }
        } while (department.isEmpty() || (!department.equalsIgnoreCase("accounting") && !department.equalsIgnoreCase("computer science")) || !splitTutorID.equalsIgnoreCase(departmentInShort(department)));
        return department;
    }

    //break down tutorID into pieces only maintain the alphabet in middle
    private static String splitTutorID(String tutorID) {
        String alphabetString = "";
        for (int i = 0; i < tutorID.length(); i++) {
            char ch = tutorID.charAt(i);
            if (Character.isLetter(ch)) {
                alphabetString += ch;
            }
        }
        return alphabetString;
    }

    //convert user input department to short form for comparison purpose
    private static String departmentInShort(String department) {
        switch (department) {
            case "accounting":
                return "acc";
            case "computer science":
                return "cps";
            default:
                return "";
        }
    }
    
    
    private static String validateTutorStatus() {
        Scanner scanner = new Scanner(System.in);
        String status = "";
        
        System.out.printf("Please Enter Tutor Status: ");
        do {
            status = scanner.nextLine().toLowerCase();
            if (status.isEmpty()) {
                System.out.printf("Please Enter Tutor Status: ");
            } else if (!status.equalsIgnoreCase("part-time") && !status.equalsIgnoreCase("lecturer") && !status.equalsIgnoreCase("senior lecturer") && !status.equalsIgnoreCase("professor")) {
                System.out.printf("Please choose within Part-Time, Lecturer, Senior Lecturer and Professor: ");
            }
        } while (status.isEmpty() || !status.equalsIgnoreCase("part-time") && !status.equalsIgnoreCase("lecturer") && !status.equalsIgnoreCase("senior lecturer") && !status.equalsIgnoreCase("professor"));
        return status;
    }
    
    private static double validateTutorSalary(String status) {
        Scanner scanner = new Scanner(System.in);
        double salary = 0;
        boolean checkDouble;

        System.out.printf("Please Enter Tutor Salary: ");
        do {
            try {
                checkDouble = true;
                salary = scanner.nextDouble();
            } catch (Exception ex) {
                checkDouble = false;
                scanner.next();
            }

            if (salary == 0.0) {
                System.out.printf("Please Enter Tutor Salary: ");
            } else if (checkDouble == false) {
                System.out.printf("Please Enter only Integer or Double: ");
            } else if (status.equalsIgnoreCase("part-time") && salary < 1500){
                System.out.printf("The Minimum Salary for Part-Time are 1500. Please re-enter the Salary: ");
            }else if (status.equalsIgnoreCase("lecturer") && salary < 3000){
                System.out.printf("The Minimum Salary for Lecturer are 3000. Please re-enter the Salary: ");
            }else if (status.equalsIgnoreCase("senior lecturer") && salary < 5000){
                System.out.printf("The Minimum Salary for Lecturer are 5000. Please re-enter the Salary: ");
            }else if (status.equalsIgnoreCase("professor") && salary < 7000){
                System.out.printf("The Minimum Salary for Lecturer are 7000. Please re-enter the Salary: ");
            }
        } while (salary == 0.0 || checkDouble == false || status.equalsIgnoreCase("part-time") && salary < 1500 || status.equalsIgnoreCase("lecturer") && salary < 3000 || status.equalsIgnoreCase("senior lecturer") && salary < 5000 || status.equalsIgnoreCase("professor") && salary < 7000);

        return salary;
    }
    
    
    private static String validateContinueOperation() {
        Scanner scanner = new Scanner(System.in);
        String proceedInput = "";
        do {
            proceedInput = scanner.nextLine();
            if (!proceedInput.equalsIgnoreCase("YES") && !proceedInput.equalsIgnoreCase("NO")) {
                System.out.printf("Please enter only yes or no > ");
            }
        } while (!proceedInput.equalsIgnoreCase("YES") && !proceedInput.equalsIgnoreCase("NO"));
        
        return proceedInput;
    }

    //display all tutor Information
    private static void tutorInformationReview(String tutorID, String name, String gender, String email, String phoneNo, String department, String status, double salary) {
        System.out.println("Tutor ID: " + tutorID);
        System.out.println("Tutor Name: " + name);
        System.out.println("Tutor Gender: " + gender);
        System.out.println("Tutor Email: " + email);
        System.out.println("Tutor PhoneNo: " + phoneNo);
        System.out.println("Tutor Department: " + department);
        System.out.println("Tutor Status: " + status);
        System.out.printf("Tutor Salary: %.2f \n", salary);
    }
    
    //Janice
    
    //Jeffer
    
    
    
     private static void courseMenu(LinkedHashMapInterface<String, TutorManagement> tutor,LinkedHashMapInterface<String, Course> courseManagement, LinkedHashMapInterface<Course, ListInterface<Programme>> courseProgramme) {

        Scanner scanner = new Scanner(System.in);

        int choice = -1;

        do {
           System.out.println("+---------------------------------------+");
System.out.println("|            Course Management System   |");
System.out.println("+---------------------------------------+");
System.out.println("|   1. Add Course                       |");
System.out.println("|   2. Remove Course                    |");
System.out.println("|   3. Find Course                      |");
System.out.println("|   4. Amend Course Details             |");
System.out.println("|   5. Show all Course                  |");
System.out.println("|   6. Add Programme                    |");
System.out.println("|   7. Remove Programme                 |");
System.out.println("|   8. Reports                          |");
System.out.println("|   0. Exit                             |");
System.out.println("+---------------------------------------+");
System.out.printf("Please Enter Your Choice (0-8): ");
            try {
                
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        addCourse(tutor,courseManagement, courseProgramme);
                        break;
                    case 2:
                        removeCourse(tutor,courseManagement, courseProgramme);
                        break;
                    case 3:
                        findCourse(tutor,courseManagement, courseProgramme);
                        break;
                    case 4:
                        amendCourse(tutor,courseManagement, courseProgramme);
                        break;
                    case 5:
                        listAllCourse(tutor,courseManagement, courseProgramme);
                        break;
                    case 6:
                        addProgramme_Course(tutor,courseManagement, courseProgramme);
                        break;
                    case 7:
                        removeProgramme_Course(tutor,courseManagement, courseProgramme);
                        break;
                    case 8:
                        reportsMenu(tutor,courseManagement,courseProgramme);
                    case 0:
                        menu(tutor,courseManagement, courseProgramme);
                    default:
                        System.out.print("Please re-input a valid choice(0-8) ");
                        break;
                }

            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Please Enter number Only");

            }
        } while (choice != 0);

    }

    private static void reportsMenu(LinkedHashMapInterface<String, TutorManagement> tutor,LinkedHashMapInterface<String, Course> courseManagement, LinkedHashMapInterface<Course, ListInterface<Programme>> courseProgramme) {
        Scanner scanner=new Scanner(System.in);
        
        int choice=-1;
   

    
do{
      
         
          
        System.out.println("+----------------------+");
System.out.println("|     Report Menu      |");
System.out.println("+----------------------+");
System.out.println("|  1. Fee Report       |");
System.out.println("|  2. Programme Report |");
System.out.println("|  3. Top 5 capacity   |");
System.out.println("|  0. Exit             |");
System.out.println("+----------------------+\n");
System.out.printf("Please Enter Your Choice (0-3): ");
    


    try { 
    
        
        choice = scanner.nextInt();

        switch (choice) {
            case 1:
                generateFeeReport(courseManagement);
                break;
            case 2:
                generateProgrammeAffiliated(courseProgramme);
                break;
            case 3:
                top5CourseLimit(courseManagement);
                break;
            case 0:
                 courseMenu(tutor,courseManagement, courseProgramme);
                 break;
            default:
                System.out.println("Invalid choice. Please enter a number between 0 and 3.");
        }
    } catch (InputMismatchException e) {
        System.out.println("Invalid input. Please enter a valid number.");
    }
       }while(choice != 0); 
        courseMenu(tutor,courseManagement,courseProgramme);

    }

    private static void generateFeeReport(LinkedHashMapInterface<String, Course> courseManagement){
        
        
        
        if(courseManagement.isEmpty()){
            System.out.println("There are no Course Found");
            return;
        }
        
       double totalCourseFees=0.0;
        ListInterface<String> courseKey=courseManagement.getAllKeys();
        Date currentDate = new Date();
        double averageCourseFee=0.0;
        double totalPossibleEarning=0.0;
        int numberOfCapacityPerCourse=0;
        
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
System.out.println();
System.out.println("+--------------------------------------------------------------------------------+");

System.out.println("Course Fee Summary Report");
System.out.println("Report Date/Time: " + dateFormat.format(currentDate));
System.out.println("+--------------------------------------------------------------------------------+");

 System.out.printf("║ %-7s │ %-40s │ %-7s │ %-7s ║%n", "CourseID", "Course Name", "Credit Hr", "Course Fee");
 System.out.println("+--------------------------------------------------------------------------------+");

for (int i = 0; i < courseKey.size(); i++) {
    Course course = courseManagement.get(courseKey.get(i));
    
     
    System.out.println("+--------------------------------------------------------------------------------+");
    System.out.printf("║ %-7s │ %-40s │ %-7d │ $%.2f     ║%n", course.getCourseID(), course.getCourseName(), course.getCreditHour(), course.calculateCourseFee());
    System.out.println("+--------------------------------------------------------------------------------+");

    
    numberOfCapacityPerCourse+=course.getCourseLimit();
    totalCourseFees += course.calculateCourseFee();
}
averageCourseFee=totalCourseFees/courseManagement.size();
totalPossibleEarning=totalCourseFees*numberOfCapacityPerCourse;

  System.out.println("+--------------------------------------------------------------------------------+");
System.out.printf("Total Course Fees: $%.2f%n", totalCourseFees);
System.out.printf("Average Course Fees: $%.2f%n", averageCourseFee);
System.out.printf("Total Possible Earning From Course: $%.2f%n", totalPossibleEarning);
  System.out.println("+--------------------------------------------------------------------------------+");
        
        
    }
    
    
    
   private static void generateProgrammeAffiliated(LinkedHashMapInterface<Course, ListInterface<Programme>> courseProgramme){
    
     if(courseProgramme.isEmpty()){
            System.out.println("There are no Course Found");
            return;
        }
    
     ListInterface<Course> courseKey=courseProgramme.getAllKeys();
        Date currentDate = new Date();
        int totalNumberOfTutorial=0;
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
       
System.out.println("+----------------------------------------------+");
System.out.println("Programme Affiliated Report");
System.out.println("Report Date/Time: " + dateFormat.format(currentDate));
System.out.println("+----------------------------------------------+\n");
    
    for (int i = 0; i < courseKey.size(); i++) {
    ListInterface<Programme> programme = courseProgramme.get(courseKey.get(i));
     String str="";
     int numberOfTutorial=0;
     for(int j=0;j<programme.size();j++){
       
       str+=programme.get(j).getProgrammeID()+" ";
         numberOfTutorial+=programme.get(j).getNumberOfTutorialGroup();
   }
  
  System.out.println("\n\n+------------------"+courseKey.get(i).getCourseID()+"---------------------+");
    System.out.println("Course ID: " + courseKey.get(i).getCourseID());
    System.out.println("Course Name: " + courseKey.get(i).getCourseName());
    System.out.println("Number Of Programmes: "+programme.size());
    System.out.println("Number Of Tutorial Groups: "+ numberOfTutorial);
     System.out.println("\n+----------------------------------------------+");
    System.out.println("              Programmes Affiliated");
    System.out.println("+----------------------------------------------+");
   System.out.println("Programmes: ");
   System.out.print(str);
   totalNumberOfTutorial+=numberOfTutorial;
   
}
    
    System.out.println("\n\n\n\n+----------------------------------------------+");
   
   System.out.println("Total Tutorial Group: "+totalNumberOfTutorial);
   System.out.println("+----------------------------------------------+\n\n");
    
    
    
    }
   
   
   
   
   
   
   
   
   
   
   
    private static void bubbleSort(ListInterface<Course> course) {
        int totalSize = course.size();
    boolean swapped;

    do {
        swapped = false;
        for (int i = 1; i < totalSize; i++) {
            if (course.get(i - 1).getCourseLimit() < course.get(i).getCourseLimit()) {
                Course tempCourse = course.get(i - 1);
                course.set(i - 1, course.get(i));
                course.set(i, tempCourse);
                swapped = true;
            }
        }
        // After each pass, the largest element will be at the beginning, so we reduce totalSize
        totalSize--;
    } while (swapped);
    }
    
    
    
    
    
    
    
    
    private static void top5CourseLimit(LinkedHashMapInterface<String,Course> courseManagement){
        
         if(courseManagement.isEmpty()){
            System.out.println("There are no Course Found");
            return;
        }
           Date currentDate = new Date();
         ListInterface<Course> courseValue=new ArrayList<>();
         ListInterface<String> courseKey=courseManagement.getAllKeys();
           SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
           
           
         for(int i=0;i<courseKey.size();i++){
             courseValue.add(courseManagement.get(courseKey.get(i)));
             
         }
         
         bubbleSort(courseValue);
         int totalSize=courseValue.size();
         
         System.out.println("+---------------------------------------------+");
         System.out.println("Top 5 Highest Course Capacity");
        System.out.println("Report Date/Time: " + dateFormat.format(currentDate));
       System.out.println("+---------------------------------------------+\n");
       
         for(int i=0;i<5;i++){
             String courseID=courseValue.get(i).getCourseID();
             String courseName=courseValue.get(i).getCourseName();
             int courseLimit=courseValue.get(i).getCourseLimit();
             
    System.out.println("+------------------"+courseID+"---------------------+");
    System.out.println("Course ID: " + courseID);
    System.out.println("Course Name: " + courseName);
    System.out.println("Course Limit: "+courseLimit);
     
  
   System.out.println("+-----------------------------------------------+\n");
  
           
             
             
         }
         
         
      
    
    

}
        
        

    
    private static void removeProgramme_Course(LinkedHashMapInterface<String, TutorManagement> tutor,LinkedHashMapInterface<String, Course> courseManagement, LinkedHashMapInterface<Course, ListInterface<Programme>> courseProgramme) {
        Scanner scanner = new Scanner(System.in);
        String proceedInput = "";
        String courseID;
        String programmeID;
        ListInterface<Course> courseList = new ArrayList<>();

        boolean removed = false;

        do {

            courseList = courseProgramme.getAllKeys();
            if (courseList.isEmpty()) {
                System.out.println("No Available Course To Remove Programme");
                return; //No courses available, exit the function
            }
            System.out.println("+---------------------------------------+");
            System.out.println("|            Course Available           |");
            System.out.println("+---------------------------------------+");

            for (int i = 0; i < courseList.size(); i++) {
                System.out.println(courseList.get(i).getCourseID());
            }

            System.out.println("+---------------------------------------+");

            removed = false;
            ListInterface<Programme> programme = new ArrayList<>();

            while (true) {
                courseID = getValidCourseID(scanner);

                if (!courseManagement.containsKey(courseID)) {
                    System.out.println("Course not found. Please enter a valid Course ID.");
                } else {
                    break; // Exit the validation loop if a valid courseID is entered
                }
            }

            Course course = courseManagement.get(courseID);
            programme = courseProgramme.get(course);

            System.out.println("+---------------------------------------+");
            System.out.println("|\t\tProgramme\t\t|");
            System.out.println("+---------------------------------------+");

            for (int i = 0; i < programme.size(); i++) {
                System.out.println(programme.get(i).getProgrammeID());
            }

            System.out.println("+---------------------------------------+");

            if (programme.isEmpty()) {
                System.out.println("No Programme added in " + course.getCourseID());
            } else {
                System.out.print("Please Enter The Programme to Remove:");
                programmeID = scanner.nextLine();

                for (int i = 0; i < programme.size(); i++) {
                    if (!programme.get(i).getProgrammeID().equals(programmeID)) {
                        continue;
                    }
                    System.out.print("Are You Sure(YES/NO)?:");
                    proceedInput = getValidProceedInput(scanner);
                    if (proceedInput.equalsIgnoreCase("YES")) {
                        programme.remove(programme.get(i));

                        removed = true;

                        break;
                    }

                }
                if (!removed) {
                    System.out.print("Not Removed");
                } else {
                    System.out.print("Successfully Removed");

                    if (programme.isEmpty()) {
                        courseProgramme.remove(course);
                    }

                }
            }

            System.out.print("\nDo you wish to Continue? (YES/NO):");
            proceedInput = getValidProceedInput(scanner);

        } while (proceedInput.equalsIgnoreCase("YES"));

        courseMenu(tutor,courseManagement, courseProgramme);
    }

    private static void addProgramme_Course(LinkedHashMapInterface<String, TutorManagement> tutor,LinkedHashMapInterface<String, Course> courseManagement, LinkedHashMapInterface<Course, ListInterface<Programme>> courseProgramme) {

        Scanner scanner = new Scanner(System.in);
        String proceedInput = "";
        boolean noAvailableProgramme = false;
        boolean programmeAlreadyAdded = false;
        boolean isAvailable = false;

        ListInterface<Programme> programmeList = new ArrayList<>();

        programmeList.add(new Programme("RSW", "Software Engineering", 3, 3));
        programmeList.add(new Programme("RSD", "Software Systems Development", 3, 3));
        programmeList.add(new Programme("RDS", "Data Science", 3, 3));
        programmeList.add(new Programme("RIS", "Information Security", 3, 3));
        programmeList.add(new Programme("RMM", "Marketing", 3, 3));
        programmeList.add(new Programme("RIT", "Internet Technology", 3, 3));

        if (courseManagement.isEmpty()) {
            System.out.println("No Course Found");
            return;
        }

        do {

            ListInterface<Programme> programme = new ArrayList<>();
            System.out.println("+---------------------------------------+");
            System.out.println("|            Course Available           |");
            System.out.println("+---------------------------------------+");
            courseManagement.displayKeys();
            System.out.println("+---------------------------------------+");

            String courseID = getValidCourseID(scanner);

            if (!courseManagement.containsKey(courseID)) {
                System.out.println("No Course Found.");
                continue;
            }

            Course course = courseManagement.get(courseID);

            System.out.println("+---------------------------------------+");
            System.out.println("|             Programme              |");
            System.out.println("+---------------------------------------+");
            System.out.println("+---------------------------------------+");

            if (!courseProgramme.containsKey(course)) {

                courseProgramme.put(course, new ArrayList<>());
                programme = courseProgramme.get(course);

            } else {
                programme = courseProgramme.get(course);
            }
            
            for (int i = 0; i < programmeList.size(); i++) {
                isAvailable = false;
                for (int j = 0; j < programme.size(); j++) {
                    if (programme.get(j).getProgrammeID().equals(programmeList.get(i).getProgrammeID())) {
                        isAvailable = true;
                        break;
                    }
                }

                if (isAvailable) {
                    System.out.println(programmeList.get(i).getProgrammeID() + " (Unvailable)");
                } else {
                    System.out.println(programmeList.get(i).getProgrammeID() + " (Available)");
                }
            }

            if (programmeList.size() == programme.size()) {

                System.out.println("There is not Available Programme to add.");

                continue;

            }

            System.out.print("Please Enter The Programme to Add:");
            String programmeID = scanner.nextLine();

            System.out.print("\nAre You Sure You Want To Add? (YES/NO):");
            proceedInput = getValidProceedInput(scanner);

            if (proceedInput.equalsIgnoreCase("YES")) {

                programmeAlreadyAdded = false;

                for (int i = 0; i < programmeList.size(); i++) {
                    if (programmeList.get(i).getProgrammeID().equals(programmeID)) {
                        programmeAlreadyAdded = false;

                        for (int j = 0; j < programme.size(); j++) {
                            if (programme.get(j).getProgrammeID().equals(programmeID)) {

                                System.out.println("Programme Already in the Course");
                                programmeAlreadyAdded = true;
                                break;

                            }

                        }

                        if (!programmeAlreadyAdded) {

                            programme.add(programmeList.get(i));
                            System.out.print("Programme has been successfully Added!!");

                        }
                        break;
                    }
                }
            }

            courseProgramme.put(course, programme);

            if (programmeAlreadyAdded) {
                System.out.println("No programme Added!");

            }

            System.out.println("\n+-------------" + courseID + "-------------+");
            System.out.println("|        Programme Affiliated         |");
            System.out.println("+---------------------------------------+");

            int size = courseProgramme.get(course).size();

            for (int i = 0; i < size; i++) {
                System.out.println(programme.get(i).getProgrammeID());

            }

            System.out.print("\nDo you wish to Continue? (YES/NO):");
            proceedInput = getValidProceedInput(scanner);

        } while (proceedInput.equalsIgnoreCase("YES"));

        courseMenu(tutor,courseManagement, courseProgramme);

    }

    
    private static void listAllCourse(LinkedHashMapInterface<String, TutorManagement> tutor,LinkedHashMapInterface<String, Course> courseManagement, LinkedHashMapInterface<Course, ListInterface<Programme>> courseProgramme) {

        courseManagement.displayValues();

        courseMenu(tutor,courseManagement, courseProgramme);
    }

    
    
    
    
    
    
    
    private static void amendCourse(LinkedHashMapInterface<String, TutorManagement> tutor,LinkedHashMapInterface<String, Course> courseManagement, LinkedHashMapInterface<Course, ListInterface<Programme>> courseProgramme) {
        Scanner scanner = new Scanner(System.in);
        String courseID, userResponse, courseName = "", proceedInput;

        boolean removed = false;
        int choice, creditHour = 0, courseLimit = 0;
        double courseFee=0;
        do {

            courseID = getValidCourseID(scanner);

            if (courseManagement.containsKey(courseID)) {
                Course courseToAmend = courseManagement.get(courseID);
                
                            courseName = courseToAmend.getCourseName();
                            creditHour = courseToAmend.getCreditHour();
                            courseLimit = courseToAmend.getCourseLimit();
                            courseFee=courseToAmend.getCourseFee();
System.out.println("+-----------------+");
System.out.println("| Course ID Found |");
System.out.println("+-----------------+\n");

                System.out.println("Course ID: " + courseID);
                System.out.println("Course Name: " + courseToAmend.getCourseName());
                System.out.println("Credit Hour: " + courseToAmend.getCreditHour());
                System.out.println("Course Limit: " + courseToAmend.getCourseLimit());
                System.out.println("Course Fees: " + courseToAmend.getCourseFee());

System.out.println("+----------------------+");
System.out.println("| Course Amendment    |");
System.out.println("+----------------------+");
System.out.println("| 1. Course ID        |");
System.out.println("| 2. Course Name      |");
System.out.println("| 3. Credit Hour      |");
System.out.println("| 4. Course Limit     |");
System.out.println("| 5. Course Fees      |");
System.out.println("| 6. All              |");
System.out.println("| 0. Exit             |");
System.out.println("+----------------------+\n");
                do {
                    System.out.print("Please Select 1-6 for amendment:");

                    choice = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice) {
                        case 1:
                            System.out.println("Please Enter a new Course ID ");
                            System.out.println("+-----------------------------+");
                            System.out.println("Old Course ID: " + courseID);
                            courseID = getValidCourseID(scanner);
                            break;
                        case 2:
                            System.out.println("Please Enter a new Course Name ");
                             System.out.println("+-----------------------------+");
                            System.out.println("Old Course Name: " + courseToAmend.getCourseName());
                            courseName = getValidCourseName(scanner);

                            break;
                        case 3:
                            System.out.println("Please Enter a new Course Credit Hour ");
                             System.out.println("+-----------------------------+");
                            System.out.println("Old Course Credit Hour: " + courseToAmend.getCreditHour());
                            creditHour = getValidCreditHour(scanner);
                            break;
                        case 4:
                            System.out.println("Please Enter a new Course Limit ");
                             System.out.println("+-----------------------------+");
                            System.out.println("Old Course Limit: " + courseToAmend.getCourseLimit());
                            courseLimit = getValidCourseLimit(scanner);

                            break;
                        case 5:
                            System.out.println("Please Enter a new Course Fees ");
                            System.out.println("+-----------------------------+");
                            System.out.println("Old Course Fees: " + courseFee+"0");
                            courseFee = getValidCourseFee(scanner); 
                            break;
                        case 6:
                            System.out.println("Please Enter a new Course ID ");
                            System.out.println("+-----------------------------+");
                            System.out.println("Old Course ID: " + courseID);
                            courseID = getValidCourseID(scanner);

                            System.out.println("Please Enter a new Course Name ");
                             System.out.println("+-----------------------------+");
                            System.out.println("Old Course Name: " + courseToAmend.getCourseName());
                            courseName = getValidCourseName(scanner);

                            System.out.println("Please Enter a new Course Credit Hour ");
                             System.out.println("+-----------------------------+");
                            System.out.println("Old Course Credit Hour: " + courseToAmend.getCreditHour());
                            creditHour = getValidCreditHour(scanner);

                            System.out.println("Please Enter a new Course Limit ");
                             System.out.println("+-----------------------------+");
                            System.out.println("Old Course Limit: " + courseToAmend.getCourseLimit());
                            courseLimit = getValidCourseLimit(scanner);
                            System.out.println("Please Enter a new Course Fees ");
                            System.out.println("+-----------------------------+");
                            System.out.println("Old Course Fees: " + courseFee+"0");
                            courseFee = getValidCourseFee(scanner);
                            break;
                        case 0:
                             courseMenu(tutor,courseManagement, courseProgramme);
                             break;
                        default:
                            System.out.printf("Please re-input a valid choice(0-6): ");
                            break;
                    }
                } while (choice >= 5 && choice <= 1);

                System.out.println("Course Amendment Details");
                System.out.println("══════════════");
                System.out.println("Course ID: " + courseToAmend.getCourseID() + "-> " + courseID);
                System.out.println("Course Name: " + courseToAmend.getCourseName() + "-> " + courseName);
                System.out.println("Course Credit Hour: " + courseToAmend.getCreditHour() + "-> " + creditHour);
                System.out.println("Course Limit: " + courseToAmend.getCourseLimit() + "-> " + courseLimit);
                System.out.println("Course Fees: " + courseToAmend.getCourseFee()+"0" + "-> " + courseFee+"0");

                System.out.print("Are You Sure You Want To Amend (YES/NO)?>");
            
                proceedInput = getValidProceedInput(scanner);

                if (proceedInput.equalsIgnoreCase("YES")) {
                    
                    if (!courseManagement.containsKey(courseID)) {

                        courseManagement.get(courseID).setCourseName(courseName);
                        courseManagement.get(courseID).setCreditHour(creditHour);
                        courseManagement.get(courseID).setCourseLimit(courseLimit);
                        courseManagement.get(courseID).setCourseFee(courseFee);

                    } else {

                        courseManagement.remove(courseToAmend.getCourseID());
                        courseToAmend.setCourseID(courseID);
                        courseToAmend.setCourseName(courseName);
                        courseToAmend.setCreditHour(creditHour);
                        courseToAmend.setCourseLimit(courseLimit);
                        courseToAmend.setCourseFee(courseFee);
                        courseManagement.put(courseID, courseToAmend);
                    }
                } else {

                    System.out.println("Course Information Has Not Changed.");
                }

            } else {
System.out.println("+---------------------+");
System.out.println("| Course ID Not Found |");
System.out.println("+---------------------+\n");
            }

            System.out.print("Do you Want to Continue Amending Courses??(YES/NO)>");
            proceedInput = getValidProceedInput(scanner);

        } while (proceedInput.equalsIgnoreCase("YES"));
        courseMenu(tutor,courseManagement, courseProgramme);

    }

    private static void removeCourse(LinkedHashMapInterface<String, TutorManagement> tutor,LinkedHashMapInterface<String, Course> courseManagement, LinkedHashMapInterface<Course, ListInterface<Programme>> courseProgramme) {
        Scanner scanner = new Scanner(System.in);
        String courseID;
        String proceedInput;
      

        do {
            
              
               
                courseID = getValidCourseID(scanner);

                if (courseManagement.containsKey(courseID)) {

                    Course courseToRemove = courseManagement.get(courseID);

System.out.println("+-----------------------------------------------------+");
System.out.println("|                    Course ID Found                  |");
System.out.println("+-----------------------------------------------------+");

                    System.out.println("Course ID: " + courseID);
                    System.out.println("Course Name: " + courseToRemove.getCourseName());
                    System.out.println("Credit Hour: " + courseToRemove.getCreditHour());
                    System.out.println("Course Limit: " + courseToRemove.getCourseLimit());
                     System.out.println("Course Fee: $" + courseToRemove.getCourseFee()+"0");
                     System.out.println("+-----------------------------------------------------+");
                    System.out.print("Are You Sure You want to Remove? (YES/NO): ");

                    proceedInput = getValidProceedInput(scanner);

                    

                    if (proceedInput.equalsIgnoreCase("YES")) {
                        courseManagement.remove(courseID);
                        System.out.print("Successfully Removed!! ");
                      
                    } else {
                        System.out.print("Course: " + courseID + " has not been Removed!! ");
                        
                    }

                } else {
System.out.println("+-----------------------------------------------------+");
System.out.println("|                 Course ID Not Found                 |");
System.out.println("+-----------------------------------------------------+");
                }

           

            System.out.print("\nDo you wish to Continue? (YES/NO):");
            proceedInput = getValidProceedInput(scanner);

            

        } while (proceedInput.equalsIgnoreCase("YES"));

        courseMenu(tutor,courseManagement, courseProgramme);
    }

    private static void findCourse(LinkedHashMapInterface<String, TutorManagement> tutor,LinkedHashMapInterface<String, Course> courseManagement, LinkedHashMapInterface<Course, ListInterface<Programme>> courseProgramme) {
        Scanner scanner = new Scanner(System.in);
        String courseID;
        String proceedInput;

System.out.println("+----------------------+");
System.out.println("|   Find Course Menu   |");
System.out.println("+----------------------+\n");

        do {
            
            
           
                courseID = getValidCourseID(scanner);

                if (courseManagement.containsKey(courseID)) {
System.out.println("+-----------------------------------------------------+");
System.out.println("|                    Course ID Found                  |");
System.out.println("+-----------------------------------------------------+\n");
                    System.out.println("Course ID: " + courseID);
                    System.out.println("Course Name: " + courseManagement.get(courseID).getCourseName());
                    System.out.println("Credit Hour: " + courseManagement.get(courseID).getCreditHour());
                    System.out.println("Course Limit: " + courseManagement.get(courseID).getCourseLimit());
                    System.out.println("Course Fees: " + courseManagement.get(courseID).getCourseFee()+"0");
                 
System.out.println("+-----------------------------------------------------+\n");
                } else if (!courseManagement.containsKey(courseID)) {
System.out.println("+---------------------+");
System.out.println("| Course ID Not Found |");
System.out.println("+---------------------+\n");
                    
                }

          

           
               System.out.print("\nDo you wish to Continue Finding? (YES/NO): ");
              proceedInput = getValidProceedInput(scanner);
           
              
        } while (proceedInput.equalsIgnoreCase("YES"));
        courseMenu(tutor,courseManagement, courseProgramme);

    }

    private static void addCourse(LinkedHashMapInterface<String, TutorManagement> tutor,LinkedHashMapInterface<String, Course> courseManagement, LinkedHashMapInterface<Course, ListInterface<Programme>> courseProgramme) {
        Scanner scanner = new Scanner(System.in);
        String courseID = "";
        String courseName = "";
        int creditHour = 0;
        int courseLimit = 0;
      double courseFee;
        boolean integerCheck;
        String proceedInput = "";

        do {
            boolean override = false;
System.out.println("+----------------------+");
System.out.println("|   Add Course Menu    |");
System.out.println("+----------------------+");

            courseID = getValidCourseID(scanner);

            if (courseManagement.containsKey(courseID)) {
                System.out.println("------Duplicated Course ID------");
                System.out.print("Do you want to Override the old course (YES/NO)?:");
                proceedInput = getValidProceedInput(scanner);

                if (proceedInput.equalsIgnoreCase("YES")) {

                    override = true;

                } else {
                    override = false;
                    System.out.println("Exited");
                    continue;
                }
            }
            
            courseName = getValidCourseName(scanner);
            creditHour = getValidCreditHour(scanner);
            courseLimit = getValidCourseLimit(scanner);
            courseFee=getValidCourseFee(scanner);
            
            
System.out.println("+-----------------------------------------------------+");
System.out.println("|                     Course Review                   |");
System.out.println("+-----------------------------------------------------+");
System.out.println("Course ID: " + courseID);
System.out.println("Course Name: " + courseName);
System.out.println("Credit Hour: " + creditHour);
System.out.println("Course Limit: " + courseLimit);
System.out.println("Course Fees: " + courseFee+"0");
System.out.println("+-----------------------------------------------------+\n");
            
            scanner.nextLine();

            if (override) {
                System.out.print("\nAre You Sure You Want To Override Old Course? (YES/NO): ");

            } else {
                System.out.print("\nAre You Sure You Want To Add? (YES/NO): ");
            }

            proceedInput = getValidProceedInput(scanner);

            if (!override && proceedInput.equalsIgnoreCase("YES")) {
                courseManagement.put(courseID, new Course(courseID, courseName, creditHour, courseLimit,courseFee));

System.out.println("+---------------------------+");
System.out.println("| Course Added Successfully |");
System.out.println("+---------------------------+\n");
                System.out.print(courseManagement.get(courseID));
            } else if (override && proceedInput.equalsIgnoreCase("YES")) {
                courseManagement.put(courseID, new Course(courseID, courseName, creditHour, courseLimit,courseFee));
System.out.println("+-------------------------------+");
System.out.println("| Course Overrided Successfully |");
System.out.println("+-------------------------------+\n");
                System.out.print(courseManagement.get(courseID));

            } else {
System.out.println("+------------------+");
System.out.println("| Course Not Added |");
System.out.println("+------------------+\n");

            }
            System.out.print("\nDo you wish to Continue Adding? (YES/NO): ");
            proceedInput = getValidProceedInput(scanner);

        } while (proceedInput.equalsIgnoreCase("YES"));

        courseMenu(tutor,courseManagement, courseProgramme);

    }
    
   
 private static double getValidCourseFee(Scanner scanner) {

        double courseFee=-1.0;
        
        do {
            try {
                System.out.print("Please Enter Course Fees: ");
                courseFee = scanner.nextDouble();
                if (courseFee < 0.0) {
                    System.out.println("Please Course Fee Not below than 0!! ");
                }

            } catch (InputMismatchException e) {
                System.out.println("Please Enter only Number!!");
                scanner.next();
            }

        } while (courseFee < 0.0 );
 
            
       return courseFee;
 
 }
 
 
    private static String getValidProceedInput(Scanner scanner) {
        String proceedInput = "";
        
        do {

            proceedInput = scanner.nextLine();

            if (!proceedInput.equalsIgnoreCase("YES") && !proceedInput.equalsIgnoreCase("NO")) {
                System.out.print("Please enter only YES or NO: ");

            }
        } while (!proceedInput.equalsIgnoreCase("YES") && !proceedInput.equalsIgnoreCase("NO"));

        return proceedInput;
    }

    private static int getValidCourseLimit(Scanner scanner) {
        int courseLimit = 0;

        do {
            try {
                System.out.print("Please Enter a Course Credit Limit(5-175): ");
                courseLimit = scanner.nextInt();
                if (courseLimit < 5 || courseLimit > 175) {
                    System.out.println("Please Enter a Course Credit Limit within 5-175!! ");
                }

            } catch (InputMismatchException e) {
                System.out.println("Please Enter only Number(5-175)!!");
                scanner.next();
            }

        } while (courseLimit < 5 || courseLimit > 175);

        return courseLimit;
    }

    private static int getValidCreditHour(Scanner scanner) {
        int creditHour = 0;

        do {

            try {
                System.out.print("Please Enter Credit Hour Number(2-5): ");
                creditHour = scanner.nextInt();

                if (creditHour < 2 || creditHour > 5) {

                    System.out.println("Please Enter Course Credit Hour withing Range(2-5)!!");

                }
            } catch (InputMismatchException e) {
                System.out.println("Please Enter only Number(2-5)!!");
                scanner.next();

            }
        } while (creditHour < 2 || creditHour > 5);

        return creditHour;
    }

    private static String getValidCourseName(Scanner scanner) {
        String courseName = "";

        do {
            System.out.printf("Please Enter Course Name: ");
            courseName = scanner.nextLine();

            if (courseName.isEmpty()) {
                System.out.println("Please Enter A Course Name!!");
            } else if (!courseName.matches("^[A-Za-z ]+$")) {
                System.out.println("Course Name cannot contain digits. Please enter a valid Course Name!!");
            } else if (courseName.length() > 75) {
                System.out.println("Please Enter Valid Name Not longer than 75 Character!!");
            }
        } while (courseName.isEmpty() || !courseName.matches("^[A-Za-z ]+$") || courseName.length() > 75);

        return courseName;
    }

    private static String getValidCourseID(Scanner scanner) {
        String courseID = "";

        do {
            System.out.printf("Please Enter Course ID: ");
            courseID = scanner.nextLine();

            if (courseID.isEmpty()) {
                System.out.println("Please Enter A Course ID!!");
            } else if (!courseID.matches("^(BACS|BAIT|MPU)(\\d{4})$")) {
                System.out.println("Format of Course ID: BACSXXXX|BAITXXXX|MPUXXXX(X = number)");

            }

        } while (!courseID.matches("^(BACS|BAIT|MPU)(\\d{4})$"));

        return courseID;
    }
    
    
    
    
}
