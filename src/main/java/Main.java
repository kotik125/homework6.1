public class Main {

    public static void main(String[] args) {
        Calculator calc = new Calculator();

        double deduct = calc.deduction(93, 74);
        System.out.println("Вычитание: 93 - 74 = " + deduct);

        double add = calc.addition(93, 74);
        System.out.println("Сложение: 93 + 74 = " + add);

        double mult = calc.multiplication(93, 74);
        System.out.println("Умножение: 93 * 74 = " + mult);

        int div = calc.division(93, 74);
        System.out.println("Деление: 93 / 74 = " + div);

        String mathEq = "8 / 2 * 3 - 5 + 8";
        System.out.println("Исходный формат уровнения: " + mathEq);
        calc.polishNotation(mathEq);
        System.out.println();

        int x = 11;
        int result = calc.linearEquation(x);
        System.out.println(
                "Линейное уравнение: 8 * (" + x + " - 1) + 2 * " + x + " / 2 = " + result);
    }
}
