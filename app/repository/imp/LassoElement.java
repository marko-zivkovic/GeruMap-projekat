package app.repository.imp;

import app.repository.composite.MapNode;

import java.awt.*;

public class LassoElement extends Element{
    Point b;
    public LassoElement(String name, MapNode parent, Stroke stroke, Paint paint, Point p, Dimension d) {
        super(name, parent, stroke, paint, p, d);
    }public void setSecondPoint(Point b){
        this.b = b;
    }
    public Point getPoint2(){
        return b;
    }

}
