/*
Entrega a Atividade 2 - Algoritmos e Programação II

Nós,

Edson de Oliveira Correia 
Gustavo da Silva de Brito
José Elias Gomes Camargo
José Joaquin Julcamoro Bustamante

declaramos que

todas as respostas são fruto de nosso próprio trabalho,
não copiamos respostas de colegas externos à equipe,
não disponibilizamos nossas respostas para colegas externos ao grupo e
não realizamos quaisquer outras atividades desonestas para nos beneficiar ou prejudicar outros.
*/

import java.io.File;
import java.util.Scanner;


class Main {
  public static void main(String[] args) throws Exception {
  //INICIALIZANDO AS VARIÁVEIS 
    File arquivo = new File("entrada.txt");
    Scanner leitor = new Scanner(arquivo);
    String[] dicionario = new String[1000];
    String[] palavrasPorLinha;
    String linha;
    String textoCompleto = "";
    int numPalavras, indexDicionario;
    numPalavras = indexDicionario = 0;

  //PERCORRE CADA LINHA DO ARQUIVO .TXT
    while (leitor.hasNext() && indexDicionario < 1000) {

      //LÊ UMA LINHA DO ARQUIVO .TXT e CONCATENA À VARIÁVEL textoCompleto PARA EXIBIR O TEXTO COMPLETO NO CONSOLE
      linha = leitor.nextLine();
      textoCompleto += linha + "\n";
      palavrasPorLinha = linha.split(" ");

      //PERCORRE CADA PALAVRA POR LINHA DO ARQUIVO .TXT
       for(String palavra : palavrasPorLinha){

         //TRATAMENTO DE CASE SENSITIVE LEVANDO TODAS AS LETRAS DA PALAVRA PARA MINÚSCULO
          palavra = palavra.toLowerCase();

         //CONDIÇÃO PARA CHECAR SE A PALAVRA JÁ ESTÁ NO DICIONÁRIO E TAMBÉM SE O SPLIT NÃO GEROU PALAVRAS VAZIAS ("")
         if ((palavraEstaNoDicionario(palavra, dicionario, indexDicionario) == -1) && palavra.length() > 0) {
          dicionario[indexDicionario] = palavra;
  
          //A CADA PALAVRA ADICIONADA CHAMA O MÉTODO DE ORDENAÇÃO DO DICIONÁRIO      
          ordenarDicionario(dicionario, indexDicionario);

          //SOMA PARA CONTAR O TOTAL DE PALAVRAS DISTINTAS
          numPalavras++;

           //AVANÇA NO INDEX DO VETOR DICIONÁRIO
          indexDicionario++;
           }

       }
    }
    //IMPRIME NA TELA O TEXTO COMPLETO DO ARQUIVO .TXT
    System.out.println("Texto Encontrado no Arquivo entrada.txt:");
    System.out.println("__________________________________________________________________________________\n");
    System.out.printf("%s%n", textoCompleto);
    System.out.println("‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");
  //PERCORRE O DICIONÁRIO EXIBINDO UMA PALAVRA POR LINHA
    System.out.println("\nPalavras no Dicionario do Texto: \n");
    for(int i = 0; i < dicionario.length; i++) {
      if (dicionario[i] != null){
        System.out.printf("%4d. \"%s\"%n", (i + 1), dicionario[i]);  
      }
      else {
        break;
      }
    }

  //IMPRIME A VARIÁVEL COM O TOTAL DE PALAVRAS DISTINTAS
    System.out.printf("\nTotal de Palavras Diferentes no Dicionario: %d%n", numPalavras);
    leitor.close();
  }

  //FUNÇÃO PARA VERIFICAR SE UMA PALAVRA JÁ ESTÁ NO DICIONARIO USANDO BUSCA BINÁRIA
  //Neste código, a função vai retornar um valor inteiro, se a palavra estiver presente a função retornará seu indice no vetor, caso contrário, irá retornar -1
  public static int palavraEstaNoDicionario(String palavra, String[] dicionario, int ultimaPosicao) {
    
  int inicio = 0;
  int meio; 
  int fim = ultimaPosicao - 1;
    
    while (inicio <= fim) {
      meio = (inicio + fim) / 2;
      if (palavra.equals(dicionario[meio])) {
        return meio;
      }
      if (palavra.compareTo(dicionario[meio]) < 0) {
        fim = meio - 1;
      } else {
        inicio = meio + 1;
      }
    }
      return -1;
    }
    
  


  //FUNÇÃO PARA ORDENAR O VETOR A CADA NOVA ENTRADA COM INSERTION SORT
  //Criamos uma variável "ultimaPosicao" para limitar a ordenação ao indice da última palavra adicionada, reduzindo assim o nº de instruções.
    public static void ordenarDicionario(String[] dicionario, int ultimaPosicao) {
      //A variável fim guarda o indice da última posição e a variável AUX guarda a variável a ser comparada no passo de Insertion Sort.
      int fim = ultimaPosicao;
      String aux = dicionario[fim];
      //Criamos um loop(while) e utilizamos o método (compareTo) para dar o tratamento de texto a todas as posições do vetor aux.
        while (fim > 0 && aux.compareTo(dicionario[fim-1]) < 0) {
        dicionario[fim] = dicionario[fim-1];
        fim--;
        }
      dicionario[fim] = aux;
    }
               }
  
