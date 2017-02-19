package in.co.thingsdata.gurukul.ui.ReportCardUi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import in.co.thingsdata.gurukul.R;
import in.co.thingsdata.gurukul.data.MarkSheetData;
import in.co.thingsdata.gurukul.data.common.UserData;
import in.co.thingsdata.gurukul.services.helper.CommonRequest;
import in.co.thingsdata.gurukul.services.request.GetResultReq;
import in.co.thingsdata.gurukul.ui.dataUi.DataOfUi;
import in.co.thingsdata.gurukul.ui.dataUi.ReportCardData;

public class ReportCardSingleStudent extends AppCompatActivity implements GetResultReq.GetResultCallback {

    private List<DataOfUi> dataList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private ReportCardAdapter mAdapter;

    String[] yearArray , typeOfExamArray;
    TextView mName,mClassSection,mRollNumber;
    AutoCompleteTextView tvYear , tvTypeOfExam;

    TextView mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.reportcard_singlestudent);
        initRes();
        mAdapter = new ReportCardAdapter(dataList,ReportCardAdapter.SINGLE_STUDENT_REPORTCARD_DETAIL , new ReportCardAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(View view, int position) {
                Log.d("asas", "asasa");
                ///list item was clicked
            }
        });



        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);


        initAutotextViewer();
    }


    void initRes(){
        mRecyclerView = (RecyclerView)findViewById(R.id.singleStudentMarks);
        mName = (TextView)findViewById(R.id.enteredNametv);
        mClassSection = (TextView)findViewById(R.id.ClassSection);
        mRollNumber = (TextView)findViewById(R.id.enteredRolNum);
    }


    void initAutotextViewer(){

        yearArray = getResources().getStringArray(R.array.YearOfExam);
        typeOfExamArray = getResources().getStringArray(R.array.TypeOfExam);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, yearArray);
        tvYear = (AutoCompleteTextView)
                findViewById(R.id.autocomplete_year);
        tvYear.setThreshold(0);
        tvYear.setAdapter(adapter);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, typeOfExamArray);
        tvTypeOfExam = (AutoCompleteTextView)
                findViewById(R.id.autocomplete_type);

        tvTypeOfExam.setThreshold(0);
        tvTypeOfExam.setAdapter(adapter2);

   }


    void prepareMovieData(){

        ReportCardData data = new ReportCardData("argsubject","argmarksObtained","argtotal","argpercentage");

        dataList.add(data);

        data =  new ReportCardData("argsubject1","argmarksObtained1","argtotal1","argpercentage1");
        dataList.add(data);

        data =  new ReportCardData("argsubject2","argmarksObtained2","argtotal2","argpercentage2");
        dataList.add(data);

        data =  new ReportCardData("argsubject3","argmarksObtained3","argtotal3","argpercentage3");
        dataList.add(data);

        mAdapter.notifyDataSetChanged();
    }



    @Override
    public void onResultResponse(CommonRequest.ResponseCode res, MarkSheetData data) {

    }

    public void executeResultQuery(View view) {
        String token = UserData.getAccessToken();
           //    MarkSheetData markdata = new MarkSheetData(token,7,2017,);
        //       GetResultReq reqMarkesheet = GetResultReq(this, ,this);

        prepareMovieData();


    }

    void setDataOfViews(){


    }

}






