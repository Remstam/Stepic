public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
    final int TRIES = 3;
    int tries = 0;
    boolean isCon = false;
    RobotConnection con = null;
    
    while (isCon != true && tries < TRIES) {
        try {
            con = robotConnectionManager.getConnection();
            isCon = true;
            con.moveRobotTo(toX, toY);
        } catch (RobotConnectionException e) {
            isCon = false;
        } catch (Throwable t) {
            isCon = false;
            throw t;
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (RobotConnectionException e) {
                    // do nothing ?
                } finally {
                    if (isCon == false) {
                        tries++;
                    }
                }
            } else {
                tries++;
            }
        }
    }
    
    if (isCon == false && tries == TRIES) {
        throw new RobotConnectionException("Couldn't connect in " + TRIES + " tries.");
    }
}
