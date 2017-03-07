package in.co.thingsdata.gurukul.data.common;

import java.util.ArrayList;

/**
 * Created by Vikas on 2/10/2017.
 */

public final class CommonDetails {

    private static ArrayList<ClassData> mClasses = new ArrayList<>();

    public enum NotificationTypeEnum  {
        NOTIFICATION_TYPE_NORMAL, // Used for the day which don't exist like 30 FEB.
        NOTIFICATION_TYPE_VOTE,

        NOTIFICATION_TYPE_END // WARNING: Add all attendance value above this line only
    }

    public enum NotificationReplyEnum  {
        NOTIFICATION_REPLY_YES, // Used for the day which don't exist like 30 FEB.
        NOTIFICATION_REPLY_NO,
        NOTIFICATION_REPLY_READ,
        NOTIFICATION_REPLY_PENDING,

        NOTIFICATION_REPLY_END // WARNING: Add all attendance value above this line only
    }

    public static final String EXAM_TYPE_HALF_YEARLY = "HALF_YEARLY";
    public static final String EXAM_TYPE_YEARLY = "YEARLY";

    public static final String USER_TYPE_STUDENT = "STUDENT";
    public static final String USER_TYPE_TEACHER = "TEACHER";
    public static final String USER_TYPE_PARENT = "PARENT";
    public static final String USER_TYPE_PRINCIPAL = "PRINCIPAL";

    public static final String USER_GENDER_MALE= "MALE";
    public static final String USER_GENDER_FEMALE = "FEMALE";


    public static ArrayList<ClassData> getAllClassesInSchool(){return mClasses;}
    public static int getTotalNumberOfClasses(){return mClasses.size();}
    public static void addClass(ClassData c){mClasses.add(c);}

}
