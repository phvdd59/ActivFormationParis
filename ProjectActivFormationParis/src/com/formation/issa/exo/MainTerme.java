package com.formation.issa.exo;

public class MainTerme {

	public static void main(String[] args) {
		MainTerme mainTerme=new MainTerme();
		mainTerme.init();

	}

	private void init() {
		Terme terme =new Terme();
		String txt="Un long dimanche de fiançailles et tout redevient paisible et corsé";
		terme.epuration(txt);
		
	}

}
