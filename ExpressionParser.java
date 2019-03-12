package expressionParser;

public class ExpressionParser {

    private static String expression;
    private int currentPosition;
    private long length;

    private Expression variable() {
        StringBuilder var = new StringBuilder();
        Expression current;
        char symbol = expression.charAt(currentPosition);
        while (currentPosition < length
                && (
                    Character.isLetter(symbol)
                    || Character.isDigit(symbol)
                    || symbol == '\''
                    )
                ) {
            var.append(symbol);
            currentPosition++;
            if (currentPosition < length) {
                symbol = expression.charAt(currentPosition);
            }
        }
        current = new Variable(var.toString());
        return current;
    }

    private Expression bracket() {
        char symbol = expression.charAt(currentPosition);
        if (symbol == '!') {
            currentPosition++;
            return new Negate(bracket());
        } else {
            if (symbol == '(') {
                currentPosition++;
                Expression current = result();
                symbol = expression.charAt(currentPosition);
                if (symbol == ')') {
                    currentPosition++;
                }
                return current;
            }
        }
        return variable();
    }

    private Expression conjunction() {
        Expression current = bracket();
        boolean check = true;
        while (check) {
            if (currentPosition == length) {
                check = false;
            } else {
                char symbol = expression.charAt(currentPosition);
                if (symbol == '&') {
                    currentPosition++;
                    current = new Conjunction(current, bracket());
                } else {
                    check = false;
                }
            }
        }
        return current;
    }

    private Expression disjunction() {
        Expression current = conjunction();
        while(currentPosition < length) {
            char symbol = expression.charAt(currentPosition);
            if (symbol == '|') {
                currentPosition++;
                current = new Disjunction(current, conjunction());
            } else {
                break;
            }
        }
        return current;
    }

    private Expression result() {
        Expression current = disjunction();
        while(currentPosition < length) {
            char symbol = expression.charAt(currentPosition);
            if (symbol == '-') {
                currentPosition += 2;
                current = new Implication(current, result());
            } else {
                break;
            }
        }
        return current;
    }

    public Expression parse(String expr) {
        expression = expr;
        currentPosition = 0;
        length = expression.length();
        return result();
    }
}
