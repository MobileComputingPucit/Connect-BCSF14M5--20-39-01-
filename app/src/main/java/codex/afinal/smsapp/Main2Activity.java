package codex.afinal.smsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    TextView tv;
    Button btn;
    EditText e1,e2;
    DatabaseHelper helper=new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv=(TextView) findViewById(R.id.hello);
        btn= (Button)findViewById(R.id.b1);
        e1=(EditText)findViewById(R.id.e1);
        e2=(EditText)findViewById(R.id.e2);

        tv.setText(getIntent().getStringExtra("name"));
        e1.setText(getIntent().getStringExtra("contact"));



        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                String num=e1.getText().toString();
                String text=e2.getText().toString();
                try {
                    SmsManager sms = SmsManager.getDefault();
                    sms.sendTextMessage(num, null, text, null, null);
                    Toast.makeText(Main2Activity.this,"Sent",Toast.LENGTH_SHORT).show();
                }catch(Exception e){


                }
            }

        });
    }







}
