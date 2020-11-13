import java.io.*;
import java.util.*;
class InvalidRollNoException extends Exception{
    String warning;
    InvalidRollNoException(String w)
    {
        warning=w;
    }
    public String toString()
    {
        return  "InvalidRollNoException: "+warning;
    }
}
class Student
{
    public  static String[] courseName={"Linear Algebra","Data Structures","Computer Architecture","Discrete Structures","OOP","Economics for Engineers","DSLab","OOPLab","EVS"};
    public static String[] courseCode={"19Z301","19Z302","19Z303","19Z304","19Z305","19O306","19Z310","19Z311","19K312"};
    private int[] present_hr;
    private int[] absent_hr;
    private int[] excuseab_hr;
    private int[] unexcuse_hr;
    private String Name;
    private String Roll_no;
    Student(String line) {
        present_hr = new int[9];
        absent_hr=new int[9];
        excuseab_hr = new int[9];
        unexcuse_hr = new int[9];
        int i,index=0;
        String l[]=line.split(",");
        Name=l[0];
        Roll_no=l[1];
        for (i = 2; i < 38; i = i + 4) {

            present_hr[index] = Integer.parseInt(l[i]);
            absent_hr[index] = Integer.parseInt(l[i + 1]);
            excuseab_hr[index] = Integer.parseInt(l[i + 2]);
            unexcuse_hr[index] = Integer.parseInt(l[i + 3]);
            index++;
        }

    }
    public void view_attendance_student()
    {
        int i;
        float percent,total;
        System.out.println("NAME : "+Name+"  ROLL NO : "+Roll_no);
        System.out.println();
        for(i=0;i<9;i++)
        {
            total=present_hr[i]+absent_hr[i]+excuseab_hr[i]+unexcuse_hr[i];
            percent=(float)(present_hr[i]/total)*100;
            System.out.println("COURSE NAME : "+courseName[i]+"  COURSE CODE : "+courseCode[i]);
            System.out.println();
            System.out.println("Present : "+present_hr[i]+" Absent : "+absent_hr[i]+" Excused Absence : "+excuseab_hr[i]+" Unexcused Absence : "+unexcuse_hr[i]+" Percentage : "+percent+"%");
            System.out.println();

        }
    }



}

class Faculty1 {
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

