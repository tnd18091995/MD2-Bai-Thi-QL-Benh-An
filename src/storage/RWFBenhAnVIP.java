package storage;

import model.BenhAnVIP;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RWFBenhAnVIP implements IRWFBenhAnVIP {
    public static final String PATHNAME_BENHANVIP = "benhanvip.txt";

    public void writeFile(List<BenhAnVIP> bavs){
        File fileBAV = new File(PATHNAME_BENHANVIP);
        try {
            OutputStream opsBAV = new FileOutputStream(fileBAV);
            ObjectOutputStream oosBAV =  new ObjectOutputStream(opsBAV);
            oosBAV.writeObject(bavs);
            oosBAV.close();
            opsBAV.close();
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }

    public List<BenhAnVIP> readFile(){
        File file = new File(PATHNAME_BENHANVIP);
        if (!file.exists()) {
            return getBenhAnVIP();
        }
        try {
            InputStream isBAV = new FileInputStream(file);
            ObjectInputStream oisBAV = new ObjectInputStream(isBAV);
            Object object = oisBAV.readObject();
            return (List<BenhAnVIP>) object;
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file: " + e.getMessage());
            return getBenhAnVIP();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
            return getBenhAnVIP();
        }
    }

    public List<BenhAnVIP> getBenhAnVIP(){
        List<BenhAnVIP> listBAV = new ArrayList<>();
        listBAV.add(new BenhAnVIP(1, "BAXXX", "BNXXX", "Nguyen Van A","04/05/2024","14/05/2024","Tieu Duong","VIP", "30/06/2024"));
        writeFile(listBAV);
        return listBAV;
    }
}
