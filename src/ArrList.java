import java.util.Collection;

//Реализация ArrList, принимает
//в качестве типа любой класс, реализующий
//интерфейс Comparable
public class ArrList<T extends Comparable<T>> implements MyList<T>{
    private Object[] array;
    private boolean isSorted = false;
    public int length = 0;

    public ArrList(){
        array = new Object[10];
    }

    //Конструктор с параметрами, который принимает
    //любую коллекцию, тип который является наследником
    //типа структуры
    public ArrList(Collection<? extends T> col){
        array = new Object[10];
        addAll(col);
    }

    //Метод, добавляюший элемент в структуру
    public void add(T t){
        if(length==array.length){
            optArr();
        }
        array[length]=t;
        length++;
        isSorted = false;
    }

    //Метод, позволяющий поддерживать динамичность структуры
    private void optArr(){
        Object[] arr2 = new Object[array.length*3/2+1];
        int i = 0;
        for (Object item : array){
            arr2[i]=item;
            i++;
        }
        array=arr2;
    }

    //Получение элемента по индексу
    @SuppressWarnings("unchecked")
    public T get(int index) throws ArrayIndexOutOfBoundsException{
        if((index>length)||(index<0))
            throw new ArrayIndexOutOfBoundsException("Out of bounds of array");
        else
            return (T) array[index];
    }
    
    //Удаление элемента по индексу
    public void remove(int index) throws ArrayIndexOutOfBoundsException{
        if((index>length)||(index<0))
            throw new ArrayIndexOutOfBoundsException("Out of bounds of array");
        else{
            int i = index;
            while (i<length){
                array[i]=array[i+1];
                i++;
            }
            length--;
            if(array.length*0.4>=length)
                optArr();
        }
    }

    //Добавление элементов из коллекции
    public void addAll(Collection<? extends T> col){
        isSorted= false;
        col.stream().forEach((cons)-> {
            add(cons);
        });
    }

    //Сортировка элементов "пузырькем"
    @SuppressWarnings("unchecked")
    public void sort(){
        if(!isSorted){
            int i = 0;
            while(i<length-1){
                T t = (T) array[i];
                if(t.compareTo((T) array[i+1])<=0){
                    i++;
                }
                else{
                    array[i] = array[i+1];
                    array[i+1] = t;
                    if(i!=0)
                        i--;
                }
            }
            isSorted = true;
        }
    }

   
    
}
