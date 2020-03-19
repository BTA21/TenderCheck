package seachMethods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

public class StringSearchUsingRabinKarpAlgorithm {
    public final static int d = 10;

    StringSearchUsingRabinKarpAlgorithm(String pat, String txt, int q)
    {
        int m = pat.length();
        int n = txt.length();
        int i, j;
        int p = 0;
        int t = 0;
        int h = 1;
        if(txt.length()<pat.length()) {
            System.out.println("Pattern not found");
            return;
        }


        for (i = 0; i < m-1; i++)
            h = (h*d)%q;

        for (i = 0; i < m; i++)
        {
            p = (d*p + pat.charAt(i))%q;
            t = (d*t + txt.charAt(i))%q;
        }

        for (i = 0; i <= n - m; i++)
        {
            if ( p == t )
            {
                for (j = 0; j < m; j++)
                {
                    if (txt.charAt(i+j) != pat.charAt(j))
                    break;
                }

                if (j == m)
                    System.out.println("Pattern found at index " + (i+1));
            }

            if ( i < n-m )
            {
                t = (d*(t - txt.charAt(i)*h) + txt.charAt(i+m))%q;
                if (t < 0)
                    t = (t + q);
            }
        }
    }
}