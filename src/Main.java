import java.io.*;
import java.util.*;

class Main
{
    static String ReadLn (int maxLg)  // utility function to read from stdin
    {
        byte lin[] = new byte [maxLg];
        int lg = 0, car = -1;
        String line = "";

        try
        {
            while (lg < maxLg)
            {
                car = System.in.read();
                if ((car < 0) || (car == '\n')) break;
                lin [lg++] += car;
            }
        }
        catch (IOException e)
        {
            return (null);
        }

        if ((car < 0) && (lg == 0)) return (null);  // eof
        return (new String (lin, 0, lg));
    }

    public static void main (String args[])  // entry point from OS
    {
        Main myWork = new Main();  // create a dinamic instance
        myWork.Begin();            // the true entry point
    }

    void Begin()
    {
        String input;
        StringTokenizer idata;
        int s, n;

        input = Main.ReadLn (255);
        idata = new StringTokenizer (input);
        s = Integer.parseInt (idata.nextToken());
        n = Integer.parseInt (idata.nextToken());
        while (!(s == 0 && n == 0))
        {
            System.out.println(sevenSegment(s, n));
            input = Main.ReadLn (255);
            idata = new StringTokenizer (input);
            s = Integer.parseInt (idata.nextToken());
            n = Integer.parseInt (idata.nextToken());
        }
    }
    
    static String sevenSegment( int s, int n)
    {
        int rows = 2 * s + 3;
        int columns = s + 2;
        char[][][] number = new char[10][rows][columns];
        for (int i = 0; i < 10; i++)// build the numbers
           switch (i)
            {
                case 0: 
                    for (int k = 1; k < s + 1; k++)
                    {
                        number[i][0][k]= '-';
                        number[i][2 * s + 2][k]= '-';
                        number[i][k][0]= '|';
                        number[i][k][s+1]= '|';
                        number[i][k + s + 1][0]= '|';
                        number[i][k + s + 1][s+1]= '|';
                    }
                        
                    break;
                case 1: 
                    
                    for (int k = 1; k < s + 1; k++)
                    {
                        number[i][k][s+1]= '|';
                        number[i][k + s + 1][s+1]= '|';
                    }
                    break;
                case 2: 
                    for (int k = 1; k < s + 1; k++)
                    {
                        number[i][0][k]= '-';
                        number[i][s + 1][k]= '-';
                        number[i][2 * s + 2][k]= '-';
                        number[i][k][s+1]= '|';
                        number[i][k + s + 1][0]= '|';
                    }
                    break;
                case 3: 
                    for (int k = 1; k < s + 1; k++)
                    {
                        number[i][0][k]= '-';
                        number[i][s + 1][k]= '-';
                        number[i][2 * s + 2][k]= '-';
                        number[i][k][s+1]= '|';
                        number[i][k + s + 1][s+1]= '|';
                    }
                    break;
                case 4: 
                    for (int k = 1; k < s + 1; k++)
                    {
                        number[i][s + 1][k]= '-';
                        number[i][k][0]= '|';
                        number[i][k][s+1]= '|';
                        number[i][k + s + 1][s+1]= '|';
                    }
                    break;
                case 5: 
                    for (int k = 1; k < s + 1; k++)
                    {
                        number[i][0][k]= '-';
                        number[i][s + 1][k]= '-';
                        number[i][2 * s + 2][k]= '-';
                        number[i][k][0]= '|';
                        number[i][k + s + 1][s+1]= '|';
                    }
                    break;
                case 6: 
                    for (int k = 1; k < s + 1; k++)
                    {
                        number[i][0][k]= '-';
                        number[i][s + 1][k]= '-';
                        number[i][2 * s + 2][k]= '-';
                        number[i][k][0]= '|';
                        number[i][k + s + 1][0]= '|';
                        number[i][k + s + 1][s+1]= '|';
                    }
                    break;
                case 7: 
                    for (int k = 1; k < s + 1; k++)
                    {
                        number[i][0][k]= '-';
                        number[i][k][s+1]= '|';
                        number[i][k + s + 1][s+1]= '|';
                    }
                    break;
                case 8: 
                    for (int k = 1; k < s + 1; k++)
                    {
                        number[i][0][k]= '-';
                        number[i][s + 1][k]= '-';
                        number[i][2 * s + 2][k]= '-';
                        number[i][k][0]= '|';
                        number[i][k][s+1]= '|';
                        number[i][k + s + 1][0]= '|';
                        number[i][k + s + 1][s+1]= '|';
                    }
                    break;
                case 9: 
                    for (int k = 1; k < s + 1; k++)
                    {
                        number[i][0][k]= '-';
                        number[i][s + 1][k]= '-';
                        number[i][2 * s + 2][k]= '-';
                        number[i][k][0]= '|';
                        number[i][k][s+1]= '|';
                        number[i][k + s + 1][s+1]= '|';
                    }
                    break;
           }

        
        int numberOfDigits = String.valueOf(n).length();
        int[] digit = new int[numberOfDigits];
        for (int i = 0; i < numberOfDigits; i++)
        {
            digit[i]= n % 10;
            n = n / 10;
        }
        String result= "";
        for (int j = 0; j < 2 *s + 3;j++)
        {
            for (int i = 0; i <numberOfDigits; i ++)
            {
                String line = new String(number[digit[numberOfDigits - i - 1]][j]);
                result = result + line;
                if (i < numberOfDigits)
                    result = result + " ";
            }
            result = result + "\n";
        }
        result = result + "\n";
        return result;
    }
}