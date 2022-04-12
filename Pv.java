public class Pv extends power{
    private PHD drive;
    private VG volumeGroup;

    public Pv(String name,  PHD drive) {
        super(name, drive.getSize());
        this.drive = drive;
    }


    public PHD getDrive() {
        return drive;
    }

    public VG getVolumeGroup() {
        return volumeGroup;
    }

    public boolean hasVg()
    {
        return volumeGroup != null;
    }
    public String toString(){
        return getName();
    }
}
