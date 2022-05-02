/**
 * @author KAWAIISHY
 * @project paps-unit-tetst-with-db
 * @created 23.04.2022
 */
public class Main {
    public static void main(String[] args) {
        Registration registration1 = Registration.getInstance();
        Registration registration2 = Registration.getInstance();

        System.out.println(registration1.equals(registration2));

        System.out.println(registration1.hashCode());
        System.out.println(registration2.hashCode());
    }
}
