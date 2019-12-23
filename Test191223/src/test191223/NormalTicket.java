package test191223;

public class NormalTicket extends Ticket {
	
	boolean card;
	
	NormalTicket(int ticketNumber, int ticketPrice, boolean card){
		super(ticketNumber, ticketPrice);
		this.card = card;
	}
	
	void cardUse(){
		if(card == false) {
			System.out.println(this.ticketPrice);
		}else {
			this.ticketPrice = (int) (this.ticketPrice+(this.ticketPrice * 0.05));
			System.out.println(this.ticketPrice);
		}

	}
}
