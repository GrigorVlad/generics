package me.zadanie.countMapZadacha;

import java.util.HashMap;
import java.util.Map;

public class MyCountMap<T> implements CountMap<T> {

    private Map<T, Integer> countmap = new HashMap<>();

    @Override
    public void print() {
        for (Map.Entry<T, Integer> pair : countmap.entrySet()) {
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }
    }

    @Override
    public void add(T t) {
        countmap.put (t, getCount(t) + 1);
    }

    @Override
    public int getCount(T t) {
        if (countmap.get(t) == null) {
            return 0;
        } else {
            return countmap.get(t);
        }
    }

    @Override
    public int remove(T t) {
        if (countmap.get(t) == null) {
            return 0;
        } else {
            int result = countmap.get(t);
            countmap.remove(t);
            return result;
        }
    }

    @Override
    public int size() {
        return countmap.size();
    }

    @Override
    public void addAll(CountMap<? extends T> source) {
        for (Map.Entry<? extends T, Integer> pair : source.toMap().entrySet()) {
            countmap.put(pair.getKey(), pair.getValue() + getCount(pair.getKey()));
        }
    }

    @Override
    public Map<T, Integer> toMap() {
        return countmap;
    }

    @Override
    public void toMap(Map<? super T, Integer> destination) {
        for (Map.Entry<? extends T, Integer> pair : countmap.entrySet()) {
            destination.put(pair.getKey(), pair.getValue());
        }
    }
}
