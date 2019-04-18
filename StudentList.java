import java.util.*;


public class StudentList
{
    private ArrayList<StudentUser> stuList;

    public StudentList()
    {
        this.stuList = new ArrayList<StudentUser>();
        System.out.println("Student List created!");
    }

    public void addStudent(StudentUser studentUser)
    {
        //todo if ID is available add student
        stuList.add(studentUser);
        System.out.println("Student added to list!");
    }

    public void removeStudent(StudentUser studentUser)
    {
        //todo if ID is in the list and list not empty
        stuList.remove(studentUser);
    }

    public void printAllStudents()
    {

        for (StudentUser student : stuList)
        {
            System.out.println(student.toString());
        }

    }



    public int getListSize()
    {
        return this.stuList.size();
    }
}
