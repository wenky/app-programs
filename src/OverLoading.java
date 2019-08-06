public class OverLoading {

    void m1(long a){
        System.out.println("long");
    }
    void m1(short a){
        System.out.println("short");
    }

    void m1(Long l){
        System.out.println("Long");
    }
    public static void main(String[] args) {

        new OverLoading().m1(2);
    }
}
