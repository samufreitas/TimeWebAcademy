package Fundamentos_back_end.Maria_Clara;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ArrayDinamico {
    private List<Integer> numeros;

    public ArrayDinamico() {
        this.numeros = new ArrayList<>();
    }

    public void adicionar(int numero) {
        numeros.add(numero);
    }

    public void ordenar() {
        Collections.sort(numeros);
    }

    public int buscaBinaria(int numero) {
        return Collections.binarySearch(numeros, numero);
    }

    public List<Integer> obterMaiores(int n) {
        int size = numeros.size();
        if (n >= size) {
            return new ArrayList<>(numeros);
        }
        return numeros.subList(size - n, size);
    }

    public boolean comparar(List<Integer> other) {
        return numeros.equals(other);
    }

    public void ordenarDecrescente() {
        Collections.sort(numeros, Collections.reverseOrder());
    }

    public void imprimir() {
        for (int numero : numeros) {
            System.out.print(numero + " ");
        }
        System.out.println();
    }
}

public class ArraysDinamicos {
    public static void main(String[] args) {
        ArrayDinamico numeros = new ArrayDinamico();

        numeros.adicionar(5);
        numeros.adicionar(2);
        numeros.adicionar(9);
        numeros.adicionar(7);
        numeros.adicionar(1);

        numeros.imprimir();

        numeros.ordenar();

        numeros.imprimir();

        int index = numeros.buscaBinaria(9);

        if (index >= 0) {
            System.out.println("O número 9 foi encontrado no índice da lista ordenada: " + index);
        }

        List<Integer> maiores = numeros.obterMaiores(3);

        System.out.println("Três maiores números da lista:");
        for (int numero : maiores) {
            System.out.print(numero + " ");
        }

        boolean compara = numeros.comparar(maiores);

        if(compara){
            System.out.println("\nOs arrays são iguais.");
        }else{
            System.out.println("\nOs arrays não são iguais.");
        }

        numeros.ordenarDecrescente();

        numeros.imprimir();
    }
}
































// package Fundamentos_back_end.Maria_Clara;

// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.Collections;
// import java.util.List;

// public class ArraysDinamicos {
//     public static void main(String[] args) {
//         List<Integer> numeros = new ArrayList<Integer>();
//         numeros.add(5);
//         numeros.add(2);
//         numeros.add(9);
//         numeros.add(7);
//         numeros.add(1);

//         for (int numero : numeros) {
//             System.out.println(numero + " ");
//         }

//         //Ordena os itens em ordem crescente

//         Collections.sort(numeros);
        
//         for (int numero : numeros) {
//             System.out.println(numero + " ");
//         }

//         int index = Collections.binarySearch(numeros, 9);

//         if (index >= 0) {
//             System.out.println("O número 9 foi encontrado no índice da lista ordenada: " + index);
//         } 

//         List<Integer> maiores = numeros.subList(numeros.size() - 3, numeros.size());
        
//         System.out.println("Três maiores números da lista:");
//         for (int numero : maiores) {
//             System.out.println(numero + " ");
//         }

//         boolean compara = numeros.equals(maiores);

//         if(compara){
//             System.out.println("Os arrays são iguais.");
//         }else{
//             System.out.println("Os arrays não são iguais.");
//         }

//         Collections.sort(numeros, Collections.reverseOrder());
//         for (int numero : numeros) {
//             System.out.print(numero + " ");
//         }

//     }
    
// }
