
public interface Database<T> {
    Collection<T> collection;

    boolean clear();
    boolean addElement(T element);
    String getInfo();
    boolean removeById(T id);
    boolean updateById(T id, T element);
    boolean existsById(T id);

}
