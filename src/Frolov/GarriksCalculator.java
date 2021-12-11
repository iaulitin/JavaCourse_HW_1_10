package Frolov;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class GarriksCalculator implements Calculator {

    private final Collection<Integer> seq;

    public GarriksCalculator(Collection<Integer> seq) {
        this.seq = seq;
    }

    @Override
    public Collection<Integer> initialSequence() {
        return seq;
    }

    @Override
    public int max() {
        return seq.stream()
                .max(Integer::compareTo)
                .get();
    }

    @Override
    public int min() {
        return seq.stream()
                .min(Integer::compareTo)
                .get();
    }

    @Override
    public double avg() {
        Integer result = seq.stream()
                .reduce(Integer::sum)
                .orElse(0);
        // такое приведение допустимо?
        return result / (double) seq.size();
    }

    @Override
    public int get(Integer num) {
        return seq.stream()
                .skip(num)
                .findFirst()
                .orElse(-1);
    }

    @Override
    public Collection<Integer> even() {
        return seq.stream()
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Integer> doubleCollection() {
        return seq.stream()
                .map(x -> x * 2)
                .collect(Collectors.toList());
    }


    public static void main(String[] args) {
        List<Integer> amogus = new ArrayList<>();
        amogus.add(1);
        amogus.add(4);
        amogus.add(3);
        amogus.add(2);
        GarriksCalculator sas = new GarriksCalculator(amogus);
        System.out.println(sas.max());
        System.out.println(sas.min());
        System.out.println(sas.avg());
        System.out.println(sas.get(2));
        System.out.println(sas.get(10));
        System.out.println(sas.initialSequence());
        System.out.println(sas.even());
        System.out.println(sas.doubleCollection());


    }
}
