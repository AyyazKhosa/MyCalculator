package com.apna.status.mycalculator;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;


public class CalculatorAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<ModelCalculator> modelCalculatorArrayList;
    private Context mContext;
    public View layout2;

    public CalculatorAdapter(Context mContext, ArrayList<ModelCalculator> modelCalculatorArrayList) {
        this.mContext = mContext;
        this.modelCalculatorArrayList = modelCalculatorArrayList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_items_add, parent, false);
        return new CalculatorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CalculatorViewHolder mHolder = (CalculatorViewHolder) holder;
        mHolder.mGradeLayout.setTag(position);
        mHolder.mAppCompatTextView1.setHint(modelCalculatorArrayList.get(position).getViewClass());
//        Log.d("TAG", "onBindViewHolderonBindViewHolder: "+modelCalculatorArrayList.get(position).getGrade());
        mHolder.mGradeLayout.setHint(modelCalculatorArrayList.get(position).getGrade());
        mHolder.mAppCompatTextView3.setHint(modelCalculatorArrayList.get(position).getCredits());

        mHolder.mGradeLayout.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("beforeTextChanged", "beforeTextChanged: "+charSequence.toString());
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("beforeTextChanged", "onTextChanged: "+charSequence.toString());
            }
            @Override
            public void afterTextChanged(Editable editable) {
                Log.d("beforeTextChanged", "afterTextChanged: "+editable.toString());
                System.out.println(mHolder.mGradeLayout.getTag());
            }
        });


    }

    @Override
    public int getItemCount() {
        return modelCalculatorArrayList.size();
    }

    private class CalculatorViewHolder extends RecyclerView.ViewHolder {
        AppCompatTextView mAppCompatTextView1;
        AppCompatEditText mGradeLayout;
        AppCompatEditText mAppCompatTextView3;
        RelativeLayout linearLayout;
        private int position;
        public CalculatorViewHolder(View view) {
            super(view);

            mAppCompatTextView1 = view.findViewById(R.id.mClass_tv);
            mGradeLayout = view.findViewById(R.id.mGrade_tv);
            mAppCompatTextView3 = view.findViewById(R.id.mCredits_tv);


            layout2 = LayoutInflater.from(mContext).inflate(R.layout.single_items_add, null, false);
            linearLayout = (RelativeLayout) itemView;
            linearLayout.addView(layout2);





        }
    }


}

