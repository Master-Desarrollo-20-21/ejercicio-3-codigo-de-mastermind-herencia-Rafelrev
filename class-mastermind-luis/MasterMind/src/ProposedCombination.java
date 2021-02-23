public class ProposedCombination extends Combination{

    private int numWhites = 0;
    private int numBlacks = 0;
    private String combinacionPropuesta;

    public ProposedCombination(String combinacionPropuesta) {
        super();
        this.combinacionPropuesta = combinacionPropuesta;
    }

    public boolean isValid() {
        boolean isValid = true;
        if (this.combinacionPropuesta.length() > 4 || this.combinacionPropuesta.length() < 4) {
            myConsole.out("Wrong proposed combination length");
            isValid = false;
        }
        for (Colors color : Colors.values()) {
            if (!combinacionPropuesta.toUpperCase().contains(color.name())) {
                isValid = false;
                myConsole.out("Wrong colors, they must be: " + Colors.getStringColors());
                break;
            }
        }
        return isValid;
    }

    public void guarda() {
        combinacion = combinacionPropuesta.toUpperCase().toCharArray();
    }

    public void sumBlacks() {
        this.numBlacks++;
    }

    public void sumWhites() {
        this.numWhites++;
    }

	public boolean isTheSecretCombination() {
		return numWhites == 4;
	}

    @Override
    protected void show() {
        String prettyCombinacion = "";
        for (int i = 0; i < this.combinacion.length; i++) {
            prettyCombinacion += combinacion[i];
        }
        prettyCombinacion += " ---> " + numBlacks + " blacks and "+ numWhites +" whites";
        myConsole.out(prettyCombinacion);

    }

    
}
