package MainPocket.Posilka;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Postamat {
    private final List<PostCell> cells;
    private final List<Shipment> shipments;

    public Postamat(List<PostCell> cells) {
        this.cells = new ArrayList<>(cells);
        this.shipments = new ArrayList<>();
    }
    public int putShipment(Shipment shipment) throws IllegalArgumentException {
        for (int i = 0; i < cells.size(); i++) {
            PostCell cell = cells.get(i);
            if(cell.canAcceptShipment(shipment)){
                try{
                    cell.putShipment(shipment);
                    shipments.add(shipment);
                    return shipments.indexOf(shipment); // Возврат индекса ячейки
                }catch(IllegalArgumentException e){
                    throw new IllegalArgumentException((e.getMessage()));
                }
            }
        }
        throw new IllegalArgumentException("No suitable cell found for the shipment");
    }
    public Shipment getShipment(int index) throws IndexOutOfBoundsException{
        if(index>0&&index<shipments.size()){
            Shipment shipment=shipments.remove(index);
            for(PostCell cell:cells) {
                if(cell.hasShipment()&&cell.extractShipment()==shipment){
                    break;
                }
            }
            return shipment;
        }
        throw new IndexOutOfBoundsException("No shipment with index: "+index);
    }
    public double weightAllShipments(){
        return shipments.stream().mapToDouble(Shipment::getWeight).sum();
    }

    }




