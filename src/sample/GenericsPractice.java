/**
 * @Author Vladimir Hardy
 */
package sample;

public class GenericsPractice<T, T2> {

    /*
     * Most commonly used type parameters
     * E - Element (used extensively by the java collections framework
     * K - Key
     * N - Number
     * T - Type
     * V - Value
     * S, U, V, etc. - 2nd, 3rd, 4th types
     */

    private T t;
    private T2 k;

    /**
     * @param cellData First generic parameter
     * @param i        Second generic parameter
     * @brief Sets the specific value type and returns the value with its associated type
     */
    void setValue(T cellData, T2 i) {
        t = cellData;
        k = i;
    }

    T getT1Value() {
        return t;
    }

    T2 getT2Value() {
        return k;
    }

    /**
     * @return reformats a string with values concatenated with it
     */
    public String toString() {
        return ("Cell type is: Type 1: " + t.getClass() + " and Type 2: " + k.getClass());
    }
}
