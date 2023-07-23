import java.util.*;
class courseWork{
	static Scanner input = new Scanner(System.in);
	static String[] ids = new String[0];
	static String[] names = new String[0];
	static String[] itemCate = new String[0];
	static String[][] items = new String[0][6];
	static String user = "danujav";
	static String pass = "1234";
	
	public static void main(String args[]){
		
		checkUserName();
		
	}
	
	public static void checkUserName(){
		
		System.out.println("+-----------------------------------------------------------------------+");
		System.out.println("|\t\t\t\tLOGIN PAGE\t\t\t\t|");
		System.out.println("+-----------------------------------------------------------------------+\n");
		
		do{
			System.out.print("User Name\t: ");
			String username = input.next();
			
			if(username.equals(user)){
				checkPass();
				break;
			}else{
				System.out.println("User name is invalid. Please Try Again!\n");
			}
			
		}while(true);
	}
	
	public static void checkPass(){
		
		do{
			System.out.print("\nPassword\t: ");
			String password = input.next();
			
			if(password.equals(pass)){
				managementSystem();
				break;
			}else
				System.out.println("Password is incorrect. Please Try Again!");
		}while(true);
	}
	
	public static void managementSystem(){
		
		System.out.print("\033c");
		System.out.println("+-----------------------------------------------------------------------+");
		System.out.println("|\t\tWELCOME TO IJSE STOCK MANAGEMENT SYSTEM\t\t\t|");
		System.out.println("+-----------------------------------------------------------------------+\n");
		
		System.out.print("[1] Change the Credentials\t\t");
		System.out.println("[2] Supplier Manage");
		System.out.print("[3] Stock Manage\t\t\t");
		System.out.println("[4] Log out");
		System.out.println("[5] Exit the System");
		
		System.out.print("\nEnter an option to continue > ");
		int opt = input.nextInt();
		
		if(opt == 1){
			System.out.print("\033c");
			System.out.println("+------------------------------------------------------------------------------+");
			System.out.println("|\t\t\t\tCREDETIAL MANAGE\t\t\t\t|");
			System.out.println("+------------------------------------------------------------------------------+\n");

			
			do{
				System.out.print("Please enter the user name to verify it's you: ");
				String user1 = input.next();
				
				if(user1.equals(user)){
					System.out.println("Hey " + user);
					
					changePass();
					break;
				}else
					System.out.println("Invalid user name. Try Again!\n");
			}while(true);
		}
		if(opt == 2){
			System.out.print("\033c");
			supplierManage();
		}
		if(opt == 3){
			System.out.print("\033c");
			stockManage();
		}
		if(opt == 4){
			System.out.print("\033c");
			checkUserName();
		}
		if(opt == 5){
			System.out.print("\033c");
		}
		
	}
	
	public static void changePass(){
		
		do{
			System.out.print("Enter your current password: ");
			String pw = input.next();
			
			if(pw.equals(pass)){
				System.out.print("Enter your new password: ");
				pass = input.next();
				
				System.out.print("\nPassword changed successfully! ");
				
				System.out.print("Do you want to go home page (Y/N) : ");
				char op = input.next().charAt(0);
				
				if((op == 'Y')||(op == 'y')){
					managementSystem();
					break;
				}
				else
					return;
				
			}else
				System.out.println("Password is incorrect. Please Try Again!\n");
		}while(true);
	}
	
	public static void supplierManage(){
		
		System.out.print("\033c");
		System.out.println("+-----------------------------------------------------------------------+");
		System.out.println("|\t\t\t\tSUPPLIER MANAGE\t\t\t\t|");
		System.out.println("+-----------------------------------------------------------------------+\n");

		
		System.out.print("[1] Add Supplier\t\t\t");
		System.out.println("[2] Update Supplier");
		System.out.print("[3] Delete Supplier\t\t\t");
		System.out.println("[4] View Supplier");
		System.out.print("[5] Search Supplier\t\t\t");
		System.out.println("[6] Home Page");
		
		System.out.print("\nEnter an option to continue > ");
		int opt = input.nextInt();
		
		if(opt == 1){
			addSupplier();
		}
		if(opt == 2){
			updateSupplier();
		}
		if(opt == 3){
			deleteSupplier();
		}
		if(opt == 4){
			viewSupplier();
		}
		if(opt == 5){
			searchSupplier();
		}
		if(opt == 6){
			managementSystem();
		}
		
	}
	
