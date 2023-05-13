package edu.mde.lab2;

import java.text.NumberFormat;

public class Exp implements Function{
    private final Function fx;

    public Exp(Function fx) {
        this.fx = fx;
    }

    @Override
    public double calculate(double x){
        return Math.exp(fx.calculate(x));
    }
    @Override
    public Function derivative(){
        return new Product(new Exp(fx), fx.derivative());
    }
    @Override
    public String toPrettyString(NumberFormat nf){
        return "Exp(" + fx.toPrettyString(nf) + ")";
    }

    public static Exp of(Function fx){
        return new Exp(fx);
    }
}
