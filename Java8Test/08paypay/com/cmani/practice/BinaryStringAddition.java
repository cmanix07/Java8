package com.cmani.practice;

public class BinaryStringAddition {

    public static String sumBinary(String s1, String s2){
        String output = "";
        int digitSum = 0;
        int len1 = s1.length() - 1 ;
        int len2 = s2.length() - 1;
        while(len1>=0 || len2 >= 0 ){
            digitSum +=  (len1>=0) ? s1.charAt(len1) - '0' : 0;
            digitSum +=  (len2>=0) ? s2.charAt(len2) - '0' : 0;

            output = (char) (digitSum % 2 + '0') + output;
            digitSum = digitSum/2;
            len1--;
            len2--;
        }
        //Last digit has a carry then append this carry to output.
        if (digitSum !=0)
            output = "1"+output;
        return output;
    }

    public static void main(String[] args) {
        String s1 = "1010";
        String s2 = "1011";
        System.out.println(sumBinary(s1,s2));
    }
}
