package MainPocket.Posilka;
import java.util.Objects;

public class PostCell {
    private final Dimensions cellDimensions;
    private Status status;
    private Shipment shipment;

    public PostCell(Dimensions cellDimensions, Status status){
        this.cellDimensions=Objects.requireNonNull(cellDimensions);
        this.status=Objects.requireNonNull(status);
    }
    public PostCell(Dimensions cellDimensions){
        this(cellDimensions, Status.WORK);
    }
    public boolean hasShipment(){
        return shipment!=null;
    }

    public boolean canAcceptShipment(Shipment shipment){
        if(this.shipment!=null||status==Status.AT_MAINTENANCE){
            return false;
        } return shipment.getDimensions().fitsIn(cellDimensions);
    }
    public void putShipment(Shipment shipment) throws IllegalStateException{
        if(!canAcceptShipment(shipment)){
            throw new IllegalStateException("Can't accept this shipment");
        }
        this.shipment=shipment;
    }
    public Shipment extractShipment(){
        if(hasShipment()){
            Shipment extractedShipment=this.shipment;
            this.shipment=null;
            return extractedShipment;
        }
        return null;
    }

    public void turnMaintenanceMode() throws IllegalStateException{
        if(hasShipment()){
            throw new IllegalStateException("Can't switch to maintenance mode while cell contains a shipment");
        }
        status=Status.AT_MAINTENANCE;
    }
    public void turnWorkingMode(){
        status=Status.WORK;
    }


public enum Status {
    WORK, AT_MAINTENANCE;
 }
}
