package in.co.thingsdata.gurukul.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import in.co.thingsdata.gurukul.R;
import in.co.thingsdata.gurukul.ui.ReportCardUi.ReportCardSingleStudent;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }

    public void launchReportCard(View view) {

        Intent launchFeature = new Intent(this, ReportCardSingleStudent.class);
        startActivity(launchFeature);

    }
}
