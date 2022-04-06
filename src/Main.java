public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList();

        arrayList.add(1);
        arrayList.add(1, 2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.remove(1);
        arrayList.show();

        System.out.println(arrayList);

    }
}
