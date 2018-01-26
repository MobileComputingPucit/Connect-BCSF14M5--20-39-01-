package codex.afinal.smsapp;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MiddleActivity extends AppCompatActivity {

    DatabaseHelper help=new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_middle);
        RecyclerView recyclerView=(RecyclerView) findViewById(R.id.personList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<person>data=help.getList();

        recyclerView.setAdapter(new personAdapter(this,data));
    }
}
