package org.example.cayenne.persistent.auto;

import java.util.List;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;
import org.example.cayenne.persistent.Izdelie;
import org.example.cayenne.persistent.MetaParams;
import org.example.cayenne.persistent.ParamClassa;
import org.example.cayenne.persistent.Value;

/**
 * Class _Parametr was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _Parametr extends CayenneDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String ID_PK_COLUMN = "ID";

    public static final Property<String> META_PARAMETR_NAME_ = Property.create("metaParametrName_", String.class);
    public static final Property<String> PARAM_CLASSA_NAME = Property.create("paramClassaName", String.class);
    public static final Property<List<Izdelie>> IZDELIES = Property.create("izdelies", List.class);
    public static final Property<MetaParams> META_PARAMS = Property.create("meta_params", MetaParams.class);
    public static final Property<List<ParamClassa>> PARAMS_CLASSA = Property.create("paramsClassa", List.class);
    public static final Property<List<Value>> VALUES = Property.create("values", List.class);

    public void setMetaParametrName_(String metaParametrName_) {
        writeProperty("metaParametrName_", metaParametrName_);
    }
    public String getMetaParametrName_() {
        return (String)readProperty("metaParametrName_");
    }

    public void setParamClassaName(String paramClassaName) {
        writeProperty("paramClassaName", paramClassaName);
    }
    public String getParamClassaName() {
        return (String)readProperty("paramClassaName");
    }

    public void addToIzdelies(Izdelie obj) {
        addToManyTarget("izdelies", obj, true);
    }
    public void removeFromIzdelies(Izdelie obj) {
        removeToManyTarget("izdelies", obj, true);
    }
    @SuppressWarnings("unchecked")
    public List<Izdelie> getIzdelies() {
        return (List<Izdelie>)readProperty("izdelies");
    }


    public void setMeta_params(MetaParams meta_params) {
        setToOneTarget("meta_params", meta_params, true);
    }

    public MetaParams getMeta_params() {
        return (MetaParams)readProperty("meta_params");
    }


    public void addToParamsClassa(ParamClassa obj) {
        addToManyTarget("paramsClassa", obj, true);
    }
    public void removeFromParamsClassa(ParamClassa obj) {
        removeToManyTarget("paramsClassa", obj, true);
    }
    @SuppressWarnings("unchecked")
    public List<ParamClassa> getParamsClassa() {
        return (List<ParamClassa>)readProperty("paramsClassa");
    }


    public void addToValues(Value obj) {
        addToManyTarget("values", obj, true);
    }
    public void removeFromValues(Value obj) {
        removeToManyTarget("values", obj, true);
    }
    @SuppressWarnings("unchecked")
    public List<Value> getValues() {
        return (List<Value>)readProperty("values");
    }


}
