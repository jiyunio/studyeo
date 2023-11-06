import javax.swing.*;
import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String word = scan.next();
        word = word.toUpperCase();
        int[] word_count = new int[26];

        int index;
        for (int i = 0; i < word.length(); i++) {
            index = word.charAt(i) - 'A';
            word_count[index]++;
        }

        int max = 0;
        int max_index = 0;
        for (int i = 0; i < 26; i++) {
            if (word_count[i] >= max) {
                max = word_count[i];
                max_index = i;
            }
        }

        int max_sec = 0;
        for (int i = 0; i < max_index; i++) {
            if(word_count[i] >= max_sec){
                max_sec = word_count[i];
            }
        }

        if(max_sec == word_count[max_index]){
            System.out.println("?");
        }
        else{
            max_index = max_index+'A';
            System.out.println((char)max_index);
        }
    }
}