	public static void addSupplier(){
			System.out.print("\033c");
			System.out.println("+-----------------------------------------------------------------------+");
			System.out.println("|\t\t\t\tADD SUPPLIER\t\t\t\t|");
			System.out.println("+-----------------------------------------------------------------------+");

		L1:
		do {
			System.out.print("\nSupplier ID : ");
			String id = input.next();
			
			for (int i = 0; i < ids.length; i++) {
				if(id.equals(ids[i])) {
					System.out.println("Already exists. Try Another Supplier ID !");
					
					continue L1;
				}
			}
			ids = grow(ids);
			ids[ids.length - 1] = id;
			
			System.out.print("Supplier Name : ");
			String name = input.next();
			
			names = grow(names);
			names[names.length - 1] = name;
			
			System.out.print("Added Successfully.! ");
			
			System.out.print("Do you want to add another Supplier(Y/N)? ");
			char op = input.next().charAt(0);
			
			if((op == 'Y')||(op == 'y')){
				System.out.print("\033c");
				addSupplier();
			}else{
				supplierManage();
			}
			
		} while (true);
		
	}
	
	public static String[] grow(String[] sup) {
		
		String[] temp = new String[sup.length + 1];
		for (int i = 0; i < sup.length; i++) {
			temp[i] = sup[i];
		}
		return temp;
	}
	
	public static void updateSupplier(){
		
		System.out.print("\033c");
		System.out.println("+-----------------------------------------------------------------------+");
		System.out.println("|\t\t\t\tUPDATE SUPPLIER\t\t\t\t|");
		System.out.println("+-----------------------------------------------------------------------+");
		
		L2:
		do {
			System.out.print("\nSupplier ID : ");
			String id = input.next();
			
			for (int i = 0; i < ids.length; i++) {
				if(id.equals(ids[i])) {
					
					System.out.println("Supplier Name : " + names[i]);
					
					System.out.print("\nEnter the New Supplier Name : ");
					names[i] = input.next();
					
					System.out.print("Updated Successfully.! ");
					
					System.out.print("Do you want to update another Supplier(Y/N)? ");
					char op = input.next().charAt(0);
					
					if((op == 'Y')||(op == 'y')){
						System.out.print("\033c");
						updateSupplier();
					}else{
						supplierManage();
					}
				}else
					System.out.println("Can't Find Supplier ID. Try Again.!");
				
				break;
			}
			
		}while(true);
	}
	
	public static void deleteSupplier(){
		
		System.out.print("\033c");
		System.out.println("+-----------------------------------------------------------------------+");
		System.out.println("|\t\t\t\tDELETE SUPPLIER\t\t\t\t|");
		System.out.println("+-----------------------------------------------------------------------+");
		
		L2:
		do {
			System.out.print("\nSupplier ID : ");
			String id = input.next();
			
			for (int i = 0; i < ids.length; i++) {
				if(id.equals(ids[i])) {
					
					remove(id);
					
					System.out.print("Deleted Successfully.! ");
					
					System.out.print("Do you want to delete another Supplier(Y/N)? ");
					char op = input.next().charAt(0);
					
					if((op == 'Y')||(op == 'y')){
						System.out.print("\033c");
						deleteSupplier();
					}else{
						supplierManage();
					}
				}else{
					System.out.println("Can't Find Supplier ID. Try Again.!");
				}
				break;
			}
			
		}while(true);
	}
	
