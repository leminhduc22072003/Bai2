package session3;

public class Main {
    public static void main(String args[]) {
        FptStudent[] fptStudent = new FptStudent[4];
        fptStudent[0] = new FptStudent();
        fptStudent[1] = new FptStudent();

        int[] arr = new int[5];
        arr[0] = 10;
        arr[1] = 20;
        fptStudent[0].run();

        ArrayList<FptStuent> farr = new ArrayList<>();

        farr.get(0).run(); // farr[0]

        for (int i = 0; i < fArr.size(); i++) {
            fArr.get(i).run("ABC");
        }

        for (FptStudent fx : fArr) {
            fx.run("XYZ");//fx = fArr[i]
        }

        ArrayList<String> stArr = new ArrayList<>();
        ArrayList<Integer> intArr = new ArrayList<Integer>();
        intArr.add(10);

        T2204MStudent ts =new T2204MStudent();
        ts.run();
        ts.setMark(5);
        System.out.println(ts.getMark());
        // ts.mark

    }
}
