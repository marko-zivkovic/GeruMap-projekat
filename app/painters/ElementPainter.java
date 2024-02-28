package app.painters;

import app.repository.imp.Element;

import java.awt.*;

public abstract class ElementPainter {
    Element element;
    public ElementPainter(Element element) {
        this.element = element;
    }

    public abstract void paint(Graphics2D g, Element element);

    public abstract boolean elementAt(Element element, Point pos);

    public Element getElement(){
        return element;
    }

}