	public static void remove(String id) {
		
		String[] tempId = new String[ids.length - 1];
		String[] tempName = new String[names.length - 1];
		
		int index = -1;
		
		for (int i = 0,j = 0; i < ids.length; i++) {
			if(ids[i].equals(id)) {
				index = i;
				continue;
			}
			tempId[j++] = ids[i];
			
		}
		
		for (int i = 0,j = 0; i < names.length; i++) {
			if(i == index) {
				continue;
			}
			tempName[j++] = names[i];
		}
		ids = tempId;
		names = tempName;
		
	}
	
	public static void viewSupplier(){
		
		System.out.print("\033c");
		System.out.println("+-----------------------------------------------------------------------+");
		System.out.println("|\t\t\t\tVIEW SUPPLIER\t\t\t\t|");
		System.out.println("+-----------------------------------------------------------------------+");
		
		System.out.println("+---------------------------------------------------------------+");
		System.out.println("|\tSUPPLIER ID\t\t|\tSUPPLIER NAME\t\t|");
		System.out.println("+---------------------------------------------------------------+");
		
		for(int i=0; i < ids.length; i++){
			System.out.println("|\t\t" + ids[i] + "\t\t|\t\t" + names[i] + "\t\t|");
		}
		
		System.out.println("+---------------------------------------------------------------+");
		
		System.out.print("Do you want to go Supplier Manage Page(Y/N)? ");
		char op = input.next().charAt(0);
		
		if((op == 'Y')||(op == 'y')){
			System.out.print("\033c");
			supplierManage();
		}else{
			viewSupplier();
		}
	}
	
	public static void searchSupplier(){
		
		System.out.print("\033c");
		System.out.println("+-----------------------------------------------------------------------+");
		System.out.println("|\t\t\t\tSEARCH SUPPLIER\t\t\t\t|");
		System.out.println("+-----------------------------------------------------------------------+");
		
		L2:
		do {
			System.out.print("\nSupplier ID : ");
			String id = input.next();
			
			for (int i = 0; i < ids.length; i++) {
				if(id.equals(ids[i])) {
					
					System.out.println("Supplier Name : " + names[i]);
					
					System.out.print("Added Successfully.! ");
					
					System.out.print("Do you want to add another Find(Y/N)? ");
					char op = input.next().charAt(0);
					
					if((op == 'Y')||(op == 'y')){
						System.out.print("\033c");
						searchSupplier();
					}else{
						supplierManage();
					}
				}else{
					System.out.println("Can't Find Supplier ID. Try Again.!");
				}
				break;
			}
			
		}while(true);
	}
	
	public static void stockManage(){
		
		System.out.print("\033c");
		System.out.println("+-----------------------------------------------------------------------+");
		System.out.println("|\t\t\t\tSTOCK MANAGEMENT\t\t\t|");
		System.out.println("+-----------------------------------------------------------------------+\n");

		
		System.out.print("[1] Manage Item Categories\t\t\t");
		System.out.println("[2] Add Item");
		System.out.print("[3] Get Item Supplier Wise\t\t\t");
		System.out.println("[4] View Items");
		System.out.print("[5] Rank Item Per Unit Price\t\t\t");
		System.out.println("[6] Home Page");
		
		System.out.print("\nEnter an option to continue > ");
		int opt = input.nextInt();
		
		if(opt == 1){
			manageItemCategory();
		}
		if(opt == 2){
			addItems();
		}
		if(opt == 3){
			getItem();
		}
		if(opt == 4){
			viewItem();
		}
		if(opt == 5){
			rankItems();
		}
		if(opt == 6){
			managementSystem();
		}
		
	}
	
	public static void manageItemCategory(){
		
		System.out.print("\033c");
		System.out.println("+-----------------------------------------------------------------------+");
		System.out.println("|\t\t\t\tMANAGE ITEM CATEGORY\t\t\t|");
		System.out.println("+-----------------------------------------------------------------------+\n");

		
		System.out.print("[1] Add New Item Category\t\t\t");
		System.out.println("[2] Delete Item Category");
		System.out.print("[3] Update Item Category\t\t\t");
		System.out.println("[4] Stock Management");
		
		System.out.print("\nEnter an option to continue > ");
		int opt = input.nextInt();
		
		if(opt == 1){
			addItemCategory();
		}
		if(opt == 2){
			deleteItemCate();
		}
		if(opt == 3){
			updateItemCate();
		}
		if(opt == 4){
			stockManage();
		}
		
	}
	
