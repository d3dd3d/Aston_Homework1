package Homework_1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {

        //Инициализация коллекции для проверки методов
        Collection<Integer> colI = new ArrayList<Integer>();
        
        //Инициализация ArrayList без параметров
        ArrList<Integer> arlS = new ArrList<>();

        //Инициализация LinkedList без параметров
        LinkList<Integer> ls = new LinkList<>();
        
        //Рандом для заполнения массивов
        Random r = new Random();
        
        //Заполнение массивов
        for(int i = 0;i<15;i++){
            colI.add(r.nextInt(15));
            arlS.add(r.nextInt(15));
            ls.add(r.nextInt(15));
        }

        //Инициализация массивов с параметрами
        ArrList<Integer> arlS2 = new ArrList<>(colI);
        LinkList<Integer> ls2 = new LinkList<>(colI);

        //Вывод элементов
        System.out.println("Arrays with parametrs");
        System.out.println("ArrList\t LinkList\tCollection");
        for(int i = 0;i<15;i++){
            System.out.println(arlS2.get(i) + " \t " + ls2.get(i) + "\t\t" + colI.toArray()[i]);
        }

        //Вывод элементов
        System.out.println("Initial arrays");
        System.out.println("ArrList\t LinkList\tCollection");
        for(int i = 0;i<15;i++){
            System.out.println(arlS.get(i) + " \t " + ls.get(i) + "\t\t" + colI.toArray()[i]);
        }

        //Удаление элементов из массива по индексу
        arlS.remove(5);
        ls.remove(5);

        //Вывод элементов
        System.out.println("Removed element at index 5");
        System.out.println("ArrList\t LinkList");
        for(int i = 0;i<14;i++){
            System.out.println(arlS.get(i) + " \t " + ls.get(i));
        }

        //Метод addAll
        arlS.addAll(colI);
        ls.addAll(colI);

        //Вывод элементов
        System.out.println("Adding collection to arrays");
        System.out.println("ArrList\t LinkList");
        for(int i = 0;i<arlS.length;i++){
            System.out.println(arlS.get(i) + " \t " + ls.get(i));
        }

        //Сортировка
        arlS.sort();
        ls.sort();

        //Вывод элементов
        System.out.println("Sorted arrays");
        System.out.println("ArrList\t LinkList");
        for(int i = 0;i<arlS.length;i++){
            System.out.println(arlS.get(i) + " \t " + ls.get(i));
        }

        //Статичный метод сортировки
        MyList.sort(colI);

        //Вывод элементов
        System.out.println("Sorted collection");
        System.out.println("Collection");
        for(int i = 0;i<15;i++){
            System.out.println(colI.toArray()[i]);
        }
    }
}
