import java.util.UUID;

public class power {
    private String name;
    private String uuid;
    private int storage;
    public power (String name, int storage)
    {
        UUID u = UUID.randomUUID();
        this.uuid = u.toString();
        this.name = name;
        this.storage= storage;
    }

    public String getName() {
        return name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

}