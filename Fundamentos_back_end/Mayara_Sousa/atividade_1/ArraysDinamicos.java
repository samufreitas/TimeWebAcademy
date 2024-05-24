import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArraysDinamicos {

    List<Integer> numeros = new ArrayList<>();
    //Construtor
    public ArraysDinamicos() {
        numeros.add(5);
        numeros.add(2);
        numeros.add(9);
        numeros.add(7);
        numeros.add(1);
    }
    //Mostrando os elementos de numeros
    public void imprimirElementos() {
        for (int item : numeros) {
            System.out.println(item);
        }
    }
    //Ordenando
    public void ordenarNumeros() {
        Collections.sort(numeros);
    }
    //Buscando o numero
    public void buscarNumero(int numero) {
        int indice = Collections.binarySearch(numeros, numero);
        if (indice >= 0) {
            System.out.println("O número " + numero + " foi encontrado na posição " + indice);
        } else {
            System.out.println("O número " + numero + " não foi encontrado na lista");
        }
    }

    public static void main(String[] args) {
        ArraysDinamicos arrayDinamico = new ArraysDinamicos();

        arrayDinamico.imprimirElementos();
        System.out.println("Após ordenar:");
        arrayDinamico.ordenarNumeros();
        arrayDinamico.imprimirElementos();

        int numeroBusca = 9;
        System.out.println("Buscando o número " + numeroBusca + ":");
        arrayDinamico.buscarNumero(numeroBusca);

        arrayDinamico.copiarMaiores();
        System.out.println("Três maiores números:");
        for (int item : arrayDinamico.maiores) {
            System.out.println(item);
        }
        
        // Comparando os arrays numeros e maiores
        System.out.println("Comparação entre numeros e maiores:");
        System.out.println(arrayDinamico.numeros.equals(arrayDinamico.maiores));

        //Mostrando numeros de forma decresente
        System.out.println("Mostrando numeros de forma decresente:");
        arrayDinamico.decressente();
    }

    List<Integer> maiores = new ArrayList<>();
    //Copia
    public void copiarMaiores() {
        maiores = numeros.subList(numeros.size() - 3, numeros.size());
    }

    public void decressente() {
        for (int item : numeros) {
            System.out.println(item);
        }
    }
}
