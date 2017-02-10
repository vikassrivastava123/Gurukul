package in.co.thingsdata.gurukul.data;

import java.util.ArrayList;

import in.co.thingsdata.gurukul.data.common.Student;
import in.co.thingsdata.gurukul.data.common.Subject;

/**
 * Created by Vikas on 2/10/2017.
 */

public class GetSubjectListData {
    private String mAccessToken;
    private ArrayList<Subject> mSubjectList = new ArrayList<>();

    public GetSubjectListData(String token){
        mAccessToken = token;
    }
    public String getAccessToken(){return mAccessToken;}
    public ArrayList<Subject> getSubjectList(){return mSubjectList;}
    public void addSubject(Subject s){mSubjectList.add(s);}
    public int getTotalNumberOfSubjects(){return mSubjectList.size();}
}
