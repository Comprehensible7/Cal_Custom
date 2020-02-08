package com.example.cal_custom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    double firstNum; // 1번째 숫자
    double secondNum; // 2번째 숫자
    private String op; // 연산자 입력

    String input_num = "";
    String s_operator = ""; // 연산자 값 받아올 변수

    boolean b_gap = true;


    double res = 0;
    int i_temp_num = 0; // 인트값 확인필요, firstNum, secondNum 값 확인

    private EditText etDisplay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etDisplay = (EditText) findViewById(R.id.etDisplay);


    }

    public void onNumClick(View view) {


        if (!b_gap) {

            firstNum = 0;
            secondNum = 0;
            op = "";

            etDisplay.setText("");

           // firstNum = secondNum = 0;
            
            input_num = "";
            s_operator = "";

            b_gap = true;



           /*
           텍스트창을 초기화 시키고
                    나머지도 초기화 시키고
                    기존 boolean변수는 true 로 변환
                    각 변수마다 boolean값 입력해주기
                    그래야 연산결과가 출력됨
                    */
        }



        String num = etDisplay.getText().toString();


        switch (view.getId()) {

            case R.id.btn_0:
                num += "0";
                break;

            case R.id.btn_1:
                num += "1";
                break;

            case R.id.btn_2:
                num += "2";
                break;

            case R.id.btn_3:
                num += "3";
                break;

            case R.id.btn_4:
                num += "4";
                break;

            case R.id.btn_5:
                num += "5";
                break;

            case R.id.btn_6:
                num += "6";
                break;

            case R.id.btn_7:
                num += "7";
                break;

            case R.id.btn_8:
                num += "8";
                break;

            case R.id.btn_9:
                num += "9";
                break;

            case R.id.btn_10:
                num += ".";

                // 소수점 값 입력

                if (num.equals(".")) {
                    if (etDisplay.getText().toString().equals("")) {
                        etDisplay.setText("0.");

                        return;

                    } else if (etDisplay.getText().toString().contains(".")) {
                        return;
                    }

                    if (etDisplay != null) {
                        etDisplay.append(num);

                    } else {
                        etDisplay.setText(num);
                    }

                    break;
                }
        }

        etDisplay.setText(num);


    }


    public void onOpClick(View view) {
        try {
            //firstNum = Integer.parseInt(etDisplay.getText().toString());
            firstNum = Double.parseDouble(etDisplay.getText().toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        b_gap = true;


        switch (view.getId()) {

            case R.id.btn_Plus:
                op = "+";

                setOperator();
                s_operator = "+";
                firstNum = Double.parseDouble(etDisplay.getText().toString());
                input_num = etDisplay.getText().toString();
                etDisplay.setText("");
                break;

            case R.id.btn_Minus:
                op = "-";

                setOperator();
                s_operator = "-";
                firstNum = Double.parseDouble(etDisplay.getText().toString());
                input_num = etDisplay.getText().toString();
                etDisplay.setText("");
                break;

            case R.id.btn_Mul:
                op = "*";

                setOperator();
                s_operator = "*";
                firstNum = Double.parseDouble(etDisplay.getText().toString());
                input_num = etDisplay.getText().toString();
                etDisplay.setText("");
                break;

            case R.id.btn_Div:
                op = "/";

                setOperator();
                s_operator = "/";
                firstNum = Double.parseDouble(etDisplay.getText().toString());
                input_num = etDisplay.getText().toString();
                etDisplay.setText("");
                break;

        }

        Toast.makeText(MainActivity.this, op, Toast.LENGTH_SHORT).show();

        etDisplay.setText("");

    }



    public void onEqClick(View view) {

        try {
            //secondNum = Integer.valueOf(etDisplay.getText().toString());
            secondNum = Double.parseDouble(etDisplay.getText().toString());
            // Double.toString(secondNum);
            // Double.toString(더블형변수)

            // 문제 해결해보기

            setOperator();

            b_gap = false;
            s_operator = "";
            input_num = etDisplay.getText().toString();


        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        }



        // 값 초기화

        public void onClearClick (View view){
            firstNum = 0;
            secondNum = 0;
            op = "";

            etDisplay.setText("");
            //i_temp_num = 0;
            firstNum = secondNum = 0;
            input_num = null;
            s_operator = "";
            b_gap = true;


        }
        // 값 한자리씩 지우기

        public void onResetClick (View view){

            b_gap = true;

            int result_length = etDisplay.getText().length();
            if (result_length > 1) {
                etDisplay.getText().delete(result_length - 1, result_length);
                etDisplay.setText(etDisplay.getText());
            } else if (result_length <= 1) {
                etDisplay.setText("");
            }
        }


        public void setOperator () {
            if (input_num != null && s_operator != null) {
                secondNum = 0;

                if (!(etDisplay.getText().toString().equals("")))
                    secondNum = Double.parseDouble(etDisplay.getText().toString());

                if (op.equals("+")) {
                    res = firstNum + secondNum;
                } else if (op.equals("-")) {
                    res = firstNum - secondNum;
                } else if (op.equals("/")) {
                    res = firstNum / secondNum;
                } else if (op.equals("*")) {
                    res = firstNum * secondNum;
                }

                b_gap = true;

                i_temp_num = (int) res;
                if (res == i_temp_num)
                    etDisplay.setText(Integer.toString(i_temp_num)); // remove floating point
                else etDisplay.setText(Double.toString(res));

                secondNum = 0;
            }
        }
    }



