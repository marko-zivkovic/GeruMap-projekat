import app.SwingGui;
import app.repository.MapRepositoryImp;
import app.view.MainWindow;
import core.AppFramework;
import core.Gui;
import core.MapRepository;

public class AppCore {
    public static void main (String[] args){
        AppFramework appcore = AppFramework.getInstance();
        Gui gui = new SwingGui();
        MapRepository mapRe = new MapRepositoryImp();
        appcore.initialise(gui,mapRe);
        appcore.run();

    }
}
