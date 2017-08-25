package xiaozhao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zack.lr on 2017/8/12.
 */

public class T0302{

    //public static int[] nixu(int[] array){
    public static int[] nixu(String array0){
        String[] split = array0.split(",");
        int[] array = new int[array0.length()];
        for (int i =0;i<split.length;i++) {
            array[i] = Integer.parseInt(split[i]);
        }
        int array2[] = new int[array.length];
        for(int i = 0; i < array.length; i++){
            int value = array[array.length-(i+1)];
            array2[i] = value;
        }
        return array2;
    }

    /*public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()){
            String next = scanner.nextLine();
            String next1 = scanner.nextLine();
            int count = Integer.parseInt(next);
            String[] split = next1.split(" ");

            StringBuilder builder = new StringBuilder();

            for(int i=0;i<split.length;i++){
                builder.append(split[i]+",");
                int[] nixu = nixu(builder.toString());



                if(nixu.length==split.length){
                    for (int j=0;j<nixu.length; j++) {
                        if(j<nixu.length-1){
                            System.out.print(nixu[j]+" ");
                        }else{
                            System.out.print(nixu[j]);
                        }
                    }
                }
            }


        }
    }*/

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        StringBuilder builder = new StringBuilder();
        builder.append(",");

        String next = scanner.nextLine();
        String next1 = scanner.nextLine();
        int count = Integer.parseInt(next);
        String[] split0 = next1.split(" ");

        for(int i =0;i<split0.length;i++){
            builder.append(split0[i]+",");
            builder.reverse();
        }

        String[] split = builder.toString().substring(1).split(",");

        for(int i=0;i<split.length;i++){
            if(i<split.length-1){
                    System.out.print(split[i]+" ");
                }else{
                    System.out.print(split[i]);
                }
            }
        }

}
