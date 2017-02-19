package in.co.thingsdata.gurukul.ui.dataUi;

import in.co.thingsdata.gurukul.ui.ReportCardUi.ReportCardAdapter;

/**
 * Created by Ritika on 2/10/2017.
 */
public class ReportCardData extends DataOfUi {

    String subject = null , marksObtained = null , total = null , percentage = null;

    String name = null; int rollNumber = 0;

    public ReportCardData(String argname , int argrollNumber){

        name = argname;
        rollNumber = argrollNumber;

    }

    public ReportCardData(String argsubject , String argmarksObtained, String argtotal, String argpercentage){

        subject = argsubject ; marksObtained = argmarksObtained; total = argtotal;
        percentage = argpercentage;

    }

    public String getName(){
        return name;
    }

    public int getRollNumber(){
        return rollNumber;
    }

    public void setRollNumber(int argRollNumber){
        rollNumber = argRollNumber;
    }

    public void setName(String data){
        name = data;
    }

    public String getSubject(){
            return subject;
    }

    public void setSubject(String data){
        subject = data;
    }

    public String getMarksObtained(){
        return marksObtained;
    }

    public void setMarksObtained(String data){
          marksObtained = data;
    }

    public String getTotal(){
        return total;
    }

    public void setTotal(String data){
        total = data;
    }

    public String getPercentage(){

        return percentage;
    }

    public void setPercentage(String data){
        percentage = data;
    }

    public void initData(){

    }

    @Override
    public String getFilterableObject(int scrnName) {
        String retVal = null;
        if(scrnName == ReportCardAdapter.SINGLE_STUDENT_REPORTCARD_DETAIL)
            retVal = subject;
        else if(scrnName == ReportCardAdapter.TEACHER_VIEW_REPORTCARD){
            retVal = name;
        }
        return retVal;
    }

    /////
    public static String classOfStudent ,section,year,typeOfExam;
    public static void setSelectedClass(String data){
        classOfStudent = data;
    }

    public static  void setSelectedSection(String data){
        section = data;
    }

    public static  void setSelectedYear(String data){
        year = data;
    }

    public static  void setSelectedTypeOfExam(String data){
        typeOfExam = data;
    }

    public static  String  getSelectedClass(){
        return classOfStudent;
    }

    public  static String  getSelectedYear(){
        return year;
    }

    public static String  getSelectedSection(){
        return section;
    }

    public static String  getSelectedTypeOfExam(){
        return typeOfExam;
    }

    ////


}
