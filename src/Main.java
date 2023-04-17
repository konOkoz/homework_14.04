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

        String str = "AAA bbbb dEF cDkls bBb";
        Predicate<String> predicate = s -> s.length() == 3;
        Function<String, String> function = s -> s.toLowerCase();
        System.out.println(training(str,predicate,function));

        Predicate<String> predicate1 = s -> s.length() == 4;
        Function<String, String> function1 = s -> s.toUpperCase();
        System.out.println(training(str,predicate1,function1));

        Predicate<String> predicate2 = s -> s.length() == 5;
        Function<String, String> function2 = s -> s="*****";
        System.out.println(training(str,predicate2,function2));





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
    public static String training(String string, Predicate<String> predicate,Function<String,String>function){
        String[] arr = string.split(" ");

        for(int i=0;i<arr.length;i++) {
            if(predicate.test(arr[i])){
                arr[i] = function.apply(arr[i]);
            }
        }
         return String.join(" ",arr);
        }

}