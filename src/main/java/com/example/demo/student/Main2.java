package com.example.demo.student;
/*
Run–length encoding (RLE) is a simple form of lossless data compression that runs on
sequences with the same value occurring many consecutive times.
It encodes the sequence to store only a single value and its count.
 */

public class Main2 {
        // Perform Run–length encoding (RLE) data compression algorithm
        // on string `str`
        public static String encode(String str)
        {
            // stores output string
            String someString = "";
            
            // base case
            if (str == null) {
                return someString;
            }

            int count;

            for (int i = 0; i < str.length(); i++)
            {
                // count occurrences of character at index `i`
                count = 1;
                while (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1))
                {
                    count++;
                    i++;
                }

                // append current character and its count to the result
                someString += String.valueOf(count) + str.charAt(i);
            }

            return someString;
        }

        public static void main(String[] args)
        {
            String str = "ABBCCCD";

            System.out.print(encode(str));
        }

}
