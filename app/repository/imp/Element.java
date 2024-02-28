package app.repository.imp;

import app.observer.ISubscriber;
import app.painters.ElementPainter;
import app.repository.composite.MapNode;

import java.awt.*;

public class Element extends MapNode {
    protected  Paint paint ;
    protected  Paint staraBoja;


    protected Stroke stroke;
    protected String description;
    protected Dimension size;
    protected Point position;
    public Rectangle r;
    public Element(String name, MapNode parent,Stroke stroke, Paint paint, Point p, Dimension d) {
        super(name, parent);
        this.stroke = stroke;
        this.paint = paint;
        this.position = p;
        this.size = d;


    }

    @Override
    public String getAutor() {return null;}





    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    public Stroke getStroke() {
        return stroke;
    }

    public Paint getStaraBoja() {return staraBoja;}
    public void setStaraBoja(Paint staraBoja) {this.staraBoja = staraBoja;}

    public void setStroke(Stroke stroke) {
        this.stroke = stroke;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Dimension getSize() {
        return size;
    }

    public void setSize(Dimension size) {
        this.size = size;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    @Override
    public void addSubscriber(ISubscriber sub) {}
    @Override
    public void removeSubscriber(ISubscriber sub) {}
    @Override
    public void notifySubscribers(Object notification) {}
    @Override
    public void update(Object notification) {}
}
