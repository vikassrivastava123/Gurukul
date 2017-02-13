package in.co.thingsdata.gurukul.ui.ReportCardUi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import in.co.thingsdata.gurukul.R;
import in.co.thingsdata.gurukul.data.GetStudentListInClassData;
import in.co.thingsdata.gurukul.services.helper.CommonRequest;
import in.co.thingsdata.gurukul.services.request.GetStudentListInClassReq;
import in.co.thingsdata.gurukul.ui.dataUi.DataOfUi;
import in.co.thingsdata.gurukul.ui.dataUi.ReportCardData;

public class ReportCardTeacherView extends AppCompatActivity implements GetStudentListInClassReq.GetStudentListInClassCallback{

    private List<DataOfUi> dataList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ReportCardAdapter mAdapter;
    TextView mTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rc_teacher_view);


/*        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
      //  toolbar.bringToFront();
        setSupportActionBar(toolbar);


        mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        Typeface mycustomFont=Typeface.createFromAsset(getAssets(),"fonts/Montserrat-Regular.otf");
        mTitle.setTypeface(mycustomFont);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
                finish();
                //Intent intent = new Intent(getBaseContext(),HomeScreenFirstLogin.class);
                //startActivity(intent);
            }
        });

*/



        mAdapter = new ReportCardAdapter(dataList,ReportCardAdapter.TEACHER_VIEW_REPORTCARD);

        recyclerView = (RecyclerView)findViewById(R.id.singleStudentMarks);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareMovieData();

        initAutoTextView();

    }

    @Override
    public void onGetStudentListResponse(CommonRequest.ResponseCode res, GetStudentListInClassData data) {

    }


    void prepareMovieData(){

        ReportCardData data = new ReportCardData("name 1",1);

        dataList.add(data);

        data =  new ReportCardData("name 2",2);
        dataList.add(data);

        data =  new ReportCardData("name 3",3);
        dataList.add(data);

        data =  new ReportCardData("name 4",4);
        dataList.add(data);

        mAdapter.notifyDataSetChanged();
    }

    public void executeResultQuery(View view) {

        //GetStudentListInClassData data = new GetStudentListInClassData();
        //GetStudentListInClassReq req = new GetStudentListInClassReq(this,data,this);

        prepareMovieData();

    }

    void initAutoTextView(){

        AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.searchList);
        textView.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                if(mAdapter != null) {
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

}
