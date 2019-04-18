public class StudentUser extends User
{
    private String university;
    private String subjectStudying;

    public StudentUser(String firstName, String lastName, String university, String subjectStudying)
    {
        super(firstName, lastName);
        this.university = university;
        this.subjectStudying = subjectStudying;
    }

    public String getUniversity()
    {
        return university;
    }

    public void setUniversity(String university)
    {
        this.university = university;
    }

    public String getSubjectStudying()
    {
        return subjectStudying;
    }

    public void setSubjectStudying(String subjectStudying)
    {
        this.subjectStudying = subjectStudying;
    }

    @Override
    public String toString()
    {
        return super.toString() + ", University= " + university + ", Subject= " + subjectStudying;
    }
}
