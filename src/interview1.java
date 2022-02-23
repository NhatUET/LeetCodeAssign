class Base {
    private void f() {
        System.out.print("base");
    }
    public void show() {f();}
}

class ct {
    private int val = 0;
    public ct(int v) {
        this.val = v;
    }
    public int get() {
        return val;
    }
}
public abstract class interview1 {
//   public abstract void f1();
//   public abstract void f2();
   public void f3() {
//       f1();
//       f2();
   }
    public static void main(String[] args) {
        derived ddd = new derived();
        ddd.f3();
        derived dd = new derived();
        interview1 a = new derived();
        derived b = (derived) a;
    }
}

class derived extends interview1 {
    public void f1() {
        System.out.print("f1");
    }
    public void f2() {
        System.out.print("f2");

    }
}

class d extends derived {

}

class A {
    private int a;
    public A(int a) {
        this.a = a;
    }

    protected void m() {

    }
}

class B extends  A {
    public B(int a) {
        super(a);
    }
    public void m() {

    }
}

