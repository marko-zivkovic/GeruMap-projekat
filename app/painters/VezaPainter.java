package app.painters;

import app.repository.imp.Element;
import app.repository.imp.PojamElement;
import app.repository.imp.VezaElement;

import java.awt.geom.GeneralPath;

public class VezaPainter extends  DevicePainter{
    public VezaPainter(Element device) {
        super(device);
        VezaElement veza = (VezaElement) device;

        shape=new GeneralPath();
        ((GeneralPath)shape).moveTo(veza.getPosition().x,veza.getPosition().y);

        ((GeneralPath)shape).lineTo(veza.getX2(),veza.getY2());
        ((GeneralPath)shape).lineTo(veza.getPosition().x,veza.getPosition().y);
        ((GeneralPath)shape).closePath();
    }
}
