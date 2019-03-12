package expressionParser;

public class Disjunction extends BinaryOperation {

    public Disjunction(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public String getOperation() {
        return "|";
    }
}
