package in.co.thingsdata.gurukul.ui.ReportCardUi;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

import in.co.thingsdata.gurukul.R;
import in.co.thingsdata.gurukul.data.GetStudentListInClassData;
import in.co.thingsdata.gurukul.data.common.UserData;
import in.co.thingsdata.gurukul.services.helper.CommonRequest;
import in.co.thingsdata.gurukul.services.request.GetStudentListInClassReq;
import in.co.thingsdata.gurukul.ui.MainActivity;
import in.co.thingsdata.gurukul.ui.dataUi.ReportCardData;
import in.co.thingsdata.gurukul.ui.dataUi.ReportCardStaticData;

public class ReportCardTeacherView extends AppCompatActivity implements GetStudentListInClassReq.GetStudentListInClassCallback{

    private RecyclerView mRecyclerView = null;
    private ReportCardAdapter mAdapter = null;
    TextView mTitle;
    Button findButton ,upLoadButton;
    AutoCompleteTextView searchList;
    android.support.v7.widget.CardView headerOfList;
    static  final String TAG = "ReportCardTeacherView";
   // ArrayList<Student>  mStudentList = null;
    String classEntered,sectionEntered,yearEntered,typeOfExamcEntered;
    AutoCompleteTextView classTv , sectionTv, yearTv, typeOfExamTv;
int rollNum = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rc_teacher_view);
        initRes();
        fillPrevEnteredadat();
        initAutoTextView();


        mAdapter = new ReportCardAdapter(MainActivity.dataList,ReportCardAdapter.TEACHER_VIEW_REPORTCARD
                , new ReportCardAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(View view, int position) {

                Intent start = new Intent(ReportCardTeacherView.this,ReportCardSingleStudent.class);
                start.putExtra(getResources().getString(R.string.intent_extra_posInList),position);

                startActivity(start);

               ///list item was clicked
            }




        });

        mRecyclerView = (RecyclerView)findViewById(R.id.singleStudentMarks);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);


