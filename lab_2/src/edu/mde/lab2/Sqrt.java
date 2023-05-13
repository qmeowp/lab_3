package edu.mde.lab2;

import java.text.NumberFormat;

public class Sqrt implements Function{
    private final Function fx;

    public Sqrt(Function fx) {
        this.fx = fx;
    }

    @Override
    public double calculate(double x){
        return Math.sqrt(fx.calculate(x));
    }
    @Override
    public Function derivative(){
        return new Product(new Power(new Product(new Const(2), new Sqrt(fx)), -1),fx.derivative());
    }
    @Override
    public String toPrettyString(NumberFormat nf){
        return "Sqrt(" + fx.toPrettyString(nf) + ")";
    }

    public static Sqrt of(Function fx){
        return new Sqrt(fx);
    }
}