	public static void addItemCategory(){
		
		System.out.print("\033c");
		System.out.println("+-----------------------------------------------------------------------+");
		System.out.println("|\t\t\t\tADD ITEM CATEGORY\t\t\t|");
		System.out.println("+-----------------------------------------------------------------------+");

		L1:
		do {
			System.out.print("\nEnter the New Item Category : ");
			String item = input.next();
			
			for (int i = 0; i < itemCate.length; i++) {
				if(item.equals(itemCate[i])) {
					System.out.println("Already exists. Try Another Item Category !");
					
					continue L1;
				}
			}
			itemCate = grow(itemCate);
			itemCate[itemCate.length - 1] = item;
			
			System.out.print("Added Successfully.! ");
			
			System.out.print("Do you want to add another Category?(Y/N)? ");
			char op = input.next().charAt(0);
			
			if((op == 'Y')||(op == 'y')){
				System.out.print("\033c");
				addItemCategory();
			}else{
				manageItemCategory();
			}
			
		} while (true);
		
	}
	
	public static void updateItemCate(){
		
		System.out.print("\033c");
		System.out.println("+------------------------------------------------------------------------------+");
		System.out.println("|\t\t\t\tUPDATE ITEM CATEGORY\t\t\t\t|");
		System.out.println("+------------------------------------------------------------------------------+");
		
		L2:
		do {
			System.out.print("\nEnter Item Category : ");
			String item = input.next();
			
			for (int i = 0; i < itemCate.length; i++) {
				if(item.equals(itemCate[i])) {
					
					System.out.print("\nEnter the New Item Category : ");
					itemCate[i] = input.next();
					
					System.out.print("Updated Successfully.! ");
					
					System.out.print("Do you want to update another Item Category.?(Y/N)? ");
					char op = input.next().charAt(0);
					
					if((op == 'Y')||(op == 'y')){
						System.out.print("\033c");
						updateItemCate();
					}else{
						manageItemCategory();
					}
				}else
					System.out.println("Can't Find Item Category. Try Again.!");
				
				break;
			}
			
		}while(true);
	}
	
	public static void deleteItemCate(){
		
		System.out.print("\033c");
		System.out.println("+------------------------------------------------------------------------------+");
		System.out.println("|\t\t\t\tDELETE ITEM CATEGORY\t\t\t\t|");
		System.out.println("+------------------------------------------------------------------------------+");
		
		L2:
		do {
			System.out.print("\nEnter Item Category : ");
			String item = input.next();
			
			for (int i = 0; i < itemCate.length; i++) {
				if(item.equals(itemCate[i])) {
					
					removeCate(item);
					
					System.out.print("Deleted Successfully.! ");
					
					System.out.print("Do you want to delete another Item Category(Y/N)? ");
					char op = input.next().charAt(0);
					
					if((op == 'Y')||(op == 'y')){
						System.out.print("\033c");
						deleteItemCate();
					}else{
						manageItemCategory();
					}
				}else{
					System.out.println("Can't Find Item Category. Try Again.!");
				}
				break;
			}
			
		}while(true);
	}
	
	public static void removeCate(String item) {
		
		String[] tempCate = new String[itemCate.length - 1];
		
		for (int i = 0,j = 0; i < itemCate.length; i++) {
			if(itemCate[i].equals(item)) {
				continue;
			}
			tempCate[j++] = itemCate[i];
		}
		itemCate = tempCate;
		
	}
	
