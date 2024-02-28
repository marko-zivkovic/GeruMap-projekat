package app.repository.imp;

import app.painters.ElementPainter;
import app.painters.PojamPainter;
import app.repository.composite.MapNode;

import java.awt.*;

public class PojamElement extends Element{
    public PojamElement(String name, MapNode parent, Stroke stroke, Paint paint, Point p, Dimension d) {
        super(name, parent, stroke, paint, p, d);
    }
}
