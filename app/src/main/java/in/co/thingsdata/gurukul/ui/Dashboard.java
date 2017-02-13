package in.co.thingsdata.gurukul.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import in.co.thingsdata.gurukul.R;
import in.co.thingsdata.gurukul.ui.ReportCardUi.ReportCardLaunch;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }

    public void launchReportCard(View view) {

        Intent launchFeature = new Intent(this, ReportCardLaunch.class);
        startActivity(launchFeature);

    }
}