	public static void addItems(){
		
		System.out.print("\033c");
		System.out.println("+-----------------------------------------------------------------------+");
		System.out.println("|\t\t\t\tADD ITEM\t\t\t\t|");
		System.out.println("+-----------------------------------------------------------------------+\n");
		
		L1:
		while(true){
			if(itemCate.length == 0){
				System.out.println("OOPS! It seems that you don't have any Item Categories in the System.");
				
				System.out.print("Do you want to add a new Item Category?(Y/N)? ");
				char op = input.next().charAt(0);
				
				if((op == 'Y')||(op == 'y')){
					System.out.print("\033c");
					addItemCategory();
				}else{
					stockManage();
				}
			}
			if(ids.length == 0){
				System.out.println("OOPS! It seems that you don't have any Suppliers in the System.");
				
				System.out.print("Do you want to add a new Supplier?(Y/N)? ");
				char op = input.next().charAt(0);
				
				if((op == 'Y')||(op == 'y')){
					System.out.print("\033c");
					addSupplier();
				}else{
					stockManage();
				}
			}
			break L1;
		}
		items = grow2d(items);
		
		System.out.print("Item Code\t: ");
		String code = input.next();
		
		System.out.println("\nSupplier List:");
		System.out.println("+---------------+-----------------------+-----------------------+");
		System.out.println("|\t#\t|\tSUPPLIER ID\t|\tSUPPLIER NAME\t|");
		System.out.println("+---------------+-----------------------+-----------------------+");
		
		for(int i=0; i < ids.length; i++){
			System.out.println("|\t" + (i+1) + "\t|\t" + ids[i] + "\t\t|\t" + names[i] + "\t\t|");
		}
		System.out.println("+---------------+-----------------------+-----------------------+\n");
		
		System.out.print("Enter the Supplier Number: ");
		int supNum = input.nextInt();
		
		System.out.println("\nItem Categories:");
		System.out.println("+---------------+-----------------------+");
		System.out.println("|\t#\t|\tCATEGORY NAME\t|");
		System.out.println("+---------------+-----------------------+");
		
		for(int i=0; i < itemCate.length; i++){
			System.out.println("|\t" + (i+1) + "\t|\t" + itemCate[i] + "\t\t|");
		}
		System.out.println("+---------------+-----------------------+\n");
		
		System.out.print("Enter the Category Number: ");
		int cateNum = input.nextInt();
		
		System.out.print("\nDescription\t: ");
		String desc = input.next();
		
		System.out.print("Unit Price\t: ");
		String price = input.next();
		
		System.out.print("Qty on Hand\t: ");
		String qty = input.next();
		
		items[items.length - 1][0] = ids[supNum - 1];
		items[items.length - 1][1] = code;
		items[items.length - 1][2] = desc;
		items[items.length - 1][3] = price;
		items[items.length - 1][4] = qty;
		items[items.length - 1][5] = itemCate[cateNum - 1];
		
		System.out.print("Added Successfully.! ");
		
		System.out.print("Do you want to add another Item?(Y/N)? ");
		char op = input.next().charAt(0);
		
		if((op == 'Y')||(op == 'y')){
			System.out.print("\033c");
			addItems();
		}else{
			stockManage();
		}
	}
	
	public static String[][] grow2d(String[][] items) {
		
		String[][] temp = new String[items.length + 1][6];
		for(int i = 0; i < items.length; i++){
			for(int j = 0; j < items[i].length; j++){
				temp[i][j] = items[i][j];
			}
		}
		return temp;
	}
	
