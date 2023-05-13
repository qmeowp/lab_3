package edu.mde.lab2;

import java.text.NumberFormat;

public class Cbrt implements Function{
    private final Function fx;

    public Cbrt(Function fx) {
        this.fx = fx;
    }

    @Override
    public double calculate(double x){
        return Math.cbrt(fx.calculate(x));
    }
    @Override
    public Function derivative(){
        return new Product(new Power(new Product(new Const(3), new Power(new Cbrt(fx), 2)), -1),fx.derivative());
    }
    @Override
    public String toPrettyString(NumberFormat nf){
        return "Cbrt(" + fx.toPrettyString(nf) + ")";
    }

    public static Cbrt of(Function fx){
        return new Cbrt(fx);
    }
}
