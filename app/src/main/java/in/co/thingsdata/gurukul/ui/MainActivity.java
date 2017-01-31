package in.co.thingsdata.gurukul.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import in.co.thingsdata.gurukul.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dashboard (View v){
        Intent it = new Intent(this, Dashboard.class);
        startActivity(it);
    }
}
