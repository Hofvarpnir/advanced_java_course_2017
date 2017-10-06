package edu.technopolis;

/**
 * Это <b>неправильный</b> с точки зрения задания алгоритм.
 */
public class DummyFibonacciAlgorithm implements FibonacciAlgorithm {
    @Override
    public String evaluate(int index) {
        String i1;
        String i2;
        String sum;
        i1 = "1";
        i2 = "1";
        sum = i1;
        int i=2;
        while(i < index)
        {
            sum = BigSumm(i1, i2);
            i1 = i2;
            i2 = sum;
            i++;
        }
        return sum;
    }

    private static String BigSumm(String a, String b)
    {
        int max = Math.max(a.length(), b.length());
        byte[] digit1 = new byte[max];
        byte[] digit2 = new byte[max];
        int buffer = 0;
        String result = new String();
        for (int i = 0; i < max; i++) {
            if (i < a.length()) {
                digit1[i] = Byte.parseByte(a.substring(a.length() - i - 1, a.length() - i));

            }
            if (i < b.length()) {
                digit2[i] = Byte.parseByte(b.substring(b.length() - i - 1, b.length() - i));
            }
        }
        for (int i = 0; i < max; i++)
        {
            buffer += digit1[i] + digit2[i];
            if (buffer > 9)
            {

                result += buffer % 10;
                buffer /= 10;
            }
            else
            {
                result += buffer;
                buffer = 0;
            }
        }
        if (buffer != 0)
            result += buffer;
        String summfine = new StringBuilder(result).reverse().toString();
        return summfine;
    }
}
