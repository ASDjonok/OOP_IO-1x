package io12._20_maksymenko.lab_2_OOP.src;

public class CalcClass {
    private short MY_ARR[][] = { { 4, 4, 12, 3, 3 }, { 5, 6, 5, 23, 5 }, { 0, 11, 52, 13, 14 }, { 5, 16, 6, 1, 1 },
            { 20, 1, 2, 23, 4 } };
    private short res;

    void call_calcC5(short CONST_A) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                MY_ARR[i][j] = (short) ((MY_ARR[i][j]) * CONST_A);
            }
        }

    }

    void call_calcC11() {
        short BUFF;
        res = 0;
        for (int i = 0; i < 5; i++) {

            for (int j = 4; j > 0; j--) {
                if (MY_ARR[i][j-1] < MY_ARR[i][j]) {
                    BUFF = MY_ARR[i][j-1];
                    MY_ARR[i][j-1] = MY_ARR[i][j];
                    MY_ARR[i][j] = BUFF;
                    j = 5;
                }
            }
            res += MY_ARR[i][4];
        }

    }

    void call_out() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(MY_ARR[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("Sum C11 is " + res);
    }
}
