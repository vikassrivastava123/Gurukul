package in.co.thingsdata.gurukul.ui.ReportCardUi;

import android.content.Intent;
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
import in.co.thingsdata.gurukul.ui.MainActivity;
import in.co.thingsdata.gurukul.ui.dataUi.DataOfUi;
import in.co.thingsdata.gurukul.ui.dataUi.ReportCardData;
import in.co.thingsdata.gurukul.ui.dataUi.ReportCardStaticData;

public class ReportCardSingleStudent extends AppCompatActivity implements GetResultReq.GetResultCallback {

    private List<DataOfUi> dataList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private ReportCardAdapter mAdapter;

    int mTotalMarksObtained  = 80, mTotalMarks = 100;
    float mFinalPer = 0;

    String[] yearArray , typeOfExamArray;
    TextView mName,mClassSection,mRollNumber;
    TextView mMarksObt,mTotal,mPercent;
    AutoCompleteTextView tvYear , tvTypeOfExam;
    int mRolNumber = 0;
    TextView mTitle;
    ReportCardData mSelectedStudent;
    public static String TAG = "ReportCardSingleStudent";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.reportcard_singlestudent);
        initRes();

        Intent intent = getIntent();
        int posInList = intent.getIntExtra(getResources().getString(R.string.intent_extra_rolnumber), 1);

        try {
            mSelectedStudent = (ReportCardData) MainActivity.dataList.get(posInList);
            mName.setText(mSelectedStudent.getName());

            mClassSection.setText(getResources().getText(R.string.classOfStudent) +  ReportCardStaticData.getSelectedClass()
                    + " " + ReportCardStaticData.getSelectedSection());

            mRolNumber = mSelectedStudent.getRollNumber();
            mRollNumber.setText(Integer.toString(mRolNumber));
        }catch(NullPointerException e){
            Log.d(TAG,"Data is null");
        }
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


        mMarksObt = (TextView)findViewById(R.id.totalMarksObtained);
        mTotal = (TextView)findViewById(R.id.totalSumOfMarks);
        mPercent = (TextView)findViewById(R.id.percentageOfMarks);

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

    void setFooter(){
        mMarksObt.setText(Integer.toString(mTotalMarksObtained));
        mTotal.setText(Integer.toString(mTotalMarks));
        mPercent.setText(Float.toString(mFinalPer));
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
    public void onResultResponse(CommonRequest.ResponseCode res, MarkSheetData mrData) {

        /*
        if(res == CommonRequest.ResponseCode.COMMON_RES_SUCCESS){

            try {
                ArrayList<SubjectWiseMarks> receivedSubjMakrs = mrData.getMarkSheet();

                for (SubjectWiseMarks subjMakrs : receivedSubjMakrs) {

                    int marks = subjMakrs.getMarksObtained();
                    int totalMarks = subjMakrs.getTotalMarks();
                    mTotalMarksObtained += marks;
                    mTotalMarks += totalMarks;
                    float percentage = (marks*100)/ totalMarks;

                    ReportCardData data = new ReportCardData(subjMakrs.getSubject().getSubjectName(), Integer.toString(marks),
                            Integer.toString(totalMarks), Float.toString(percentage));
                    dataList.add(data);

                }
            }catch(Exception e){
                Log.d(TAG,"Error in marksheek ");
            }

        }
        mAdapter.notifyDataSetChanged();
        */

        mFinalPer = (mTotalMarksObtained*100)/mTotalMarks;

        setFooter();
        prepareMovieData();

    }

    public void executeResultQuery(View view) {
        String token = UserData.getAccessToken();
        //todo dummy RegistrationId
        MarkSheetData markdata = new MarkSheetData(token,mRolNumber,ReportCardStaticData.getSelectedYear(),ReportCardStaticData.getSelectedTypeOfExam(),"1");
        GetResultReq reqMarkesheet = new GetResultReq(ReportCardSingleStudent.this,markdata,this);

        reqMarkesheet.executeRequest();
    }

    void setDataOfViews(){


    }

}






