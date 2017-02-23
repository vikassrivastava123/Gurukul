package in.co.thingsdata.gurukul.data.common;

/**
 * Created by Vikas on 2/10/2017.
 */

public final class CommonDetails {
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

    public static final int CLASS_PRE_NURSERY = -1;
    public static final int CLASS_NURSERY = 0;
    public static final int CLASS_1 = 1;
    public static final int CLASS_2 = 2;
    public static final int CLASS_3 = 3;
    public static final int CLASS_4 = 4;
    public static final int CLASS_5 = 5;
    public static final int CLASS_6 = 6;
    public static final int CLASS_7 = 7;
    public static final int CLASS_8 = 8;
    public static final int CLASS_9 = 9;
    public static final int CLASS_10 = 10;
    public static final int CLASS_11 = 11;
    public static final int CLASS_12 = 12;

    public static final String SECTION_A = "A";
    public static final String SECTION_B = "B";
    public static final String SECTION_C = "C";
    public static final String SECTION_D = "D";
    public static final String SECTION_INVALID = "INVALID";

    public static final String EXAM_TYPE_HALF_YEARLY = "HALF_YEARLY";
    public static final String EXAM_TYPE_YEARLY = "YEARLY";

    public static final String USER_TYPE_STUDENT = "STUDENT";
    public static final String USER_TYPE_TEACHER = "TEACHER";
    public static final String USER_TYPE_PARENT = "PARENT";
    public static final String USER_TYPE_PRINCIPAL = "PRINCIPAL";

    public static final String USER_GENDER_MALE= "MALE";
    public static final String USER_GENDER_FEMALE = "FEMALE";

}
