package com.code4rox.calculatorfox;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder>{
    private List<contactvo> contactvolist;
    private Context mContext;
    public ContactAdapter(List<contactvo> contactvolist,Context mcontext){
        this.contactvolist=contactvolist;
        this.mContext=mcontext;


    }
    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.single_contact_view,parent,false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {

        contactvo cont=contactvolist.get(position);
        holder.tv1.setText(cont.getContactName());
        holder.tv2.setText(cont.getContactNumber());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(Intent.ACTION_CALL,Uri.fromParts("tel",cont.getContactNumber(),null));
                in.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(in);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactvolist.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder{

        ImageView imgicon;
        TextView tv1;
        TextView tv2;
        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            imgicon=(ImageView) itemView.findViewById(R.id.contactimage);
            tv1=(TextView) itemView.findViewById(R.id.contactname);
            tv2=(TextView) itemView.findViewById(R.id.contactnumber);
        }
    }
}
