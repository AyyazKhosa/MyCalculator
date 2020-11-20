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

public class CalculatorAdapter extends RecyclerView.Adapter<CalculatorAdapter.ViewHolder> {

    private ArrayList<ModelCalculator> modelCalculatorArrayList;
    private Context mContext;

    public CalculatorAdapter(Context mContext, ArrayList<ModelCalculator> modelCalculatorArrayList) {
        this.mContext = mContext;
        this.modelCalculatorArrayList = modelCalculatorArrayList;
    }

    @Override
    public CalculatorAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_items_add, parent, false);
        // pass MyCustomEditTextListener to viewholder in onCreateViewHolder
        // so that we don't have to do this expensive allocation in onBindViewHolder
        ViewHolder vh = new ViewHolder(v, new MyCustomEditTextListener(), new MyCustomEditTextListener1());

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // update MyCustomEditTextListener every time we bind a new item
        // so that it knows what item in modelCalculatorArrayList to update
//        holder.myCustomEditTextListener.updatePosition(holder.getAdapterPosition());
//        holder.myCustomEditTextListener1.updatePosition(holder.getAdapterPosition());
//        holder.mGradeLayout.setText(modelCalculatorArrayList.get(holder.getAdapterPosition()).getGrade());
//        holder.mAppCompatTextView3.setText(modelCalculatorArrayList.get(holder.getAdapterPosition()).getCredits());

        holder.mAppCompatTextView3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d("afterTextChanged", "afterTextChanged: " + s.toString());
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("afterTextChanged", "afterTextChanged: " + s.toString());
                int number = 0;
                try {
                    number = Integer.parseInt(s.toString());
                } catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                }

                modelCalculatorArrayList.get(position).setCredits(number);
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d("afterTextChanged", "afterTextChanged: " + s.toString());
            }
        });


