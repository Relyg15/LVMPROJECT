import java.util.UUID;
import java.util.*;
public class VG extends power{

    private int storageUsed;
    private ArrayList <Pv> pvs = new ArrayList<Pv>();
    private ArrayList<LV> lvs = new ArrayList<>();

    public VG(String name,  Pv pv) {
        super(name, pv.getStorage());
        pvs = new ArrayList<>();
        lvs = new ArrayList<>();
        storageUsed = 0;
        pvs.add(pv);
    }

    public int getStorageUsed() {
        return storageUsed;
    }

    public void extendVg(Pv pv)
    {
        pvs.add(pv);
        setStorage(pv.getStorage()+getStorage());
    }

    public boolean addLv(LV lv)
    {
        int lvStore = lv.getStorage();
        if(storageUsed + lvStore > getStorage())
        {
            return false;
        }
        else
        {
            lvs.add(lv);
            storageUsed += lvStore;
            return true;
        }
    }

    public ArrayList<Pv> getPvs ()
    {
        return pvs;
    }
    public ArrayList<LV> getLvs()
    {
        return lvs;
    }

}

