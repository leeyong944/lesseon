package test191223;

public class Ticket {
	int ticketNumber;
	int ticketPrice;
	
	Ticket(int ticketNumber, int ticketPrice){
		this.ticketNumber = ticketNumber;
		this.ticketPrice = ticketPrice;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	
	

}
