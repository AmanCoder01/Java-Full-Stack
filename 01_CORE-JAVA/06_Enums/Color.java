public enum Color {
    RED, GREEN, BLUE, BLACK;

    private Color() {
        System.out.println("Constructor called for : " + this.toString());
    }

    public static void main(String[] args) {
        System.out.println("Main method started...\n");

        for (Color c : Color.values()) {
            System.out.println("Color: " + c);
        }

        System.out.println("\nMain method ended.");
    }
}