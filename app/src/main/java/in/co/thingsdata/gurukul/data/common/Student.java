package in.co.thingsdata.gurukul.data.common;

/**
 * Created by Vikas on 2/10/2017.
 */

public final class Student {
    private int mStudentId;
    private String mStudentName;
    private int mRollNumber;

    public Student (int id, String name, int roll_num){
        mStudentId = id; mStudentName = name; mRollNumber = roll_num;
    }

    public int getStudentId(){return mStudentId;}
    public int getRollNumber(){return mRollNumber;}
    public String getName(){return mStudentName;}
}
