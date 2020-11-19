package com.apna.status.mycalculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private AppCompatButton mAddClassBtn;

    private CalculatorAdapter mCalculatorAdapter;
    private RecyclerView mLayout1;
    private ArrayList<ModelCalculator> modelCalculatorArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
//        mLinearLayout = findViewById(R.id.mLayoutAdd);
        mAddClassBtn = findViewById(R.id.mAddClass_btn);
        mAddClassBtn.setOnClickListener(this);
        mLayout1 = findViewById(R.id.mLayout1);


        modelCalculatorArrayList = setRecyclerViewList();
        mLayout1.setHasFixedSize(true);
        mLayout1.setLayoutManager(new LinearLayoutManager(this));
        mCalculatorAdapter = new CalculatorAdapter(this, modelCalculatorArrayList);
        mLayout1.setAdapter(mCalculatorAdapter);

    }

    private ArrayList<ModelCalculator> setRecyclerViewList() {
        ModelCalculator mModelCalculator = new ModelCalculator();
        modelCalculatorArrayList.add(mModelCalculator);
        return modelCalculatorArrayList;
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.mAddClass_btn) {

            addLayout("This is text 1", "This is first button", "This is second Button");
//            LayoutInflater inflater = LayoutInflater.from(this);
//            ConstraintLayout layout = (ConstraintLayout) inflater.inflate(R.layout.single_items_add, null, false);
//
//
//            for (int i=0;i<20;i++) {
//                mainView.addView(layout);
//            }
        }
    }

    private void addLayout(String textViewText, String buttonText1, String buttonText2) {

//        insertSingleItem();
        modelCalculatorArrayList = setRecyclerViewList();
        mCalculatorAdapter.notifyDataSetChanged();
    }
    private void insertSingleItem() {
        ModelCalculator mModelCalculator = new ModelCalculator();

        modelCalculatorArrayList.add(mModelCalculator);
        mCalculatorAdapter.notifyItemInserted(modelCalculatorArrayList.size()+1);
    }
}