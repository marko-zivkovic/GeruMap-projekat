package app.painters;

import app.repository.imp.Element;
import app.repository.imp.PojamElement;

import java.awt.geom.GeneralPath;

public class PojamPainter extends DevicePainter{
    public PojamPainter(Element device) {
        super(device);
        PojamElement rectangle = (PojamElement) device;

        shape=new GeneralPath();
        ((GeneralPath)shape).moveTo(rectangle.getPosition().x,rectangle.getPosition().y);

        ((GeneralPath)shape).lineTo(rectangle.getPosition().x+rectangle.getSize().width,rectangle.getPosition().y);

        ((GeneralPath)shape).lineTo(rectangle.getPosition().x+rectangle.getSize().width,rectangle.getPosition().y+rectangle.getSize().height);

        ((GeneralPath)shape).lineTo(rectangle.getPosition().x,rectangle.getPosition().y+rectangle.getSize().height);

        ((GeneralPath)shape).closePath();
    }


}
