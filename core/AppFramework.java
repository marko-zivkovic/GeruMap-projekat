package core;

public class AppFramework {

    protected Gui gui;
    protected MapRepository mapRepository;
    protected MessageGen messageGen;

    protected ConsoleLog consoleLog;
    protected FileLog fileLog;
    public void run(){this.gui.start();}
    public void initialise(Gui gui, MapRepository mr){
        this.gui = gui;
        this.mapRepository = mr;
        this.messageGen = new MessageGenImp();
        messageGen.addSubscriber(this.gui);
        this.consoleLog = new ConsoleLog();
        this.fileLog = new FileLog();
        messageGen.addSubscriber(consoleLog);
        messageGen.addSubscriber(fileLog);
    }
    private static AppFramework instance;
    private AppFramework(){
    }
    public static AppFramework getInstance(){
        if(instance==null){
            instance = new AppFramework();
        }
        return instance;
    }



    public Gui getGui() {return gui;}
    public void setGui(Gui gui) {this.gui = gui;}
    public MapRepository getMapRepository() {return mapRepository;}
    public void setMapRepository(MapRepository mapRepository) {
        this.mapRepository = mapRepository;}
    public MessageGen getErrorGenerator(){
        return messageGen;
    }
}
