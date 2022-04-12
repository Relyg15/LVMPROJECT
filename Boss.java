import javax.xml.transform.SourceLocator;
import java.sql.SQLOutput;
import java.util.*;
public class Boss {
    private Map<String, Pv> pvList;
    private Map<String, LV> lvList;
    private Map<String, VG> vgList;
    private Map<String, PHD> phdList;

    public Boss (){
        pvList = new HashMap<>();
        lvList = new HashMap<>();
        vgList = new HashMap<>();
        phdList = new HashMap<>();
    }
    public boolean installDrive(String name, int size){
        if (phdList.containsKey(name))return false;

        phdList.put(name, new PHD(name,size));
        return true;
    }

    public void listDrives()
    {
        for (Map.Entry <String,PHD> entry: phdList.entrySet()) {
            PHD phd = entry.getValue();
            System.out.println(phd.getName()+ "[" + phd.getSize() + "G]");
        }


    }
    public boolean pvcreate(String name, String driveName){
        PHD phd = phdList.get(driveName);
        if (phd == null) return false;
        if (phd.hasPv()){
            return false;
        }
        Pv pv = new Pv(name, phd);
        pvList.put(name,pv);
        return true;
    }
    public boolean vgCreate(String vgName, String pvName){
        Pv pv = pvList.get(pvName);
        if (pv == null) return false;
        if (pv.hasVg()) return false;
        VG vg = new VG (vgName,pv);
        vgList.put(vgName, vg);
        return true;
    }
    public boolean vgExtend(String vgName,String pvName){
        Pv pv = pvList.get(pvName);
        if (pv == null) return false;
        VG vg = vgList.get(vgName);
        if (vg == null) return false;
        vg.extendVg(pv);
        return true;
    }
    public void vgList(){
        for (Map.Entry <String,VG> entry: vgList.entrySet()){
            VG vg = entry.getValue();
            System.out.println(vg.getName()+ ": Total: [" + vg.getStorage()+ "G] available :["+ (vg.getStorage()-vg.getStorageUsed())+"G] "+vg.getPvs().toString()+" [" + vg.getUuid()+ "]" );

        }
    }
    public boolean lvCreate(String lvName,int size,String vgName) {
        VG vg = vgList.get(vgName);
        if (vg == null) return false;
        LV lv = new LV(lvName, size, vg);
        if (vg.addLv(lv) == false) return false;
        else {
            lvList.put(lvName, lv);
            return true;
        }
    }
    public void lvList(){
        for (Map.Entry<String,VG> entry: vgList.entrySet()){
            VG vg = entry.getValue();
            for (LV lv: vg.getLvs()){
                System.out.println(lv.getName()+ ": ["+ lv.getStorage() + "G] [" + vg.getName()+ "] [" +lv.getUuid() + "]");
            }

        }
    }



    public void pvList(){
        for (Map.Entry <String,Pv> entry: pvList.entrySet()) {
            Pv pv = entry.getValue();
            if (pv.hasVg()) System.out.println(pv.getName()+ "[" + pv.getStorage() + "G] [" + pv.getVolumeGroup().getName() + "] [" + pv.getUuid() + "]");
            else System.out.println(pv.getName()+ "[" + pv.getStorage() + "G] [" + pv.getUuid());
        }

    }

}
