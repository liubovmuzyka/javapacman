package src;

import java.awt.*;

/* Ghost class controls the ghost. */
class Ghost extends Mover {

    Image ghost10 = Toolkit.getDefaultToolkit().getImage("img/ghost10.jpg");
    Image ghost20 = Toolkit.getDefaultToolkit().getImage("img/ghost20.jpg");
    Image ghost30 = Toolkit.getDefaultToolkit().getImage("img/ghost30.jpg");
    Image ghost40 = Toolkit.getDefaultToolkit().getImage("img/ghost40.jpg");
    Image ghost11 = Toolkit.getDefaultToolkit().getImage("img/ghost11.jpg");
    Image ghost21 = Toolkit.getDefaultToolkit().getImage("img/ghost21.jpg");
    Image ghost31 = Toolkit.getDefaultToolkit().getImage("img/ghost31.jpg");
    Image ghost41 = Toolkit.getDefaultToolkit().getImage("img/ghost41.jpg");
    /* Direction ghost is heading */
    char direction;

    /* Last ghost location*/
    int lastX;
    int lastY;

    /* Current ghost location */
    int x;
    int y;

    /* The pellet the ghost is on top of */
    int pelletX, pelletY;

    /* The pellet the ghost was last on top of */
    int lastPelletX, lastPelletY;

    /*Constructor places ghost and updates states*/
    public Ghost(int x, int y) {
        direction = 'L';
        pelletX = x / gridSize - 1;
        pelletY = x / gridSize - 1;
        lastPelletX = pelletX;
        lastPelletY = pelletY;
        this.lastX = x;
        this.lastY = y;
        this.x = x;
        this.y = y;
    }

    /* update pellet status */
    @Override
    public void updatePellet() {
        int tempX, tempY;
        tempX = x / gridSize - 1;
        tempY = y / gridSize - 1;
        if (tempX != pelletX || tempY != pelletY) {
            lastPelletX = pelletX;
            lastPelletY = pelletY;
            pelletX = tempX;
            pelletY = tempY;
        }

    }

    /* Random move function for ghost */
    @Override
    public void move() {
        lastX = x;
        lastY = y;

        /* If we can make a decision, pick a new direction randomly */
        if (isChoiceDest(x, y)) {
            direction = newDirection(x, y, direction);
        }

        /* If that direction is valid, move that way */
        switch (direction) {
            case 'L':
                if (isValidDest(x - increment, y))
                    x -= increment;
                break;
            case 'R':
                if (isValidDest(x + gridSize, y))
                    x += increment;
                break;
            case 'U':
                if (isValidDest(x, y - increment))
                    y -= increment;
                break;
            case 'D':
                if (isValidDest(x, y + gridSize))
                    y += increment;
                break;
        }
    }
}
