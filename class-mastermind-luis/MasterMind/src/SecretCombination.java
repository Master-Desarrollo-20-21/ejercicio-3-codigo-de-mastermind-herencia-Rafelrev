import java.util.Random;

public class SecretCombination extends Combination {

    private final int NUM_DIGITS_SECRET_COMBINATION = 4;

    public SecretCombination() {
        super();
        this.combinacion = new char[NUM_DIGITS_SECRET_COMBINATION];
    }

    public void init(){
       for(int i=0 ; i<NUM_DIGITS_SECRET_COMBINATION;i++){
           this.combinacion[i] = 'x';
       }
    }

    public SecretCombination createSecretCombination() {
        int num;
        char color;
        init();
        while (!isCompleto()) {
            do {
                num = new Random().nextInt(4);
                color = Combination.Colors.values()[num].name().toUpperCase().charAt(0);

            } while (this.existe(color));
            añade(color);
        }
        return this;
    }

    private boolean isCompleto() {
        for (int i = 0; i < 4; i++) {
            if (combinacion[i] == 'x') {
                return false;
            }
        }
        return true;
    }

    private boolean existe(char color) {
        for (int i = 0; i < 4; i++) {
            if (combinacion[i] == color) {
                return true;
            }
        }
        return false;
    }

    private void añade(char color) {
        for (int i = 0; i < 4; i++) {
            if (combinacion[i] == 'x') {
                combinacion[i] = color;
                break;
            }
        }
    }

    @Override
    protected void show() {
        String secretCombination = "";
        for (int i = 0; i < 4; i++) {
            secretCombination += this.combinacion[i];
        }
        new MyConsole().out(secretCombination);
    }

    protected void check(Combination combination) {
        ProposedCombination proposedCombination = (ProposedCombination) combination;
        for (int i = 0; i < 4; i++) {
            if (proposedCombination.getCombination()[i] != this.combinacion[i])
                proposedCombination.sumBlacks();
            else
                proposedCombination.sumWhites();
        }

    }

	public String showHide() {
		return "XXXX";
	}

}
