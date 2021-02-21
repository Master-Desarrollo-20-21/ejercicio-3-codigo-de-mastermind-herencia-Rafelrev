
import java.util.ArrayList;
import java.util.List;

public class Game {

	private static final int MAX_NUM_INTENTOS = 5;
	private MyConsole myConsole;
	private List<Combination> combinacionesPropuestas = new ArrayList<Combination>();
	private SecretCombination secretCombination;

	public Game() {
		this.myConsole = new MyConsole();
		this.secretCombination = new SecretCombination();
	}

	public void start() {
		
		this.secretCombination.createSecretCombination();
		this.secretCombination.show();
		this.combinacionesPropuestas.clear();
	}

	public void play() {

		do {
			this.muestraCombinaciones();
			Combination CombinacionPropuesta = this.preguntaCombinacion();
		} while (!this.hasWon() && !this.hasLose());

		if (hasWon()) {
			myConsole.out("You've Won!! :-)");
		}
		if (hasLose()) {
			this.muestraCombinaciones();
			myConsole.out("You've lost!!! :-(");
		}

	}

	private Combination preguntaCombinacion() {
		Combination combinacionPropuesta;
		do {
			combinacionPropuesta = new ProposedCombination(myConsole.read("Propon una Combinacion:"));
		} while (!combinacionPropuesta.isValid());
		combinacionPropuesta.guarda();
		combinacionesPropuestas.add(combinacionPropuesta);
		this.secretCombination.check(combinacionPropuesta);
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
		for (Combination combination : combinacionesPropuestas) {
			if (combination.isTheSecretCombination()) {
				return true;
			}
		}
		return false;
	}

}
