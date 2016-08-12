package com.formation.soka.metier;

import java.text.DecimalFormat;
import java.util.Date;

import com.formation.soka.main.MainThread;

public class MonProcessus implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		long t = System.nanoTime();
		System.out.println("Début MonProcessus " + Thread.currentThread().getName());
		for (int i = 0; i < 20; i++) {
			Date date = new Date();
			if (Thread.currentThread().getName().equals("PremierThread")) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				date = new Date();
				System.out.println(Thread.currentThread().getName() +" "+ MainThread.difToString(t, System.nanoTime()));
			}
			if (Thread.currentThread().getName().equals("SecondThread")) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				date = new Date();
				System.out.println(Thread.currentThread().getName() + " " +MainThread.difToString(t, System.nanoTime()));

			}
		}
		System.out.println("Fin MonProcessus " + Thread.currentThread().getName() );
	}
}
