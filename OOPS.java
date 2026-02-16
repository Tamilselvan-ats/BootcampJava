public class Oops {
    public static void main(String[] args) {

        String[] lines = {
            " *****    *****    *****    ***** ",
            "*     *  *     *  *     *  *     *",
            "*     *  *     *  *     *  *      ",
            "*     *  *     *  *****    *****  ",
            "*     *  *     *  *             * ",
            "*     *  *     *  *             * ",
            " *****    *****    *       *****  "
        };

        System.out.println(String.join("\n", lines));
    }
}
