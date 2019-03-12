package expressionParser;

public abstract class BinaryOperation extends Expression {
    private Expression left;
    private Expression right;

    BinaryOperation(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
    public String toString() {
        return "(" + getOperation() + "," + left + "," + right + ")";
    }
}
