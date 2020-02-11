/**************************************
BİLİŞİM SİSTEMLERİ MÜHENDİSLİĞİ
PROGRAMLAMA DİLLERİ PRENSİPLERİ ÖDEV 1
İLKNUR KARADUMAN    B161200040
****************************************

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deneme;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author İLKNUR KARADUMAN
 */
public class Deneme {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File file=new File("dosya.txt"); 
	try 
        {
            file.createNewFile();
            try (FileOutputStream output = new FileOutputStream(file)) {
                FileWriter fw= new FileWriter("dosya.txt");
                try (PrintWriter pw = new PrintWriter(fw)) 
                {
                    int rastgele=(11+(int) (Math.random()*88));
                    System.out.println("rastgele üretilen sayı="+rastgele);
                    ArrayList xi = new ArrayList();
                    ArrayList yi = new ArrayList();
                    ArrayList s = new ArrayList();
                    ArrayList fark = new ArrayList();
                    HashMap  liste = new HashMap <>();
                    pw.println(" xi     yi     si");
                    for(int i=0; i<rastgele; i++)
                    {
                        int xideger=(500+(int) (Math.random()*499));
                        xi.add(xideger);
                        int yideger=(1000+(int) (Math.random()*499));
                        yi.add(yideger);
                        int sideger=(1+(int) (Math.random()*4));
                        s.add(sideger);
                        pw.println(xi.get(i)+"     "+yi.get(i)+"     "+s.get(i));
                    }
                    Scanner input = new Scanner(System.in);
                    int xyeni;
                    System.out.print("500 ile 999 arası bir sayı giriniz: ");
                    xyeni = input.nextInt();
                    Scanner giriş = new Scanner(System.in);
                    int yyeni;
                    System.out.print("1000 ile 1499 arası bir sayı giriniz: ");
                    yyeni = giriş.nextInt();
                    System.out.println("xyeni="+xyeni+"   yyeni="+yyeni);
                    pw.println("FARKLAR");
                    for(int i=0; i<rastgele; i++)
                    {
                        int a=(int)xi.get(i)-xyeni;
                        int b=(int)yi.get(i)-yyeni;
                        int c=(int)(Math.pow(a,2)+ Math.pow(b,2));
                        int farkdegeri=(int)Math.sqrt(c);
                        fark.add(farkdegeri);
                        pw.println(fark.get(i));
                        liste.put(fark.get(i),s.get(i));
                    }
                    pw.println("xxxxxxxxxxx");
                    Collections.sort(fark);  // Sıralanmış diziyi gösteriyoruz
                    pw.println("FARK DEGERLERININ SIRALANMIS HALI VE O INDISE KARSILIK GELEN SI DEGERLERI:");
                    for (int i = 0; i < fark.size(); i++) 
                    {
                        int q=(int)liste.get(fark.get(i));
                       pw.println((i+1) + " -> " + fark.get(i)+ " -> "+q );
                    }
                    pw.println("xxxxxxxxxxx    önceki tablonun ilk 11'i");
                    pw.println("---> sıralanan farklar -> s degerleri");
                    int  sayac1 = 0, sayac2 = 0, sayac3 = 0, sayac4 = 0, sayac5 = 0, encok=0;
                    for (int i = 0; i < 11 ; i++) 
                    {
                        int q=(int)liste.get(fark.get(i));
                        int[] qq = new int[15000];
                        qq[i] = q;
                        pw.println((i+1) + " -> " + fark.get(i)+ " -> "+q );
                        switch (qq[i]) {
                            case 1:
                                sayac1++;
                                break;
                            case 2:
                                sayac2++;
                                break;
                            case 3:
                                sayac3++;
                                break;
                            case 4:
                                sayac4++;
                                break;
                            case 5:
                                sayac5++;
                                break;
                            default:
                                break;
                        }
                        if (sayac1>sayac2 && sayac1>sayac3 && sayac1>sayac4 && sayac1>sayac5) {encok = 1;}
                        if (sayac2>sayac1 && sayac2>sayac3 && sayac2>sayac4 && sayac2>sayac5) {encok = 2;}
                        if (sayac3>sayac1 && sayac3>sayac2 && sayac3>sayac4 && sayac3>sayac5) {encok = 3;}
                        if (sayac4>sayac1 && sayac4>sayac2 && sayac4>sayac3 && sayac4>sayac5) {encok = 4;}
                        if (sayac5>sayac1 && sayac5>sayac2 && sayac5>sayac3 && sayac5>sayac4) {encok = 5;}
                    }
                    pw.println("xxxxxxxxxx");
                    pw.println("tekrar eden 1 sayısı: "+sayac1);
                    pw.println("tekrar eden 2 sayısı: "+sayac2);
                    pw.println("tekrar eden 3 sayısı: "+sayac3);
                    pw.println("tekrar eden 4 sayısı: "+sayac4);
                    pw.println("tekrar eden 5 sayısı: "+sayac5);
                    pw.println("SONUÇ:");
                    pw.println("en cok tekrar eden si degeri: "+encok);
                }
            }
        } catch (IOException e)
        {
        }
    }
    
}
