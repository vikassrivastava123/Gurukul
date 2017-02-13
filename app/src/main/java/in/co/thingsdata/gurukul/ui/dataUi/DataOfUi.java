package in.co.thingsdata.gurukul.ui.dataUi;

/**
 * Created by Ritika on 2/10/2017.
 */
public abstract class DataOfUi {

  abstract public String getFilterableObject(int screenName);
  abstract public void setSubject(String data);
  abstract public void setMarksObtained(String data);
  abstract public void setTotal(String data);
  abstract public void setPercentage(String data);

}
