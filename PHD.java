public class PHD {

    private String name;
    private int size;
    private Pv pv;

    public PHD (String name, int size)
    {
        this.name=name;
        this.size=size;
    }

    public void assignPv(Pv phyv)
    {
        pv = phyv;
    }

    public boolean hasPv()
    {
        return pv!=null;
    }



    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }
}
