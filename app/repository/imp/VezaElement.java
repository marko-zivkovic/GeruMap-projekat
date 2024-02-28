package app.repository.imp;

import app.painters.PojamPainter;
import app.painters.VezaPainter;
import app.repository.composite.MapNode;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class VezaElement extends Element{
    int x2, y2;
    public VezaElement(String name, MapNode parent, Stroke stroke, Paint c, Point p, Dimension d) {

        super(name, parent, stroke, c, p, d);

    }
    public int getX2() {return x2;}
    public void setX2(int x2) {this.x2 = x2;}
    public int getY2() {return y2;}
    public void setY2(int y2) {this.y2 = y2;}

}
