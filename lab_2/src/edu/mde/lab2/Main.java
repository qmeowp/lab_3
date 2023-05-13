package edu.mde.lab2;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final double A = -2.5;
        final double B = 2.5;

        final Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть х: ");
        final double x = scanner.nextDouble();

        final Function expression1 =
                Sum.of(
                        Exp.of(
                                Product.of(
                                        Const.of(A),
                                        Cos.of(Linear.X)
                                )
                        ),
                        Cbrt.of(
                                Power.of(
                                        Sin.of(
                                                Sum.of(
                                                        Product.of(
                                                               Const.of(B),
                                                               Power.of(
                                                                       Linear.X,
                                                                       3
                                                               )
                                                        ),
                                                        Const.ONE
                                                )
                                        ),
                                        2
                                )
                        )
                )
                ;
        final NumberFormat nf1 = NumberFormat.getInstance();
        System.out.format("f1(x) = %s", expression1.toPrettyString(nf1)).println();
        System.out.format("f1'(x) = %s", expression1.derivative().toPrettyString(nf1)).println();
        System.out.format("f1(" + x + ") = %f", expression1.calculate(x)).println();
        System.out.format("f1'(" + x + ") =%f", expression1.derivative().calculate(x)).println();

        final Function expression2 =
                Product.of(
                        Ctg.of(
                                Product.of(
                                        Const.of(A),
                                        Power.of(
                                                Linear.X,
                                                3
                                        )
                                )
                        ),
                        Power.of(
                                Sqrt.of(
                                        Abs.of(
                                                Sum.of(
                                                        Linear.X,
                                                        Const.of(B)
                                                )
                                        )
                                ),
                                -1
                        )
                )
                ;
        final NumberFormat nf2 = NumberFormat.getInstance();
        System.out.format("f2(x) = %s", expression2.toPrettyString(nf2)).println();
        System.out.format("f2'(x) = %s", expression2.derivative().toPrettyString(nf2)).println();
        System.out.format("f2(" + x + ") = %f", expression2.calculate(x)).println();
        System.out.format("f2'(" + x + ") =%f", expression2.derivative().calculate(x)).println();
    }
}