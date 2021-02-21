public class Mastermind {

    private Game game;

    public Mastermind() {
        this.game = new Game();
    }

    private void play() {
        do {
            this.game.start();
            this.game.play();
        } while (this.resume());
        System.exit(0);
    }

    private boolean resume() {
        String response = "";
        MyConsole myConsole = new MyConsole();
        do {
            response = myConsole.read("Resume? (y/n):");
        } while (!response.equalsIgnoreCase("y") && !response.equalsIgnoreCase("n"));
        return response.equalsIgnoreCase("y");

    }

    public static void main(String[] args) {
        new Mastermind().play();
    }
}