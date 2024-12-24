package MainPocket.Posilka;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создаём габариты

        Dimensions smallDimensions = new Dimensions(10, 20, 30);
        Dimensions largeDimensions = new Dimensions(50, 60, 70);

        PostCell cell1 = new PostCell(smallDimensions);
        PostCell cell2 = new PostCell(largeDimensions);

        //Создаём посылку
        Shipment shipment = new Shipment(smallDimensions, 5, "Small package");

        // Proverka поместился ли?
        System.out.println("Поместился ли пакет? " + cell1.canAcceptShipment(shipment));

        // посылку в первую ячейку

        try {
            cell1.putShipment(shipment);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        //берём посылку из первой ячейки

        Shipment extractedShipment = cell1.extractShipment();
        System.out.println("Вы достали из ячейки: " + extractedShipment.getDescription());

        // создаю постамат с двумя ячейками

        List<PostCell> cells = List.of(cell1, cell2);
        Postamat postamat = new Postamat(cells);

        try {// загружаю посылку в автомат
            int index = postamat.putShipment(shipment);
            System.out.println(index); // 0
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
        double totalWeight=postamat.weightAllShipments();
        System.out.println("Cумма веса всех посылок составляет: "+totalWeight);

        try{// Достаём посылку по индекcу
            Shipment receivedShipment=postamat.getShipment(0);
            System.out.println("Вы достали: "+receivedShipment.getDescription());
        } catch (IndexOutOfBoundsException e){
            System.out.println("Увы ничего не было");
        }
    }
}