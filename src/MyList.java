import java.util.Collection;

//Интерфейс для структур
public interface MyList<T> {
    //Добавление элемента
    public void add(T t);

    //Удаление элемента по индексу
    public void remove(int index);

    //Получение элемента по индексу
    public T get(int index);

    //Добавление элементов из другой коллекции
    public void addAll(Collection<? extends T> col);

    //Сортировка по возрастанию
    public void sort();

    //Статичный метод сортировки коллекции
    //В качестве параметра принимает любые коллекции,
    //у которых тип реализует интерфейс Comparable
    @SuppressWarnings("unchecked")
    static <Tp extends Comparable<Tp>> void sort(Collection<Tp> col){
        int i = 0;
        Object[] temp = col.toArray();
        while(i<temp.length-1){
            Tp t = (Tp) temp[i];
            if(t.compareTo((Tp) temp[i+1])<=0){
                i++;
            }
            else{
                temp[i] = temp[i+1];
                temp[i+1] = t;
                if(i!=0)
                    i--;
            }
        }
        col.clear();
        for(i=0;i<temp.length;i++){
            col.add((Tp)temp[i]);
        }
    }
}
