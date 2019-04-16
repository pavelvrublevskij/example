package lt.asprogramuoju.sessionhiber.domain.enums;

public enum CustomerTypeEnum {
    SIMPLE(1, "SIMPLE"),
    LOYAL(2, "LOYAL");

    private final int id;
    private final String name;

    CustomerTypeEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
