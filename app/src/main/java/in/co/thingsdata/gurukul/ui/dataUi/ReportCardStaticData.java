package in.co.thingsdata.gurukul.ui.dataUi;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import in.co.thingsdata.gurukul.data.common.Student;

/**
 * Created by Ritika on 2/18/2017.
 */
public class ReportCardStaticData {

    public static ArrayList<Student> mStudentList = null;
    private static String classOfStudent ,section,typeOfExam,regId,classRoomId;

    public enum buttonType{
        viewBtn,
        uploadBtn
    }

    public static buttonType clickedButton =  buttonType.viewBtn;
    public static int year;

    public static void setSelectedClass(String data){
        classOfStudent = data;
    }

    public static void setRegistrationId(String data){
        regId = data;
    }

    public static  void setSelectedSection(String data){
        section = data;
    }

    public static  void setSelectedYear(int data){
        year = data;
    }

    public static  void setSelectedClassRoomId(String data){
        classRoomId = data;
    }



    public static  void setSelectedTypeOfExam(String data){
        typeOfExam = data;
    }

    public static  String  getSelectedClass(){
        return classOfStudent;
    }

    public static  String  getSelectedClassRoomId(){
        return classRoomId;
    }

    public  static int  getSelectedYear(){
        return year;
    }

    public static String  getSelectedSection(){
        return section;
    }

    public static String  getSelectedTypeOfExam(){
        return typeOfExam;
    }

    public static String getRegId(){
        return regId;
    }


    private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);

    /**
     * Generate a value suitable for use in {@link # setId(int)}.
     * This value will not collide with ID values generated at build time by aapt for R.id.
     *
     * @return a generated ID value
     */
    public static int generateViewId() {
        for (;;) {
            final int result = sNextGeneratedId.get();
            // aapt-generated IDs have the high byte nonzero; clamp to the range under that.
            int newValue = result + 1;
            if (newValue > 0x00FFFFFF) newValue = 1; // Roll over to 1, not 0.
            if (sNextGeneratedId.compareAndSet(result, newValue)) {
                return result;
            }
        }
    }

}
