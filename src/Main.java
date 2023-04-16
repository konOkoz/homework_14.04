import java.util.function.*;

public class Main {
    public static void main(String[] args) {


        Predicate<Integer> checkable = num -> num>3;
        System.out.println(checkable.test(10));

        Consumer<String> printable = (string) -> System.out.println(string);
        printable.accept("Hey");

        Supplier<String> producable = () -> "Hi";
        System.out.println(producable.get());

        BinaryOperator<String> stringConcate = (string,string2) -> string.concat(string2);
        System.out.println(stringConcate.apply("Hello"," World"));

        Function<String , Integer> transformable = num -> Integer.parseInt(num);
        System.out.println(transformable.apply("3")+3);

        String str = "AAA BBBB dEF cDkls bBb";

        Predicate<Integer> length1 = num -> num==3;
        System.out.println(training(str,length1));

        Predicate<Integer> length2 = num -> num==4;
        System.out.println(training(str,length2));

        Predicate<Integer> length3 = num -> num==5;
        System.out.println(training(str,length3));




    }
    /*
    Переписать лямбда-выражения для интерфейсов Checkable,Printable, Producable, StringConcate,Transformable
    из домашнего задания и с урока на стандартных функциональных интерфейсах Java.
     */

/* Написать метод, принимающий строку, содержащую слова разделенные пробелом и два функциональных интерфейса - function и predicate.
Метод возвращает строку. Он должен предоставлять возможность реализации следующих действий:
1. при длине слова= 3, изменить все буквы этого слова на строчные и вернуть измененную строку
2. при длине слова= 4, изменить все буквы слова на заглавные и вернуть измененную строку
3. при длине слова= 5, изменить все буквы слова на звездочки и вернуть измененную строку
(т.е. должен работать таким образом при передаче в него соотвествующих лямбда выражений для каждого случая).
Протестировать.
Пример: есть строка AAA BBBB dEF cDkls bBb
Условие: если длина слова = 3 то заменить буквы этого слова на маленькие.
На выходе будет: aaa BBBB def cDkls bbb
Это задача со звездочкой
     */
    public static String training(String string, Predicate<Integer> predicate){
        StringBuilder result = new StringBuilder();
        String[] arr = string.split(" ");
        for(int i=0;i<arr.length;i++){
            if(predicate.test(arr[i].length())) {
                result.append(arr[i].toLowerCase()).append(" ");
            }
            else if(predicate.test(arr[i].length())) {
                result.append(arr[i].toUpperCase()).append(" ");
            }
            else if(predicate.test(arr[i].length())){
                result.append("*****").append(" ");
                }
            else {
                result.append(arr[i]).append(" ");
            }
            }

        return result.toString().trim();
        }


}