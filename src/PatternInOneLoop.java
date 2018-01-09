public class PatternInOneLoop {

    public static void main(String arg[]){
        int start_printer=0;
        for(int i=1;i<6;){
            if(start_printer<i){
                System.out.print("* ");
                start_printer++;
            }
            if(start_printer==i){
                System.out.println();
                start_printer = 0;
                i++;
            }
        }
    }
}
