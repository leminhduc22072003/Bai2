package session4lab1;

public class Main {
    public static void main(String[] args){
        PhoneBook pb1 = new PhoneBook();

        pb1.insertPhone("Duc","0359903359");
        pb1.insertPhone("Linh","0904175005");
        pb1.insertPhone(" Cường","012345678");
        pb1.insertPhone("Duy","023456789");

        System.out.println("\nDisplay contact list\n");
        for(contact ct: pb1.PhoneList){
            System.out.println(ct.name);
            System.out.println(ct.phone);
        }

        pb1.removePhone("Cường");
        System.out.println("\nRemove\n");
        for(contact ct: pb1.PhoneList){
            System.out.println(ct.name);
            System.out.println(ct.phone);
        }

        System.out.println("\nUpdate\n");
        pb1.updatePhone(" Cường","012345678");
        pb1.updatePhone("Duy","034567890");

        for(contact ct: pb1.PhoneList){
            System.out.println(ct.name);
            System.out.println(ct.phone);
        }

        System.out.println("\nSearch\n");
        pb1.searchPhone("Cam");
        pb1.searchPhone("Cuong");

        System.out.println("\nSort\n");
        pb1.sort();
    }
}