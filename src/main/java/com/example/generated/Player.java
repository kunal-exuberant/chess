public class Player {
    private String name;
    private int x;
    private int y;

    public Player(String name, int startX, int startY) {
        this.name = name;
        this.x = startX;
        this.y = startY;
    }

    public void move(String direction) {
        switch (direction.toLowerCase()) {
            case "up":
                y++;
                break;
            case "down":
                y--;
                break;
            case "left":
                x--;
                break;
            case "right":
                x++;
                break;
            default:
                System.out.println("Invalid direction. Use up, down, left, or right.");
                return;
        }
        System.out.println(name + " moved " + direction + " to position (" + x + ", " + y + ").");
    }

    public static void main(String[] args) {
        Player player = new Player("Hero", 0, 0);
        player.move("up");
        player.move("right");
        player.move("down");
        player.move("left");
    }
}