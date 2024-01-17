package caulenhlap;

public class bai5 {
	    //Do để thực hiện in số chia hết cho cả 3 và 5, ta phải đặt yêu cầu đó đầu tiên
	public static void main(String[] args) {
        for (int i  = 1; i<=100; i++){
            if (i % 3 == 0 && i % 5 == 0)
                System.out.println("Hello World");
            else if (i % 5 == 0)
                System.out.println("World");
            else if ( i % 3 ==0 )
                System.out.println("Hello");
            else
                System.out.println(i);

        }
    }
}
