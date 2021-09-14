package com.example.userprofileusingapi;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.usersDataHolder> {


    List<Users> usersList;
    Context context;

    public UsersAdapter(List<Users> usersList, Context context) {
        this.usersList = usersList;
        this.context = context;
    }

    @NonNull
    @Override
    public usersDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.rv_usersinfo,null);
        return new usersDataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull usersDataHolder holder, int position) {
        final Users usersData = usersList.get(position);
        holder.userId.setText(usersData.getId());
        holder.FirstName.setText(usersData.getFirst_name());
        holder.LastName.setText(usersData.getLast_name());
        holder.Email.setText(usersData.getEmail());
        Picasso.get().load(usersData.getAvatar()).into(holder.imageViewUser);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  Toast.makeText(context, ""+usersData.getFirst_name(), Toast.LENGTH_SHORT).show();

               Intent intent = new Intent(context, ProfileActivity.class);
                intent.putExtra("image",usersData.getAvatar());
                intent.putExtra("lastName",usersData.getLast_name());
                intent.putExtra("firstName",usersData.getFirst_name());
                intent.putExtra("id",usersData.getId());
                intent.putExtra("email",usersData.getEmail());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
              context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }


    public  class usersDataHolder extends RecyclerView.ViewHolder{
        TextView userId,FirstName,LastName,Email;
        ImageView imageViewUser;

        public usersDataHolder(@NonNull View itemView) {
            super(itemView);
            userId = itemView.findViewById(R.id.textViewId);
            FirstName =  itemView.findViewById(R.id.textViewFirstName);
            LastName = itemView.findViewById(R.id.textViewLastName);
            Email = itemView.findViewById(R.id.textViewEmail);
            imageViewUser = itemView.findViewById(R.id.imageViewUser);
        }
    }
}
