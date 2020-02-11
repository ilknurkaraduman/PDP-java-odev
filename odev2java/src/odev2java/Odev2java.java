/**************************************
BİLİŞİM SİSTEMLERİ MÜHENDİSLİĞİ
PROGRAMLAMA DİLLERİ PRENSİPLERİ ÖDEV 2
İLKNUR KARADUMAN    B161200040
TARİH : 22.04.2018
****************************************/
package odev2java;
/**
 * @author İLKNUR KARADUMAN
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
class metotlar
{
    String[] dizi = new String[20];
    int elemansayisi=20;
    void satiroku() throws FileNotFoundException, IOException {
        File file = new File("veriler.txt");
        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(file));
        String satir = reader.readLine();
        while (satir!=null) {
            System.out.println(satir);
            satir = reader.readLine();
        }
    }
    void kontrol() throws IOException{
        try {
            File f = new File("veriler.txt");
            FileReader fr;
            fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String satir;
            try {
                int j=0;
                while ((satir = br.readLine()) != null) { 
                    dizi[j] = satir.toString();
                    j++;
                }
                for (int k = 0; k< 20; k++) {
                    System.out.print(dizi[k]+"  :  ");
                    String Str1 =dizi[k];
                    System.out.println(Str1.matches("veriler:[5-9][0-9][0-9]-1[0-4][0-9][0-9]-[1-5]"));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    void uygunluk(){        
        try {
            File f = new File("veriler.txt");
            FileReader fr;
            fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String satir;
            try {
                int j=0;
                while ((satir = br.readLine()) != null) {
                    dizi[j] = satir.toString();
                    j++;
                }
                BufferedWriter output=new BufferedWriter(new FileWriter("veriler.txt",false));
                
                for (int k = 0; k< 20; k++) {
                    System.out.print(dizi[k]+"  :  ");
                    String Str1 =dizi[k];
                    if(Str1.matches("veriler:[5-9][0-9][0-9]-1[0-4][0-9][0-9]-[1-5]")){
                        System.out.println("karakter katari uygun");
                        ayristir(Str1);
                        output.write(dizi[k]);
                        output.newLine();
                    }
                    else{
                        System.out.println("karakter katari uygun degildir");
                        //sil(k);
                    }
                }output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        /*System.out.println("--------------- YENİİİİ \n");
        for(int i=0; i<elemansayisi;i++){
            System.out.println(dizi[i]);
        }*/
    }
    void ayristir(String bölünen){
        String[] Lines = bölünen.split("-");
        int LineCount = Lines.length;
        for(int i=0; i< LineCount; i++) {
            System.out.println( (i+1) + ".->  :" + Lines[i]);
        }
    }
    /*void sil(int index){
        for(int i=index; i<elemansayisi-1;i++){
                            dizi[i]=dizi[i+1];
                        }
        elemansayisi--;
    }*/
}

public class Odev2java 
{
    public static void main(String[] args) throws IOException 
    {
        System.out.println("METOT 1: DOSYAYI OKU");
        System.out.println("********************");
        metotlar satirokur = new metotlar();
        satirokur.satiroku();
        System.out.println("********************");
        System.out.println("METOT 2: KONTROL ET");
        System.out.println("********************");
        metotlar listemm = new metotlar();
        listemm.kontrol();
        System.out.println("********************");
        System.out.println("METOT 3: UYGUNLUK- SİL/AYRIŞTIR");
        System.out.println("********************");
        metotlar yazdir = new metotlar();
        yazdir.uygunluk();
               
    }
    
}
