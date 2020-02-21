package lt.asprogramuoju.impl;

import lt.asprogramuoju.bean.Person;

import java.util.Comparator;
import java.util.Map;

/**
 * @author pavel.vrublevskij
 */
public interface PersonGroup<G, E> extends Map<G, E> {

    /**
     * Set data to group. For doSort {@link #setComparator} should be override
     * @param group {@link G}
     * @param type {@link E}
     * @param doSort when true will call {@link #setComparator}
     */
    void setToGroup(G group, E type, boolean doSort);

    <T> Comparator<T> setComparator();

    /**
     * Set person to group. This method don't sort students.
     * For sorting use {@link #fillDataAndSort(G, E)}
     * @param group group of {@link G}
     * @param type list of students {@link E}
     */
    void fillData(G group, E type);

    /**
     * Set person to group and make sort asc. See interface {@link E}
     * @param group group of {@link G}
     * @param type list of students {@link E}
     */
    void fillDataAndSort(G group, E type);

    /**
     * Return list of persons by group name
     * @param group
     * @return {@link E}
     */
    E getByGroup(G group);

    /**
     * Method will return all data from Map without group
     * @return List of {@link E}
     */
    E getAllData();

}