//        String text = holder.mGradeLayout.getSelectedItem().toString();
//        modelCalculatorArrayList.get(position).setGrade(text);


        holder.mGradeLayout.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d("afterTextChanged", "afterTextChanged: " + s.toString());
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                if (s.toString().toUpperCase().contains("A+")) {
                    modelCalculatorArrayList.get(position).setGrade(s.toString().toUpperCase());
                } else if (s.toString().toUpperCase().contains("A")) {
                    modelCalculatorArrayList.get(position).setGrade(s.toString().toUpperCase());
                } else if (s.toString().toUpperCase().contains("A-")) {
                    modelCalculatorArrayList.get(position).setGrade(s.toString().toUpperCase());
                } else if (s.toString().toUpperCase().contains("B+")) {
                    modelCalculatorArrayList.get(position).setGrade(s.toString().toUpperCase());
                } else if (s.toString().toUpperCase().contains("B")) {
                    modelCalculatorArrayList.get(position).setGrade(s.toString().toUpperCase());
                } else if (s.toString().toUpperCase().contains("B-")) {
                    modelCalculatorArrayList.get(position).setGrade(s.toString().toUpperCase());
                } else if (s.toString().toUpperCase().contains("C+")) {
                    modelCalculatorArrayList.get(position).setGrade(s.toString().toUpperCase());
                } else if (s.toString().toUpperCase().contains("C")) {
                    modelCalculatorArrayList.get(position).setGrade(s.toString().toUpperCase());
                } else if (s.toString().toUpperCase().contains("C-")) {
                    modelCalculatorArrayList.get(position).setGrade(s.toString().toUpperCase());
                } else if (s.toString().toUpperCase().contains("D+")) {
                    modelCalculatorArrayList.get(position).setGrade(s.toString().toUpperCase());
                } else if (s.toString().toUpperCase().contains("D")) {
                    modelCalculatorArrayList.get(position).setGrade(s.toString().toUpperCase());
                } else if (s.toString().toUpperCase().contains("D-")) {
                    modelCalculatorArrayList.get(position).setGrade(s.toString().toUpperCase());
                } else if (s.toString().toUpperCase().contains("F")) {
                    modelCalculatorArrayList.get(position).setGrade(s.toString().toUpperCase());
                } else {
                    holder.mGradeLayout.setError("e.g(A+,A,A-,B+,B,B-,C+,C,C-,D+,D,D-,F)");
//                    Toast.makeText(mContext, "e.g(A+,A,A-,B+,B,B-,C+,C,C-,D+,D,D-,F)", Toast.LENGTH_LONG).show();
                }


            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d("afterTextChanged", "afterTextChanged: " + s.toString());
            }
        });


    }

    @Override
    public int getItemCount() {
        return modelCalculatorArrayList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        AppCompatTextView mAppCompatTextView1;
        AppCompatEditText mGradeLayout;
        AppCompatEditText mAppCompatTextView3;
        //        public AppCompatEditText mEditText;
        public MyCustomEditTextListener myCustomEditTextListener;
        public MyCustomEditTextListener1 myCustomEditTextListener1;

        public ViewHolder(View v, MyCustomEditTextListener myCustomEditTextListener, MyCustomEditTextListener1 myCustomEditTextListener1) {
            super(v);

            this.mGradeLayout = v.findViewById(R.id.mGrade_tv);
//            this.myCustomEditTextListener = myCustomEditTextListener;
//            this.mGradeLayout.addTextChangedListener(myCustomEditTextListener);
            this.mAppCompatTextView3 = v.findViewById(R.id.mCredits_tv);
//            this.myCustomEditTextListener1 = myCustomEditTextListener1;
//            this.mGradeLayout.addTextChangedListener(myCustomEditTextListener1);
        }
    }

    // we make TextWatcher to be aware of the position it currently works with
    // this way, once a new item is attached in onBindViewHolder, it will
    // update current position MyCustomEditTextListener, reference to which is kept by ViewHolder
    private class MyCustomEditTextListener implements TextWatcher {
        private int position;

        public void updatePosition(int position) {
            this.position = position;
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            // no op
            Log.d("beforeTextChanged", "beforeTextChanged: " + charSequence.toString());
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Log.d("onTextChanged", "onTextChanged: " + charSequence.toString());
            modelCalculatorArrayList.get(position).setGrade(charSequence.toString());
        }

        @Override
        public void afterTextChanged(Editable editable) {
            Log.d("afterTextChanged", "afterTextChanged: " + editable.toString());
            // no op
        }
    }

    private class MyCustomEditTextListener1 implements TextWatcher {
        private int position;

        public void updatePosition(int position) {
            this.position = position;
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            // no op
            Log.d("beforeTextChanged", "beforeTextChanged: " + charSequence.toString());
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Log.d("onTextChanged", "onTextChanged: " + charSequence.toString());
            modelCalculatorArrayList.get(position).setCredits(Integer.parseInt(charSequence.toString()));
        }

        @Override
        public void afterTextChanged(Editable editable) {
            Log.d("afterTextChanged", "afterTextChanged: " + editable.toString());
            // no op
        }
    }
}
//public class CalculatorAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
//{
//    private ArrayList<ModelCalculator> modelCalculatorArrayList;
//    private Context mContext;
//    public View layout2;
//
//    public CalculatorAdapter(Context mContext, ArrayList<ModelCalculator> modelCalculatorArrayList) {
//        this.mContext = mContext;
//        this.modelCalculatorArrayList = modelCalculatorArrayList;
//    }
//
//    @NonNull
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_items_add, parent, false);
//        return new CalculatorViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//        CalculatorViewHolder mHolder = (CalculatorViewHolder) holder;
//        mHolder.mGradeLayout.setTag(position);
////        mHolder.mGradeLayout.setText(modelCalculatorArrayList.get(position).toString());
////        mHolder.mAppCompatTextView1.setHint(modelCalculatorArrayList.get(position).getViewClass());
////        Log.d("TAG", "onBindViewHolderonBindViewHolder: "+modelCalculatorArrayList.get(position).getGrade());
////        mHolder.mGradeLayout.setHint(modelCalculatorArrayList.get(position).getGrade());
////        mHolder.mAppCompatTextView3.setHint(modelCalculatorArrayList.get(position).getCredits());
//
//
//
//        mHolder.mGradeLayout.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                Log.d("beforeTextChanged", "beforeTextChanged: "+charSequence.toString());
//            }
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                Log.d("beforeTextChanged", "onTextChanged: "+charSequence.toString());
//            }
//            @Override
//            public void afterTextChanged(Editable editable) {
//                Log.d("beforeTextChanged", "afterTextChanged: "+editable.toString());
//                System.out.println(mHolder.mGradeLayout.getTag());
//            }
//        });
//
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return modelCalculatorArrayList.size();
//    }
//
//    private class CalculatorViewHolder extends RecyclerView.ViewHolder {
//        AppCompatTextView mAppCompatTextView1;
//        AppCompatEditText mGradeLayout;
//        AppCompatEditText mAppCompatTextView3;
//        RelativeLayout linearLayout;
//        private int position;
//        public CalculatorViewHolder(View view) {
//            super(view);
//
//            mAppCompatTextView1 = view.findViewById(R.id.mClass_tv);
//            mGradeLayout = view.findViewById(R.id.mGrade_tv);
//            mAppCompatTextView3 = view.findViewById(R.id.mCredits_tv);
//
//
//            layout2 = LayoutInflater.from(mContext).inflate(R.layout.single_items_add, null, false);
//            linearLayout = (RelativeLayout) itemView;
//            linearLayout.addView(layout2);
//
//
////            MyTextWatcher textWatcher = new MyTextWatcher(mAppCompatTextView3);
////            mAppCompatTextView3.addTextChangedListener(textWatcher);
//
//
//        }
//    }
//
//    public static class MyTextWatcher implements TextWatcher {
//        private final EditText editText;
//
//        public MyTextWatcher(EditText editText) {
//            this.editText = editText;
//        }
//
//        @Override
//        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//            Log.d("beforeTextChanged", "beforeTextChanged: "+s.toString());
//        }
//
//        @Override
//        public void onTextChanged(CharSequence s, int start, int before, int count) {
//            int position = (int) editText.getTag();
//            // Do whatever you want with position
//            Log.d("beforeTextChanged", "beforeTextChanged: "+s.toString());
//        }
//
//        @Override
//        public void afterTextChanged(Editable s) {
//            Log.d("beforeTextChanged", "beforeTextChanged: "+s.toString());
//        }
//    }
//}
//
