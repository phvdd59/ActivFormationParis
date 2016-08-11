package com.formation.emma.main;

import java.util.Date;

public class MonProcessus implements Runnable {
	
	@Override
	public void run() {
		//		System.out.println("bonjour processus" + Thread.currentThread().getName());
		//		if (Thread.currentThread().getName().equals("SecondThread")) {
		//			try {
		//				
		//				Thread.sleep(5000);
		//			} catch (InterruptedException e) {
		//				e.printStackTrace();
		//			}
		//			System.out.println("5 sec ecoulées");
		//		}
		//
		//		
		//		if (Thread.currentThread().getName().equals("PremierThread")) {
		//			try {
		//				Thread.sleep(10000);
		//			} catch (InterruptedException e) {
		//				e.printStackTrace();
		//			}
		//			System.out.println("10 sec ecoulées");
		//		}
		//
		//		System.out.println("fin processus" + Thread.currentThread().getName());

		
		Date date = new Date();
		long x = date.getTime();
		long y = 0;
		if (Thread.currentThread().getName().equals("PremierThread")) {
			for (int i = 0; i < 20; i++) {
				try {
					Thread.sleep(1000);
					Date date2 = new Date();
					y = date2.getTime();

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				long difference = y - x;
				System.out.print(Thread.currentThread().getName() + "," + difference + "\n");
			}
		}

		Date date3 = new Date();
		long x2 = date3.getTime();
		long y2 = 0;
		if (Thread.currentThread().getName().equals("SecondThread")) {
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(2000);
					Date date4 = new Date();
					y2 = date4.getTime();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				long difference2 = y2 - x2;
				System.out.print(Thread.currentThread().getName() + "," + difference2 + "\n");
			}
		}
	}
}
