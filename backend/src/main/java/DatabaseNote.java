import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;

@Getter
@Setter
public class DatabaseNote implements Database<Note> {
    private final LinkedList<Note> collection = new LinkedList<>();
    private static long lastMaxId = 0;

    public boolean fillCollection() {
        return true;
    }

    @Override
    public boolean clear() {
        if (!collection.isEmpty()) {
            collection.clear();
            return true;
        }
        return false;
    }

    @Override
    public boolean addElement(Note element) {
        lastMaxId += 1;
        element.setId(lastMaxId);
        return collection.add(element);
    }

    @Override
    public String getInfo() {
        return "This database is suck.";
    }

    @Override
    public boolean removeById(int id) {
        try {
            return collection.removeIf(item -> item.getId() == id);
        } catch (NullPointerException e) {
            return false;
        }
    }

    @Override
    public boolean updateById(int id, Note newElement) { // сделать суб-класс с помощью которого эта штука вызываться будет
        if (removeById(id)) {
            addElement(newElement);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean existsById(int id) {
        return false;
    }
}
