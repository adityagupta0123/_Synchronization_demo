package Multithreading;

class MyData{

    public void display(String s){
        synchronized (this) {
            for (int i = 0; i < s.length(); i++) {
                System.out.print(s.charAt(i));
            }
        }
    }
}
class thread1 extends Thread{
    MyData d ;
    public thread1(MyData d){
        this.d= d;
    }
    @Override
    public void run() {
        d.display(" thread1");
    }
}
class thread2 extends Thread{
    MyData d ;
    public thread2(MyData d){
        this.d= d;
    }
    @Override
    public void run() {
        d.display(" thread2");
    }
}

public class SycoDemo {
    public static void main(String[] args) {
        MyData d  = new MyData();
        thread1 t1 = new thread1(d);
        thread2 t2 = new thread2(d);
        t1.start();
        t2.start();
    }
}
