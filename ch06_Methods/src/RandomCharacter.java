public class RandomCharacter {

    public static void main(String[] args) {
        System.out.println(getRandomLowerCaseLetter());
    }

    /** Generate a random character between ch1 and ch2 */
    public static char getRandomCharacter(char ch1, char ch2) {
        System.out.println((int)ch1);
        System.out.println((int)ch2);
        System.out.println(ch2 - ch1);
        System.out.println(ch2 - ch1 + 1);
        return (char)(ch1 + Math.random() * (ch2 - ch1 + 1));
    }

    /** Generate a random lowercase letter */
    public static char getRandomLowerCaseLetter() {
        return getRandomCharacter('a', 'z');
    }

    /** Generate a random uppercase letter */
    public static char getRandomUpperCaseLetter() {
        return getRandomCharacter('A','Z');
    }
}
