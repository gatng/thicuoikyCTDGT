package thi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class khohanghoa {
    khohanghoa() throws ParseException{
        
        trongKho("thuc pham", 1325, "com", 10000, 600, "6/5/2021");
        trongKho("thuc pham", 1326, "thit bo", 40000, 200, "17/5/2021");
        trongKho("thuc pham", 1329, "thit heo", 25000, 150, "11/4/2021");
        trongKho("thuc pham", 1321, "nuoc mam", 7500, 500, "7/4/2021");
        trongKho("thuc pham", 1328, "toi", 3000, 90, "1/6/2021");
        trongKho("thuc pham", 1322, "khoai tay", 2000, 400, "3/3/2021");
        trongKho("sanh su", 2011, "lo", 7000000, 30, "14/4/2022");
        trongKho("sanh su", 2015, "chen", 12000, 50, "23/8/2022");
        trongKho("sanh su", 2018, "dia", 9000, 40, "26/7/2022");
        trongKho("sanh su", 2019, "to", 89000, 100, "8/6/2021");
        trongKho("sanh su", 2012, "lu", 7777, 80, "21/8/2020");
        trongKho("sanh su", 2014, "ghe", 21000, 60, "14/4/2020");
        trongKho("dien may", 4355, "may tinh ", 32000000, 50, "3/3/2021");
        trongKho("dien may", 4356, "tivi ", 450050, 50, "25/6/2021");
        trongKho("dien may", 4351, "noi com ", 250000, 50, "16/12/2021");
        trongKho("dien may", 4357, "may giat ", 33800000, 50, "7/7/2017");
        trongKho("dien may", 4359, "quat ", 4800000, 50, "2/1/2020");
        trongKho("dien may", 4350, "may lanh ", 88600000, 50, "3/4/2005");
        trongKho("dien may", 4352, "dien thoai  ", 1230000, 50, "17/5/2019");
        trongKho("dien may", 4353, "den dien ", 67800000, 50, "9/2/2019");
        
    }

    node head=null;
    node tail=null;
    Scanner kitu = new Scanner(System.in);
    Scanner so = new Scanner(System.in);

    node  dienThongTin() throws ParseException{
        System.out.print("Nhập loại ( thuc pham/sanh su/dien may ): ");
        String loai = kitu.nextLine();
        System.out.print("Nhập mã: ");
        int ma = so.nextInt();
        System.out.print("Tên: ");
        String ten = kitu.nextLine();
        System.out.print("Giá: ");
        double gia = so.nextDouble();
        System.out.print("Số lượng: ");
        int soluong = so.nextInt();
        System.out.print("Ngày nhập kho ( dd/mm/yyyy ): ");
        String chuoiNgay = kitu.nextLine();
        Date ngay = chuyenChuoiSangNgay(chuoiNgay);
        hanhhoa dulieu = new hanhhoa(loai, ma, ten, gia, soluong, ngay);
        node  node = new node(dulieu);
        return node;
    }

    void trongKho(String loai,int ma,String ten,double gia,int soluong,String chuoiNgay) throws ParseException{
        Date ngay = chuyenChuoiSangNgay(chuoiNgay);
        hanhhoa duLieu = new hanhhoa(loai, ma, ten, gia, soluong, ngay);
        node node = new node(duLieu);
        if(head==null){
            head=node;
            tail=node;
        }
        else{
            tail.next=node;
            tail=node;
        }
    }

    Date chuyenChuoiSangNgay(String chuoiNgay) throws ParseException{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = simpleDateFormat.parse(chuoiNgay);
        return date;
    }

    void them() throws ParseException{
        node node = dienThongTin();
        if(head==null){
            head=node;
            tail=node;
        }
        else{
            tail.next=node;
            tail=node;
        }
    }

    void xoa(node current){
        if(current==head){
            head=head.next;
        }
        else if(current==tail){
            current = head;
            while(current!=null){
                if(current.next==tail){
                    tail=current;
                    tail.next=null;
                    break;
                }
                current=current.next;
            }
        }
        else{
            node previous=head;
            while(previous!=null){
                if(previous.next==current){
                    break;
                }
                previous=previous.next;
            }
            current=current.next;
            previous.next=current;
        }
        System.out.println("Đã xoá sản phẩm trên");
    }

    void doiCho(node mot, node hai){
        node ba= new node();
        ba.data=mot.data;
        mot.data=hai.data;
        hai.data=ba.data;
    }


    boolean khoRong(){
        boolean rong = false;
        if(head==null){
            System.out.println("Kho rỗng");
            rong=true;
        }
        return rong;
    }

    void inThongTin(){
        if(khoRong()==true){
        }
        else{
            node current=head;
            while(current!=null){
                current.data.inThongTin();
                current=current.next;
            }
        }
    }


    void sapXepTangDanTheoMa(){
        node current = head;
        node check;
        node save;
        while(current!=null){
            check=current;
            save=current;
            while(check!=null){
                if(check.data.id<save.data.id){
                    save=check;
                }
                check=check.next;
            }
            doiCho(current, save);
            current=current.next;
        }
    }

    node timKiemTheoTen(String ten){
        node current = head;
        if(khoRong()==true){

        }
        else{
            while(current!=null){
                if(current.data.name.equals(ten)){
                    current.data.inThongTin();
                    return current;
                }
                current=current.next;
            }
        }
        System.out.println("Không tìm thấy");
        return null;
    }

    node timKiemTheoMa(int ma){
        sapXepTangDanTheoMa();
        node left=head;
        node right=tail;
        node current;
        int dem;
        while(left!=right){
            current=left;
            dem=1;
            while(current!=right){
                dem++;
                current=current.next;
            }
            dem=(dem-1)/2;
            current=left;
            for(int i=1;i<=dem;i++){
                current=current.next;
            }
            if(current.data.id==ma){
                current.data.inThongTin();
                return current;
            }
            if(current.data.id<ma){
                left=current.next;
            }
            else{
                current=left;
                while(current.next!=right){
                    current=current.next;
                }
                right=current;
            }
        }
        current=left;
        if(current.data.id==ma){
            current.data.inThongTin();
            return current;
        }
        System.out.println("Không tìm thấy");
        return null;
    }


    void sua(node current)throws ParseException{
        System.out.print("Nhập loại ( thuc pham/sanh su/dien may ): ");
        String loai = kitu.nextLine();
        System.out.print("Tên: ");
        String ten = kitu.nextLine();
        System.out.print("Giá: ");
        double gia = so.nextDouble();
        System.out.print("Số lượng: ");
        int soluong = so.nextInt();
        System.out.print("Ngày nhập kho ( dd/mm/yyyy ): ");
        String chuoiNgay = kitu.nextLine();
        Date ngay = chuyenChuoiSangNgay(chuoiNgay);
        current.data.type=loai;
        current.data.name=ten;
        current.data.price=gia;
        current.data.amount=soluong;
        current.data.date=ngay;
        System.out.println("Đã sửa thông tin");
        current.data.inThongTin();
    }

    void suaTheoMa(int ma) throws ParseException{
        node current = timKiemTheoMa(ma);
        if(current==null){

        }
        else{
            sua(current);
        }
    }

     

    void xoaTheoMa(int ma){
        node current = timKiemTheoMa(ma);
        if(current==null){

        }
        else{
            xoa(current);
        }
    }

    void xoaTheoTen(String ten){
        node current=timKiemTheoTen(ten);
        if(current==null){

        }
        else{
            xoa(current);
        }
    }


    void sapXepTangDanTheoGiaVaLoai(){
        node current = head;
        node check;
        node save;
        while(current!=null){
            check=current;
            save=current;
            while(check!=null){
                if(check.data.price<save.data.price && check.data.type.equals(save.data.type)){
                    save=check;
                }
                check=check.next;
            }
            doiCho(current, save);
            current=current.next;
        }
    }

    void sapXepTangDanTheoGia(){
        node current = head;
        node check;
        node save;
        while(current!=null){
            check=current;
            save=current;
            while(check!=null){
                if(check.data.price<save.data.price){
                    save=check;
                }
                check=check.next;
            }
            doiCho(current, save);
            current=current.next;
        }
    }

    void sapXepGiamDanTheoGiaVaLoai(){
        node current = head;
        node check;
        node save;
        while(current!=null){
            check=current;
            save=current;
            while(check!=null){
                if(check.data.price>save.data.price && check.data.type.equals(save.data.type)){
                    save=check;
                }
                check=check.next;
            }
            doiCho(current, save);
            current=current.next;
        }
    }

    void sapXepGiamDanTheoGia(){
        node current = head;
        node check;
        node save;
        while(current!=null){
            check=current;
            save=current;
            while(check!=null){
                if(check.data.price>save.data.price){
                    save=check;
                }
                check=check.next;
            }
            doiCho(current, save);
            current=current.next;
        }
    }

    void sapXepTangDanTheoNgayVaLoai(){
        node current = head;
        node check;
        node save;
        while(current!=null){
            check=current;
            save=current;
            while(check!=null){
                if(check.data.date.before(save.data.date) && check.data.type.equals(save.data.type)){
                    save=check;
                }
                check=check.next;
            }
            doiCho(current, save);
            current=current.next;
        }
    }

    void sapXepTangDanTheoNgay(){
        node current = head;
        node check;
        node save;
        while(current!=null){
            check=current;
            save=current;
            while(check!=null){
                if(check.data.date.before(save.data.date)){
                    save=check;
                }
                check=check.next;
            }
            doiCho(current, save);
            current=current.next;
        }
    }

    void sapXepGiamDanTheoNgayVaLoai(){
        node current = head;
        node check;
        node save;
        while(current!=null){
            check=current;
            save=current;
            while(check!=null){
                if(check.data.date.after(save.data.date) && check.data.type.equals(save.data.type)){
                    save=check;
                }
                check=check.next;
            }
            doiCho(current, save);
            current=current.next;
        }
    }

    void sapXepGiamDanTheoNgay(){
        node current = head;
        node check;
        node save;
        while(current!=null){
            check=current;
            save=current;
            while(check!=null){
                if(check.data.date.after(save.data.date)){
                    save=check;
                }
                check=check.next;
            }
            doiCho(current, save);
            current=current.next;
        }
    }

    void suaTheoTen(String ten) throws ParseException{
        node current = timKiemTheoTen(ten);
        if(current==null){

        }
        else{
            sua(current);
        }

    }


    void ketQuaTimTheoGia(double gia){
        node current=head;
        boolean co=false;
        while(current!=null){
            if(current.data.price==gia){
                current.data.inThongTin();
                co=true;
            }
            current=current.next;
        }
        if(co==false){
            System.out.println("Không tìm thấy");
        }
    }


    void ketQuaTimTheoKhoangGia(double giaDau, double giaSau){
        node current=head;
        boolean co=false;
        while(current!=null){
            if(current.data.price>=giaDau&&current.data.price<=giaSau){
                current.data.inThongTin();
                co=true;
            }
            current=current.next;
        }
        if(co==false){
            System.out.println("Không tìm thấy");
        }
    }

    void ketQuaTimTheoLoai(String loai){
        node current = head;
        if(khoRong()==true){

        }
        else{
            boolean co=false;
            while(current!=null){
                if(current.data.type.equals(loai)){
                    current.data.inThongTin();
                    co=true;
                }
                current=current.next;
            }
            if(co==false){
                System.out.println("Không tìm thấy");
            }
        }
    }

    void ketQuaTimTheoNgay(Date ngay){
        node current=head;
        boolean co=false;
        while(current!=null){
            if(current.data.date.equals(ngay)){
                current.data.inThongTin();
                co=true;
            }
            current=current.next;
        }
        if(co==false){
            System.out.println("Không tìm thấy");
        }
    }


    void ketQuaTimTheoKhoangNgay(Date ngayDau, Date ngaySau){
        node current=head;
        boolean co=false;
        while(current!=null){
            if((current.data.date.equals(ngayDau)||current.data.date.after(ngayDau))&&(current.data.date.equals(ngaySau)||current.data.date.before(ngaySau))){
                current.data.inThongTin();
                co=true;
            }
            current=current.next;
        }
        if(co==false){
            System.out.println("Không tìm thấy");
        }
    }

    void thongKe(){
        node current=head;
        int tongHangHoa=0;
        double tongGiaTri=0;
        int tongThucPham=0;
        int tongSanhSu=0;
        int tongDienMay=0;
        if(head==null){

        }
        else{
            while(current!=null){
                tongHangHoa++;
                tongGiaTri=tongGiaTri+(current.data.price*current.data.amount);
                if(current.data.type.equals("thuc pham")){
                    tongThucPham++;
                }
                if(current.data.type.equals("sanh su")){
                    tongSanhSu++;
                }
                if(current.data.type.equals("dien may")){
                    tongDienMay++;
                }
                current=current.next;
            }
        }
        System.out.println("Tổng số lượng hàng hoá: "+tongHangHoa);
        System.out.println("Tổng giá trị nhập kho: "+tongGiaTri);
        System.out.println("Số lượng loại hàng thực phẩm: "+tongThucPham);
        System.out.println("Số lượng loại hàng sành sứ: "+tongSanhSu);
        System.out.println("Số lượng loại hàng điện máy: "+tongDienMay);
    }













}
