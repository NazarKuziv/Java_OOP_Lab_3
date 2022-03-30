package com.company;

import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System. in);
    public static boolean Contain(String s)
    {
        String s1 = "SQ";
        String s2 = "QS";
        boolean b = false;
        b = s.contains(s1);
        if(b == true)
            return b;
        else
            b = s.contains(s2);

        return b;
    }
    static int CountWords(String str)
    {
        if(str == null || str.isEmpty())
            return 0;

        int count = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) != ' '){
                count++;
                while(str.charAt(i) != ' ' && i < str.length()-1){
                    i++;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        String s;
        System.out.print("Enter string: ");
        s = input.nextLine();
        boolean b = Contain(s);
        System.out.println("1) Whether there is a pair of adjacent letters SQ or QS among the characters:");
        if (b)
            System.out.println("Yes");
        else
            System.out.println("No");

        System.out.println("2) Кeplace SQ or QS with *** :");
        String s2 = s.replace("SQ", "***");
        s2 = s2.replace("QS", "***");
        System.out.println(s2);
        System.out.println("");
        System.out.println("3) Number of words = "+CountWords(s));

    }
}
