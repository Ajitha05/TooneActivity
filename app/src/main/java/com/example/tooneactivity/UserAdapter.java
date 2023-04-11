package com.example.tooneactivity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.constraintlayout.widget.ConstraintLayout;


import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    List<User> userList;




    public UserAdapter(List<User>userList){
        this.userList=userList;
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.item_row,parent,false);
        ViewHolder viewHolder=new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {
        final User user = userList.get(position);
        holder.getName().setText(user.getName().trim());
        holder.getId().setText(String.valueOf(user.getId()));


        holder.constraintLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Toast.makeText(view.getContext(), user.getName(), Toast.LENGTH_SHORT).show();

                Intent i = new Intent(view.getContext(),UserDetails.class);

                Profile profile = user.getProfile();



                i.putExtra("address",profile.getAddress());
                i.putExtra("email",profile.getEmail());
                i.putExtra("detail id",profile.getId());
                i.putExtra("user id",user.getId());
                view.getContext().startActivity(i);


            }

        });

    }




    @Override
    public int getItemCount() {
        return userList.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        public void setName(TextView name) {
            this.name = name;

        }
        public void setId(TextView id) {
            this.id = id;
        }


        public TextView getName() {
            return name;

        }
        public TextView getId() {
            return id;

        }

        private TextView name,id;
        public ConstraintLayout constraintLayout;

        public ViewHolder( View view) {
            super(view);
            this.name=(TextView) view.findViewById(R.id.labelItemName);
            this.id =(TextView) view.findViewById(R.id.useridtv);
            constraintLayout=(ConstraintLayout) view.findViewById(R.id.itemrow);

        }
    }

    }
