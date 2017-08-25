package offer.jihe;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by zack.lr on 2017/7/29.
 */
public class TestArrays {
    public static void main(String[] args) {
        //Integer []a  = {2,5,1,9,3};
/*        int []a  = {2,5,1,9,3};
        Arrays.sort(a, new Comparable<>() {
            public int compareTo(Integer o) {
                return 0;
            }
        });*/

        String []b = {"a","c","b","z"};
        Arrays.sort(b, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        for (String s : b) {
            System.out.println(s);
        }
    }

    @Test
    public void gsq(){
        System.out.println("lirui".compareTo("lizhi"));
        System.out.println("lirui".compareTo("lidan"));

        Comparator<String> haha = new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }

            public boolean equals(Object obj) {
                return false;
            }
        };

        System.out.println(haha.compare("lirui","lizhi"));
        System.out.println(haha.compare("lirui","lidhi"));


        String []A = {"lirui","lizhi","lidan"};
        Arrays.sort(A,haha);
        for (String s : A) {
            System.out.println(s);
        }

    }
}
