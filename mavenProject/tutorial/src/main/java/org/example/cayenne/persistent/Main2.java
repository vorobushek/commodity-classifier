package org.example.cayenne.persistent;


import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.configuration.server.ServerRuntime;
import org.apache.cayenne.query.SelectQuery;

import java.sql.SQLException;
import java.util.List;



public class Main2 {
    public static void main(String[] args) {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ServerRuntime cayenneRuntime = ServerRuntime.builder()
                .addConfig("cayenne-project.xml")
                .build();
        ObjectContext context = cayenneRuntime.newContext();



        SelectQuery selectQuery = new SelectQuery(Value.class);
        List<Value> values = context.performQuery(selectQuery);

        SelectQuery selectQuery1 = new SelectQuery(Parametr.class);
        List<Parametr> parametres = context.performQuery(selectQuery1);

        String s1 = "metaParametrName_=>Технический параметр";
        System.out.println(values.size());
        for(int i = 0; i < values.size(); i++) {
            //System.out.println(values.get(i));
            //System.out.println(values.get(i).getParametr());
            if (values.get(i).getParametr().toString().contains(s1)) {
                if(values.get(i).isIsEnum()) {
                    System.out.println(values.get(i).getParametr().getParamClassaName() + " = " + values.get(i).getEnum().
                            getValue() + " " + values.get(i).getEdenicaIzmerenia().getTitle());
                }else{
                    System.out.println(values.get(i).getParametr().getParamClassaName() + " = " + values.get(i).getValue()
                            + " " + values.get(i).getEdenicaIzmerenia().getTitle());
                }
            }
        }
    }
}



