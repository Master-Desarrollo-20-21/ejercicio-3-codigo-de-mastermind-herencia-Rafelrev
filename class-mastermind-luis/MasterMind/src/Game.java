
import java.util.ArrayList;
import java.util.List;

public class Game {

	private static final int MAX_NUM_INTENTOS = 10;
	private MyConsole myConsole;
	private List<ProposedCombination> combinacionesPropuestas = new ArrayList<ProposedCombination>();
	private SecretCombination secretCombination;

	public Game() {
		this.myConsole = new MyConsole();
		this.secretCombination = new SecretCombination();
	}

	public void start() {
		this.myConsole.out("\n --- MasterMind 0.0.1 ---");
		this.secretCombination.createSecretCombination();
		this.combinacionesPropuestas.clear();
	}

	public void play() {

		do {
			this.muestraCombinaciones();
			ProposedCombination combinacionPropuesta = this.preguntaCombinacion();
			combinacionPropuesta.guarda();
			combinacionesPropuestas.add(combinacionPropuesta);
			this.secretCombination.check(combinacionPropuesta);
		} while (!this.hasWon() && !this.hasLose());

		if (hasWon()) {
			myConsole.out("You've Won!! :-)");
		}
		if (hasLose()) {
			this.muestraCombinaciones();
			myConsole.out("You've lost!!! :-(");
			myConsole.out("The Secret:");
			this.secretCombination.show();
		}

	}

	private ProposedCombination preguntaCombinacion() {
		ProposedCombination combinacionPropuesta;
		do {
			combinacionPropuesta = new ProposedCombination(myConsole.read("Propon una Combinacion:"));
		} while (!combinacionPropuesta.isValid());

		return combinacionPropuesta;
	}

	private void muestraCombinaciones() {
		myConsole.out("\n");
		myConsole.out(combinacionesPropuestas.size() + " Attemp(s):");
		myConsole.out(secretCombination.showHide());
		for (Combination combination : combinacionesPropuestas) {
			combination.show();
		}
	}

	public boolean hasLose() {
		return combinacionesPropuestas.size() >= MAX_NUM_INTENTOS;
	}

	public boolean hasWon() {
		for (ProposedCombination combination : combinacionesPropuestas) {
			if (combination.isTheSecretCombination()) {
				return true;
			}
		}
		return false;
	}

}
