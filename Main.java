package expressionParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String expression = bufferedReader.readLine();
        ExpressionParser parser = new ExpressionParser();

        System.out.println(parser.parse(expression));
    }
}
