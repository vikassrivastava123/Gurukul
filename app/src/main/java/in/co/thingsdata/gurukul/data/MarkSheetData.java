package in.co.thingsdata.gurukul.data;

import java.util.ArrayList;

/**
 * Created by Vikas on 2/10/2017.
 */

public class MarkSheetData {
    private String mAccessToken;
    private int mRollNumber;
    private String mRegistrationId;
    private int mYear;
    private String mExamType;
    private ArrayList<SubjectWiseMarks>mMarkSheet = new ArrayList<>();

    public MarkSheetData(String token, int rollNum, int year, String examType, String registrationId){
        mAccessToken = token; mRollNumber = rollNum; mExamType = examType; mYear = year;
        mRegistrationId = registrationId;
    }

    public String getAccessToken(){return mAccessToken;}
    public int getRollNumber(){return mRollNumber;}
    public int getExamYear(){return mYear;}
    public String getExamType(){return mExamType;}
    public String getRegistrationId(){return mRegistrationId;}

    public void addMarksInSubject(SubjectWiseMarks m){mMarkSheet.add(m);}
    public ArrayList<SubjectWiseMarks>getMarkSheet(){return mMarkSheet;}
}
