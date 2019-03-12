package expressionParser;

public class Conjunction extends BinaryOperation{

    public Conjunction(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public String getOperation() {
        return "&";
    }
}
