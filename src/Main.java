import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        int contagem = 0;
        List<TipoPilhaContainer> tpcLista = new ArrayList<>();
        TipoPilhaContainer tpc = new TipoPilhaContainer();
        tpc.inserirContainer(new Container(789));
        tpc.inserirContainer(new Container(456));
        tpc.inserirContainer(new Container(987));
        tpcLista.add(tpc);



        boolean loop = true;
        while(loop){
            menu();
            System.out.print("Opção: ");
            int escolha = teclado.nextInt();
            switch (escolha){
                case 0:
                    loop = false;
                    System.out.println("Fechando o programa.");
                    break;
                case 1:
                    if(tpcLista.get(contagem).getLengthPilha() < 3) {
                        System.out.print("Insira o id do Contêiner: ");
                        int idCriar = teclado.nextInt();
                        Container container = new Container(idCriar);
                        tpcLista.get(contagem).inserirContainer(container);
                    }else{
                        contagem++;
                        TipoPilhaContainer novo = new TipoPilhaContainer();
                        tpcLista.add(novo);
                        System.out.println("Pilha foi alterada!");
                        System.out.print("Insira o id do Contêiner: ");
                        int idCriar = teclado.nextInt();
                        Container container = new Container(idCriar);
                        tpcLista.get(contagem).inserirContainer(container);
                    }
                    break;
                case 2:
                    System.out.print("Insira o id do Contêiner a ser retirado: ");
                    int idExcluir = teclado.nextInt();

                    for(TipoPilhaContainer tpcProcurar: tpcLista){
                        if(tpcProcurar.procura(idExcluir)){
                            tpcProcurar.removerContainer(idExcluir);
                            System.out.println("Contêiner excluir!");
                            break;
                        }
                    }
                    break;
                case 3:
                    int contaMovimento = 0;
                    for(TipoPilhaContainer tpcContagem: tpcLista){
                        contaMovimento += tpcContagem.contagemMovimentacao();
                    }
                    System.out.println("Número de Movimentos: " + contaMovimento);
                    break;
                case 4:
                    for(TipoPilhaContainer tpcMostraPilha: tpcLista){
                        tpcMostraPilha.apresentarPilha();
                    }
                    break;
                case 5:
                    int c = 0;//Variável auxiliar de contagem
                    for(TipoPilhaContainer tpcMostrarPlanilha: tpcLista){
                        tpcMostrarPlanilha.aprensentarPlanilha(c);
                        c++;
                    }
            }
        }
    }

    public static void menu(){
        System.out.println("=================================================");
        System.out.println("0 - Encerrar programa. \n" +
                "1 - Inserir contêiner no pátio. \n" +
                "2 - Retirar contêiner do pátio. \n" +
                "3 - Cálculo do custo da movimentação dos conteineres. \n" +
                "4 - Apresenta os conteineres em cada pilha do pátio. \n" +
                "5 - Apresenta planilhas de conteineres de cada pilha do pátio.");
        System.out.println("=================================================");

    }

}