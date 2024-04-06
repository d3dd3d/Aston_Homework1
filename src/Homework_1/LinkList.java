package Homework_1;
import java.util.Collection;

//Реализация LinkedList, принимает
//в качестве типа любой класс, реализующий
//интерфейс Comparable
public class LinkList<T extends Comparable<T>> implements MyList<T> {

    //Внутренний класс Node
    private class Node{
        private T value;
        private Node next;
        private Node prev;

        @SuppressWarnings("unused")
        private Node(){}

        Node(T value, Node next, Node prev){
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

    }

    private Node head;
    private Node tail;

    public int length = 0;
    private boolean isSort = false;

    public LinkList(){
        
    }

    //Конструктор с параметрами, который принимает
    //любую коллекцию, тип который является наследником
    //типа структуры
    public LinkList(Collection<? extends T> col){
        col.forEach((cons)->{
            add(cons);
        });
    }

    //Метод, возвращающий Node по индексу
    private Node goTo(int index){
        int i = 0;
        Node cur = head;
        while(i!=index){
            cur = cur.next;
            i++;
        }
        return cur;
    }

    //Метод, добавляюший элемент в структуру
    public void add(T t){
        if(length==0){
            head = new Node(t,null,null);
        }
        else if(length==1){
            tail = new Node(t,null,head);
            head.next = tail;
        }
        else{
            Node tmp = new Node(t, null, tail);
            tail.next = tmp;
            tail = tmp;
        }
        isSort = false;
        length++;
    }

    //Получение значения по индексу
    public T get(int index) throws ArrayIndexOutOfBoundsException{
        if((index>=length)||(index<0))
            throw new ArrayIndexOutOfBoundsException();
        return goTo(index).value;
    }

    //Удаление элемента по индексу
    public void remove(int index) throws ArrayIndexOutOfBoundsException{
        if((index>=length)||(index<0))
            throw new ArrayIndexOutOfBoundsException();
        Node del = goTo(index);
        if(del.next!=null)
            del.prev.next = del.next;
        del.next.prev = del.prev;
    }

    //Добавление элементов коллекции
    public void addAll(Collection<? extends T> col){
        col.forEach((cons)->{
            add(cons);
        });
        isSort = false;
    }

    //Сортировка структуры "пузыркем"
    public void sort(){
        if(!isSort){
            Node cur = head;
            while(cur.next!=null){
                if (cur.value.compareTo(cur.next.value)<=0){
                    cur = cur.next;
                }
                else{
                    Node next = cur.next;
                    T tmpVal = next.value;
                    next.value = cur.value;
                    cur.value = tmpVal;
                    if(cur.prev!=null)
                        cur = cur.prev;
                }
            }
            isSort = true;
        }
    }
}
