package in.co.thingsdata.gurukul.ui.ReportCardUi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import in.co.thingsdata.gurukul.R;
import in.co.thingsdata.gurukul.ui.dataUi.DataOfUi;

public class ReportCardCreate extends AppCompatActivity {

    private List<DataOfUi> dataList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ReportCardAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rc_create);
      /*  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
*/

        mAdapter = new ReportCardAdapter(dataList,ReportCardAdapter.CREATE_REPORT_CARD);

        recyclerView = (RecyclerView)findViewById(R.id.singleStudentMarks);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);






    }

    public void addSubject(View view) {
    }
}
