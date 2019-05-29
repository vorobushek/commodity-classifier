package org.example.cayenne.persistent;
import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.configuration.server.ServerRuntime;
import org.apache.cayenne.query.SelectQuery;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ServerRuntime cayenneRuntime = ServerRuntime.builder()
                .addConfig("cayenne-project.xml")
                .build();
        ObjectContext context = cayenneRuntime.newContext();

        Classifikator classifikator = context.newObject(Classifikator.class);
        Classifikator dreli = context.newObject(Classifikator.class);
        Classifikator perforator = context.newObject(Classifikator.class);
        Classifikator kompi = context.newObject(Classifikator.class);
        Classifikator gameKompi = context.newObject(Classifikator.class);

        EdenicaIzmerenia kg = context.newObject(EdenicaIzmerenia.class);
        kg.setTitle("КГ");
        EdenicaIzmerenia ach = context.newObject(EdenicaIzmerenia.class);
        ach.setTitle("Ач");
        EdenicaIzmerenia nol = context.newObject(EdenicaIzmerenia.class);
        nol.setTitle("");

        Value valueTable = context.newObject(Value.class);
        Value valueTable1 = context.newObject(Value.class);
        Value valueTable2 = context.newObject(Value.class);

        Enum enumeration = context.newObject(Enum.class);

        classifikator.setNodeName("eletronika");
        dreli.setNodeName("dreli");
        perforator.setNodeName("Perforator");
        kompi.setNodeName("komps");
        gameKompi.setNodeName("game komps");

        classifikator.setToParent(classifikator);

        classifikator.addToToChields(dreli);
        classifikator.addToToChields(perforator);
        classifikator.addToToChields(kompi);

        kompi.addToToChields(gameKompi);

        ParamClassa classifTOparametr= context.newObject(ParamClassa.class);
        ParamClassa classifTOparametr1= context.newObject(ParamClassa.class);
        ParamClassa classifTOparametr2= context.newObject(ParamClassa.class);

        MetaParams techParam = context.newObject(MetaParams.class);
        MetaParams opisanie = context.newObject(MetaParams.class);

        Parametr parametr = context.newObject(Parametr.class);
        Parametr parametr1 = context.newObject(Parametr.class);
        Parametr parametr2 = context.newObject(Parametr.class);

        techParam.setName("Технический параметр");
        techParam.addToParametrs(parametr);
        techParam.addToParametrs(parametr1);

        opisanie.setName("Общее описание");

        parametr.setMetaParametrName_(techParam.getName());
        parametr.setMeta_params(techParam);
        parametr.addToParamsClassa(classifTOparametr);
        parametr.setParamClassaName("вес");

        parametr1.setMetaParametrName_(techParam.getName());
        parametr1.setMeta_params(techParam);
        parametr1.addToParamsClassa(classifTOparametr1);
        parametr1.setParamClassaName("Емкость аккамулятора");

        parametr2.setMetaParametrName_(opisanie.getName());
        parametr2.setMeta_params(opisanie);
        parametr2.addToParamsClassa(classifTOparametr2);
        parametr2.setParamClassaName("Название");


        classifikator.addToParamsClassa(classifTOparametr);
        classifikator.addToParamsClassa(classifTOparametr1);
        classifikator.addToParamsClassa(classifTOparametr2);

        classifTOparametr.setParams(parametr);
        classifTOparametr1.setParams(parametr1);
        classifTOparametr2.setParams(parametr2);

        Izdelie izdelie = context.newObject(Izdelie.class);

        TypesOfParameter typeOfParam = context.newObject(TypesOfParameter.class);

        typeOfParam.addToIzdelies(izdelie);
        typeOfParam.setName("Вес");

        enumeration.setGrouping("1");
        enumeration.setValue("50");

        enumeration.setValue1(valueTable);

        valueTable.setEdenicaIzmerenia(kg);
        valueTable.setIsEnum(true);
        valueTable.setParametr(parametr);
        valueTable.setIzdelie(izdelie);

        valueTable1.setEdenicaIzmerenia(ach);
        valueTable1.setIsEnum(false);
        valueTable1.setParametr(parametr1);
        valueTable1.setIzdelie(izdelie);
        valueTable1.setValue("0.6");

        valueTable2.setEdenicaIzmerenia(nol);
        valueTable2.setIsEnum(false);
        valueTable2.setParametr(parametr2);
        valueTable2.setIzdelie(izdelie);
        valueTable2.setValue("Дрель-шуруповерт аккумуляторная");

        izdelie.setParametr(parametr);
        izdelie.setParametr(parametr1);
        izdelie.setParametr(parametr2);

//        DROP TABLE classifikator,izdelie,meta_params,param_classa,parametr,types_of_parameter,edenica_izmerenia,value ,enum;

        context.commitChanges();

        SelectQuery selectQuery = new SelectQuery(Value.class);
        List<Value> values = context.performQuery(selectQuery);

        SelectQuery selectQuery1 = new SelectQuery(Parametr.class);
        List<Parametr> parametres = context.performQuery(selectQuery1);

        String s1 = "metaParametrName_=>Технический параметр";
        for(int i = 0; i < values.size(); i++) {
            if (values.get(i).getParametr().toString().contains(s1)) {
                if(values.get(i).isIsEnum()==true) {
                    System.out.println(values.get(i).getParametr().getParamClassaName() + " = " + enumeration.
                            getValue() + " " + values.get(i).getEdenicaIzmerenia().getTitle());
                }else{
                    System.out.println(values.get(i).getParametr().getParamClassaName() + " = " + values.get(i).getValue()
                            + " " + values.get(i).getEdenicaIzmerenia().getTitle());
                }
            }
        }
    }
}
