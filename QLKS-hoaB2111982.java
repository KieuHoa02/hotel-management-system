package CT206H;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.*;
public class QLKS {
	static Connection c = null;
    static Statement stmt = null;
    static ResultSet rs = null;
    static CallableStatement cStmt = null;
    
	public static void main(String[] args) {
		try {
			//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Class.forName("com.mysql.jdbc.Driver").newInstance();		
			String url = "jdbc:mysql://localhost/QLKS?user=root&password=h09022003";
			c = DriverManager.getConnection(url);
			System.out.println("Connected nha");
			
			
			try {
				Statement stmt = c.createStatement();
				String sql = "select * from KHACH";
				ResultSet rs = stmt.executeQuery(sql);
				System.out.println("chay thanh cong");
				System.out.println("KHACH YEU CUA SHOP NE MN!!!!");
				while (rs.next()) {
					System.out.println("SO: " + rs.getInt("KID"));
					System.out.println("TEN KHACH: " + rs.getString("TEN"));
					System.out.println("SODT CUA KHACH NHA EM: " + rs.getString("Phone"));
					//System.out.println("SO: " + rs.getInt("KID"));
				}
				
			} catch (SQLException hihi) {
				System.out.println("chay chua duoc" + hihi.getMessage());
				
			}
			
			
			
		} catch (Exception e) {
			System.out.println("chua ket noi duoc: " + e.getMessage());
		}
		menuchinh();
	
	}
//	try {
//		Statement stmt = c.createStatement();
//		String sql = "select * from KHACH";
//		ResultSet rs = stmt.executeQuery(sql);
//		System.out.println("chay thanh cong");
//		System.out.println("KHACH YEU CUA SHOP NE MN!!!!");
//		while (rs.next()) {
//			System.out.println("SO: " + rs.getInt("KID"));
//			System.out.println("TEN KHACH: " + rs.getString("TEN"));
//			System.out.println("SODT CUA KHACH NHA EM: " + rs.getString("Phone"));
//			//System.out.println("SO: " + rs.getInt("KID"));
//		}
//		
//	} catch (SQLException hihi) {
//		System.out.println("chay chua duoc" + hihi.getMessage());
//		
//	}
	public static void menuchinh(){
        System.out.println();
        System.out.println("+ - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -+");
        System.out.println("|                                                                  |");
        System.out.println("|                         HOTEL 'NGOI NHA'                         |");
        System.out.println("|                           XIN KINH CHAO                          |");
        System.out.println("+ - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -+");
        System.out.println("|                                                                  |");
        System.out.println("|          +===============+              +===============+        |");
        System.out.println("|      P:  |     PHONG     |          K:  |   KHACH HANG  |        |");
        System.out.println("|          +===============+              +===============+        |");
        System.out.println("|                                                                  |");
        System.out.println("|                                                                  |");
        System.out.println("|          +===============+              +===============+        |");
        System.out.println("|      B:  |   BOOKING     |          D:  |   DICH VU     |        |");
        System.out.println("|          +===============+              +===============+        |");
        System.out.println("|                                                                  |");
        System.out.println("|                         +===============+                        |");
        System.out.println("|                     T:  |     THOAT     |                        |");
        System.out.println("|                         +===============+                        |");
        System.out.println("|                                                                  |");
        System.out.println("+ - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -+");
		
        System.out.print("\n >>> ");
        Scanner sc = new Scanner(System.in);
        char x = sc.nextLine().charAt(0);
        switch(x){
        case 'P':
            subMenu('P');
        case 'K': 
            subMenu('K');
        case 'B':
            subMenu('B');
        case 'D':
            subMenu('D');
        case 'T':
            System.out.println("====================================================== Ket thuc chuong trinh ... ======================================================");
            break;
        default:
            System.out.print("Lua chon khong phu hop.");
    }
}
	public static void subMenu(char t){
        if (t=='P'){
            System.out.println();
            System.out.println("+============= PHONG ================+");
            System.out.println("|         1. Xem DS PHONG            |");
            System.out.println("|         2. Them phong              |");
            System.out.println("|         3. Thay doi gia            |");
            System.out.println("+====================================+");
            System.out.println("                           E: Tro ve");
        
        System.out.print("\n>>> ");
        Scanner sc = new Scanner(System.in);
        char x = sc.nextLine().charAt(0);
        
        switch(x){
        case '1':
        	try {
        		stmt = c.createStatement();
				String sql = "select * from Phong";
				rs = stmt.executeQuery(sql);
				//System.out.println("chay thanh cong");
				System.out.println("BEN EM CON PHONG NHE KHACH");
				while (rs.next()) {
					System.out.println("ID: " + rs.getInt("PID"));
					System.out.println("SO: " + rs.getInt("SOPHONG"));
					System.out.println("LOAI: " + rs.getString("LOAIPHONG"));
					System.out.println("GIA: " + rs.getFloat("gia"));
					//System.out.println("SO: " + rs.getInt("KID"));
				}
				
			} catch (SQLException hihi) {
				System.out.println("chay chua duoc" + hihi.getMessage());
				
			}
            sc.nextLine();
            subMenu('P');
        case '2':
        	inputPhong();
        	sc.nextLine();
            subMenu('P');
        case '3': 
        	UPGIAPHONG();
        	sc.nextLine();
            subMenu('P');
        case 'E':
            menuchinh();
        default:
            System.out.print("Lua chon khong phu hop!");
            subMenu('P');
    }
    }
        if (t=='K'){
            System.out.println();
            System.out.println("+============= KHACH ================+");
            System.out.println("|         1. Xem DS KHACH            |");
            System.out.println("|         2. Them KHACHHANG          |");
            System.out.println("|         3. Xem phong phu hop       |");
            System.out.println("+====================================+");
            System.out.println("                           E: Tro ve  ");
            System.out.print("\n>>> ");
            Scanner sc = new Scanner(System.in);
            char x = sc.nextLine().charAt(0);
            switch(x){
            case '1':
            	try {
    				stmt = c.createStatement();
    				String sql = "select * from KHACH";
    				ResultSet rs = stmt.executeQuery(sql);
    				System.out.println("chay thanh cong");
    				System.out.println("KHACH YEU CUA SHOP NE MN!!!!");
    				while (rs.next()) {
    					System.out.println("SO: " + rs.getInt("KID"));
    					System.out.println("TEN KHACH: " + rs.getString("TEN"));
    					System.out.println("SODT CUA KHACH NHA EM: " + rs.getString("Phone"));
    					//System.out.println("SO: " + rs.getInt("KID"));
    				}
    				
    			} catch (SQLException hihi) {
    				System.out.println("chay chua duoc" + hihi.getMessage());
    				
    			}
                sc.nextLine();
                subMenu('K');
            case '2':
            	inputKhach();
            	sc.nextLine();
                subMenu('K');
            case '3': 
            	chon();
            	sc.nextLine();
                subMenu('K');
            case 'E':
                menuchinh();
            default:
                System.out.print("Lua chon khong phu hop!");
                subMenu('K');
        }
     
    }
        if (t=='B'){
            System.out.println();
            System.out.println("+============= BOOKINGS =============+");
            System.out.println("|         1. DAT PHONG               |");
            System.out.println("|         2. XOA BOOKING             |");
            System.out.println("+====================================+");
            System.out.println("                           E: Tro ve  ");
            System.out.print("\n>>> ");
            Scanner sc = new Scanner(System.in);
            char x = sc.nextLine().charAt(0);
            switch(x){
            case '1':
            	inputBOOKINGS();
                sc.nextLine();
                subMenu('B');
            case '2':
            	xoabook();
            	sc.nextLine();
                subMenu('B');
            case 'E':
                menuchinh();
            default:
                System.out.print("Lua chon khong phu hop!");
                subMenu('B');
        }
     
    }
        if (t=='D'){
            System.out.println();
            System.out.println("+============= DV ================+");
            System.out.println("|                                 |");
            System.out.println("|         1. XEM DV               |");
            System.out.println("|                                 |");
            System.out.println("+=================================+");
            System.out.println("                          E: Tro ve");
            System.out.print("\n>>> ");
            Scanner sc = new Scanner(System.in);
            char x = sc.nextLine().charAt(0);
            switch(x){
            case '1':
            	try {
    				stmt = c.createStatement();
    				String sql = "select * from DICHVU";
    				ResultSet rs = stmt.executeQuery(sql);
    				System.out.println("chay thanh cong");
    				System.out.println("DICH VU NHA EM NE KHACH YEU!!!!");
    				while (rs.next()) {
    					System.out.println("SO DV: " + rs.getInt("DID"));
    					System.out.println("TEN DV: " + rs.getString("TENDV"));
    					System.out.println("GIA THEM: " + rs.getString("GIATHEM"));
    					//System.out.println("SO: " + rs.getInt("KID"));
    				}
    				
    			} catch (SQLException hihi) {
    				System.out.println("chay chua duoc" + hihi.getMessage());
    				
    			}
                sc.nextLine();
                subMenu('D');

            case 'E':
                menuchinh();
            default:
                System.out.print("Lua chon khong phu hop!");
                sc.nextLine();
                subMenu('D');
        }
     
    }
        
        
	}
	public static void inputPhong(){
	       ResultSet rs2 = null;
	        try {
	            stmt = c.createStatement();
	            cStmt = c.prepareCall("{call ins_phong(?,?,?,?)}");
	            Scanner sc = new Scanner(System.in);
	            System.out.println("Nhap phong moi: ");
	            System.out.print("ID PHONG: ");
	            int mphong = sc.nextInt();        
	            System.out.print("SO PHONG: ");
	            int giaphong = sc.nextInt();
	            sc.nextLine();
	            System.out.print("LOAI PHONG: ");
	            String mloai = sc.nextLine();
	            System.out.print("GIA: ");
	            float mtro = sc.nextFloat();
	            cStmt.setInt(1, mphong);
	            cStmt.setInt(2, giaphong);
	            cStmt.setString(3, mloai);
	            cStmt.setFloat(4, mtro);

	            rs = cStmt.executeQuery();

	            System.out.print("Them phong thanh cong!!!");
	        } catch (SQLException ex){ //xử lý ngoại lệ
	            System.out.println("SQLException: " + ex.getMessage());
	        }
	}
	public static void inputBOOKINGS(){
	       ResultSet rs2 = null;
	        try {
	            stmt = c.createStatement();
	            cStmt = c.prepareCall("{call booking(?,?,?,?,?,?)}");
	            
	            Scanner sc = new Scanner(System.in);
	            System.out.println("Nhap Khach moi: ");
	            System.out.print("ID Khach: ");
	            int KID = sc.nextInt();        
	            System.out.print("Ten Khach: ");
	            String ten = sc.nextLine();
	            sc.nextLine();
	            System.out.print("Email: ");
	            String email = sc.nextLine();
	            System.out.print("Dien thoai: ");
	            String dt = sc.nextLine();
	            System.out.print("ID PHONG: ");
	            int mphong = sc.nextInt(); 
	            System.out.print("ID Book: ");
	            int mbook = sc.nextInt();
	            cStmt.setInt(1, KID);
	            cStmt.setString(2, ten);
	            cStmt.setString(3, email);
	            cStmt.setString(4, dt);
	            cStmt.setInt(5, mphong);
	            cStmt.setInt(6, mbook);
	            
	            rs = cStmt.executeQuery();

	            System.out.print("Them Book thanh cong!!!");
	        } catch (SQLException ex){ //xử lý ngoại lệ
	            System.out.println("SQLException: " + ex.getMessage());
	        }
	}
	public static void inputKhach(){
	       ResultSet rs2 = null;
	        try {
	            stmt = c.createStatement();
	            cStmt = c.prepareCall("{call ThemKhach(?,?,?,?)}");
	            Scanner sc = new Scanner(System.in);
	            System.out.println("Nhap Khach moi: ");
	            System.out.print("ID Khach: ");
	            int KID = sc.nextInt();        
	            System.out.print("Ten Khach: ");
	            String ten = sc.nextLine();
	            sc.nextLine();
	            System.out.print("Email: ");
	            String email = sc.nextLine();
	            System.out.print("Dien thoai: ");
	            String dt = sc.nextLine();
	            cStmt.setInt(1, KID);
	            cStmt.setString(2, ten);
	            cStmt.setString(3, email);
	            cStmt.setString(4, dt);
	            rs = cStmt.executeQuery();

	            System.out.print("Them Khach thanh cong!!!");
	        } catch (SQLException ex){ //xử lý ngoại lệ
	            System.out.println("SQLException: " + ex.getMessage());
	        }
	}
	public static void UPGIAPHONG(){
	       try {
	            ResultSet rs2 = null;
	            
	            stmt = c.createStatement();
	            cStmt = c.prepareCall("{call update_gia(?,?)}");
	               
	            Scanner sc = new Scanner(System.in);
	            String maphong = sc.nextLine();
	            System.out.print("Ma phong: ");
	            maphong = sc.nextLine();
	               
	            System.out.println("\nCap nhat gia phong " + maphong);
	               
	            cStmt.setString(1, maphong);
	            System.out.print("LEN TIEN: ");
	            int chisoTien = sc.nextInt();
	            cStmt.setInt(2, chisoTien);
	  
	            rs = cStmt.executeQuery();
	            stmt = c.createStatement();
	            rs2 = stmt.executeQuery("SELECT * FROM phong");

	            System.out.print("-------------------------");
	            System.out.println("\nDa cap nhat dien nuoc phong " + maphong);

	            }
	            catch (SQLException ex){ //xử lý ngoại lệ
	                System.out.println("SQLException: " + ex.getMessage());
	            }
	    }
	public static void xoabook(){
	       try {
	            ResultSet rs2 = null;
	            
	            stmt = c.createStatement();
	            cStmt = c.prepareCall("{call XoaBooking(?)}");
	               
	            Scanner sc = new Scanner(System.in);
	            int mabook = sc.nextInt();
	            System.out.print("Ma phong: ");
	            mabook = sc.nextInt();
	               
	            System.out.println("\nXOA BOOKING có ID " + mabook);
	               
	            cStmt.setInt(1, mabook);
	            rs = cStmt.executeQuery();
	            
	            stmt = c.createStatement();
	            rs2 = stmt.executeQuery("SELECT * FROM BOOKINGS");

	            System.out.print("-------------------------");
	            System.out.println("\nDa XOA BOOKING CO MA: " + mabook);

	            }
	            catch (SQLException ex){ //xử lý ngoại lệ
	                System.out.println("SQLException: " + ex.getMessage());
	            }
	    }
	
	
	public static void chon(){
	       try {
	    	   stmt = c.createStatement();
	    	   String sql = "select * from PHONG";
	    	   Scanner sc = new Scanner(System.in);
	    	   System.out.print("ban co bao nhiu tien: ");
	    	   float tien = sc.nextFloat();
	    	   sql = "select * from PHONG where gia <  '" + tien + " ' ";
	    	   rs = stmt.executeQuery(sql);
	    	   while (rs.next()) {
					System.out.println("ID: " + rs.getInt("PID"));
					System.out.println("SO: " + rs.getInt("SOPHONG"));
					System.out.println("LOAI: " + rs.getString("LOAIPHONG"));
					System.out.println("GIA: " + rs.getFloat("gia"));
	            } }
	            catch (SQLException ex){ //xử lý ngoại lệ
	                System.out.println("SQLException: " + ex.getMessage());
	            }
	    }

}

