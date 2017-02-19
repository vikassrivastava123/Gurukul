package in.co.thingsdata.gurukul.data;

import java.util.ArrayList;

import in.co.thingsdata.gurukul.data.common.Student;

/**
 * Created by Vikas on 2/10/2017.
 */

public class GetStudentListInClassData {
    private String mAccessToken;
    private int mClass;
    private int mSection;

    private ArrayList<Student> mStudentList = new ArrayList<>();

    public GetStudentListInClassData(String token, int c, int sec){
        mAccessToken = token; mClass = c; mSection = sec;
    }

    public String getAccessToken(){return mAccessToken;}
    public int getClassId(){return mClass;}
    public int getSectionId(){return mSection;}

    public void addStudent(Student s){
        mStudentList.add(s);
    }
    public int getTotalNumberOfStudent(){return  mStudentList.size();}
    public ArrayList<Student> getStudentListInClass(){

        return mStudentList;}
}
