package main.repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import main.interfaces.Repository;
import main.models.Allotment;

public class AllotmentRepository implements Repository<String, Allotment> {
    Map<String, Allotment> allotments;

    public AllotmentRepository() {
        this.allotments = new HashMap<>();
    }

    public Allotment get(String id) {
        return allotments.get(id);
    }

    public Collection<Allotment> all() {
        return allotments.values();
    }

    public void add(Allotment allotment) {
        allotments.put(allotment.getId(), allotment);
    }

    public Allotment remove(String id) {
        return allotments.remove(id);
    }
}
