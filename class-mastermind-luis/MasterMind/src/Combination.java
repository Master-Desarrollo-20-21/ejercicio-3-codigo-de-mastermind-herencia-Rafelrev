
public abstract class Combination {

    protected char[] combinacion;
    protected MyConsole myConsole;

    public enum Colors {
        R, B, Y, O;
        public static String getStringColors() {
            return "R,B,Y,O";
        }

    }

    public Combination() {
        myConsole = new MyConsole();
    }

    public char[] getCombination() {
        return combinacion;
    }

    protected abstract void show();



}
