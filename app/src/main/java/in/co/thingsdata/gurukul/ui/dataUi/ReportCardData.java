package in.co.thingsdata.gurukul.ui.dataUi;

/**
 * Created by Ritika on 2/10/2017.
 */
public class ReportCardData extends DataOfUi {

    public ReportCardData(){

    }

    public ReportCardData(String argsubject , String argmarksObtained, String argtotal, String argpercentage){

        subject = argsubject ; marksObtained = argmarksObtained; total = argtotal;
        percentage = argpercentage;

    }

    String subject = null , marksObtained = null , total = null , percentage = null;

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

}
