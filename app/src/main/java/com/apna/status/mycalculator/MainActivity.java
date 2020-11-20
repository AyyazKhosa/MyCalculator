package com.apna.status.mycalculator;

import android.os.Bundle;
import android.util.Log;
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
    private AppCompatTextView mPrevious;
    private AppCompatTextView mPreviousGpa_tv;

    private CalculatorAdapter mCalculatorAdapter;
    private RecyclerView mLayout1;
    private ArrayList<ModelCalculator> modelCalculatorArrayList = new ArrayList<>();
    ArrayList<Double> gradesValue = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mPreviousGpa_tv = findViewById(R.id.mPreviousGpa_tv);
        mPrevious = findViewById(R.id.mPrevious_tv);

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
                int number = 0;

                for (int i = 0; i < modelCalculatorArrayList.size(); i++) {
                    if (modelCalculatorArrayList.get(i).getCredits() != 0) {
                        totalGrade += modelCalculatorArrayList.get(i).getCredits();
                        grades = modelCalculatorArrayList.get(i).getGrade();
                        if (grades!=null) {
                            switch (grades) {
                                case "A+":
//                            gradesValue = 4.03;
                                    number = modelCalculatorArrayList.get(i).getCredits();

                                    gradesValue.add(4.3 * number);


                                    break;
                                case "A":
//                            gradesValue = 4.00;
                                    number = modelCalculatorArrayList.get(i).getCredits();
                                    gradesValue.add(4.00 * number);
                                    break;
                                case "A-":
//                            gradesValue = 3.07;
                                    number = modelCalculatorArrayList.get(i).getCredits();
                                    gradesValue.add(3.7 * number);
                                    break;
                                case "B+":
                                    number = modelCalculatorArrayList.get(i).getCredits();
                                    gradesValue.add(3.3 * number);
                                    break;
//                            gradesValue = 3.03;
                                case "B":
//                            gradesValue = 3.00;
                                    number = modelCalculatorArrayList.get(i).getCredits();
                                    gradesValue.add(3.00 * number);
                                    break;
                                case "B-":
//                            gradesValue = 2.07;
                                    number = modelCalculatorArrayList.get(i).getCredits();
                                    gradesValue.add(2.7 * number);
                                    break;
                                case "C+":
                                    number = modelCalculatorArrayList.get(i).getCredits();
                                    gradesValue.add(2.3 * number);
                                    break;
//                            gradesValue = 2.03;
                                case "C":
//                            gradesValue = 2.00;
                                    number = modelCalculatorArrayList.get(i).getCredits();
                                    gradesValue.add(2.00 * number);
                                    break;
                                case "C-":
//                            gradesValue = 2.00;
                                    number = modelCalculatorArrayList.get(i).getCredits();
                                    gradesValue.add(1.7 * number);
                                    break;
                                case "D+":
//                            gradesValue = 1.03;
                                    number = modelCalculatorArrayList.get(i).getCredits();
                                    gradesValue.add(1.3 * number);
                                    break;
                                case "D":
//                            gradesValue = 1.00;
                                    number = modelCalculatorArrayList.get(i).getCredits();
                                    gradesValue.add(1.00 * number);
                                    break;
                                case "D-":
//                            gradesValue = 0.07;
                                    number = modelCalculatorArrayList.get(i).getCredits();
                                    gradesValue.add(0.7 * number);
                                    break;
                                case "F":
//                            gradesValue = 0.00;
                                    gradesValue.add(0.00 * number);
                                    break;
                            }
                        }else {
                            Toast.makeText(this, "Grade is not Empty", Toast.LENGTH_SHORT).show();
                        }


                    } else {
                        Toast.makeText(this, "Null Value", Toast.LENGTH_SHORT).show();
                    }
                    if (i + 1 == modelCalculatorArrayList.size()) {
                        calculatorGpa(totalGrade);
                    }
                }


                Toast.makeText(this, "total" + gradesValue, Toast.LENGTH_SHORT).show();


            } else {
                Toast.makeText(this, "set Your Grade First", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void calculatorGpa(int totalGrade) {
        double mPointTotal = 0;
        for (int k = 0; k < gradesValue.size(); k++) {
            mPointTotal += gradesValue.get(k);
        }
        double gpa = mPointTotal / totalGrade;
        String n= String.valueOf(gpa);
        String nn= String.valueOf(totalGrade);
        mPrevious.setText(nn);
//        Log.d("TotalGradeValue", "calculatorGpa: point" + mPointTotal / totalGrade);
        mPreviousGpa_tv.setText(n);
    }

    private void addLayout(String textViewText, String buttonText1, String buttonText2) {

        insertSingleItem();
    }

    private void insertSingleItem() {
        ModelCalculator mModelCalculator = new ModelCalculator();

        modelCalculatorArrayList.add(mModelCalculator);
        mCalculatorAdapter.notifyItemInserted(modelCalculatorArrayList.size() + 1);
    }
}