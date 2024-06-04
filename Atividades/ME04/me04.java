
package br.com.exp;


public class Super {

  public void print() {
    System.out.println("Chamada da superclasse");
  }
}

public class Sub extends Super {

  @Override
  public void print() {
    System.out.println("Chamada da subclasse");
  }

  public static void main(String[] args) {
    Super s = new Sub();
    s.print(); 
  }
}
---------------------------------------------------------

package br.com.exp;


public class Super {

  public void print() {
    System.out.println("Chamada da superclasse");
  }
}


public class Sub extends Super {

  @Override
  public void print() {
    System.out.println("Chamada da subclasse");
  }

  public static void main(String[] args) {
    Super sup = new Super();
    Sub sub = new Sub();
    Super poli = sub; 
    sup.print();
    sub.print(); 
    poli.print(); 
  }
}
