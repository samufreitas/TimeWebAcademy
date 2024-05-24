package Fundamentos_back_end.Samuel_Freitas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {

        // Criando o Array dinâmico de inteiros 
        List<Integer> numeros = new ArrayList<Integer>();

        // Inserindo os dados no Array 
        numeros.add(5);
        numeros.add(2);
        numeros.add(9);
        numeros.add(7);
        numeros.add(1);

        //Agora vamos imprimir os dados do Array  

        for(int itens: numeros){
            System.out.println(itens);
        }

        //Agora vamos ordenar os dados do Array 
        Collections.sort(numeros);

        // Imprimindo os dados do Array de forma ordenada
        System.out.println("Elementos de forma ordena do Array:");
        for(int itens: numeros){
            System.out.println(itens);
        }
        //buscando o número 9 no array e imprimindo 
        int num9 = Collections.binarySearch(numeros, 9);
        System.out.println("O resultado da busca pelo número 9 é: "+numeros.get(num9));

        // Criando o Array dinâmico maiores 
        List<Integer> maiores = numeros.subList(2, 5);

        System.out.println("Imprimindo os três maiores números copiados do Array numeros:");
        for(int itens: maiores){
            System.out.println(itens);
        }
        // Utilizando o método equals nos Arrays
        if(numeros.equals(maiores)){
            System.out.println("Arrays numeros e maiores são iguais!");
        }else{
            System.out.println("Arrays 'numeros' e 'maiores' são diferentes!");
        }

        // Imprimindo dados na ordem decrescente 
        System.out.println("Elementos do Array números em ordem decrescente:");
        Collections.reverse(numeros);
        for(int i: numeros){
            System.out.print(i +" ");
        }
    }
}
