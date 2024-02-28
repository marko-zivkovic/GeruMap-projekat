package app.painters;

import app.repository.imp.Element;
import app.repository.imp.LassoElement;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class SelectPainter extends DevicePainter{
    public SelectPainter(Element element) {
        super(element);
        LassoElement rectangle =(LassoElement)element;

        shape = new Rectangle();
        ((Rectangle) shape).setFrameFromDiagonal(rectangle.getPosition(), rectangle.getPoint2());


    }


}
