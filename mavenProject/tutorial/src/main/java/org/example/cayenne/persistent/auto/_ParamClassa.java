package org.example.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;
import org.example.cayenne.persistent.Classifikator;
import org.example.cayenne.persistent.Parametr;

/**
 * Class _ParamClassa was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _ParamClassa extends CayenneDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String ID_PK_COLUMN = "ID";

    public static final Property<Classifikator> CLASSSIFATORS = Property.create("classsifators", Classifikator.class);
    public static final Property<Parametr> PARAMS = Property.create("params", Parametr.class);

    public void setClasssifators(Classifikator classsifators) {
        setToOneTarget("classsifators", classsifators, true);
    }

    public Classifikator getClasssifators() {
        return (Classifikator)readProperty("classsifators");
    }


    public void setParams(Parametr params) {
        setToOneTarget("params", params, true);
    }

    public Parametr getParams() {
        return (Parametr)readProperty("params");
    }


}
