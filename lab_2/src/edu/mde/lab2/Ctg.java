package edu.mde.lab2;

import java.text.NumberFormat;

public class Ctg implements Function{
    private final Function fx;

    public Ctg(Function fx) {
        this.fx = fx;
    }

    @Override
    public double calculate(double x){
        return Math.cos(fx.calculate(x)) / Math.sin(fx.calculate(x));
    }
    @Override
    public Function derivative(){
        return new Product(Const.NEGATIVE_ONE, new Power(new Sin(fx), -2), fx.derivative());
    }
    @Override
    public String toPrettyString(NumberFormat nf){
        return "Ctg(" + fx.toPrettyString(nf) + ")";
    }

    public static Ctg of(Function fx){
        return new Ctg(fx);
    }
}
