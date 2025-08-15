import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while(true){
            System.out.println("\n----- Lost And Found Portal -----");
            System.out.println("1.Add Item");
            System.out.println("2. Search Item");
            System.out.println("3. View All Items");
            System.out.println("4.Exit");
            System.out.println("Select an option: ");
            int select=scan.nextInt();scan.nextLine();
            try{
                switch (select) {
                    case 1:
                        addItem(scan);
                    case 2:
                        searchItem(scan);
                    case 3:
                        viewItem(scan);
                    case 4: {
                        System.out.println("Bye Bye!!");
                        return;
                    }
                    default:
                        System.out.println("Invalid select");
                }
            }catch(Exception e){
                System.out.println("Error: "+e.getMessage());
            }
        }
    }

    private static void addItem(Scanner scan) throws IOException {
        System.out.println("Enter Name: ");
        String name=scan.nextLine();
        System.out.println("Enter Details: ");
        String detail=scan.nextLine();
        System.out.println("Status(lost/found): ");
        String status=scan.nextLine();
        System.out.println("Enter Contact Information: ");
        String contact=scan.nextLine();
        details det=new details(name,detail,status,contact);
        file.saveDetail(det);
        System.out.println("Details Added Successfully");
    }

    private static void searchItem(Scanner scan) throws IOException {
        System.out.println("Enter keyword to search: ");
        String key=scan.nextLine().toLowerCase();
        List<details> detail=file.loadDetail();
        boolean found=false;

        for(details det:detail){
            if(det.name.toLowerCase().contains(key)){
                System.out.println(det);
                found=true;
            }
        }
        if(!found) System.out.println("No Matching Result Found");
    }

    private static void viewItem(Scanner scan) throws IOException {
        List<details> detail=file.loadDetail();
        if(detail.isEmpty()){
            System.out.println("No items recorded. ");
        }else{
            for(details det:detail){
                System.out.println(det);
            }
        }
    }
}