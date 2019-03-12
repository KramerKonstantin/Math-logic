package expressionParser;

public class Variable extends Expression {
    private String var;

    public Variable(String var) {
        this.var = var;
    }

    @Override
    public String getOperation() {
        return "";
    }

    @Override
    public String toString() {
        return var;
    }
}
