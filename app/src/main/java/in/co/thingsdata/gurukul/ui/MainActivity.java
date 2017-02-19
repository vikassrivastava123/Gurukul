package in.co.thingsdata.gurukul.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import in.co.thingsdata.gurukul.R;
import in.co.thingsdata.gurukul.ui.dataUi.DataOfUi;

public class MainActivity extends AppCompatActivity {

    public static List<DataOfUi> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dashboard (View v){
        Intent it = new Intent(this, Dashboard.class);
        startActivity(it);
    }

    public static List<DataOfUi> getDataList(){
        return dataList;
    }

    public static void setDataList(List<DataOfUi> data){

         dataList = data;
    }

}
