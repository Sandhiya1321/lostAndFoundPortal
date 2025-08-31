import java.util.Scanner;
import java.sql.*;

public class Main {
    private static String url = "jdbc:mysql://127.0.0.1:3306/lostfoundportal";
    private static String user = "root";
    private static String password = "sandhiya1312";
    private static Connection connect;
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        try {
            connect = DriverManager.getConnection(url, user, password);
            System.out.println("✅ connected to database");
            int choice;
            do {
                System.out.println("\n----- Lost And Found Portal -----");
                System.out.println("1.Add Item");
                System.out.println("2. View All Items");
                System.out.println("3. Search Item");
                System.out.println("4.Exit");
                System.out.println("Select an option: ");
                choice = scan.nextInt();
                scan.nextLine();
                switch (choice) {
                    case 1:
                        addItem();
                    case 2:
                        searchItem();
                    case 3:
                        viewItem();
                    case 4: {
                        System.out.println("Bye Bye!!");
                        return;
                    }
                    default:
                        System.out.println("Invalid select");
                }
            }
            while (choice != 4);
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
    }
    }
        private static void addItem() throws SQLException {
            System.out.println("Enter Name: ");
            String name = scan.nextLine();
            System.out.println("Enter description: ");
            String description = scan.nextLine();
            System.out.println("Status(lost/found): ");
            String status = scan.nextLine();
            System.out.println("location: ");
            String location = scan.nextLine();
            System.out.println("Enter Contact Information: ");
            String contact = scan.nextLine();
            System.out.println("Enter date(MM-DD-YYYY): ");
            String date = scan.nextLine();
            String sql = "INSERT INTO items(name,description,status,location,contactdetails,date)VALUES(?,?,?,?,?,?,?)";
            PreparedStatement pst = connect.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, description);
            pst.setString(3, status);
            pst.setString(4, location);
            pst.setString(5, contact);
            pst.setString(6, date);
            int rows = pst.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ item added Successfully");
            }
        }

        private static void searchItem() throws SQLException {
            System.out.println("Enter item name to search: ");
            String search = scan.nextLine();
            String sql = "SELECT * FROM items WHERE name LIKE ? OR status Like ?";
            PreparedStatement pst = connect.prepareStatement(sql);
            pst.setString(1, "%" + search + "%");
            pst.setString(2, "%" + search + "%");
            ResultSet rs = pst.executeQuery();
            boolean found = false;
            while (rs.next()) {
                System.out.println("ID:" + rs.getInt("id"));
                System.out.println("Name:" + rs.getString("name"));
                System.out.println("Description:" + rs.getString("description"));
                System.out.println("Status:" + rs.getString("status"));
                System.out.println("Location:" + rs.getString("location"));
                System.out.println("Contact Details:" + rs.getString("contactdetails"));
                System.out.println("Date:" + rs.getString("date"));
                System.out.println("---------------------------------");
                found = true;
            }
            if (!found) {
                System.out.println("No matching item found😒.");
            }
        }

        private static void viewItem() throws SQLException {
            String sql="SELECT * FROM items";
            Statement st=connect.createStatement();
            ResultSet rs=st.executeQuery(sql);
            System.out.println("-----ALL ITEMS-----\n");
            while (rs.next()) {
                System.out.println("ID:" + rs.getInt("id"));
                System.out.println("Name:" + rs.getString("name"));
                System.out.println("Description:" + rs.getString("description"));
                System.out.println("Status:" + rs.getString("status"));
                System.out.println("Location:" + rs.getString("location"));
                System.out.println("Contact Details:" + rs.getString("contactdetails"));
                System.out.println("Date:" + rs.getString("date"));
                System.out.println("---------------------------------");

            }
        }
    }
