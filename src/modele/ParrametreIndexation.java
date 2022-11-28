package modele;

import interfaceC.InterfaceC;

public class ParrametreIndexation {
	private int parrametreIndexationImage;
	private int parrametreIndexationAudio;
	private int parrametreIndexationTexte;
	protected boolean aJour;

	private boolean texteAJour;
	private boolean imageAJour;
	private boolean audioAJour;

	// methodes pour les changer

	private ParrametreIndexation() {
		texteAJour = true;
		imageAJour = true;
		audioAJour = true;
		parrametreIndexationImage = InterfaceC.chargerParametreImage();
		parrametreIndexationTexte = InterfaceC.chargerParametreTexte();
		parrametreIndexationAudio = InterfaceC.chargerParametreAudio();
		aJour = true;
	}

	private static class ParrametreIndexationHolder {
		private static ParrametreIndexation instance = new ParrametreIndexation();
	}

	// faire les methodes du singleton
	public static ParrametreIndexation getInstance() {
		return ParrametreIndexationHolder.instance;
	}

	public boolean TexteAJour() {
		return texteAJour;
	}

	public boolean ImageAJour() {
		return imageAJour;
	}

	public boolean AudioAJour() {
		return audioAJour;
	}

	public int getParrametreIndexationImage() {
		return parrametreIndexationImage;
	}

	public int getParrametreIndexationTexte() {
		return parrametreIndexationTexte;
	}

	public int getParrametreIndexationAudio() {
		return parrametreIndexationAudio;
	}

	public boolean setParrametreIndexationImage(int nouveauParametreIndexationImage) {
		if (nouveauParametreIndexationImage != parrametreIndexationImage) {
			imageAJour = false;
			aJour = false;
			parrametreIndexationImage = nouveauParametreIndexationImage;
			return true;
		}
		return false;
	}

	public boolean setParrametreIndexationTexte(int nouveauParametreIndexationTexte) {
		if (nouveauParametreIndexationTexte != parrametreIndexationTexte) {
			texteAJour = false;
			aJour = false;
			parrametreIndexationTexte = nouveauParametreIndexationTexte;
			return true;
		}
		return false;
	}

	public boolean setParrametreIndexationAudio(int nouveauParametreIndexationAudio) {
		if (nouveauParametreIndexationAudio != parrametreIndexationAudio) {
			audioAJour = false;
			aJour = false;
			parrametreIndexationAudio = nouveauParametreIndexationAudio;
			return true;
		}
		return false;
	}

	public void miseAJour() {
		if (!aJour) {
			InterfaceC.changerParrametreAudio(this.getParrametreIndexationAudio());
			audioAJour = true;
			InterfaceC.changerParrametreTexte(this.getParrametreIndexationTexte());
			texteAJour = true;
			InterfaceC.changerParrametreImage(this.getParrametreIndexationImage());
			imageAJour = true;
			aJour = true;
		}
	}

}