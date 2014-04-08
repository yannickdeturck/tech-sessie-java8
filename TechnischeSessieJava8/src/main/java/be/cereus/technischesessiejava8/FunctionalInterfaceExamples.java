package be.cereus.technischesessiejava8;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalInterfaceExamples {

    @FunctionalInterface
    interface Formula {
        double calculate(int a, int b);
    }

    public static void main(String[] args) {
        // Java 7
        Formula myFormula = new Formula() {
            @Override
            public double calculate(int a, int b) {
                return a + b;
            }
        };
        // or using a Lambda
        Formula myFormulaV2 = (a, b) -> a - b;

        System.out.println(myFormula.calculate(1, 2));
        System.out.println("---");
        System.out.println(myFormulaV2.calculate(5, 3));

        Converter<Double, Double> kmConverter = kmAmount -> kmAmount * 1000;
        System.out.println(kmConverter.convert(5.12));

        System.out.println("---");

        // Predicate example (takes an argument and returns a boolean result)
        Predicate<String> isNull = s ->  s == null;
        System.out.println(isNull.test("something"));

        System.out.println("---");

        // Function example (takes an argument and returns a result)
        Function<String, Integer> calculateLength = s -> s.length();
        System.out.println(calculateLength.apply("foo"));

        System.out.println("---");

        // Consumer example (takes an argument and returns nothing, eg it operates via side-effects)
        Consumer<Integer> consumer = x -> System.out.println(x);
    }

    @FunctionalInterface
    interface Converter<F, T> {
        T convert(F from);
    }

}