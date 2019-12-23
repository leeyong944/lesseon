package test191223;

public class TicketMain {

	public static void main(String[] args) {
		BookingTicket bt = new BookingTicket(1111,30000,10);
		NormalTicket nt = new NormalTicket(2222,20000,false);
		
		
		
		System.out.println(bt.ticketNumber);
		
		bt.reservation();
		
		System.out.println(nt.ticketNumber);
		
		nt.cardUse();

	}

}
