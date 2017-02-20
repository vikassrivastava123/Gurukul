package in.co.thingsdata.gurukul.ui.dataUi;

import java.util.ArrayList;

import in.co.thingsdata.gurukul.data.common.Student;

/**
 * Created by Ritika on 2/18/2017.
 */
public class ReportCardStaticData {

    public static ArrayList<Student> mStudentList = null;
    public static String classOfStudent ,section,typeOfExam;
    static int year;

    public static void setSelectedClass(String data){
        classOfStudent = data;
    }

    public static  void setSelectedSection(String data){
        section = data;
    }

    public static  void setSelectedYear(int data){
        year = data;
    }

    public static  void setSelectedTypeOfExam(String data){
        typeOfExam = data;
    }

    public static  String  getSelectedClass(){
        return classOfStudent;
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

}
