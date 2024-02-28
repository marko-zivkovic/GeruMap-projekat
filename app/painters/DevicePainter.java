package app.painters;

import app.repository.imp.Element;

import java.awt.*;

public class DevicePainter extends ElementPainter{
    protected Shape shape;
    public DevicePainter(Element device){
        super(device);
    }
    @Override
    public void paint(Graphics2D g, Element element) {
        g.setPaint(Color.black);
        g.setStroke(element.getStroke());
        g.draw(getShape());
        g.setPaint(element.getPaint());

        g.fill(getShape());

        if (element instanceof Element){
            g.setPaint(Color.BLACK);
            Element device=(Element)element;
            g.drawString(device.getName(), (int)device.getPosition().getX()+10,
                    (int)device.getPosition().getY()+10);
        }
    }

    public Shape getShape() {
        return shape;
    }
    @Override
    public boolean elementAt(Element element, Point pos) {
        return getShape().contains(pos);
    }
    public Element getElement() {return super.element;}


}
