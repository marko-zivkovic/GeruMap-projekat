package state;

import app.repository.imp.Element;
import app.repository.imp.MapaUma;
import app.view.MapaUmaView;

public interface State {
    void prikazi(int x, int y, MapaUma m);
    void  prikazi(int x, int y, MapaUma m, MapaUmaView mv, Element ele);

}
