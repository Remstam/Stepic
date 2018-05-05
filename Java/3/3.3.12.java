public static void moveRobot(Robot robot, int toX, int toY) {
    Direction dir = robot.getDirection();
    int curX = robot.getX();
    int curY = robot.getY();
    
    Direction dirX = (toX - curX) > 0 ? Direction.RIGHT : Direction.LEFT;
    Direction dirY = (toY - curY) > 0 ? Direction.UP : Direction.DOWN;
    
    while (dir != dirX)
    {
        robot.turnRight();
        dir = robot.getDirection();
    }
    
    while (curX != toX)
    {
        curX += (dir == Direction.RIGHT ? 1 : -1);
        robot.stepForward();
    }
    
    while (dir != dirY)
    {
        robot.turnRight();
        dir = robot.getDirection();
    }
    
    while (curY != toY)
    {
        curY += (dir == Direction.UP ? 1 : -1);
        robot.stepForward();
    }
}
