package thi;

import java.text.SimpleDateFormat;
import java.util.Date;

public class hanhhoa {
    String type;
    int id;
    String name;
    double price;
    int amount;
    Date date;

    hanhhoa(String loai, int ma, String ten, double gia, int soluong, Date ngay){
        type=loai;
        id=ma;
        name=ten;
        price=gia;
        amount=soluong;
        date=ngay;
    }

    hanhhoa(){}

     
    public String chuyenNgaySangChuoi(Date date){
        String chuoiNgayViet = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        chuoiNgayViet =  simpleDateFormat.format(date);
        return chuoiNgayViet;
    }

    public void inThongTin(){
        System.out.println("-------------------");
        System.out.println("Loại: "+type);
        System.out.println("Mã: "+id);
        System.out.println("Tên: "+name);
        System.out.println("Giá: "+price);
        System.out.println("Số lượng: "+amount);
        System.out.println("Ngày: "+chuyenNgaySangChuoi(date));
    }

     
}
