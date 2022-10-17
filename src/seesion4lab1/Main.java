package seesion4lab1;

public class Main {
    public static void main (String[] args){
        PhoneBook pb1 = new Phone Book();

        pb1.insertPhone("Duc","0369286085");
        pb1.insertPhone("an"),"0123456789");
        pb1.insertPhone("dat"),("02439871492");
        pb1.insertPhone("dung"),("0349085534");

        System.out.println("\nDisplay contact list\n");
        for(contact ct: pb1.PhoneList){
            System.out.println(ct.name);
            System.out.println(ct.phone);
        }

        pb1.removePhone("Lê Đức");
        System.out.println("\nRemove\n");
        for(contact ct: pb1.PhoneList){
            System.out.println(ct.name);
            System.out.println(ct.phone);
        }

        System.out.println("\nUpdate\n");
        pb1.updatePhone("Lê An","012345678");
        pb1.updatePhone("Đức","0369286085");

        for(contact ct: pb1.PhoneList){
            System.out.println(ct.name);
            System.out.println(ct.phone);
        }

        System.out.println("\nSearch\n");
        pb1.searchPhone("Duc");
        pb1.searchPhone("Dat");

        System.out.println("\nSort\n");
        pb1.sort();
    }
}


