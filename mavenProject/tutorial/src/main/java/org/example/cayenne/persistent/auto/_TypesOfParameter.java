package org.example.cayenne.persistent.auto;

import java.util.List;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;
import org.example.cayenne.persistent.Izdelie;

/**
 * Class _TypesOfParameter was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _TypesOfParameter extends CayenneDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String ID_TYPE_PK_COLUMN = "ID_TYPE";

    public static final Property<String> NAME = Property.create("name", String.class);
    public static final Property<List<Izdelie>> IZDELIES = Property.create("izdelies", List.class);

    public void setName(String name) {
        writeProperty("name", name);
    }
    public String getName() {
        return (String)readProperty("name");
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


}
