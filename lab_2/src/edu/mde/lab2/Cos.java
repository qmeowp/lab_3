package edu.mde.lab2;

import java.text.NumberFormat;

public class Cos implements Function{
    private final Function fx;

    public Cos(Function fx) {
        this.fx = fx;
    }

    @Override
    public double calculate(double x){
        return Math.cos(fx.calculate(x));
    }
    @Override
    public Function derivative(){
        return new Product(Const.NEGATIVE_ONE, new Sin(fx), fx.derivative());
    }
    @Override
    public String toPrettyString(NumberFormat nf){
        return "Cos(" + fx.toPrettyString(nf) + ")";
    }

    public static Cos of(Function fx){
        return new Cos(fx);
    }
}
