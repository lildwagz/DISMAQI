package ei.eseptiyadi.dismaqi.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import ei.eseptiyadi.dismaqi.R;

public class DashboardMain extends AppCompatActivity {

    TextView hellouser,descriplembaga;
    FloatingActionButton addpenilaian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_main);

        addpenilaian = (FloatingActionButton)findViewById(R.id.fab_addpenilaian);
        hellouser =(TextView)findViewById(R.id.txt_hellouser);
        descriplembaga =(TextView)findViewById(R.id.txt_descriplembaga);

        addpenilaian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), DataAccess.class));
                finish();
            }
        });
    }
}