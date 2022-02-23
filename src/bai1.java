

import java.util.Scanner;

class sinhvien{
    String hoTen;
    Double diem;
    String hocLuc = "";

    public void setHocLuc(String hocluc) {
        this.hocLuc = hocluc;
    }

    public String showInfo() {
        return hoTen + " " + diem + " " + hocLuc;
    }
}
public class bai1 {
    sinhvien[] sv;

    public static void sapxep(sinhvien[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j < arr.length; j++){
                if(arr[i].diem > arr[j].diem){
                    sinhvien c;
                    c=arr[i];
                    arr[i]=arr[j];
                    arr[j]=c;
                }
            }
        }
    }
    public static void hocluc(sinhvien[] arr){
        for (sinhvien sv : arr) {
            if (sv.diem < 5) {
                sv.setHocLuc("Học lực yếu");
            } else if (sv.diem < 6.5) {
                sv.setHocLuc("Học lực trung bình");
            } else if (sv.diem < 7.5) {
                sv.setHocLuc("Học lực khá");
            } else if (sv.diem < 9) {
                sv.setHocLuc("Học lực giỏi");
            } else {
                sv.setHocLuc("Học lực xuất sắc");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n;

        System.out.print("Xin mời nhập số học sinh: ");
        n = sc.nextInt();

        sinhvien[] SV = new sinhvien[n];

        for(int i = 0; i < n; i++){
            sinhvien sv = new sinhvien();
            System.out.printf("Học sinh thứ %d: ",i+1);

            System.out.print("\n\tHọ và tên: ");
            sv.hoTen = sc.nextLine();

            System.out.print("\n\tĐiểm= ");
            sv.diem = sc.nextDouble();

            SV[i] = sv;
        }

        sapxep(SV);
        hocluc(SV);

        System.out.println("----------Xuất mảng-----------");
        for(int i = 0; i < n; i++){
            System.out.printf("Học sinh đứng thứ %d ",i+1);
            System.out.println(SV[i].showInfo());
        }
    }
}

