package com.example.random25022020;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText mEdtSomin,mEdtSomax;
    Button mBtnRandom;
    TextView mTvKetqua;
    String mTextmin,mTextmax;
    int mSmin,mSmax,mValue;
    Random mRandom;
    String mTvValue = "";
    int mOld_min=0, mOld_max=0,i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEdtSomax = findViewById(R.id.edtSomax);
        mEdtSomin = findViewById(R.id.edtSomin);
        mBtnRandom = findViewById(R.id.btnRandom);
        mTvKetqua = findViewById(R.id.tvKetqua);


        // Khai bao mang
        final ArrayList<Integer> arrayNumber = new ArrayList<>();

        // Thêm dữ liệu
       // arrayNumber.add(10); // index = 0
//        arrayNumber.add(9); // index = 1
//        arrayNumber.add(8); // index = 2

        // Lay kích thước mảng
//        Log.d("BBB",String.valueOf(arrayNumber.size()));

        // Lấy giá trị phần tử theo vị trí
//        Log.d("BBB",String.valueOf(arrayNumber.get(0)));

        // xóa
//        arrayNumber.remove(0);
//        Log.d("BBB",String.valueOf(arrayNumber.get(0)));

        // Sửa
//        arrayNumber.set(0,1);
//        Log.d("BBB",String.valueOf(arrayNumber.get(0)));

        mBtnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextmin = mEdtSomin.getText().toString();
                mTextmax = mEdtSomax.getText().toString();
                //
                if (mTextmin.equals("") || mTextmax.equals("")){
                    Toast.makeText(MainActivity.this, "Bạn nhập thiếu thông tin", Toast.LENGTH_SHORT).show();
                    return;
                }
                mSmin = Integer.parseInt(mTextmin);
                mSmax = Integer.parseInt(mTextmax);
                mSmax = mSmin > mSmax ? mSmin + 1 : mSmax;
                mEdtSomax.setText(String.valueOf(mSmax));
                mRandom = new Random();
                if(mOld_max!=mSmax || mOld_min!=mSmin)
                {
                    mOld_max=mSmax;
                    mOld_min=mSmin;
                    mTvKetqua.setText("");
                    //chep so vao mang
                    for(i=0;i<(mSmax-mSmin+1);i++)
                    {
                        arrayNumber.add(mSmin+i);
                    }
                    // check

                    for(i=0;i<arrayNumber.size();i++)
                    {
                        Log.d("BBB",String.valueOf(arrayNumber.get(i)));
                    }
                }
                if(arrayNumber.size()==0)
                {
                    Log.d("BBB","khong con gi de random");
                    Toast.makeText(MainActivity.this, "Hết số để RANDOM", Toast.LENGTH_LONG).show();
                    return;
                }
                //chay ham Random
                i = mRandom.nextInt(arrayNumber.size());
                //Lay gia tri ramdom trong arrayList
                mValue = arrayNumber.get(i);
                //remove gia tri da xuat ra
                arrayNumber.remove(i);
                //hien thi ra man hinh
                if(arrayNumber.size()==0)
                {
                    mTvKetqua.append(mValue + "");
                }
                else
                {
                    mTvKetqua.append(mValue + " - ");
                }


            }
        });

    }
}
