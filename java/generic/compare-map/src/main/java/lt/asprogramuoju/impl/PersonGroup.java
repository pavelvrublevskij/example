package lt.asprogramuoju.impl;

import lt.asprogramuoju.bean.Person;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public abstract class PersonGroup<G, E extends List<? extends Person>> extends HashMap<G, E> {

    /**
     * Set data to group. For doSort {@link #setComparator} should be override
     * @param group {@link G}
     * @param type {@link E}
     * @param doSort when true will call {@link #setComparator}
     */
    public void setToGroup(G group, E type, boolean doSort) {
        if (doSort) {
            type.sort(setComparator());
        }
        this.put(group, type);
    }

    public abstract Comparator<Person> setComparator();

    /**
     * Set person to group. This method don't sort students.
     * For sorting use {@link #fillDataAndSort(G, E)}
     * @param group group of {@link G}
     * @param type list of students {@link E}
     */
    public void fillData(G group, E type) {
        this.put(group, type);
    }

    /**
     * Set person to group and make sort asc. See interface {@link E}
     * @param group group of {@link G}
     * @param type list of students {@link E}
     */
    public void fillDataAndSort(G group, E type) {
        type.sort(setComparator());
        fillData(group, type);
    }

    /**
     * Return list of persons by group name
     * @param group
     * @return {@link E}
     */
    public E getByGroup(G group) {
        return this.get(group);
    }

    /**
     * Method will return all data from Map without group
     * @return List of {@link E}
     */
    @SuppressWarnings("unchecked")
    public E getAllData() {
        List<Person> personList = new ArrayList<>();
        this.forEach((g, person) -> personList.addAll(person));

        return (E) personList;
    }
}
