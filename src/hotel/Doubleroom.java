package hotel;

public class Doubleroom extends Room {


	public Doubleroom(int roomNumber){
		this.setNumber(roomNumber);
		this.setNumberOfBeds(2);
		this.setHasMinibar(false);
		this.setRoomType(RoomType.DOUBLEROOM);
	}
	
	public Doubleroom(int roomNumber, int numberOfBeds, boolean isEmpty, boolean hasMinibar){
		this.setNumber(roomNumber);
		this.setNumberOfBeds(numberOfBeds);
		this.setEmpty(isEmpty);
		this.setHasMinibar(hasMinibar);
		this.setRoomType(RoomType.DOUBLEROOM);
	}
	
}
