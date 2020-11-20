import java.io.*;
import java.util.*;

class InvalidRollNoException extends Exception // user defined invalid rollno exception
{
    String warning;
    InvalidRollNoException(String w)
    {
        warning=
                w;
    }
    public String toString() // overridden toString method
    {
        return  "InvalidRollNoException: "+ warning;
    }
}

class Student //student class to hold student details
{
    public  static String[] courseName={"Linear Algebra","Data Structures","Computer Architecture","Discrete Structures","OOP","Economics for Engineers","DSLab","OOPLab","EVS"};
    public static String[] courseCode={"19Z301","19Z302","19Z303","19Z304","19Z305","19O306","19Z310","19Z311","19K312"};
    private int[] present_hr;
    private int[] absent_hr;
    private int[] excuseab_hr;
    private int[] unexcuse_hr;
    private String Name;
    private String Roll_no;

    Student(String line) //paramerterized constructor
    {
        present_hr = new int[9];
        absent_hr=new int[9];
        excuseab_hr = new int[9];
        unexcuse_hr = new int[9];
        int i,index=0;
        String l[]=line.split(",");
        Name=l[0];
        Roll_no=l[1];
        for (i = 2; i < 38; i = i + 4)
        {

            present_hr[index] = Integer.parseInt(l[i]);
            absent_hr[index] = Integer.parseInt(l[i + 1]);
            excuseab_hr[index] = Integer.parseInt(l[i + 2]);
            unexcuse_hr[index] = Integer.parseInt(l[i + 3]);
            index++;
        }

    }

    public void view_attendance_student() //func to view student attendance details
    {
        int i;
        float percent,total;
        System.out.println("NAME : "+Name+"  ROLL NO : "+Roll_no);
        System.out.println();
        for(i=0;i<9;i++)
        {
            total=present_hr[i]+absent_hr[i]+excuseab_hr[i]+unexcuse_hr[i];
            percent=(float)(present_hr[i]/total)*100; //calculating percentage
            System.out.println("COURSE NAME : "+courseName[i]+"  COURSE CODE : "+courseCode[i]);
            System.out.println();
            System.out.println("Present : "+present_hr[i]+" Absent : "+absent_hr[i]+" Excused Absence : "+excuseab_hr[i]+" Unexcused Absence : "+unexcuse_hr[i]+" Percentage : "+percent+"%");
            System.out.println();

        }
    }



}

class Faculty1 //class faculty to store student details for a faculty user
{
    public static String[] courseName = {"Linear Algebra", "Data Structures", "Computer Architecture","Discrete Structures", "OOP", "Economics for Engineers", "DSLab", "OOPLab", "EVS"};
    public static String[] courseCode = {"19Z301", "19Z302", "19Z303", "19Z304", "19Z305", "19O306", "19Z310", "19Z311", "19K312"};
    private int[] present_hr;
    private int[] absent_hr;
    private int[] excuseab_hr;
    private int[] unexcuse_hr;
    private String Name;
    private String Roll_no;

    Faculty1(String line) {
        present_hr = new int[9];
        absent_hr = new int[9];
        excuseab_hr = new int[9];
        unexcuse_hr = new int[9];
        int i, index = 0;
        String l[] = line.split(",");
        Name = l[0];
        Roll_no = l[1];
        for (i = 2; i < 38; i = i + 4) {

            present_hr[index] = Integer.parseInt(l[i]);
            absent_hr[index] = Integer.parseInt(l[i + 1]);
            excuseab_hr[index] = Integer.parseInt(l[i + 2]);
            unexcuse_hr[index] = Integer.parseInt(l[i + 3]);
            index++;
        }

    }

