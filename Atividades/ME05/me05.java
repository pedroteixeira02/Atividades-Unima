
package animals;

public abstract class Animal {
    public abstract void fazerBarulho();
}

package interfaces;

public interface Colorido {
    String obterCor();
}

package interfaces;

public interface Colorido {
    String obterCor();
}
--------------------------------------------------------------------------------------------

package animals;

public abstract class Animal {
    public abstract void fazerBarulho();
}


package interfaces;

public interface Pesado {
    double obterPeso();
}

package interfaces;

public interface Colorido {
    String obterCor();
}

package animals;

import interfaces.Pesado;
import interfaces.Colorido;

public class Porco extends Animal implements Pesado, Colorido {
    @Override
    public void fazerBarulho() {
        System.out.println("Oinc!");
    }

    @Override
    public double obterPeso() {
        return 50.0;
    }

    @Override
    public String obterCor() {
        return "Preto";
    }
}
---------------------------------------------------------------------------------------

package animals;

import interfaces.Pesado;
import interfaces.Colorido;

public class Porco extends Animal implements Pesado, Colorido {
    @Override
    public void fazerBarulho() {
        System.out.println("Oinc!");
    }

    @Override
    public double obterPeso() {
        return 50.0;
    }

    @Override
    public String obterCor() {
        return "Preto";
    }


    public boolean enlameado() {
        return true;
    }

    @Override
    public String toString() {
        return String.format(
    
            obterCor(),
            obterPeso(),
            enlameado() ? "Sim" : "Não"
        );
    }
}
