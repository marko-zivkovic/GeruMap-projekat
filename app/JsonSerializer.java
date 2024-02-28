package app;

import app.repository.imp.Element;
import app.repository.imp.MapaUma;
import app.repository.imp.Project;
import app.repository.imp.PojamElement;
import com.google.gson.Gson;
import core.Serializer;

import java.io.*;

public class JsonSerializer implements Serializer {

    private final Gson gson = new Gson();


    @Override
    public Project loadProject(File file) {
        System.out.println(file);
        try(FileReader writer = new FileReader(file)){

            Project project = gson.fromJson( writer ,Project.class);

        } catch (IOException e) {

            e.printStackTrace();
        }





        return null;
    }

    @Override
    public void saveProject(Project node) {


        //File file = new File(node.getFilePath());

        for (int i = 0 ; i < node.getChildren().size() ; i++){
            MapaUma mapa = (MapaUma)node.getChildren().get(i);
            node.mapeUma.add(mapa);
            for (int j = 0 ; j < mapa.getChildren().size(); j++){
                    Element aaaa = (Element) mapa.getChildren().get(j);
                    mapa.elementi.add(aaaa);



            }
        }
       // System.out.println(node.getFilePath());
       // System.out.println(node.toString());
        try(FileWriter writer = new FileWriter(node.getFilePath())){
            System.out.println("uslo");
            gson.toJson(node,writer);

        } catch (IOException e) {

            e.printStackTrace();
        }
        //String s =  gson.toJson(node);


    }
}