	public static void getItem(){
		
		System.out.print("\033c");
		System.out.println("+-----------------------------------------------------------------------+");
		System.out.println("|\t\t\tSEARCH ITEMS SUPPLIER WISE\t\t\t|");
		System.out.println("+-----------------------------------------------------------------------+\n");
		
		L2:
		do {
			System.out.print("Enter Supplier ID : ");
			String id = input.next();
			
			for (int i = 0; i < ids.length; i++) {
				if(id.equals(ids[i])) {
					
					System.out.println("Supplier Name : " + names[i]);
					
					System.out.println("+-----------------------+-----------------------+-----------------------+-----------------------+-----------------------+");
					System.out.println("|\tITEM CODE\t|\tDESTRIPTION\t|\tUNIT PRICE\t|\tQTY ON HAND\t|\tCATEGORY\t|");
					System.out.println("+-----------------------+-----------------------+-----------------------+-----------------------+-----------------------+");
					
					for(int j=0; j < items.length; j++){
						System.out.println("|\t" + items[i][1] + "\t\t|\t" + items[i][2] + "\t\t|\t" + items[i][3] + "\t\t|\t\t" + items[i][4] + "\t\t|\t" + items[i][5] + "\t\t|");
					}
					System.out.println("+-----------------------+-----------------------+-----------------------+-----------------------+-----------------------+");
					
					System.out.print("Search Successfully! ");
					
					System.out.print("Do you want to another Search?(Y/N)? ");
					char op = input.next().charAt(0);
					
					if((op == 'Y')||(op == 'y')){
						System.out.print("\033c");
						getItem();
					}else{
						stockManage();
					}
				}else{
					System.out.println("Can't Find Supplier ID. Try Again.!");
				}
			}
			
		}while(true);
	}
	
	public static void viewItem(){
		
		System.out.print("\033c");
		System.out.println("+-----------------------------------------------------------------------+");
		System.out.println("|\t\t\t\tVIEW ITEMS\t\t\t\t|");
		System.out.println("+-----------------------------------------------------------------------+");
		
		for(int i=0; i < (itemCate.length); i++){
			
			System.out.println("\n" + itemCate[i] + ": ");
			
				System.out.println("+---------------+---------------+---------------+---------------+--------------+");
				System.out.println("|\tS ID\t|\tCODE\t|\tDESC\t|\tPRICE\t|\tQTY\t|");
				System.out.println("+---------------+---------------+---------------+---------------+--------------+");
				
				for(int j=0; j < items.length; j++){
					if(itemCate[i].equals(items[j][5])){
						
						System.out.println("|\t" + items[j][0] + "\t|\t" + items[j][1] + "\t|\t" + items[j][2] + "\t|\t" + items[j][3] + "\t|\t" + items[j][4] + "\t|");
					}
				}
				
				System.out.println("+---------------+---------------+---------------+---------------+--------------+");
		}
		
		System.out.print("Do you want to go Stock Manage Page(Y/N)? ");
		char op = input.next().charAt(0);
		
		if((op == 'Y')||(op == 'y')){
			System.out.print("\033c");
			stockManage();
		}else{
			viewItem();
		}
		
	}
	
	public static void rankItems(){
		
		System.out.print("\033c");
		System.out.println("+-----------------------------------------------------------------------+");
		System.out.println("|\t\t\t\tRANKED UNIT PRICE\t\t\t|");
		System.out.println("+-----------------------------------------------------------------------+\n");
		
		System.out.println("+---------------+---------------+---------------+---------------+--------------+----------------+");
		System.out.println("|\tS ID\t|\tCODE\t|\tDESC\t|\tPRICE\t|\tQTY\t|\tCAT\t|");
		System.out.println("+---------------+---------------+---------------+---------------+--------------+----------------+");
		
		sortArray();
		
		for(int i=0; i < items.length; i++){
			System.out.println("|\t" + items[i][0] + "\t|\t" + items[i][1] + "\t|\t" + items[i][2] + "\t|\t" + items[i][3] + "\t|\t" + items[i][4] + "\t|\t" + items[i][5] + "\t|");
		}
		System.out.println("+---------------+---------------+---------------+---------------+--------------+----------------+");
		
		System.out.print("Do you want to go Stock Manage Page(Y/N)? ");
		char op = input.next().charAt(0);
		
		if((op == 'Y')||(op == 'y')){
			System.out.print("\033c");
			stockManage();
		}else{
			rankItems();
		}
		
	}
	
	public static void sortArray(){
		
		for(int i = 0; i<items.length; i++){
			for(int j = 0; j<(items.length - 1); j++){
				if(Integer.parseInt(items[j][3]) > Integer.parseInt(items[j+1][3])){
					String[] temp = items[j];
					items[j] = items[j+1];
					items[j+1] = temp;
					
				}
			}
		}
	}

}
