import java.util.ArrayList;
import java.util.List;

public class TipoPilhaContainer {
    private List<Container> pilhaContainer = new ArrayList<>();
    private List<Container> pilhaContainer_auxiliar = new ArrayList<>();
    private int lastContainer = pilhaContainer.size();
    private int move = 0;

    public void inserirContainer(Container container) {
        if (!procura(container.getID())){
            pilhaContainer.add(container);
            System.out.println("Container " + container.getID() + " Inserido!");
            System.out.println("Contêiner Criado com sucesso!");
        }else{
            System.out.println("Esse ID já está ocupado!");
        }
    }

    public void removerContainer(int idConteiner){
        if(procura(idConteiner)){
            while(true){
                if(pilhaContainer.get(pilhaContainer.size()-1).getID() == idConteiner){
                    System.out.println("Contêiner " + pilhaContainer.get(pilhaContainer.size()-1).getID() +
                            " saindo para seu destino final.");
                    pilhaContainer.remove(pilhaContainer.remove(pilhaContainer.size()-1));
                    move++;
                    break;
                }else{
                    pilhaContainer.get(pilhaContainer.size()-1).movimenta();
                    move++;
                    pilhaContainer_auxiliar.add(pilhaContainer.get(pilhaContainer.size()-1));
                    pilhaContainer.remove(pilhaContainer.size()-1);
                }
            }
            pilhaContainer.addAll(pilhaContainer_auxiliar);
            pilhaContainer_auxiliar.clear();
        }
    }

    public Boolean procura(int idConteiner){
        boolean existe = false;
        for(Container procurador: pilhaContainer){
            if(procurador.getID() == idConteiner){
                existe = true;
                break;
            }
        }
        return existe;
    }

    public int contagemMovimentacao(){
        return move;
    }

    public void apresentarPilha(){
        System.out.println("Pilha topo -> \n" + (pilhaContainer.size()-1) + "]:");
        for(int i = 0; i < pilhaContainer.size(); i++){
            System.out.println(i + "]: Contêiner [" +
                    "contMove=" + pilhaContainer.get(i).getContMove() +
                    ", idConteiner=" + pilhaContainer.get(i).getID());
        }
    }

    public void aprensentarPlanilha(int numeroPlanilha){
        System.out.println("**********  Planilha de contêiners (pilha " + numeroPlanilha + ") **************");
        for(Container con: pilhaContainer){
            System.out.println(con.getID());
        }
    }

    public int getLengthPilha(){
        return pilhaContainer.size();
    }

}