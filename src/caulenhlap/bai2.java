package caulenhlap;
import java.util.*;
public class bai2 {
    public static boolean isPrime(int number) {
        if (number < 2)
            return false;
        if (number == 2 || number == 3) return true;
        if (number % 2 == 0 || number % 3 == 0) return false;

        for (int i = 5; i <= Math.sqrt(number); i = i + 6) {
            if (number % i == 0) return false;
        }
        return true;

    }



    public static void main(String[] args) {

        System.out.println("Nhập một số: ");
        int number;
        Scanner scanner = new Scanner(System.in);
        number = Integer.parseInt(scanner.nextLine());
        scanner.close();
//
//        if (isPrime(number))
//            System.out.println("Đúng");
//        else{
//            System.out.println("Sai");
//        }

        // thực hiện hiện thỉ 20 số nguyên tố đầu tiên
        int count = 0;
        int i = 1;
        while(count<20){
            if (isPrime(i)){
                count++;
                System.out.print(i + "\t") ;
            }
            i++;

        }

    }
}
