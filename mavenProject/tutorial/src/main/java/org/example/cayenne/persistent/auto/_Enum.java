package org.example.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;
import org.example.cayenne.persistent.Value;

/**
 * Class _Enum was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _Enum extends CayenneDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String ID_PK_COLUMN = "ID";

    public static final Property<String> GROUPING = Property.create("grouping", String.class);
    public static final Property<String> VALUE = Property.create("value", String.class);
    public static final Property<Value> VALUE1 = Property.create("value1", Value.class);

    public void setGrouping(String grouping) {
        writeProperty("grouping", grouping);
    }
    public String getGrouping() {
        return (String)readProperty("grouping");
    }

    public void setValue(String value) {
        writeProperty("value", value);
    }
    public String getValue() {
        return (String)readProperty("value");
    }

    public void setValue1(Value value1) {
        setToOneTarget("value1", value1, true);
    }

    public Value getValue1() {
        return (Value)readProperty("value1");
    }


}