/*        if(ReportCardStaticData.mStudentList != null) {
            fillPrevEnteredadat();
            initRecyclerView();
            executeResultQuery();
        }*/

    }



    void onClickImplimentation(){





        if(mRecyclerView != null) {

          /*  ItemClickSupport.addTo(mRecyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                @Override
                public void onItemClicked(RecyclerView recyclerView, int position, View v) {

                    RecyclerView.ViewHolder holder = mRecyclerView.getChildViewHolder(v);
                    holder.itemView.setBackgroundColor(Color.parseColor("#76767"));
                    Log.d(TAG, "item clicked:" + position);

                }

            });*/
        }

    }


    void initRecyclerView(){
        if(mAdapter == null) {
            mAdapter = new ReportCardAdapter(MainActivity.dataList, ReportCardAdapter.TEACHER_VIEW_REPORTCARD , new ReportCardAdapter.OnItemClickListener() {

                @Override
                public void onItemClick(View view, int position) {
                     Log.d("asas","asasa");
                    ///list item was clicked
                }
            });
        }
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
            mRecyclerView.setItemAnimator(new DefaultItemAnimator());
            mRecyclerView.setAdapter(mAdapter);





    }


    @Override
    public void onGetStudentListResponse(CommonRequest.ResponseCode res, GetStudentListInClassData data) {
        ReportCardData dataStudentListForAdapter = null;
        switch (res){

            case COMMON_RES_SUCCESS:
                ReportCardStaticData.mStudentList = data.getStudentListInClass();

                //if(ReportCardStaticData.mStudentList == null && ReportCardStaticData.mStudentList.size() ==0)
                {
                    prepareMovieData();
                }
/*                for(Student obj: ReportCardStaticData.mStudentList){

                     String name = obj.getName();
                     int rollNumber = obj.getRollNumber();
                     dataStudentListForAdapter = new ReportCardData(name,rollNumber);
                     MainActivity.dataList.add(dataStudentListForAdapter);

                }*/


                break;
            default:
                break;
        }


    }


    void prepareMovieData(){

        ReportCardData data = new ReportCardData("argsubject3",1);
        MainActivity.dataList.add(data);

        data =  new ReportCardData("secondubject3",2);
        MainActivity.dataList.add(data);

        data =  new ReportCardData("thoredsubject3",3);
        MainActivity.dataList.add(data);

        data =  new ReportCardData("fourthsubject3",4);
        MainActivity.dataList.add(data);

        data =  new ReportCardData("secondubject3",2);
        MainActivity.dataList.add(data);

        data =  new ReportCardData("thoredsubject3",3);
        MainActivity.dataList.add(data);

        data =  new ReportCardData("fourthsubject3",4);
        MainActivity.dataList.add(data);

        data =  new ReportCardData("secondubject3",2);
        MainActivity.dataList.add(data);

        data =  new ReportCardData("thoredsubject3",3);
        MainActivity.dataList.add(data);

        data =  new ReportCardData("fourthsubject3",4);
        MainActivity.dataList.add(data);

        mAdapter.notifyDataSetChanged();

    }

    public void executeResultQuery() {

        String token = UserData.getAccessToken();
        GetStudentListInClassData data = new GetStudentListInClassData(token,7,2);
        GetStudentListInClassReq req = new GetStudentListInClassReq(this,data,this);

        req.executeRequest();

        //prepareMovieData();

    }

    void initAutoTextView(){

        AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.searchList);
        textView.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                if (mAdapter != null) {
                    mAdapter.getFilter().filter(cs);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int arg1, int arg2, int arg3) {

            }

            @Override
            public void afterTextChanged(Editable arg0) {

            }

        });

    }


    void initRes(){

        headerOfList = (android.support.v7.widget.CardView)findViewById(R.id.headerOfList);
        mRecyclerView = (RecyclerView)findViewById(R.id.singleStudentMarks);
        searchList = (AutoCompleteTextView)findViewById(R.id.searchList);
        findButton = (Button)findViewById(R.id.findButton);
        upLoadButton = (Button)findViewById(R.id.uploadButton);


        classTv =  (AutoCompleteTextView)findViewById(R.id.autocomplete_class);
        sectionTv =  (AutoCompleteTextView)findViewById(R.id.autocomplete_section);
        yearTv =  (AutoCompleteTextView)findViewById(R.id.autocomplete_year);
        typeOfExamTv =  (AutoCompleteTextView)findViewById(R.id.autocomplete_type);
    }

    void fillPrevEnteredadat(){

        try{
            classTv.setText(ReportCardStaticData.getSelectedClass());
            sectionTv.setText(ReportCardStaticData.getSelectedSection());
            yearTv.setText(ReportCardStaticData.getSelectedYear());
            typeOfExamTv.setText(ReportCardStaticData.getSelectedTypeOfExam());
        }catch(Resources.NotFoundException | NullPointerException ed){
            Log.d(TAG,"fillPrevEnteredadat ERROR");
        }
    }


    void setVisibilityOfComponents(int visibility){
        mRecyclerView.setVisibility(visibility);
        headerOfList.setVisibility(visibility);
        searchList.setVisibility(visibility);


    }

    void getTextEnteredByUser(){

        try {
            classEntered = classTv.getText().toString();
            ReportCardStaticData.setSelectedClass(classEntered);

            sectionEntered = sectionTv.getText().toString();
            ReportCardStaticData.setSelectedSection(sectionEntered);

            yearEntered = yearTv.getText().toString();
            ReportCardStaticData.setSelectedYear(Integer.parseInt(yearEntered));

            typeOfExamcEntered = typeOfExamTv.getText().toString();
            ReportCardStaticData.setSelectedSection(typeOfExamcEntered);
        }catch (Exception e){
            Log.d(TAG,"AutoComplete resources null");
        }


    }



    public void executeFindQuery(View view) {
        setVisibilityOfComponents(View.VISIBLE);
        getTextEnteredByUser();

        initRecyclerView();
        executeResultQuery(); //we need to show student list . when teacher clicks particular student show his results

    }

    public void executeUploadQuery(View view) {
        setVisibilityOfComponents(View.VISIBLE);
        getTextEnteredByUser();
        initRecyclerView();

    }
}
