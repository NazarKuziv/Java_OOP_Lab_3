package com.company;

import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System. in);

    static String[] SpecialtyStr = { "Комп’ютерні науки", "Інформатика", "Математика та економіка", "Фізика та інформатика", "Трудове навчання" };

    static public class Student
    {
        public String prizv;
        public int kurs;
        public String specialty;
        public int Phisic;
        public int Math;
        public int IT;

        public Student(String prizv,int kurs,String specialty,int Phisic,int Math,int IT)
        {
            this.prizv = prizv;
            this.kurs = kurs;
            this.specialty = specialty;
            this.Phisic = Phisic;
            this.Math = Math;
            this.IT = IT;
        }
        public void setPrizv(String value) {
            prizv = value;
        }
        public void setKurs(int value) {
            kurs = value;
        }
        public void setSpecialty(String value) {
            specialty = value;
        }
        public void setPhisic(int value) {
            Phisic = value;
        }
        public void setMath(int value) {
            Math = value;
        }
        public void setIT(int value) {
            IT = value;
        }
    }


    public static void main(String[] args) {
        int N;
        System.out.print("Введіть кількість студентів = ");
        N = input.nextInt();
        Student[] p = new Student[N];
        for (int i = 0; i < N; i++) {
            p[i] = new Student("", 0, "", 0, 0, 0);
        }
        Create(p);
        Print(p);
        double P = Percentage_of_Excellent_Students(p,N);
        System.out.println("Введіть кількість студентів " + String.format("%.0f", P)+ " %");
        System.out.println("");
        Print_Students_Who_Have_5_or_4_In_Physics(p);
    }
    static void Create(Student[] p)
    {
        int specialty;
        int n = 1;
        for (int i = 0; i < p.length; i++) {
            System.out.println("Студент № " + n++ );
            System.out.print(" Прізвище: ");p[i].prizv = input.next();
            System.out.print(" Курс: "); p[i].kurs = input.nextInt();
            System.out.print("  Спеціальність (0 - Комп’ютерні науки, 1 - Інформатика, 2 - Математика та економіка, 3 - Фізика та інформатика, 4 - Трудове навчання): ");
            specialty = input.nextInt();
            p[i].specialty = SpecialtyStr[specialty];
            System.out.print(" Оцінка з Фізики: "); p[i].Phisic = input.nextInt();
            System.out.print(" Оцінка з Математики: "); p[i].Math = input.nextInt();
            System.out.print(" Оцінка з Інформатики: "); p[i].IT = input.nextInt();
        }
    }
    static void Print(Student[] p)
    {
        System.out.println("=====================================================================================================================");
        System.out.println("                                        Список студентів");
        System.out.println("=====================================================================================================================");
        System.out.println("|  № |   Прізвище   | Курс |      Спеціальність      | Оцінка з Фізики | Оцінка з Математики | Оцінка з Інформатики |");
        System.out.println("---------------------------------------------------------------------------------------------------------------------");

        for (int i = 0; i < p.length; i++) {
            String str_1 = String.format("|%-4d|", i+1);
            String str_2 = String.format("%-14s|", p[i].prizv);
            String str_3 = String.format("%-6d|", p[i].kurs);
            String str_4 = String.format("%-25s|", p[i].specialty);
            String str_5 = String.format("%-17d|", p[i].Phisic);
            String str_6 = String.format("%-21d|", p[i].Math);
            String str_7 = String.format("%-22d|", p[i].IT);
            System.out.println(str_1 + str_2 + str_3 + str_4 + str_5 + str_6 + str_7);
        }
        System.out.println("=====================================================================================================================");
        System.out.println("");
    }
    static double Percentage_of_Excellent_Students(Student[] p, int N){
        double P = 0;

        for (int i = 0; i < N; i++)
        {
            if (p[i].Phisic > 3 && p[i].Math > 3 && p[i].IT > 3)
                P += 1;
        }

        P = (P / N) * 100;

        return P;
    }
    static void Print_Students_Who_Have_5_or_4_In_Physics(Student[] p)
    {
        System.out.println("Прізвища студентів, які отримали з фізики оцінки “5” або “4”: ");
        for (int i = 0; i < p.length; i++)
            if (p[i].Phisic == 4 || p[i].Phisic == 5)
                System.out.println(i+1+":"+p[i].prizv);

    }
}
