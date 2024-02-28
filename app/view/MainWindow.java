package app.view;

import app.controller.ActionManager;
import app.observer.ISubscriber;
import app.tree.MapTree;
import app.tree.MapTreeImp;
import core.AppFramework;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame implements ISubscriber {
    private static MainWindow instance = null;
    private ActionManager actionManager;
    private JMenuBar menu;
    private JToolBar toolBar;
    private JToolBar desniToolbar;
    private MapTree mapTree;
    //private MojTabbedPane mojTabbedPane;
    private JPanel desniPanel;
    private JSplitPane split;
    private MainWindow()
    {
    }
    public static MainWindow getInstance(){
        if(instance == null){
            instance = new MainWindow();
            instance.initialise();

        }
        return instance;
    }
    private void initialise(){

        actionManager = new ActionManager();
        mapTree = new MapTreeImp();
        System.out.println("test");
        initialiseGui();
    }
    private void initialiseGui(){

        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenD = tk.getScreenSize();
        int visina = screenD.height;
        int sirina = screenD.width;
        setSize((sirina/2)+450,(visina/2)+250);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("GeRuMap app");

        menu = new MenuBar();
        this.setJMenuBar(menu);
        toolBar = new Toolbar();
        this.getContentPane().add(toolBar,BorderLayout.NORTH);
        desniToolbar = new DesniToolBar();
        this.getContentPane().add(desniToolbar,BorderLayout.EAST);

        JTree projectExplorer = mapTree.generateTree(AppFramework.getInstance().getMapRepository().getProjectExplorer());
        AppFramework.getInstance().getMapRepository().getProjectExplorer().addSubscriber(this);

        desniPanel = new JPanel();
        desniPanel.setBackground(Color.gray);

        JScrollPane scroll=new JScrollPane(projectExplorer);
        scroll.setMinimumSize(new Dimension(200,150));
        split=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,scroll,desniPanel);
        getContentPane().add(split,BorderLayout.CENTER);
        split.setDividerLocation(250);
        split.setOneTouchExpandable(true);

        setVisible(true);
    }
    public ActionManager getActionManager(){return actionManager;}
    //public MojTabbedPane getMojTabbedPane(){return mojTabbedPane;}
    public JMenuBar getMenu() {return menu;}
    public JPanel getDesniPanel(){return desniPanel;}
    public JToolBar getToolBar() {return toolBar;}
    public MapTree getMapTree() {return mapTree;}
    public void setDesniPanel(ProjectView Panel) {
        this.desniPanel = Panel;
        this.split.setRightComponent(Panel);
        this.revalidate();
        this.repaint();
    }

    @Override
    public void update(Object notification) {
        if (notification instanceof String && notification.equals("deletePro")){
            desniPanel = new JPanel();
            this.split.setRightComponent(desniPanel);
            this.revalidate();
            this.repaint();
        }
    }
    public void disableUndoAction(){actionManager.getUndoAction().setEnabled(false);}
    public void disableRedoAction(){actionManager.getReDoAction().setEnabled(false);}
    public void enableUndoAction(){actionManager.getUndoAction().setEnabled(true);}
    public void enableRedoAction(){actionManager.getReDoAction().setEnabled(true);}
}
