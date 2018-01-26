package codex.afinal.smsapp;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.textservice.TextInfo;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ali on 22-Nov-17.
 */

public class personAdapter extends RecyclerView.Adapter<personAdapter.PersonViewHolder>{

    private Context context;
    private ArrayList<person> data;
    private int pos;

    public personAdapter(Context con,ArrayList<person> data){
        this.context=con;
        this.data=data;
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.list_item_layout,parent,false);
        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PersonViewHolder holder, int position) {
        String name=data.get(position).name;
        final String contact=data.get(position).contact;
        holder.nam.setText(name);
        holder.con.setText(contact);
        pos=position;
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,Main2Activity.class);

                intent.putExtra("name", data.get(pos).name);
                intent.putExtra("contact", data.get(pos).contact);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder{
        TextView nam;
        TextView con;
        ImageView img;
        public PersonViewHolder(View itemView){
            super(itemView);
            nam=(TextView)itemView.findViewById(R.id.name1);
            con=(TextView)itemView.findViewById(R.id.contact1);
            img=(ImageView)itemView.findViewById(R.id.img1);

        }

    }
}
