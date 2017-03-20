package in.co.thingsdata.gurukul.ui.dataUi;

import java.io.Serializable;

/**
 * Created by Ritika on 3/20/2017.
 */
public class NoticeBoardModel implements Serializable {

    private String mClassname;
    private boolean isSelected;
    public NoticeBoardModel(String argClassName, boolean isSelected){
        mClassname = argClassName;
        this.isSelected = isSelected;
    }

    public String getClassName() {
        return mClassname;
    }

    public void setClassName(String name) {
        mClassname = name;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }
}
