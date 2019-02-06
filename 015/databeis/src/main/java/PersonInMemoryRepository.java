import java.util.ArrayList;
import java.util.Arrays;

public class PersonInMemoryRepository implements CrudRepository {
    static ArrayList<Object> memoryList= new ArrayList<>(Arrays.asList(
            new Person(0,"Ana","Popescu","Vaslui"),
            new Person(1,"Vasile","Borbely","Bacau"),
            new Person(2,"Ioan","Vasilescu", "Targoviste"),
            new Person(3,"Adriana","Moldovan","Iasi")));

    @Override
    public Object findOne(Long id) {
        for(long i=0;i<memoryList.size();i++)
            if(id==i)
                return memoryList.get(Math.toIntExact(id));
        return null;
    }

    @Override
    public Iterable findAll() {
        return memoryList;
    }

    @Override
    public Object save(Object entity) {
        Person p = (Person) entity;
        if(memoryList.contains(p))
                return null;
        memoryList.add(p);
        return entity;
    }

    @Override
    public Object delete(Long id) {
        for (long i = 0; i < memoryList.size(); i++)
            if (id == i) {
                if(memoryList.get(Math.toIntExact(id))!=null) {
                    Object copy = memoryList.get(Math.toIntExact(id));
                    memoryList.remove(Math.toIntExact(id));
                    return copy;
                }
            }
        return null;
    }

    @Override
    public Object update(Object entity) {
        Person p = (Person) entity;
        if(findOne(p.ID)!=null) {
            memoryList.add((int) p.ID, entity);
            int nr = (int) p.getID();
            nr++;
            memoryList.remove(nr);
            return null;
        }
        return entity;
    }
}
