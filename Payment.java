package sms.base;

public class Payment {

	private double pendingPay = 600.00;

	public double setPay(double pay) {
		System.out.println(); // PAYING PENDING FEE
		pendingPay = pendingPay - pay;
		System.out.println(
				"***$" + pay + " has been paid successfully and the balance to be paid : $" + pendingPay + "***");
		System.out.println();
		return pendingPay;
	}

	public double showPendingPayment() {

		// pendingPay=pendingPay-pay;
		System.out.println(); // SHOWS THE PENDING FEE ALONE
		System.out.println("***Pending fee : $" + pendingPay + "***");
		System.out.println();
		return pendingPay;

	}

	public void getInfo() { // PRINTING THE PENDING FEES IN STATUS
		System.out.println("Pending fee                  : $" + (pendingPay)); 
		System.out.println("*************************************************************");
	}

}
