package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.enter);
        display.setShowSoftInputOnFocus(false);

    }
    private void  addToText( String strAdd){
        String old_string = display.getText().toString();
        int cursor_pos = display.getSelectionStart();
        String leftstr = old_string.substring(0,cursor_pos);
        String rightstr = old_string.substring(cursor_pos);
        if(getString(R.string.display).equals(display.getText().toString())){
            display.setText(strAdd);
        }
        else {
            display.setText((String.format("%s%s%s", leftstr, strAdd, rightstr)));
            display.setSelection(cursor_pos + 1);
        }

    }
    public void zeroBTN(View view){
        addToText("0");
    }
    public void oneBTN(View view){
        addToText("1");
    }
    public void twoBTN(View view){
        addToText("2");
    }
    public void threeBTN(View view){
        addToText("3");
    }
    public void fourBTN(View view){
        addToText("4");

    }
    public void fiveBTN(View view){
        addToText("5");
    }
    public void sixBTN(View view){
        addToText("6");

    }
    public void sevenBTN(View view){
        addToText("7");

    }
    public void eightBTN(View view){
        addToText("8");

    }
    public void nineBTN(View view){
        addToText("9");

    }
    public void startBTN(View view){
        addToText("(");

    }
    public void endBTN(View view){
        addToText(")");

    }
    public void decimalBTN(View view){
        addToText(".");
    }
    public void powerBTN(View view){
        addToText("^");

    }
    public void plusBTN(View view){
        addToText("+");

    }
    public void minusBTN(View view){
        addToText("-");

    }
    public void multiplyBTN(View view){
        addToText("x");

    }
    public void divideBTN(View view){
        addToText("÷");

    }
    public void backspaceBTN(View view){
        int cursorPos = display.getSelectionStart();
        int strLen = display.getText().length();
        if(cursorPos !=0 && strLen !=0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos-1,cursorPos,"");
            display.setText(selection);
            display.setSelection(cursorPos-1);
        }
    }
    public void clearBTN(View view){
        display.setText("");

    }
    public void equalsBTN(View view){
        String exp = display.getText().toString();
        exp = exp.replaceAll("÷","/");
        exp = exp.replaceAll("x","*");
        Expression expression = new Expression(exp);
        String res = String.valueOf(expression.calculate());
        display.setText(res);
        display.setSelection(res.length());
    }


}