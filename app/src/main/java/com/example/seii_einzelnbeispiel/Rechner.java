package com.example.seii_einzelnbeispiel;

import android.util.Log;
import android.widget.TextView;

public class Rechner {

    public int querSumme(String matriculationNumber){
        int numbersSum = 0;

        for(char number : matriculationNumber.toCharArray()){
            numbersSum += Character.getNumericValue(number);
        }

        return numbersSum;
    }

    public String intToBinary(int number){
        String binary = Integer.toBinaryString(number);

        final String result = binary;

        return result;
    }
}
