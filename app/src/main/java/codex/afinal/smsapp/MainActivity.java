package codex.afinal.smsapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;
public class MainActivity extends AppCompatActivity {


    EditText e1,e2;
    Button btn1,btn2;
    DatabaseHelper help=new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        if(ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED){
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission.SEND_SMS)) {
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.SEND_SMS},1);
            }
            else
            {
                ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.SEND_SMS},1);
            }

            }

        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);
        btn1=(Button)findViewById(R.id.submit);
        btn2=(Button)findViewById(R.id.send);


        btn1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                String name=e1.getText().toString();
                String con=e2.getText().toString();
                try {
                    person p=new person(name,con);
                    boolean flag=help.insertPerson(p);
                    if(flag) {
                        Toast.makeText(MainActivity.this, "Person Recorded", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(MainActivity.this, "Person Already Present", Toast.LENGTH_SHORT).show();
                    }
                }catch(Exception e){
                    Toast.makeText(MainActivity.this,"Error reported",Toast.LENGTH_SHORT).show();
                }
            }
        });


        btn2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                Intent intent = new Intent(MainActivity.this,MiddleActivity.class);
                startActivity(intent);
                //onDestroy();
            }
        });



    }


    public void onRequestPermissionsResult(int requestCode,String[] permissions, int[] grantResults){
        switch(requestCode){
            case(1):  if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                if(ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.SEND_SMS)==PackageManager.PERMISSION_GRANTED)
                {
                    Toast.makeText(this,"Permission Granted",Toast.LENGTH_SHORT).show();

                }

            }else{

                Toast.makeText(this,"Permission Must Be Granted, Sorry Try Again",Toast.LENGTH_LONG).show();
                this.onDestroy();
            }

        }



    }
}
