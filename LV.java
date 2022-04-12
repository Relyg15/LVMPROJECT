
public class LV extends power{
    private VG volumegroup;

    public LV(String name, int storage, VG volumegroup) {
        super(name, storage);
        this.volumegroup = volumegroup;
    }
}
