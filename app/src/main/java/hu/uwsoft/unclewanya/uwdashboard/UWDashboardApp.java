package hu.uwsoft.unclewanya.uwdashboard;

class UWDashboardApp {
    private static UWDashboardApp instance = null;
    private UWDashboardApp() { }
    static public UWDashboardApp instance() {
        if (instance == null) {
            instance = new UWDashboardApp();
        }
        return instance;
    }
    public void finalize() {
        instance = null;
    }
    public boolean init(){

        return(true);
    }

    public void done(){

        return;
    }

    public boolean start(){

        return(true);
    }

    public void stop(){

        return;
    }
}
