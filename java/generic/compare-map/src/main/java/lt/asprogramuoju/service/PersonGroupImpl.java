package lt.asprogramuoju.service;

import lt.asprogramuoju.bean.Person;
import lt.asprogramuoju.repository.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

@SuppressWarnings("unchecked")
public abstract class PersonGroupImpl<G, E extends List<? extends Person>> extends HashMap<G, E> implements PersonGroup<G, E> {

    public void setToGroup(G group, E type, boolean doSort) {
        if (doSort) {
            type.sort(setComparator());
        }
        this.put(group, type);
    }

    public abstract Comparator<Person> setComparator();

    public void fillData(G group, E type) {
        this.put(group, type);
    }

    public void fillDataAndSort(G group, E type) {
        type.sort(setComparator());
        fillData(group, type);
    }

    public E getByGroup(G group) {
        return this.get(group);
    }

    public E getAllData() {
        List<Person> personList = new ArrayList<>();
        this.forEach((g, person) -> personList.addAll(person));

        return (E) personList;
    }
}
