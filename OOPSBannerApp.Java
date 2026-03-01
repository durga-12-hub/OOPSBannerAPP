public class OOPSBannerApp {

    public static void main(String[] args) {

        System.out.println(" *****     *****     ******     ***** ");
        System.out.println("*     *   *     *    *     *   *     *");
        System.out.println("*     *   *     *    *     *   *      ");
        System.out.println("*     *   *     *    ******     ***** ");
        System.out.println("*     *   *     *    *               *");
        System.out.println("*     *   *     *    *         *     *");
        System.out.println(" *****     *****     *          ***** ");

    }

}public class OOPSBannerApp {
    public static void main(String[] args) {

        // 1. Define String array with number of banner lines
        String[] lines = new String[7];

        // 2. Populate each index using String.join()
        lines[0] = String.join(" ", " *****  ", "  ***   ", " *****  ", " ***** ");
        lines[1] = String.join(" ", "*     * ", " *   *  ", " *      ", "*     *");
        lines[2] = String.join(" ", "*     * ", "  * *   ", " *****  ", "*     *");
        lines[3] = String.join(" ", "*     * ", "   *    ", " *      ", " ***** ");
        lines[4] = String.join(" ", "*     * ", "  * *   ", " *      ", " *     ");
        lines[5] = String.join(" ", "*     * ", " *   *  ", " *      ", "  *    ");
        lines[6] = String.join(" ", " *****  ", "  ***   ", " *      ", "   *   ");

        // 3. Use for-each loop to print
        for (String line : lines) {
            System.out.println(line);
        }
    }
}