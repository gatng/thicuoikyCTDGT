package thi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class date {
    /*đổi chuỗi theo ngày Việt sang ngày java */
    public static Date chuyenChuoiSangNgay(String chuoiNgay) throws ParseException{
         
        Date date;
         
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        date = simpleDateFormat.parse(chuoiNgay);
        return date;
    }

    //Đổi ngày Java sang  ngày việt 
    public static String chuyenNgaySangChuoi(Date date){
        String chuoiNgayViet = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        chuoiNgayViet =  simpleDateFormat.format(date);
        return chuoiNgayViet;
    }
    public static void main(String[] args) throws ParseException {
        
        Date ngay;
        String chuoiNgay="16/12/2002";
        
        ngay = chuyenChuoiSangNgay(chuoiNgay);
        System.out.println(ngay);

        String Str = chuyenNgaySangChuoi(ngay);

        System.out.println(Str);
    }
}

    

    





