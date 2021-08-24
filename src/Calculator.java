import java.util.Arrays;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws MyException {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] words = input.split(" ");
        String[] wordsCheck = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"};
        String[] RomanCheck = {" ", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        if (words.length > 3) {
            throw new MyException("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        if (words.length < 3){
            throw new MyException("//т.к. строка не является математической операцией");
        }
        if ((!(words[1].equals("+"))) && (!(words[1].equals("*"))) && (!(words[1].equals("/"))) && (!(words[1].equals("-")))) {
            throw new MyException("\"" + words[1] + "\"" + " " + "Не явялется оператором!");
        }
        int indexAArabicCheck = Arrays.asList(wordsCheck).indexOf(words[0]);
        int indexBArabicCheck = Arrays.asList(wordsCheck).indexOf(words[2]);
        int indexARomanCheck = Arrays.asList(RomanCheck).indexOf(words[0]);
        int indexBRomanCheck = Arrays.asList(RomanCheck).indexOf(words[2]);
        if ((indexAArabicCheck >= 0) && (indexBArabicCheck >= 0)) {
            switch (words[1]) {
                case "+" -> System.out.println(indexAArabicCheck + indexBArabicCheck);
                case "-" -> System.out.println(indexAArabicCheck - indexBArabicCheck);
                case "*" -> System.out.println(indexAArabicCheck * indexBArabicCheck);
                case "/" -> System.out.println(indexAArabicCheck / indexBArabicCheck);
            }
        }else if ((indexARomanCheck >= 0) && (indexBRomanCheck >= 0)) {
            Roman roman = new Roman();
            switch (words[1]) {
                case "+" -> System.out.println(roman.RomArray[indexARomanCheck + indexBRomanCheck]);
                case "-" -> System.out.println(roman.RomArray[indexARomanCheck - indexBRomanCheck]);
                case "*" -> System.out.println(roman.RomArray[indexARomanCheck * indexBRomanCheck]);
                case "/" -> System.out.println(roman.RomArray[indexARomanCheck / indexBRomanCheck]);
            }
        }else if (((indexARomanCheck >= 0) && (indexBArabicCheck >= 0)) || ((indexAArabicCheck >= 0) && (indexBRomanCheck >= 0))){
            throw new MyException("//т.к. используются одновременно разные системы счисления");
        }else throw new MyException("Error");
    }
}
