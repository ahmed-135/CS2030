package cs2030.simulator;

/**
 *  Shop class handles and manages servers.
 *
 *  @author Ahmed Bahajjaj
 */
public class Shop {
    private Server[] svr;
    private RandomGenerator rng;

    /**
     *  Constructor creates servers and RandomGenerator reference.
     *
     *  @param  sv  Number of servers to create.
     *  @param  rng Reference pointer to RandomGenerator.
     */
    public Shop(int sv, RandomGenerator rng) {
        svr = new Server[sv];
        this.rng = rng;

        for (int i = 0; i < sv; i++) {
            svr[i] = new Server(2);
        }
    }
    
    /**
     *  Method to find available server.
     *
     *  @return The ID of an available server. If no servers are available, returns a 0.
     */
    public int findServer() {
        int x = 0;
        
        for (Server sev : svr) {
            if (sev.getSpace() == 2) {
                x = sev.getId();
                break;
            }
        }
        
        if (x == 0) {
            for (Server sev : svr) {
                if (sev.getSpace() == 1) {
                    x = sev.getId();
                    break;
                }
            }
        }
        
        return x;
    }
    
    public double getServeTime() {
        return rng.genServiceTime();
    }
    
    /**
     *  Method to retrieve a server from a server ID.
     *
     *  @param  i   Server ID.
     *  @return Reference pointer to server object.
     */
    public Server getServer(int i) {
        if (i > 0) {
            return svr[i - 1];
        } else {
            return null;
        }
    }
    
    /*
    public void setNextTime(int i, double time) {
        if (i > 0) {
            svr[i - 1].setNextTime(time);
        }
    }

    public double getNextTime(int i) {
        if (i > 0) {
            return svr[i - 1].getNextTime();
        } else {
            return 0;
        }
    }

    public void makeSpace(int i, boolean up) {
        if (i > 0) {
            if (up) {
                svr[i - 1].upSpace();
            } else {
                svr[i - 1].downSpace();
            }
        }
    }

    public int getSpace(int i) {
        if (i > 0) {
            return svr[i - 1].getSpace();
        } else {
            return -1;
        }
    }*/
}
