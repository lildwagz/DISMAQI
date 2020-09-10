package ei.eseptiyadi.dismaqi.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import ei.eseptiyadi.dismaqi.R;

public class DataAccess extends AppCompatActivity {

    Calendar calendar;
    TextView DateUpdate,TimeUpdate , TvRoles;
    String dayName, currentDate;
    EditText EdRoles,Jenjang, Kelas ,Jurusan, TahunAjaran;
    Button Approve, Revert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_access);
        Thread myThread = null;
        Runnable runnable = new CountDownRunner();
        myThread= new Thread(runnable);

        TvRoles = (TextView)findViewById(R.id.Tv_roles);
        EdRoles = (EditText)findViewById(R.id.Ed_Roles);
        Jenjang = (EditText)findViewById(R.id.Ed_Jenjang);
        Kelas = (EditText)findViewById(R.id.Ed_Kelas);
        Jurusan = (EditText)findViewById(R.id.Ed_Jurusan);
        TahunAjaran = (EditText)findViewById(R.id.Ed_Roles);

        DateUpdate = (TextView)findViewById(R.id.Tv_date);
        TimeUpdate = (TextView)findViewById(R.id.Tv_time);

        calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
        currentDate = sdf.format(calendar.getTime());

        SimpleDateFormat sdf_ = new SimpleDateFormat("EEEE");
        Date date = new Date();
        dayName = sdf_.format(date);
        DateUpdate.setText("" + dayName+", "+currentDate);




        myThread.start();
        autoFill();

    }

    public void autoFill(){
        EdRoles.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                String Roles = EdRoles.getText().toString();
                TvRoles.setText(Roles);

            }
        });

    }


    public void doWork() {
        runOnUiThread(new Runnable() {
            public void run() {
                try{
                    Date dt = new Date();
                    int hours = dt.getHours();
                    int minutes = dt.getMinutes();
                    int seconds = dt.getSeconds();
                    String curTime = hours + ":" + minutes + ":" + seconds;
                    TimeUpdate.setText(curTime);
                }catch (Exception e) {}
            }
        });
    }


    class CountDownRunner implements Runnable{
        // @Override
        public void run() {
            while(!Thread.currentThread().isInterrupted()){
                try {
                    doWork();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }catch(Exception e){
                }
            }
        }
    }
}