    public void view_attendance_student(String code) //func to view student attendance details for a specific course
    {
        int i;
        float percent, total;
        System.out.println("NAME : " + Name + " ROLL NO : " + Roll_no);
        System.out.println();
        for (i = 0; i < 9; i++) {
            if (code.equals(courseCode[i])) {
                total = present_hr[i] + absent_hr[i] + excuseab_hr[i] + unexcuse_hr[i];
                percent = (float) (present_hr[i] / total) * 100;
                System.out.println("COURSE NAME : " + courseName[i] + "  COURSE CODE : " + courseCode[i]);
                System.out.println();
                System.out.println("Present : " + present_hr[i] + " Absent : " + absent_hr[i] + " Excused Absence : " + excuseab_hr[i] + " Unexcused Absence : " + unexcuse_hr[i] + " Percentage : " + percent + "%");
                System.out.println();
            }

        }
    }
}

class User //class that has static methods to validate inputs
{
    public static boolean validate_staff(String str) //func to validate course code
    {
        String sub=str.substring(0,4);
        String last_digits=str.substring(4);
        int last_d=Integer.parseInt(last_digits);
        if(sub.equals("19Z3")  && (last_d>=1 && last_d<=12))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static boolean validate_reg(String r)  //func to validate regular student's roll number
    {
        String sub = r.substring(0, 4);
        String last_digits = r.substring(4);
        int last_d = Integer.parseInt(last_digits);
        if (sub.equals("19Z3") && (last_d >= 1 && last_d <= 64) && last_d != 19 && last_d != 25) 
        {
            return true;
        } 
        else 
        {
            return false;
        }
    }
    public static boolean validate_ias (String r) //func to validate ias student's roll number
    {
        String sub = r.substring(0, 6);
        int last_d = Integer.parseInt(r.substring(6));
        System.out.println(sub + " " + last_d);
        if (sub.equals("19IZUS") && last_d >= 9 && last_d <= 17) 
        {
            return true;
        } 
        else 
        {
            return false;
        }
    }
}

class Main //driver class
{
    public static void main(String args[]) throws InvalidRollNoException, Exception //main func
    {
        String line = null;
        ArrayList<Student> al = new ArrayList<Student>(); //creating arraylist for student objects
        Student stu;

        System.out.println("         ----------STUDENT ATTENDANCE TRACKER----------");
        System.out.println("ENTER :");
        System.out.println("        1-STUDENT");
        System.out.println("        2-FACULTY");

        Scanner scan = new Scanner(System.in);
        int choice = Integer.parseInt(scan.nextLine()); //getting choice from the user

        try //to monitor exceptions
        {
            if (choice == 1) //user-student
            {
                System.out.println("        ----------STUDENT LOGIN----------");
                System.out.println("ENTER :");
                System.out.println("        1-REGULAR");
                System.out.println("        2-IAS");

                int s = Integer.parseInt(scan.nextLine()); // choice to choose regular or ias

                System.out.println("    ----------MONTH----------");
                System.out.println("ENTER : ");
                System.out.println("    1.OCTOBER");
                System.out.println("    2.SEPTEMBER");
                System.out.println("    3.AUGUST");

                int month = Integer.parseInt(scan.nextLine()); //choice to choose month

                if (month == 1) //month-oct
                {

                    BufferedReader csv = new BufferedReader(new FileReader("C:\\Users\\Sam\\IdeaProjects\\OOP_Project_Attendance_Tracker\\src\\Attendance - October.csv"));//opening attendance file for october month
                    String csvsplit = ",";

                    try //to monitor io exception
                    {
                        String m;
                        while ((m = csv.readLine()) != null) //reading line by line from oct-csv file
                        {
                            al.add(new Student(m)); //instantiating student objects for each student and adding it to collections
                        }
                        csv.close();
                    }
                    catch (IOException e) //to catch io exception
                    {
                        e.printStackTrace(); //ioexception handler
                    }

                }
                else if (month == 2) //month-sept
                {

                    BufferedReader csv = new BufferedReader(new FileReader("C:\\Users\\Sam\\IdeaProjects\\OOP_Project_Attendance_Tracker\\src\\Attendance - September.csv")); //opening attendance file for September month
                    String csvsplit = ",";

                    try
                    {
                        String m;
                        while ((m = csv.readLine()) != null) //reading line by line from sept-csv file
                        {
                            al.add(new Student(m)); //instantiating student objects for each student and adding it to collections
                        }
                        csv.close();
                    }
                    catch (IOException e) //to catch io exception
                    {
                        e.printStackTrace(); //ioexception handler
                    }

                }
                else if (month == 3)
                {

                    BufferedReader csv = new BufferedReader(new FileReader("C:\\Users\\Sam\\IdeaProjects\\OOP_Project_Attendance_Tracker\\src\\Attendance - August.csv")); //opening attendance file for Augest month
                    String csvsplit = ",";

                    try
                    {
                        String m;
                        while ((m = csv.readLine()) != null) //reading line by line from aug-csv file
                        {
                            al.add(new Student(m)); //instantiating student objects for each student and adding it to collections
                        }
                        csv.close();
                    }
                    catch (IOException e)  //to catch io exception
                    {
                        e.printStackTrace(); //ioexception handler
                    }

                }

                String roll_no;

                if (s == 1) //user - regular student
                {

                    System.out.print("ENTER ROLL NO : ");
                    roll_no = scan.nextLine();
                    System.out.println();

                    if (User.validate_reg(roll_no) == true) //validating roll no of the user
                    {
                        int sub = Integer.parseInt(roll_no.substring(4)); //last two digits of roll no to trace student object

                        if (sub <= 18) 
                        {
                            al.get(sub - 1).view_attendance_student(); // getting student object at index sub - 1
                        }
                        else if (sub >= 20 && sub <= 24) 
                        {
                            al.get(sub - 2).view_attendance_student(); // getting student object at index sub - 2 (no 19 exists)
                        }
                        else
                            {
                            al.get(sub - 3).view_attendance_student(); // getting student object at index sub - 3 (no 25 and 19 exist)
                        }

                    }
                    else //invalid choice from user
                        {
                        throw new InvalidRollNoException("INVALID ROLL NO"); //warning to prompt user that choice is invalid
                    }

                }
                else if (s == 2) //user - ias student
                {

                    System.out.print("ENTER ROLL NO : ");
                    roll_no = scan.nextLine();
                    int sub = Integer.parseInt(roll_no.substring(6)); //last 3 digits of roll no

                    if (User.validate_ias(roll_no)) //validating ias roll no
                    {
                        al.get((al.size() - 1) - (17 - sub)).view_attendance_student(); //getting student object for the user
                    }
                    else
                        {
                        throw new InvalidRollNoException("INVALID ROLL NO"); //warning to prompt user that roll no is invalid
                    }

                }
                else
                    {
                        throw new Exception("INVALID CHOICE"); //prompting user's choice is invalid
                }

            }
            else if (choice == 2) //user - faculty
            {

                ArrayList<Faculty1> af = new ArrayList<Faculty1>(); //creating arraylist for faculty objects for each student
                Faculty1 fu;

                System.out.println("        ----------FACULTY LOGIN----------");
                System.out.println("ENTER :");
                System.out.println("        1-REGULAR");
                System.out.println("        2-IAS");

                int s = Integer.parseInt(scan.nextLine()); // choice to choose regular or ias

                System.out.println("    ----------MONTH----------");
                System.out.println("ENTER : ");
                System.out.println("    1.OCTOBER");
                System.out.println("    2.SEPTEMBER");
                System.out.println("    3.AUGUST");

                int month = Integer.parseInt(scan.nextLine()); // getting choice to choose month


                //back end
                if (month == 1) // oct - month
                {

                    BufferedReader csv = new BufferedReader(new FileReader("C:\\Users\\Sam\\IdeaProjects\\OOP_Project_Attendance_Tracker\\src\\Attendance - October.csv")); //opening attendance file for october month
                    String csvsplit = ",";

                    try // to monitor ioexception
                    {
                        String m;
                        while ((m = csv.readLine()) != null) //reading line by line from oct-csv file
                        {
                            af.add(new Faculty1(m)); //instantiating student objects for each student and adding it to collections
                        }
                        csv.close();
                    }
                    catch (IOException e) //to catch io exception
                    {
                        e.printStackTrace(); //ioexception handler
                    }

                }
                else if (month == 2)
                {

                    BufferedReader csv = new BufferedReader(new FileReader("C:\\Users\\Sam\\IdeaProjects\\OOP_Project_Attendance_Tracker\\src\\Attendance - September.csv")); //opening attendance file for September month
                    String csvsplit = ",";

                    try // to monitor ioexception
                    {
                        String m;
                        while ((m = csv.readLine()) != null)  //reading line by line from sept-csv file
                        {
                            af.add(new Faculty1(m)); //instantiating student objects for each student and adding it to collections
                        }
                        csv.close();
                    }
                    catch (IOException e) //to catch io exception
                    {
                        e.printStackTrace(); //ioexception handler
                    }

                }
                else if (month == 3)
                {
                    BufferedReader csv = new BufferedReader(new FileReader("C:\\Users\\Sam\\IdeaProjects\\OOP_Project_Attendance_Tracker\\src\\Attendance - August.csv")); //opening attendance file for Augest month
                    String csvsplit = ",";
                    try // to monitor ioexception
                    {
                        String m;
                        while ((m = csv.readLine()) != null) //reading line by line from augest-csv file
                        {
                            af.add(new Faculty1(m)); //instantiating student objects for each student and adding it to collections
                        }
                        csv.close();
                    }
                    catch (IOException e) //to catch io exception
                    {
                        e.printStackTrace(); //ioexception handler
                    }
                }

                String roll_no;
                String code;
                System.out.print("ENTER COURSE CODE: ");
                code = scan.nextLine();
                System.out.println();

                if (User.validate_staff(code) == true)  //validating course code
                {
                    int sub = Integer.parseInt(code.substring(4)); // getting last 2 digits of course code

                    if (s == 1) // user wants to view regular student's details
                    {
                        System.out.print("ENTER ROLL NO : ");
                        roll_no = scan.nextLine();
                        System.out.println();

                        if (User.validate_reg(roll_no) == true) //validating regular student's roll no
                        {
                            int subs = Integer.parseInt(roll_no.substring(4)); //getting last 2 digits of roll no to trace object

                            if(subs<=18) 
                            {
                                af.get(subs - 1).view_attendance_student(code); // getting student object at index subs - 1
                            }
                            else if(subs>=20 && subs<=24) 
                            {
                                af.get(subs-2).view_attendance_student(code); // getting student object at index subs - 2(no 19 exists)
                            }
                            else
                            {
                                af.get(subs-3).view_attendance_student(code); // getting student object at index subs - 3(no 19 ans 25 exists)
                            }
                        }
                        else
                        {
                            throw new InvalidRollNoException("INVALID ROLL NO"); //prompting user that roll no is invalid
                        }

                    }
                    else if (s == 2)
                    {
                        System.out.print("ENTER ROLL NO : ");
                        roll_no = scan.nextLine();

                        int subj = Integer.parseInt(roll_no.substring(6));//getting last 3 digits of roll no

                        if (User.validate_ias(roll_no)) //validating ias student's roll no
                        {
                            af.get((af.size() - 1) - (17 - subj)).view_attendance_student(code); //getting student object
                        }
                        else
                        {
                            throw new InvalidRollNoException("INVALID ROLL NO"); //warning user that roll no is invalid
                        }
                    }
                    else
                    {
                        throw new Exception("INVALID CHOICE"); //prompting user that choice is invalid
                    }

                }
            }
            else
            {
                throw new Exception("INVALID CHOICE"); //prompting user that choice is invalid
            }

        }
        catch (InvalidRollNoException e)  //  to catch invalidrollnoexception
        {
            System.out.println(e);
        }
        catch(Exception e) //  to catch invalidrollnoexception
        {
            System.out.println(e);
        }

    }
}




