package com.example.tutorfinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Activity2_1 extends AppCompatActivity {


    String locality;
    String class1;
    String subject;
    RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_21);


        Intent intent = getIntent();
        Bundle bundle = getIntent().getExtras();

        locality = bundle.getString("Locality");
        class1 = bundle.getString("Class");
        subject = bundle.getString("Subject");




        DbHandler handler  = new DbHandler(this, "tutors", null, 1);




        //handler.addTutor(new Tutors("Deeksha", "Class 10", "Sector 55, Gurgaon", "20 Students got 99+","img1","img2","img3", "Mathematics","9989989987","1-101 Sagavi Appartments" ,"10 years+ experience"));
        //handler.addTutor(new Tutors("Aruna", "Class 10", "Sector 55, Gurgaon", "10 Students got 98+","img4","img2","img3", "Mathematics","9879879876","Karam Dharam Society" ,"5 years+ experience"));
        
        RequestQueue requestQueue;
        requestQueue = Volley.newRequestQueue(this);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET,
                "https://mocki.io/v1/65582109-831a-4c10-9d29-26e4e4f8f64a", null, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                try {

                    for (int i = 0; i < 2; i++) {
                        JSONObject obj = response.getJSONObject(i);
                        String Name = obj.getString("Name");
                        String Class1 = obj.getString("Class");
                        String Locality = obj.getString("Locality");
                        String PastResults = obj.getString("PastResults");
                        String Subject = obj.getString("Subject");
                        String PhoneNumber = obj.getString("PhoneNumber");
                        String Address = obj.getString("Address");
                        String TeachingExperience = obj.getString("TeachingExperience");
                        String Image1 = obj.getString("Image1");
                        String Image2 = obj.getString("Image2");
                        String Image3 = obj.getString("Image3");


                        Tutors o1 = new Tutors(Name,Class1,Locality,PastResults,Image1,Image2,Image3,Subject,PhoneNumber,Address,TeachingExperience);
//                        if(handler.contains(o1))
//
                        System.out.println(handler.contains(o1));
                        handler.addTutor(o1);
                        System.out.println(handler.contains(o1));
                        System.out.println(o1.Name);




                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Shubham", "Something went wrong");
                Toast.makeText(Activity2_1.this, "Something went wrong!", Toast.LENGTH_SHORT).show();

            }
        });

        requestQueue.add(jsonArrayRequest);


        Cursor c = handler.getTutor(locality,class1,subject);
        ArrayList<Tutors> tutors =new ArrayList<>() ;

        int i = 0;
        if (c.moveToFirst() && c!=null) {
            do {
                Tutors o2 = new Tutors(c.getString(0), c.getString(1), c.getString(2),
                        c.getString(3), c.getString(4), c.getString(5),
                        c.getString(6), c.getString(7), c.getString(8),
                        c.getString(9), c.getString(10));
                tutors.add(o2);
                i += 1;
            } while (c.moveToNext());

            //

            Tutors tutors1[] = new Tutors[tutors.size()];

            recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            Activity2_1_1 c1 = new Activity2_1_1(tutors.toArray(tutors1));
            recyclerView.setAdapter(c1);
            recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        }

        else{
            Toast.makeText(Activity2_1.this, "No records exist", Toast.LENGTH_SHORT).show();
        }
        handler.close();


        }


    }

/*
    {
            "Name": "Karuna",
            "Class": "10",
                "Locality": "Sector 55, Gurgaon",
            "PastResults": "20 Students got 99+",
                "Image1": "https://randomuser.me/api/portraits/women/47.jpg",
            "Image1": "https://randomuser.me/api/portraits/women/47.jpg",
            "Image1": "https://randomuser.me/api/portraits/women/47.jpg",
            "Subject": "Mathematics",
            "PhoneNumber": 1992,
            "Address": "3-301 Sagavi Appartments",
            "TeachingExperience": "40+years experience"
            },
*/
