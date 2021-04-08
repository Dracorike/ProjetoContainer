public class Container {
    private int ID;
    private int contMove;

    public Container(int ID) {
        this.ID = ID;
        this.contMove = 0;
    }

    public Container(){

    }

    public void movimenta(){
        System.out.println("Movimentado o contêiner " + getID());
        contMove++;
    }

    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }

    public int getContMove() {
        return contMove;
    }
    public void setContMove(int contMove) {
        this.contMove = contMove;
    }
}