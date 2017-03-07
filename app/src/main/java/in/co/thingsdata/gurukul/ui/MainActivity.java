package in.co.thingsdata.gurukul.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import in.co.thingsdata.gurukul.R;
import in.co.thingsdata.gurukul.data.common.ClassData;
import in.co.thingsdata.gurukul.data.common.UserData;
import in.co.thingsdata.gurukul.services.helper.CommonRequest;
import in.co.thingsdata.gurukul.services.request.GetClassListRequest;
import in.co.thingsdata.gurukul.ui.dataUi.DataOfUi;

public class MainActivity extends AppCompatActivity implements GetClassListRequest.GetClassListCallback {

    public static List<DataOfUi> dataList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dashboard (View v){
        Intent it = new Intent(this, Dashboard.class);
        initializeUserData();
        startActivity(it);
    }

    public static List<DataOfUi> getDataList(){
        return dataList;
    }

    public static void setDataList(List<DataOfUi> data){

         dataList = data;
    }

    public void initializeUserData(){
        GetClassListRequest req = new GetClassListRequest(this, this);
        req.executeRequest();
    }

    @Override
    public void onGetClassListResponse(CommonRequest.ResponseCode res, ArrayList<ClassData> classes) {
        if (res == CommonRequest.ResponseCode.COMMON_RES_SUCCESS)
        {
            for (int i=0; i < classes.size(); i++){
                UserData.addClass(classes.get(i));
            }
        }
    }
}
