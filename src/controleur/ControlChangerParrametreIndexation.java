package controleur;

import interfaceC.InterfaceC;
import modele.ParrametreIndexation;

public class ControlChangerParrametreIndexation {
	ParrametreIndexation parrametreIndexation = ParrametreIndexation.getInstance();

	public void changerParrametreTexte(int nouveauParram) {
		boolean change = parrametreIndexation.setParrametreIndexationTexte(nouveauParram);
		if (change) {
			System.out.println("mise a jour !");
			InterfaceC.changerParrametreTexte(nouveauParram);
		}

	}

	public void changerParrametreImage(int nouveauParram) {
		boolean change = parrametreIndexation.setParrametreIndexationImage(nouveauParram);
		if (change) {
			System.out.println("mise a jour !");
			InterfaceC.changerParrametreImage(nouveauParram);
		}

	}

	public void changerParrametreAudio(int nouveauParram) {
		boolean change = parrametreIndexation.setParrametreIndexationAudio(nouveauParram);
		if (change) {
			System.out.println("mise a jour !");
			InterfaceC.changerParrametreAudio(nouveauParram);
		}
	}

	public int getParrametreTexte() {
		return parrametreIndexation.getParrametreIndexationTexte();
	}

	public int getParrametreImage() {
		return parrametreIndexation.getParrametreIndexationImage();
	}

	public int getParrametreAudio() {
		return parrametreIndexation.getParrametreIndexationAudio();
	}

	public void lancerIndexation() {
		if (!parrametreIndexation.TexteAJour()) {
			InterfaceC.indexationTexte(parrametreIndexation.getParrametreIndexationTexte());
			System.out.println("indexation texte fini"); // a enlever lors du etst final
		}
		if (!parrametreIndexation.ImageAJour()) {
			InterfaceC.indexationImage(parrametreIndexation.getParrametreIndexationTexte());
			System.out.println("indexation image fini ");
		}
		if (!parrametreIndexation.AudioAJour()) {
			InterfaceC.indexationAudio(parrametreIndexation.getParrametreIndexationTexte());
			System.out.println("indexation audio fini");
		}
	}
	
	public void miseAJour() {
		parrametreIndexation.miseAJour();
	}

}
