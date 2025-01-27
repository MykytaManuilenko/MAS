import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public abstract class Extension implements Serializable {
    private static Map<Class<? extends Extension>, List<Extension>> allExtents = new Hashtable<>();

    public Extension() {
        List<Extension> extent = null;
        Class<? extends Extension> theClass = this.getClass();

        if (allExtents.containsKey(theClass)) {
            extent = allExtents.get(theClass);
        } else {
            extent = new ArrayList<Extension>();
            allExtents.put(theClass, extent);
        }

        extent.add(this);
    }

    public static void writeExtents(ObjectOutputStream stream) throws IOException {
        stream.writeObject(allExtents);
        stream.flush();
        stream.close();
    }

    public static void readExtents(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        allExtents = (Map<Class<? extends Extension>, List<Extension>>) stream.readObject();
    }

    public static <T> void showExtent(Class<Worker> theClass) throws Exception {
        List<T> extent = null;

        if (allExtents.containsKey(theClass)) {
            extent = (List<T>) allExtents.get(theClass);
        } else {
            throw new Exception("Unknown class " + theClass);
        }

        System.out.println("Extent of the class: " + theClass.getSimpleName());

        for (Object obj : extent) {
            System.out.println(obj);
        }
    }

    public static <T> List<T> getAllExtents(Class<Worker> theClass) throws Exception {
        List<T> extent = null;

        if (allExtents.containsKey(theClass)) {
            extent = (List<T>) allExtents.get(theClass);
        } else {
            throw new Exception("Unknown class " + theClass);
        }

        return extent;
    }

    public static <T> Iterable<T> getExtent(Class<T> type) throws ClassNotFoundException {
        if (allExtents.containsKey(type)) {
            return (Iterable<T>) allExtents.get(type);
        }

        throw new ClassNotFoundException(String.format("%s. Stored extents: %s", type.toString(), allExtents.keySet()));
    }
}
