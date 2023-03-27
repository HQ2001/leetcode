package com.hlju.weizhongyinhang;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int a = s.nextInt();
            int b = s.nextInt();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            int result = 0;
            Calendar calendar = Calendar.getInstance();
            for (int i = a; i <= b; i++) {
                for (int j = 1; j <= 12; j++) {
                    String str = j < 10 ? "0" + j : String.valueOf(j);
                    Date date = sdf.parse(i + str + "01");
                    calendar.setTime(date);
                    int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
                    if (dayOfWeek == Calendar.MONDAY) {
                        result ++;
                    }
                }
            }
            System.out.println(result);

        }
    }

}
