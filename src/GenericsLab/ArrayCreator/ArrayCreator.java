package GenericsLab.ArrayCreator;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayCreator<T> {

    public static <T> T[] create(int length, T defaultValue) {
        T[] arr = (T[])Array.newInstance(defaultValue.getClass(), length);
        Arrays.fill(arr, defaultValue);
        return arr;
    }

    public static <T> T[] create(Class<T> tClass, int length, T value) {
        T[] arr = (T[])Array.newInstance(tClass,length);
        Arrays.fill(arr, value);
        return arr;
    }
}
