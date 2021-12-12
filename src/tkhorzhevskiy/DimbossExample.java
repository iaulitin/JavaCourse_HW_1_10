package tkhorzhevskiy;

import java.util.ArrayList;
import java.util.OptionalDouble;

public class DimbossExample implements DimbossInterface {

    private final ArrayList<Integer> arr;

    public DimbossExample(ArrayList<Integer> arr) {
        this.arr = arr;
    }

    public static void main(String[] args) {
        ArrayList<Integer> dimbossList = new ArrayList<>();
        dimbossList.add(1);
        dimbossList.add(2);
        dimbossList.add(3);
        dimbossList.add(4);
        dimbossList.add(5);
        DimbossExample example = new DimbossExample(dimbossList);
        example.max();
        example.min();
        System.out.println(example.findIndex(2));
        System.out.println(example.avg());
        example.evenElements();
        example.doubleArray();
        System.out.println(example.originalArray());


    }

    @Override
    public ArrayList<Integer> originalArray() {
        return arr;
    }

    @Override
    public void max() {
        Integer maxNumber = arr.stream()
                .max(Integer::compare).
                get();
        System.out.println(maxNumber);
    }

    @Override
    public void min() {
        Integer minNumber = arr.stream()
                .min(Integer::compare)
                .get();
        System.out.println(minNumber);
    }

    @Override
    public OptionalDouble avg() {
        return arr.stream()
                .mapToInt(a -> a)
                .average();
    }

    @Override
    public int findIndex(Integer element) {
        return arr.stream()
                .skip(element)
                .findFirst()
                .orElse(-1);
    }

    @Override
    public void evenElements() {
        arr.stream()
                .filter((a) -> (a % 2) == 0)
                .forEach(System.out::println);

    }

    @Override
    public void doubleArray() {
        arr.stream()
                .map(a -> a * 2)
                .forEach(System.out::println);
    } // Не очень понимаю как мне правильно в последних двух методах вывести результат в виде списка
}
