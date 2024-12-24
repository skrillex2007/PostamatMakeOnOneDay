package MainPocket.Posilka;

public class Dimensions {
    private final double LENGTH;
    private final double WIDTH;
    private final double DEPTH;


    public Dimensions(double LENGTH, double WIDTH, double DEPTH){
        this.LENGTH=LENGTH;
        this.WIDTH=WIDTH;
        this.DEPTH=DEPTH;
    }

    public boolean fitsIn(Dimensions other){
        return LENGTH<=other.LENGTH&&
                WIDTH<=other.WIDTH&&
                DEPTH<=other.DEPTH;
    }
}
