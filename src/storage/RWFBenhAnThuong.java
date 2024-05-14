package storage;

import model.BenhAnThuong;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RWFBenhAnThuong implements IRWFBenhAnThuong {
    public static final String PATHNAME_BENHANTHUONG = "benhanthuong.txt";

    public void writeFile(List<BenhAnThuong> bats){
        File fileBAT = new File(PATHNAME_BENHANTHUONG);
        try {
            OutputStream opsBAT= new FileOutputStream(fileBAT);
            ObjectOutputStream oosBAT =  new ObjectOutputStream(opsBAT);
            oosBAT.writeObject(bats);
            oosBAT.close();
            opsBAT.close();
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }

    public List<BenhAnThuong> readFile(){
        File file = new File(PATHNAME_BENHANTHUONG);
        if (!file.exists()) {
            return getBenhAnThuong();
        }
        try {
            InputStream isBAT = new FileInputStream(file);
            ObjectInputStream oisBAT = new ObjectInputStream(isBAT);
            Object object = oisBAT.readObject();
            return (List<BenhAnThuong>) object;
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file: " + e.getMessage());
            return getBenhAnThuong();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
            return getBenhAnThuong();
        }
    }

    public List<BenhAnThuong> getBenhAnThuong(){
        List<BenhAnThuong> listBAT = new ArrayList<>();
        listBAT.add(new BenhAnThuong(1, "BAXXX", "BNXXX", "Nguyen Van A","04/05/2024","14/05/2024","Tieu Duong",10.2));
        writeFile(listBAT);
        return listBAT;
    }
}
