package com.example.tutorfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Activity2 extends AppCompatActivity {

    TextView textView;
    ArrayList<String> arrayList;
    Dialog dialog;

    TextView textView1;
    TextView textView2;

    ArrayList<String> arrayList1;
    ArrayList<String> arrayList2;

    Button button;

    int t1=0;
    int t2=0;
    int t3=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_main);
        Intent intent = getIntent();

        textView = findViewById(R.id.text_view);
        arrayList = new ArrayList<>();

        arrayList.add("Sector 55, Gurgaon");
        arrayList.add("Sector 45, Gurgaon");
        arrayList.add("Sector 56, Gurgaon");
        arrayList.add("Sector 48, Gurgaon");
        arrayList.add("Sector 50, Gurgaon");
        arrayList.add("Sector 51, Gurgaon");
        arrayList.add("Sector 44, Gurgaon");
        arrayList.add("Sector 38, Gurgaon");

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("");
                dialog = new Dialog(Activity2.this);
                //Set custom dialog
                dialog.setContentView(R.layout.dialog_searchable_spinner);
                dialog.getWindow().setLayout(650,800);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                //Show dialog
                dialog.show();

                EditText editText = dialog.findViewById(R.id.edit_text);
                ListView listView = dialog.findViewById(R.id.list_view);

                ArrayAdapter<String> ad = new ArrayAdapter<>(Activity2.this, android.R.layout.simple_list_item_1,arrayList);
                listView.setAdapter(ad);

                editText.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                        //Filter array list
                        ad.getFilter().filter(s);

                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        textView.setText(ad.getItem(position));
                        dialog.dismiss();
                    }
                });
            }
        });

        textView1 = findViewById(R.id.text_view1);
        arrayList1 = new ArrayList<>();
        arrayList1.add("Class 6");
        arrayList1.add("Class 7");
        arrayList1.add("Class 8");
        arrayList1.add("Class 9");
        arrayList1.add("Class 10");
        arrayList1.add("Class 11");
        arrayList1.add("Class 12");


        textView1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                textView1.setText("");
                dialog = new Dialog(Activity2.this);
                //Set custom dialog
                dialog.setContentView(R.layout.dialog_searchable_spinner);
                dialog.getWindow().setLayout(650,800);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                //Show dialog
                dialog.show();

                EditText editText = dialog.findViewById(R.id.edit_text);
                ListView listView = dialog.findViewById(R.id.list_view);

                ArrayAdapter<String> ad = new ArrayAdapter<>(Activity2.this, android.R.layout.simple_list_item_1,arrayList1);
                listView.setAdapter(ad);

                editText.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                        //Filter array list
                        ad.getFilter().filter(s);

                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        textView1.setText(ad.getItem(position));
                        dialog.dismiss();
                    }
                });
            }
        });



        textView2 = findViewById(R.id.text_view2);
        arrayList2 = new ArrayList<>();
        arrayList2.add("Mathematics");
        arrayList2.add("English");
        arrayList2.add("Science");
        arrayList2.add("SST");
        arrayList2.add("Physics");
        arrayList2.add("Chemistry");
        arrayList2.add("Computer Science");
        arrayList2.add("Commerce");
        arrayList2.add("Economics");
        arrayList2.add("Hindi");
        arrayList2.add("History/Civics");
        arrayList2.add("Geography");


        textView2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                textView2.setText("");
                dialog = new Dialog(Activity2.this);
                //Set custom dialog
                dialog.setContentView(R.layout.dialog_searchable_spinner);
                dialog.getWindow().setLayout(650,800);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                //Show dialog
                dialog.show();

                EditText editText = dialog.findViewById(R.id.edit_text);
                ListView listView = dialog.findViewById(R.id.list_view);

                ArrayAdapter<String> ad = new ArrayAdapter<>(Activity2.this, android.R.layout.simple_list_item_1,arrayList2);
                listView.setAdapter(ad);

                editText.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                        //Filter array list
                        ad.getFilter().filter(s);

                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        textView2.setText(ad.getItem(position));

                        dialog.dismiss();

                    }
                });
            }
        });

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getText().toString()=="" || textView1.getText().toString()=="" || textView2.getText().toString() == ""){
                    Toast.makeText(Activity2.this, "Please fill all the required options", Toast.LENGTH_SHORT).show();

                }
                else{
                    Intent intent = new Intent(Activity2.this, Activity2_1.class);
                    intent.putExtra("Locality", textView.getText().toString());
                    intent.putExtra("Class", textView1.getText().toString());
                    intent.putExtra("Subject", textView2.getText().toString());
                    startActivity(intent);
                }

            }
        });


    }
}