    public void view_attendance_student(String code) {
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

class User {
    public static boolean validate_staff(String str)
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
    public static boolean validate_reg(String r) {
        String sub = r.substring(0, 4);
        String last_digits = r.substring(4);
        int last_d = Integer.parseInt(last_digits);
        if (sub.equals("19Z3") && (last_d >= 1 && last_d <= 64) && last_d != 19 && last_d != 25) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean validate_ias (String r)
    {
        String sub = r.substring(0, 6);
        int last_d = Integer.parseInt(r.substring(6));
        System.out.println(sub + " " + last_d);
        if (sub.equals("19IZUS") && last_d >= 9 && last_d <= 17) {
            return true;
        } else {
            return false;
        }
    }
}
class Main {
    public static void main(String args[]) throws InvalidRollNoException, Exception {
        String line = null;
        ArrayList<Student> al = new ArrayList<Student>();
        Student stu;
        System.out.println("         ----------STUDENT ATTENDANCE TRACKER----------");
        System.out.println("ENTER :");
        System.out.println("        1-STUDENT");
        System.out.println("        2-FACULTY");
        Scanner scan = new Scanner(System.in);
        int choice = Integer.parseInt(scan.nextLine());
        try {
            if (choice == 1) {
                System.out.println("        ----------STUDENT LOGIN----------");
                System.out.println("ENTER :");
                System.out.println("        1-REGULAR");
                System.out.println("        2-IAS");
                int s = Integer.parseInt(scan.nextLine());
                System.out.println("    ----------MONTH----------");
                System.out.println("ENTER : ");
                System.out.println("    1.OCTOBER");
                System.out.println("    2.SEPTEMBER");
                System.out.println("    3.AUGUST");
                int month = Integer.parseInt(scan.nextLine());
                if (month == 1) {
                    BufferedReader csv = new BufferedReader(new FileReader("C:\\Users\\Sam\\IdeaProjects\\OOP_Project_Attendance_Tracker\\src\\Attendance - October.csv"));
                    String csvsplit = ",";
                    try {
                        String m;
                        while ((m = csv.readLine()) != null) {
                            al.add(new Student(m));
                        }
                        csv.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (month == 2) {
                    BufferedReader csv = new BufferedReader(new FileReader("C:\\Users\\Sam\\IdeaProjects\\OOP_Project_Attendance_Tracker\\src\\Attendance - September.csv"));
                    String csvsplit = ",";
                    try {
                        String m;
                        while ((m = csv.readLine()) != null) {
                            al.add(new Student(m));
                        }
                        csv.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (month == 3) {
                    BufferedReader csv = new BufferedReader(new FileReader("C:\\Users\\Sam\\IdeaProjects\\OOP_Project_Attendance_Tracker\\src\\Attendance - August.csv"));
                    String csvsplit = ",";
                    try {
                        String m;
                        while ((m = csv.readLine()) != null) {
                            al.add(new Student(m));
                        }
                        csv.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                String roll_no;
                if (s == 1) {
                    System.out.print("ENTER ROLL NO : ");
                    roll_no = scan.nextLine();
                    System.out.println();
                    if (User.validate_reg(roll_no) == true) {
                        int sub = Integer.parseInt(roll_no.substring(4));
                        if (sub <= 18) {
                            al.get(sub - 1).view_attendance_student();
                        } else if (sub >= 20 && sub <= 24) {
                            al.get(sub - 2).view_attendance_student();
                        } else {
                            al.get(sub - 3).view_attendance_student();
                        }
                    } else {
                        throw new InvalidRollNoException("INVALID ROLL NO");
                    }
                } else if (s == 2) {
                    System.out.print("ENTER ROLL NO : ");
                    roll_no = scan.nextLine();
                    int sub = Integer.parseInt(roll_no.substring(6));
                    if (User.validate_ias(roll_no)) {
                        al.get((al.size() - 1) - (17 - sub)).view_attendance_student();
                    } else {
                        throw new InvalidRollNoException("INVALID ROLL NO");
                    }
                } else {
                    throw new Exception("INVALID CHOICE");
                }
            } else if (choice == 2) {
                ArrayList<Faculty1> af = new ArrayList<Faculty1>();
                Faculty1 fu;
                System.out.println("        ----------FACULTY LOGIN----------");
                System.out.println("ENTER :");
                System.out.println("        1-REGULAR");
                System.out.println("        2-IAS");

                int s = Integer.parseInt(scan.nextLine());
                System.out.println("    ----------MONTH----------");
                System.out.println("ENTER : ");
                System.out.println("    1.OCTOBER");
                System.out.println("    2.SEPTEMBER");
                System.out.println("    3.AUGUST");
                int month = Integer.parseInt(scan.nextLine());
                if (month == 1) {
                    BufferedReader csv = new BufferedReader(new FileReader("C:\\Users\\Sam\\IdeaProjects\\OOP_Project_Attendance_Tracker\\src\\Attendance - October.csv"));
                    String csvsplit = ",";
                    try {
                        String m;
                        while ((m = csv.readLine()) != null) {
                            af.add(new Faculty1(m));
                        }
                        csv.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (month == 2) {
                    BufferedReader csv = new BufferedReader(new FileReader("C:\\Users\\Sam\\IdeaProjects\\OOP_Project_Attendance_Tracker\\src\\Attendance - September.csv"));
                    String csvsplit = ",";
                    try {
                        String m;
                        while ((m = csv.readLine()) != null) {
                            af.add(new Faculty1(m));
                        }
                        csv.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (month == 3) {
                    BufferedReader csv = new BufferedReader(new FileReader("C:\\Users\\Sam\\IdeaProjects\\OOP_Project_Attendance_Tracker\\src\\Attendance - August.csv"));
                    String csvsplit = ",";
                    try {
                        String m;
                        while ((m = csv.readLine()) != null) {
                            af.add(new Faculty1(m));
                        }
                        csv.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                String roll_no;
                String code;
                System.out.print("ENTER COURSE CODE: ");
                code = scan.nextLine();
                System.out.println();
                if (User.validate_staff(code) == true) {
                    int sub = Integer.parseInt(code.substring(4));
                    if (s == 1) {
                        System.out.print("ENTER ROLL NO : ");
                        roll_no = scan.nextLine();
                        System.out.println();
                        if (User.validate_reg(roll_no) == true) {
                            int subs = Integer.parseInt(roll_no.substring(4));
                            if(subs<=18) {
                                af.get(subs - 1).view_attendance_student(code);
                            }
                            else if(subs>=20 && subs<=24)
                            {
                                af.get(subs-2).view_attendance_student(code);
                            }
                            else
                            {
                                af.get(subs-3).view_attendance_student(code);
                            }
                        } else {
                            throw new InvalidRollNoException("INVALID ROLL NO");
                        }
                    } else if (s == 2) {
                        System.out.print("ENTER ROLL NO : ");
                        roll_no = scan.nextLine();
                        int subj = Integer.parseInt(roll_no.substring(6));
                        if (User.validate_ias(roll_no)) {
                            af.get((af.size() - 1) - (17 - subj)).view_attendance_student(code);
                        } else {
                            throw new InvalidRollNoException("INVALID ROLL NO");
                        }
                    } else {
                        throw new Exception("INVALID CHOICE");
                    }
                }
            } else {
                throw new Exception("INVALID CHOICE");
            }
        }
        catch (InvalidRollNoException e) {
            System.out.println(e);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}




