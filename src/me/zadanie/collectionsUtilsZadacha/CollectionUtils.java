package me.zadanie.collectionsUtilsZadacha;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CollectionUtils {
    public static<T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static<T> List<? extends T> newArrayList() {
        return new ArrayList<>();
    }

    public static<T> int indexOf(List<? extends T> source, T t) {
        return source.indexOf(t);
    }

    public static<T> List<? super T> limit(List<? extends T> source, int size) {
        List<T> newList = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            newList.add(source.get(i));
        }

        return newList;
    }

    public static<T> void add(List<? super T> source, T t) {
        source.add(t);
    }

    public static<T> void removeAll(List<? super T> removeFrom, List<? extends T> c2) {
        removeFrom.removeAll(c2);
    }

    public static<T> boolean containsAll(List<? super T> checkList, List<? extends T> listOfElements) {
        return checkList.containsAll(listOfElements);
    }

    public static<T> boolean containsAny(List<? super T> checkList, List<? extends T> ListOfElements) {
        for (T t : ListOfElements) {
            if (checkList.contains(t)) {
                return true;
            }
        }

        return false;
    }

    public static<T extends Comparable<? super T>> List<T> range (List<? extends T> list, T min, T max) {
        List<T> newList = new ArrayList<>();
        for (T t : list) {
            if ((t.compareTo(min) >= 0) && (t.compareTo(max) <= 0)) {
                newList.add(t);
            }
        }

        return newList;
    }

    public static<T> List<? super T> range(List<? extends T> list, T min, T max, Comparator<? super T> comparator) {
        List<T> newList = new ArrayList<>();
        for (T t : list) {
            if ((comparator.compare(t, min) >= 0) && (comparator.compare(t, max) <= 0)) {
                newList.add(t);
            }
        }

        return newList;
    }
}