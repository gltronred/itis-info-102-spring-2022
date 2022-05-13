# Второй семестр информатики и программирования, 11-102

## 1

Написать функцию `int task(List<Integer> list)`, которая
считает сумму чётных элементов исходного списка.

Использовать `java.util.stream.*`.

Например, `[1,2,3,4,5,6] -> 12`

## 2

Написать функцию `<T> int task(List<T> list, Function<T, Integer> f)`, которая
считает количество элементов исходного списка, которые преобразуются в нечётные
числа после выполнения переданной функции f.

Использовать `java.util.stream.*`.

Например, если f - это `(x) -> x+1`, то `[1,2,3,4,5,6] -> 3`

## 3

Написать функцию `List<Integer> task(List<Integer> list)`, которая возвращает
список чётных элементов исходного списка, к каждому из которых добавили его
квадрат.

Использовать `java.util.stream.*`.

Например, `[1,2,3,4,5,6] -> [6,20,42]`

## 4

Написать функцию `List<Integer> task(List<Integer> list)`, которая возвращает список
нечётных элементов исходного списка, повторив каждый из них дважды.

Использовать `java.util.stream.*`.

Например, `[1,2,3,4,5,6] -> [1,1,3,3,5,5]`. Подсказка: flatMap, of.

## 5

Написать функцию `List<Integer> task(List<Integer> list)`, которая возвращает
список нечётных элементов исходного списка, повторив каждый из них столько раз,
чему равен сам элемент.

Использовать `java.util.stream.*`.

Например, `[1,2,3,4,5,6] -> [1,3,3,3,5,5,5,5,5]`. Подсказка: generate и limit или iterate.

## 6

Написать функцию `List<Integer> task(int n)`, которая возвращает список из
среднего и дисперсии списка из `n` случайных чисел в диапазоне от 0 до 1000.

Среднее - A = S/N, где S - сумма элементов, N - количество.
[Дисперсия](https://ru.wikipedia.org/wiki/%D0%94%D0%B8%D1%81%D0%BF%D0%B5%D1%80%D1%81%D0%B8%D1%8F_%D1%81%D0%BB%D1%83%D1%87%D0%B0%D0%B9%D0%BD%D0%BE%D0%B9_%D0%B2%D0%B5%D0%BB%D0%B8%D1%87%D0%B8%D0%BD%D1%8B) - считать по формуле D = T - A^2, где T - среднее значение квадратов элементов, A - среднее значение элементов.

Использовать `java.util.stream.*`. 
Использовать generate, limit, reduce

## 7

Написать функцию `boolean isPrime(int n)`, возвращающую, является ли число n простым, с использованием `java.util.stream.*`.

## 8

Написать функцию `Map<Integer, List<Integer>> divisible(int n, List<Integer> numbers)`, возвращающую Map, отображающий каждый возможный остаток от 0 до n-1 в список чисел из numbers, дающих такой остаток

Например, для `divisible(5,[1,2,3,6,7,3,8])`
должен получиться результат
`{1=[1,6],2=[2,7],3=[3,3,8]}`

Использовать `Collectors.toMap`

## 9

В файле input.txt в первой строке записаны числа N и M, и далее N*M строк.

В файл output.txt записать таблицу из N строк и M столбцов, данные для которой взять input.txt, выравнивать пробелами, границы ячеек - символами `+, |, -`.

``` text
2 3
что
такое
файл
и
что
мультифора
```

``` text
+---+-----+----------+
|что|такое|файл      |
+---+-----+----------+
|и  |что  |мультифора|
+---+-----+----------+
```

## 10

Написать программу, которой в качестве аргумента передаётся директория.

Программа выводит количество строк для каждого java-файла (т.е. файл, название которого заканчивается на ".java") в директории (и её поддиректориях) 

Программа выводит что-то подобное:
``` text
l1/L1.java 100
l2/L2.java 500
```

## 11

Написать функции `Map<Integer, Integer> statS(List<Integer> list)` и `Map<Integer,Integer> statP(List<Integer> list)`, которые получают на вход список целых чисел и возвращает статистику, сколько каких чисел есть в списке. Используйте методы из `Stream` для этого.

Сгенерируйте список `1_000_000` случайных чисел в диапазоне от 0 до `100_000` и измерьте время работы функции.

Сравните время работы последовательной работы (`stream()` в `statS`) и параллельной (`parallelStream()` в `statP`) и выложите эти два числа в текстовый файл `res.txt` рядом с кодом.
