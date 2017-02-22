package in.co.thingsdata.gurukul.data.common;

/**
 * Created by Vikas on 2/10/2017.
 */

public final class Subject {
    private String mId;
    private String mName;
    private int mClass;  //Class ID in which the subject it being taught, if single subject is
                            // Being taught in multiple classes it shall have multiple object.

    public Subject (String id, String name, int class_id){
        mId = id;
        mClass = class_id;
        mName = name;
    }

    public int getClassId (){return mClass;}
    public String getSubjectId(){return mId;}
    public String getSubjectName(){return mName;}
}
