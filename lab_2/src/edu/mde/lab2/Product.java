package edu.mde.lab2;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.StringJoiner;

public class Product extends Composite{
    public Product() {
        super();
    }

    public Product(Function... functions) {
        super(functions);
    }

    public Product(ArrayList<Function> functions) {
        super(functions);
    }
    public static Product of(Function... terms) {
        return new Product(terms);
    }
    @Override
    public double calculate(double x) {
        double calc = 1;
        for (Function function: getTerms()) {
            calc *= function.calculate(x);
        }
        return calc;
    }

    @Override
    public Function derivative() {
        ArrayList<Function> finalF = new ArrayList<>(getTerms().size());
        for(int i = 0; i < getTerms().size(); i++){
            ArrayList<Function> PrF = new ArrayList<>(getTerms().size());
            int j = 0;
            for (Function function: getTerms()) {
                if(j == i) PrF.add(function.derivative());
                else PrF.add(function);
                j++;
            }
            finalF.add(new Product(PrF));
        }
        return new Sum(finalF);
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        final StringJoiner joiner = new StringJoiner("*");
        for (Function function : getTerms()) {
//            if(!function.equals(Const.of(1.0)))
                joiner.add(function.toPrettyString(nf));
        }
        return String.format("(%s)", joiner.toString());
    }
}
