package com.apna.status.mycalculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

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
    private AppCompatTextView mCalculate_tv;
    private AppCompatTextView mPrevious_tv;

    private CalculatorAdapter mCalculatorAdapter;
    private RecyclerView mLayout1;
    private ArrayList<ModelCalculator> modelCalculatorArrayList = new ArrayList<>();
    Double gradesValue = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mPrevious_tv = findViewById(R.id.mPrevious_tv);
        mCalculate_tv = findViewById(R.id.mCalculate_tv);
        mCalculate_tv.setOnClickListener(this);
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
        } else if (v.getId() == R.id.mCalculate_tv) {
            if (modelCalculatorArrayList.size() > 0) {
                int totalGrade = 0;
                String grades = null;

                for (int i = 0; i < modelCalculatorArrayList.size(); i++) {
                    if (modelCalculatorArrayList.get(i).getCredits() != 0) {
                        totalGrade += modelCalculatorArrayList.get(i).getCredits();

                        grades = modelCalculatorArrayList.get(i).getGrade();
                        if (grades.equals("A+"))
                            gradesValue = 5.00;
                        else if (grades.equals("A"))
                            gradesValue = 4.5;
                        else if (grades.equals("B+"))
                            gradesValue = 4.0;
                        else if (grades.equals("B"))
                            gradesValue = 3.5;
                        else if (grades.equals("C+"))
                            gradesValue = 3.00;
                        else if (grades.equals("C"))
                            gradesValue = 2.5;
                        else if (grades.equals("D+"))
                            gradesValue = 2.0;
                        else if (grades.equals("D"))
                            gradesValue = 1.00;
                        else if (grades.equals("F"))
                            gradesValue = 0.00;


                    } else {
                        Toast.makeText(this, "Null Value", Toast.LENGTH_SHORT).show();
                    }
                }
                mPrevious_tv.setText(totalGrade);
                Toast.makeText(this, "total" + gradesValue, Toast.LENGTH_SHORT).show();
//            getCalculate();

            } else {
                Toast.makeText(this, "set Your Grade First", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void addLayout(String textViewText, String buttonText1, String buttonText2) {
        insertSingleItem();
//        modelCalculatorArrayList = setRecyclerViewList();
//        mCalculatorAdapter.notifyDataSetChanged();
    }

    private void insertSingleItem() {
        ModelCalculator mModelCalculator = new ModelCalculator();

        modelCalculatorArrayList.add(mModelCalculator);
        mCalculatorAdapter.notifyItemInserted(modelCalculatorArrayList.size() + 1);
    }
}