package in.co.thingsdata.gurukul.ui.ReportCardUi;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.List;

import in.co.thingsdata.gurukul.R;
import in.co.thingsdata.gurukul.data.GetSubjectListData;
import in.co.thingsdata.gurukul.data.MarkSheetData;
import in.co.thingsdata.gurukul.data.SubjectWiseMarks;
import in.co.thingsdata.gurukul.data.common.Subject;
import in.co.thingsdata.gurukul.data.common.UserData;
import in.co.thingsdata.gurukul.services.helper.CommonRequest;
import in.co.thingsdata.gurukul.services.request.GetSubjectListReq;
import in.co.thingsdata.gurukul.services.request.SubmitMarkSheetReq;
import in.co.thingsdata.gurukul.ui.MainActivity;
import in.co.thingsdata.gurukul.ui.dataUi.DataOfUi;
import in.co.thingsdata.gurukul.ui.dataUi.ReportCardData;
import in.co.thingsdata.gurukul.ui.dataUi.ReportCardStaticData;

public class ReportCardCreate extends AppCompatActivity implements GetSubjectListReq.GetSubjectListResponse ,
        SubmitMarkSheetReq.SubmitMarkSheetCallback {

    private List<DataOfUi> dataList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ReportCardAdapter mAdapter;
    HorizontalScrollView addSubjectView;
    RelativeLayout layout;
    int editBOxId = 1;
    int indexOfStudentSel = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rc_create);
      /*  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
*/

        Intent selKid = this.getIntent();
        indexOfStudentSel = selKid.getIntExtra(getResources().getString(R.string.intent_extra_posInList),0);
        fillSubjectListData();

    }


    GetSubjectListData data;

    void fillSubjectListData(){
        String token = UserData.getAccessToken();
        String classOfSt =  ReportCardStaticData.getSelectedClass();

        data = new GetSubjectListData(token,Integer.parseInt(classOfSt));
        GetSubjectListReq req = new GetSubjectListReq(ReportCardCreate.this,data,ReportCardCreate.this);

        req.executeRequest();


    }

    int getNumberOfSubjects(){
      return receivedSubjMakrs.size();
    }

    void createDynamicLayout(){
        final ScrollView addDynamicLayoutToScrollView =  new ScrollView(ReportCardCreate.this);
        addDynamicLayoutToScrollView.setLayoutParams
                (new ScrollView.LayoutParams(ScrollView.LayoutParams.MATCH_PARENT, ScrollView.LayoutParams.MATCH_PARENT));
        addDynamicLayoutToScrollView.removeAllViews();

        layout = (RelativeLayout) findViewById(R.id.addSubjectRl);
        layout.removeAllViews();

        final RelativeLayout layoutTest = new RelativeLayout(this);
        layoutTest.setLayoutParams(new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));
        layoutTest.removeAllViews();

        {
            int rows = getNumberOfSubjects();
            int columns = 3;
            float x =  TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100, getResources().getDisplayMetrics());
            float y =  TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 70, getResources().getDisplayMetrics());
            float marginall =  TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics());
            float rowHt =  TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100, getResources().getDisplayMetrics());
            //@Override
            //public void run()
            {
                int rowIterator = 0;
                int lastRowId = 0;
                for(;rowIterator<rows;rowIterator++) {

                    final RelativeLayout row = new RelativeLayout(ReportCardCreate.this);
                    row.removeAllViews();
                 //   row.setLayoutParams
                   //         (new RelativeLayout.LayoutParams(300, RelativeLayout.LayoutParams.MATCH_PARENT));

                    RelativeLayout.LayoutParams rowLp = new RelativeLayout.LayoutParams(new ViewGroup.LayoutParams(
                            RelativeLayout.LayoutParams.MATCH_PARENT,
                            (int)rowHt));

                    int  rowId = rowIterator;

                    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
                        rowId =  ReportCardStaticData.generateViewId();
                    } else {
                        rowId = View.generateViewId();
                    }

                    row.setId(rowId);

                    if(lastRowId!=0){
                        rowLp.addRule(RelativeLayout.BELOW, lastRowId);
                    }
                    lastRowId = rowId;
                    rowLp.setMargins((int)marginall, (int)marginall, (int)marginall, (int)marginall);
                    row.setLayoutParams(rowLp);
                    //row.setOrientation(LinearLayout.HORIZONTAL);

                    String ID[] = new String[] {"Subject","MarksObt","Total"};
                    int indexOfId = 0;
                    int lastEditBoxId = 0;
                    for(int j = 0;j<columns;j++){
                        EditText et = new EditText(ReportCardCreate.this);
                        if(j == 0) {
                            et.setEnabled(false);
                        }

                        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(new ViewGroup.LayoutParams(
                                (int)x,
                                (int)y));

                        if(indexOfId > 2){
                            indexOfId = 0;
                        }


                        if (indexOfId == 0){
                            et.setText(receivedSubjMakrs.get(rowIterator).getSubjectName());
                            et.setTag(R.id.subject_id , receivedSubjMakrs.get(rowIterator).getSubjectId());

                        }else if (indexOfId == 1){
                            et.setText("0");
                        }else if (indexOfId == 2){
                            et.setText("100");
                        }

                        int editBoxIdGen = 0;
                        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
                            editBoxIdGen =  ReportCardStaticData.generateViewId();
                        } else {
                            editBoxIdGen = View.generateViewId();
                        }
                        editBOxId++;
                        et.setId(editBoxIdGen);
                        et.setTag(ID[indexOfId]);

                        indexOfId++;

                        if(indexOfId > 0) {
                            lp.addRule(RelativeLayout.RIGHT_OF
                                    , lastEditBoxId);
                        }
                        lastEditBoxId = editBoxIdGen;
                        lp.setMargins(10, 0, 10, 0);
                        et.setLayoutParams(lp);
                        row.addView(et);

                    }
                    layoutTest.addView(row);

                }

                //setContentView(layout);
            }

            addDynamicLayoutToScrollView.addView(layoutTest);
            layout.addView(addDynamicLayoutToScrollView);
        }//, 500);


    }

    MarkSheetData subMitMarkdata = null;
    SubjectWiseMarks subWiseMarks = null;

    public void addSubject() {

        int count = layout.getChildCount();
        ScrollView viewScrol = (ScrollView)layout.getChildAt(0);
        count = viewScrol.getChildCount();

        RelativeLayout row = (RelativeLayout)viewScrol.getChildAt(0);
        count = row.getChildCount();

        ReportCardData rcData = (ReportCardData)MainActivity.dataList.get(indexOfStudentSel);
        int rolnum = rcData.getRollNumber();
        String regNum = rcData.getRegistrationNumber();


        subMitMarkdata = new MarkSheetData(UserData.getAccessToken(),rolnum,ReportCardStaticData.getSelectedYear(),
                ReportCardStaticData.getSelectedTypeOfExam(),regNum);

        for (int i = 0; i < count; i++) {

            RelativeLayout oneRow = (RelativeLayout) row.getChildAt(i);
            int innerChildCount = oneRow.getChildCount();
            String sub = null; int total = 0; int marks = 0;

            for (int y = 0; y < innerChildCount; y++) {
                final View edtText = oneRow.getChildAt(y);
                String subId = null;
                if (edtText instanceof EditText) {//"Subject","MarksObt","Total"

                    if(edtText.getTag().equals("Total")) {//total
                        String strTotal = ((EditText) edtText).getText().toString();
                        total = Integer.parseInt(strTotal);
                        Log.d("test", "String " + data);
                    }else if(edtText.getTag().equals("MarksObt")) {//these will be marks obtained
                        String strMarks = ((EditText) edtText).getText().toString();
                        marks = Integer.parseInt(strMarks);
                        Log.d("testasa", "marks " + marks);
                    }
                    else if(edtText.getTag().equals("Subject")) {//these will be subject
                        sub = ((EditText) edtText).getText().toString();
                        subId = (String)edtText.getTag();
                        subId = (String)edtText.getTag(R.id.subject_id);

                        Log.d("testasa", "sub " + sub);
                        Log.d("testasa", "sub-id " + subId);
                    }
                }

                Subject subObj = new Subject(subId,sub,Integer.parseInt(ReportCardStaticData.getSelectedClass()));
                SubjectWiseMarks addSub = new SubjectWiseMarks(subObj,total,marks);
                subMitMarkdata.addMarksInSubject(addSub);

            }
        }
        submitMarkSheetCreated();
     }
    final static String TAG = "ReportCardCreate";
    ArrayList<Subject> receivedSubjMakrs;
    @Override
    public void onGetSubjectListResponse(CommonRequest.ResponseCode res, GetSubjectListData data) {

        if(res == CommonRequest.ResponseCode.COMMON_RES_SUCCESS){

            try {
                receivedSubjMakrs = data.getSubjectList();
                createDynamicLayout();
            }catch(Exception e){
                Log.d(TAG,"Error in parsing of received data");
            }
        }


    }

    void submitMarkSheetCreated(){

        SubmitMarkSheetReq req = new SubmitMarkSheetReq(ReportCardCreate.this,subMitMarkdata,this);
        req.executeRequest();

    }

    @Override
    public void onSubmitMarksResponse(CommonRequest.ResponseCode res, MarkSheetData data) {
        Log.d(TAG, "response :" + res);
        switch (res) {
            case COMMON_RES_SUCCESS:
                break;
            default:
                break;
        }


    }

    public void executeSubjectQuery(View view) {
        addSubject();
    }

    public void cancelSubjectQuery(View view) {

        new AlertDialog.Builder(ReportCardCreate.this)
                .setTitle("Cancel Create ReportCard")
                .setMessage("Are you sure you want to quit?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}
