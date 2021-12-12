package tkhorzhevskiy;

import java.util.ArrayList;
import java.util.OptionalDouble;

public interface DimbossInterface {

    ArrayList<Integer> originalArray();

    void max();

    void min();

    OptionalDouble avg();

    int findIndex(Integer element);

    void evenElements();

    void doubleArray();
}
