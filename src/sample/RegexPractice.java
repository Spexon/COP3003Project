/**
 * @Author Vladimir Hardy
 */
package sample;

class RegexPractice {

    /**
     * @param animal the name of an animal
     * @return returns true if the animal equals Cat or cat, Dog or dog, but not dOg
     */
    static boolean getAnimal(String animal) {
        return animal.matches("[Cc]at|[Dd]og");
    }

    /**
     * @param word any word the user puts in
     * @return true or false if the word rhymes with 'AT'
     */
    static boolean checkRhyme(String word) {
        return word.matches("[a-zA-Z](at|AT)");
    }

}
