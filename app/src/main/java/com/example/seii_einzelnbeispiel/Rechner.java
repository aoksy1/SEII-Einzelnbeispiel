package com.example.seii_einzelnbeispiel;

import android.util.Log;
import android.widget.TextView;

public class Rechner {
    private final TextView responseTextView;

    public Rechner(TextView responseTextView) {
        this.responseTextView = responseTextView;
    }

    public int querSumme(String matriculationNumber){
        int numbersSum = 0;
        for(char number : matriculationNumber.toCharArray()){
            numbersSum += Character.getNumericValue(number);
        }

        Log.e("TAG", "amar "+numbersSum);

        final int result = numbersSum;
        responseTextView.post(new Runnable() {
            @Override
            public void run() {
                responseTextView.setText(String.valueOf(result));
            }
        });
        return result;
    }

    public String intToBinary(int number){
        return "";
    }
}
