import java.util.Random;

public class SecretCombination extends Combination {

    private char[] secretCombination;
    private final int NUM_DIGITS_SECRET_COMBINATION = 4;

    public SecretCombination() {
        super();
        this.secretCombination = new char[NUM_DIGITS_SECRET_COMBINATION];
    }

    public void init(){
       for(int i=0 ; i<NUM_DIGITS_SECRET_COMBINATION;i++){
           this.secretCombination[i] = 'x';
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
            if (secretCombination[i] == 'x') {
                return false;
            }
        }
        return true;
    }

    private boolean existe(char color) {
        for (int i = 0; i < 4; i++) {
            if (secretCombination[i] == color) {
                return true;
            }
        }
        return false;
    }

    private void añade(char color) {
        for (int i = 0; i < 4; i++) {
            if (secretCombination[i] == 'x') {
                secretCombination[i] = color;
                break;
            }
        }
    }

    @Override
    protected void show() {
        String secretCombination = "";
        for (int i = 0; i < 4; i++) {
            secretCombination += this.secretCombination[i];
        }
        new MyConsole().out(secretCombination);
    }



    @Override
    protected boolean isTheSecretCombination() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    protected void guarda() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void check(Combination combination) {
        ProposedCombination proposedCombination = (ProposedCombination) combination;
        for (int i = 0; i < 4; i++) {
            if (proposedCombination.getCombination()[i] != this.secretCombination[i])
                proposedCombination.sumBlacks();
            else
                proposedCombination.sumWhites();
        }

    }

    @Override
    protected boolean isValid() {
        // TODO Auto-generated method stub
        return false;
    }

	public String showHide() {
		return "XXXX";
	}

}
