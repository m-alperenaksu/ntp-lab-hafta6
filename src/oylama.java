import java.util.Scanner;
import java.util.ArrayList;

public class oylama {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int durum;
        System.out.println("Ankete girmek için 1, çıkmak için 0 giriniz\n");
        durum = input.nextInt();
        
        String[] sorunlar = {"Eğitim Sistemi", "Ekonomik Problemler", "Siyasi İklim", "Demografik Yapının Bozulması", "Çevre Sorunları"};
        int[][] dereceler = new int[5][10];
        int temp;
        int toplam = 0;
        double ortalama = 0;
        int kisiSayisi = 0;
        int[] toplamlar = new int[5];

        while(durum == 1) {
            System.out.println("Ülkenizin sahip olduğu problemlere 1'den 10'a kadar derece veriniz.\n");
            for(int i = 0; i < 5; i++) {
                System.out.println(sorunlar[i] + " derecelendiriniz: \n");
                temp = input.nextInt();
                while(temp < 1 || temp > 10) {
                    System.out.println("Lütfen 1-10 arası bir değer giriniz:");
                    temp = input.nextInt();
                }
                dereceler[i][temp-1]++;
            }
            System.out.println("Anketi doldurduğunuz için teşekkürler.\n");
            kisiSayisi++;
            System.out.println("Ankete girmek için 1, çıkmak ve sonuçları görmek için 0 giriniz:\n");
            durum = input.nextInt();
        }

        if(kisiSayisi > 0) {
            System.out.println("Sorunlar-Dereceleri ve Ortalamaları");
            for(int i = 0; i < 5; i++) {
                ortalama = 0;
                toplam = 0;
                System.out.println(sorunlar[i]);
                for(int j = 0; j < 10; j++) {    
                    System.out.println((j+1) + " - " + dereceler[i][j]);
                    toplam += dereceler[i][j] * (j+1);
                }
                toplamlar[i] = toplam;
                ortalama = (double)toplam / kisiSayisi;
                System.out.println("Bu sorunun ortalaması = " + ortalama);
            }

            int maxIndex = 0;
            for(int i = 1; i < 5; i++) {
                if(toplamlar[i] > toplamlar[maxIndex]) {
                    maxIndex = i;
                }
            }
            System.out.println("Derecesi en yüksek olan sorun = " + sorunlar[maxIndex] + " , toplam derecesi = " + toplamlar[maxIndex]);

            int minIndex = 0;
            for(int i = 1; i < 5; i++) {
                if(toplamlar[i] < toplamlar[minIndex]) {
                    minIndex = i;
                }
            }
            System.out.println("Derecesi en düşük olan sorun = " + sorunlar[minIndex] + " , toplam derecesi = " + toplamlar[minIndex]);
        } else {
            System.out.println("Hiç anket doldurulmadı!");
        }
    }
}