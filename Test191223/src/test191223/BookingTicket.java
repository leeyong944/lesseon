package test191223;

public class BookingTicket extends Ticket {
	
	int reservation;
	
	BookingTicket(int ticketNumber, int ticketPrice, int reservation){
		super(ticketNumber, ticketPrice);
		this.reservation = reservation;
	}
	
	
	void reservation() {
		if(reservation == 30) {
			this.ticketPrice = (int) (this.ticketPrice * 0.5);
			System.out.println(this.ticketPrice);
		}else if(reservation == 10) {
			this.ticketPrice = (int) (this.ticketPrice * 0.8);
			System.out.println(this.ticketPrice);
		}else if(reservation == 5) {
			this.ticketPrice = (int) (this.ticketPrice * 0.9);
			System.out.println(this.ticketPrice);
		}
	}
	
	

}
