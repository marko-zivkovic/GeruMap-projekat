package app.tree;

import app.factory.FactoryUtil;
import app.factory.MapNodeFactory;
import app.repository.composite.MapNode;
import app.repository.composite.MapNodeComp;
import app.repository.imp.Element;
import app.repository.imp.MapaUma;
import app.repository.imp.Project;
import app.repository.imp.ProjectExp;
import app.tree.model.MapTreeItem;
import app.tree.view.MapTreeView;
import app.view.MainWindow;
import app.view.ProjectView;
import core.AppFramework;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;

public class MapTreeImp implements MapTree{
    private MapTreeView treeView;
    private DefaultTreeModel treeModel;

    @Override
    public MapTreeView generateTree(ProjectExp projectExplorer) {
        MapTreeItem root = new MapTreeItem(projectExplorer);
        treeModel = new DefaultTreeModel(root);
        treeView = new MapTreeView(treeModel);
        return treeView;
    }

    @Override
    public void addChild(MapTreeItem parent) {
        if (!(parent.getMapNode() instanceof MapNodeComp)) {
            AppFramework.getInstance().getErrorGenerator().generate("LEAFA");
            return; //ERROR MESSAGE
        }
       // MapNode child = createChild(parent.getMapNode());
        MapNodeFactory factory = FactoryUtil.getFactory(parent.getMapNode());
        if(!(parent.getMapNode() instanceof MapaUma)){
        MapNode child = factory.getNode(parent.getMapNode());
        parent.add(new MapTreeItem(child));
        ((MapNodeComp) parent.getMapNode()).addChild(child);
        treeView.expandPath(treeView.getSelectionPath());
        }

        SwingUtilities.updateComponentTreeUI(treeView);
    }
    public void addChildElement(MapaUma mu, Element ele, int idx){
        MapTreeItem pro = (MapTreeItem) MainWindow.getInstance().getMapTree().getSelectedNode();
        if(pro.getMapNode() instanceof Project){
            ((MapTreeItem)pro.getChildAt(idx)).add(new MapTreeItem(ele));
            SwingUtilities.updateComponentTreeUI(treeView);
        }
        //System.out.println(idx);
    }
    public void deleteChild(MapTreeItem cvor){
        if (cvor.getMapNode() instanceof ProjectExp)
            AppFramework.getInstance().getErrorGenerator().generate("PROJECTEXPD");
        ///selected = cvor.getMapNode()///
        MapNode parent = cvor.getMapNode().getParent();
        if(parent instanceof ProjectExp){
            ((ProjectExp) parent).deleteChild(cvor.getMapNode());
        }
        else if(parent instanceof Project){
            ((Project) parent).deleteChild(cvor.getMapNode());
        }
        else if(parent instanceof MapaUma){
            ((MapaUma) parent).deleteChild(cvor.getMapNode());
        }
        cvor.removeFromParent();
        SwingUtilities.updateComponentTreeUI(treeView);
    }
    public void deleteChildElement(int mp, Element ele, MapaUma mapa){
        MapTreeItem project = (MapTreeItem) MainWindow.getInstance().getMapTree().getSelectedNode();
        if(project.getMapNode() instanceof Project){
            int brojdece = mapa.getChildren().size() + 1; int br=0; int lociran = 0; boolean flag = false;
            System.out.println(brojdece);
            while(br!=brojdece){
                String ime1 = ((MapTreeItem)project.getChildAt(mp).getChildAt(br)).getMapNode().getName();
                String ime2 = ele.getName();
                System.out.println(ime1 +" - "+ ime2 + " broj = "+br);
                if(ime1.equals(ime2)){
                    lociran = br; flag = true;
                }
                br++;
            }

            if(flag){
                System.out.println("usao sam "+ lociran);
                ((MapTreeItem) project.getChildAt(mp).getChildAt(lociran)).removeFromParent();
            }
            SwingUtilities.updateComponentTreeUI(treeView);
        }

    }
    public boolean deleteVezaElement(Element child, Point point1, Point point2, int lokacija){
        ProjectView pw = (ProjectView) MainWindow.getInstance().getDesniPanel();
        boolean flag1 = pw.getPaintersList().get(lokacija).elementAt((Element) child,point1);
        boolean flag2 = pw.getPaintersList().get(lokacija).elementAt((Element) child,point2);
        if(flag1 || flag2){return true;}
        return false;
    }

    @Override
    public MapTreeItem getSelectedNode() {
        return (MapTreeItem) treeView.getLastSelectedPathComponent();
    }
    ////////OVDE TREBA FACTORY METOD
    /*
    private MapNode createChild(MapNode parent) {
        if (parent instanceof ProjectExp)
            return  new Project("Project " + broj_sina++,parent);

        else if(parent instanceof Project){
            return  new MapaUma("MapaUma " + broj_sina1++, parent);
        }
        else if(parent instanceof MapaUma){
            return  new Element("Element " + broj_sina2++, parent);
        }
        return null;
    }
    */
    public MapTreeView getTreeView() {
        return treeView;
    }
}
