package expressionParser;

public class Negate extends Expression {

    private Expression expression;

    public Negate(Expression expression) {
        this.expression = expression;
    }

    @Override
    public String getOperation() {
        return "!";
    }

    @Override
    public String toString() {
        return "(" + getOperation() + expression.toString() + ")";
    }
}
