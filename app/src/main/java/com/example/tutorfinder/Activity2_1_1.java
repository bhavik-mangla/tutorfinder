package com.example.tutorfinder;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class Activity2_1_1 extends RecyclerView.Adapter<Activity2_1_1.ViewHolder> {

    private Tutors[] localDataSet;
    private TextView Name;
    private  TextView PhoneNumber;
    private  TextView Address;
    private ImageView imageView;
    private Button button;
    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */


    public static class ViewHolder extends RecyclerView.ViewHolder {


        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View


        }


    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public Activity2_1_1(Tutors[] dataSet) {
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_211, viewGroup, false);
        Name = view.findViewById(R.id.Name);
        PhoneNumber = view.findViewById(R.id.PhoneNumber);
        Address = view.findViewById(R.id.Address);
        imageView = view.findViewById(R.id.imageView);
        button = view.findViewById(R.id.button);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, @SuppressLint("RecyclerView") final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        Name.setText(localDataSet[position].Name);
        PhoneNumber.setText(localDataSet[position].PhoneNumber);
        Address.setText(localDataSet[position].Address);

        int id = viewHolder.itemView.getContext().getResources().getIdentifier(localDataSet[position].Image1,"drawable","com.example.tutorfinder");
        if (id!=0) {
            imageView.setImageResource(id);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(viewHolder.itemView.getContext(), Avtivity2_1_1_1.class);
                intent.putExtra("Name",  localDataSet[position].Name);
                intent.putExtra("Class1",  localDataSet[position].Class1);
                intent.putExtra("Locality",  localDataSet[position].Locality);
                intent.putExtra("Subject",  localDataSet[position].Subject);
                intent.putExtra("Address",  localDataSet[position].Address);
                intent.putExtra("PhoneNumber",  localDataSet[position].PhoneNumber);
                intent.putExtra("PastResults",  localDataSet[position].PastResults);
                intent.putExtra("Image1",  localDataSet[position].Image1);
                intent.putExtra("Image2",  localDataSet[position].Image2);
                intent.putExtra("Image3",  localDataSet[position].Image3);
                intent.putExtra("TeachingExperience",  localDataSet[position].TeachingExperience);


                viewHolder.itemView.getContext().startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {

        return localDataSet.length;
    }

}
