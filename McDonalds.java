package com.pack3;

import java.util.Scanner;

public class McD {
	static Scanner sc = new Scanner(System.in);

	static String cartMeal[] = new String[50];
	static int cartQty[] = new int[50];
	static int cartPrice[] = new int[50];

	static int cartIndex = 0;
	static int cartBill = 0;
	static int item = 0;
	static int orderId = 1000;
	static {
		for (int i = 1; i <= 30; i++) {
			System.out.print(" ");
		}
		for (int i = 1; i <= 25; i++)
			System.out.print("🍔");
		System.out.println("");
		for (int i = 1; i <= 40; i++)
			System.out.print(" ");
		System.out.println("Welcome To McDonald's!!!     ");
		for (int i = 1; i <= 30; i++)
			System.out.print(" ");
		for (int i = 1; i <= 25; i++)
			System.out.print("🍔");

	}

	void addToCart(String meal, int quantity, int price) {

		McD.cartMeal[cartIndex] = meal;
		McD.cartQty[cartIndex] = quantity;
		McD.cartPrice[cartIndex] = price;

		McD.cartIndex++;
		McD.cartBill += quantity * price;
		item += quantity;

		System.out.println(item + " items | ₹" + cartBill);
	}

	void orderItem(String name, int price) {
		System.out.println("Enter quantity:");
		int qty = Integer.parseInt(sc.nextLine());
		addToCart(name, qty, price);

		System.out.println("Do you want more items(yes/no)?");
		String ch = sc.nextLine();
		switch (ch) {
		case "yes", "YES":
			menu();
			break;
		case "no", "NO":
			showCart();
			bill();
			break;
		}
	}

	void showCart() {
		for (int i = 1; i <= 70; i++) {
			System.out.print("*");
		}
		System.out.println();
		System.out.println("                             😁your cart😁                       ");
		System.out.println();
		for (int i = 1; i <= 70; i++) {
			System.out.print("*");
		}
		System.out.println();
		System.out.println("Meal                           quantity           price");
		System.out.println();
		for (int i = 0; i <= cartIndex - 1; i++) {
			System.out.println(cartMeal[i] + "  " + cartQty[i] + "             ₹" + cartPrice[i] * cartQty[i]);
		}
		for (int i = 1; i <= 70; i++) {
			System.out.print("*");
		}
		System.out.println();
		System.out.println("Total bill:                                        ₹" + cartBill);
		for (int i = 1; i <= 70; i++) {
			System.out.print("*");
		}
		System.out.println();
	}

	void bill() {
		System.out.println("\n----------Please enter your details!!!-----------\n");
		System.out.print("Enter your name:");
		String name = sc.nextLine();
		System.out.print("Enter mobile no.:");
		String mob = sc.nextLine();
		System.out.println("Select your order type:");
		System.out.println("1.Dine-In");
		System.out.println("2.TakeAway");
		int orderType = Integer.parseInt(sc.nextLine());
		if (orderType == 1) {
			customerInfo(name, mob, "Dine-In");
		} else {
			customerInfo(name, mob, "TakeAway");
		}

		if (cartBill >= 1000) {

			double dis = cartBill * 0.30;
			System.out.println("\nCongratulations!!! You got 30% off on your cart");

			System.out.println("Final Bill : ₹" + (cartBill - dis));

		} else if (cartBill >= 700) {

			double dis = cartBill * 0.10;
			System.out.println("\nCongratulations!!! You got 10% off on your cart");

			System.out.println("Final Bill : ₹" + (cartBill - dis));

		} else {

			System.out.println("Final Bill : ₹" + cartBill);
		}
		System.out.println("\nOrder Received ☑");
		System.out.println("We are Preparing your order now🕐");
		System.out.println("\nThank you for visiting McDonalds 🍔🍟💗🍔");
		System.out.println("Visit again😊!!!!");
	}

	String customerInfo(String name, String mob, String orderType) {
		System.out.println("              🔸Name:" + name);
		System.out.println("              📞Mobile No.:" + mob);
		System.out.println("              🔸OrderType:" + orderType);
		System.out.println("              🔸OrderId:" + ++orderId);

		return "";
	}

	void menu() {
		System.out.println("\nSelect Category\n");
		System.out.println("1 Veg");
		System.out.println("2 Non Veg");
		System.out.println("3 Coffee & Beverages");
		System.out.println("4 Desserts");
		System.out.println("5 Cart");
		System.out.println("6 Exit");

		int ch = Integer.parseInt(sc.nextLine());
		switch (ch) {

		case 1:
			veg();
			break;

		case 2:
			nonVeg();
			break;
		case 3:
			beverages();
			break;

		case 4:
			desserts();
			break;
		case 5:
			showCart();
			System.out.println("1.Want anything else?");
			System.out.println("2.Bill");
			int chh = Integer.parseInt(sc.nextLine());
			switch (chh) {
			case 1:
				menu();
				break;
			case 2:
				bill();
				break;

			}
			break;
		case 6:
			System.out.println("Thank you for visiting!");
			break;
		default:
			System.out.println("Invalid category");
			System.out.println("1.Go back to menu");
			System.out.println("2.Exit");
			int choice=Integer.parseInt(sc.nextLine());
			switch(choice) {
			case 1:menu();
			break;
			case 2:
				System.out.println("Thank you!!!!!!!");
				break;
			    
			}
		}
	}

	void veg() {
		System.out.println("\n---------☘️Veg Meals☘️-----------\n");
		System.out.println("    1.Sipper meals\n");
		System.out.println("    2.Protein plus & coke zero meals\n");
		System.out.println("    3.McSaver Combos\n");
		System.out.println("    4.Group sharing Combos\n");
		int choice = Integer.parseInt(sc.nextLine());
		switch (choice) {
		case 1:
			System.out.println("------------Sipper meals------------");
			System.out.println("1.Crispy veggie Burger            ₹327");
			System.out.println("2.McCheese Veg Burger             ₹389");
			System.out.println("3.McAloo Tikki Burger             ₹205");
			System.out.println("4.McVeggie Burger                 ₹309");
			System.out.println("5.Corn and Cheese Burger          ₹290");
			int sipCh = Integer.parseInt(sc.nextLine());

			switch (sipCh) {
			case 1:
				orderItem("Crispy veggie Burger               ", 327);
				break;
			case 2:
				orderItem("McCheese Veg Burger                ", 389);
				break;
			case 3:
				orderItem("McAloo Tikki Burger                ", 205);
				break;
			case 4:
				orderItem("McVeggie Burger                    ", 309);
				break;
			case 5:
				orderItem("Corn and Cheese Burger             ", 290);
				break;
			default:
				System.out.println("Invalid category");
				System.out.println("1.Go back to menu");
				System.out.println("2.Exit");
				int ch1=Integer.parseInt(sc.nextLine());
				switch(ch1) {
				case 1:menu();
				break;
				case 2:
					System.out.println("Thank you!!!!!!!");
					break;
				    
				}
			}
			break;
		case 2:
			System.out.println("-----------Protein plus & coke zero meals-------------\n");
			System.out.println("1.McSpicy Paneer Burger Protein Plus(30g)         ₹253");
			System.out.println("2.Crispy veggie Burger Protein Plus(20g)          ₹219");
			System.out.println("3.McSpicy Premium Burger Veg Protein Plus(33g)    ₹304");
			System.out.println("4.McSpicy Panner Burger Protein(37g)              ₹319");
			int protCh = Integer.parseInt(sc.nextLine());
			switch (protCh) {
			case 1:
				orderItem("McSpicy Paneer Protein(30g)        ", 253);
				break;
			case 2:
				orderItem("Crispy veggie Protein(20g)         ", 219);
				break;
			case 3:
				orderItem("McSpicy Premium Protein(33g)       ", 304);
				break;
			case 4:
				orderItem("McSpicy Panner Protein(37g)        ", 319);
				break;
			default:
				System.out.println("Invalid category");
				System.out.println("1.Go back to menu");
				System.out.println("2.Exit");
				int ch2=Integer.parseInt(sc.nextLine());
				switch(ch2) {
				case 1:menu();
				break;
				case 2:
					System.out.println("Thank you!!!!!!!");
					break;
				    
				}

			}
			break;
		case 3:
			System.out.println("-------------McSaver Combos------------\n");
			System.out.println("1.Crispy Veggie Burger+Peri Peri Fries(M)         ₹320");
			System.out.println("2.Choco Crunch Cookie+McVeggie Burger             ₹145");
			System.out.println("3.McAloo Tikki Burger+ cold Coffee                ₹251");
			System.out.println("4.Veg pizza McPuff + Choco Crunch Cookie          ₹109");
			int savCh = Integer.parseInt(sc.nextLine());
			switch (savCh) {
			case 1:
				orderItem("Crispy Veggie+Peri-Peri Fries      ", 320);
				break;
			case 2:
				orderItem("Choco Crunch Cookie+McVeggie       ", 145);
				break;
			case 3:
				orderItem("McAloo Tikki+cold Coffee           ", 251);
				break;
			case 4:
				orderItem("Veg pizza McPuff+Crunch Cookie     ", 109);
				break;
			default:
				System.out.println("Invalid category");
				System.out.println("1.Go back to menu");
				System.out.println("2.Exit");
				int ch3=Integer.parseInt(sc.nextLine());
				switch(ch3) {
				case 1:menu();
				break;
				case 2:
					System.out.println("Thank you!!!!!!!");
					break;
				    
				}
			}
			break;
		case 4:
			System.out.println("-----------Group sharing Combos-----------\n");
			System.out.println("1.veg☘️ Pizza McPuff Party Pack                     ₹499");
			System.out.println("2.Fries Party Pack + coke                         ₹899");
			System.out.println("3.McVeggie Party pack                             ₹1199");
			System.out.println("4.Big Group Party combo                           ₹856");
			int grpCh = Integer.parseInt(sc.nextLine());
			switch (grpCh) {
			case 1:
				orderItem("Veg Pizza McPuff Party Pack        ", 499);
				break;
			case 2:
				orderItem("Fries Party Pack + coke            ", 899);
				break;
			case 3:
				orderItem("McVeggie Party pack                ", 1199);
				break;
			case 4:
				orderItem("Big Group Party combo              ", 856);
				break;
			default:
				System.out.println("Invalid category");
				System.out.println("1.Go back to menu");
				System.out.println("2.Exit");
				int ch4=Integer.parseInt(sc.nextLine());
				switch(ch4) {
				case 1:menu();
				break;
				case 2:
					System.out.println("Thank you!!!!!!!");
					break;
				    
				}
			}
			break;

		}
	}

	void nonVeg() {
		System.out.println("\n-------------Non-veg Meals🍗----------");
		System.out.println("    1.Sipper meals\n");
		System.out.println("    2.Protein plus & coke zero meals\n");
		System.out.println("    3.Group sharing Combos\n");
		System.out.println("    4.McSaver Combos\n");
		int choice = Integer.parseInt(sc.nextLine());
		switch (choice) {
		case 1:
			System.out.println("---------------------Sipper meals----------------meals\n");
			System.out.println("1.Crispy Chicken Burger                   ₹367");
			System.out.println("2.McCheese Chicken Burger                 ₹389");
			System.out.println("3.Chicken Surprise Burger                 ₹238");
			System.out.println("4.Grilled Chicken and Cheese Burger       ₹309");
			int sipCh = Integer.parseInt(sc.nextLine());

			switch (sipCh) {
			case 1:
				orderItem("Crispy chicken Burger              ", 367);
				break;
			case 2:
				orderItem("McCheese chicken Burger            ", 389);
				break;
			case 3:
				orderItem("Chicken Surprise Burger            ", 238);
				break;
			case 4:
				orderItem("Grilled Chicken and Cheese Burger  ", 309);
				break;
			default:
				System.out.println("Invalid category");
				System.out.println("1.Go back to menu");
				System.out.println("2.Exit");
				int ch1=Integer.parseInt(sc.nextLine());
				switch(ch1) {
				case 1:menu();
				break;
				case 2:
					System.out.println("Thank you!!!!!!!");
					break;
				    
				}

			}

			break;
		case 2:
			System.out.println("-----------Protein plus & coke zero meals-------------\n");
			System.out.println("1.McEgg Burger (22g protein)              ₹118");
			System.out.println("2.McChicken Burger(26g protein)           ₹213");
			System.out.println("3.Premium Chicken Burger(37g protein      ₹287");
			int protCh = Integer.parseInt(sc.nextLine());
			switch (protCh) {
			case 1:
				orderItem("McEgg Burger(22g) Protein          ", 118);
				break;
			case 2:
				orderItem("McChicken Burger(26g) Protein      ", 213);
				break;
			case 3:
				orderItem("Premium Chicken Burger(37g)        ", 287);
				break;
			default:
				System.out.println("Invalid category");
				System.out.println("1.Go back to menu");
				System.out.println("2.Exit");
				int ch2=Integer.parseInt(sc.nextLine());
				switch(ch2) {
				case 1:menu();
				break;
				case 2:
					System.out.println("Thank you!!!!!!!");
					break;
				    
				}
			}
			break;

		case 3:
			System.out.println("-----------Group sharing Combos-----------\n");
			System.out.println("1.Chicken Burger + Cold Coffee             ₹267");
			System.out.println("2.Crispy Chicken+ McAloo Tikki             ₹256");
			System.out.println("3.Crispy Chicken Burger+Peri Peri Fries    ₹360");
			System.out.println("4.New McSaver Chicken Nuggets              ₹119");
			int grpCh = Integer.parseInt(sc.nextLine());
			switch (grpCh) {
			case 1:
				orderItem("Chicken Burger + Cold Coffee       ", 267);
				break;
			case 2:
				orderItem("Crispy Chicken+ McAloo Tikki       ", 256);
				break;
			case 3:
				orderItem("Crispy Chicken+Peri Peri Fries     ", 360);
				break;
			case 4:
				orderItem("New McSaver Chicken Nuggets        ", 119);
				break;
			default:
				System.out.println("Invalid category");
				System.out.println("1.Go back to menu");
				System.out.println("2.Exit");
				int ch3=Integer.parseInt(sc.nextLine());
				switch(ch3) {
				case 1:menu();
				break;
				case 2:
					System.out.println("Thank you!!!!!!!");
					break;
				    
				}
			}
			break;
		case 4:
			System.out.println("-------------McSaver Combos------------\n");
			System.out.println("1.McChicken Party Combo                     ₹856");
			System.out.println("2.Big Group Party Combo                     ₹1199");
			System.out.println("3.Fries and Chicken Nuggets Party Pack      ₹999");
			int savCh = Integer.parseInt(sc.nextLine());
			switch (savCh) {
			case 1:
				orderItem("McChicken Party Combo              ", 856);
				break;
			case 2:
				orderItem("Big Group Party Combo              ", 1199);
				break;
			case 3:
				orderItem("Fries and Chicken Nuggets Pack     ", 999);
				break;
			default:
				System.out.println("Invalid category");
				System.out.println("1.Go back to menu");
				System.out.println("2.Exit");
				int ch4=Integer.parseInt(sc.nextLine());
				switch(ch4) {
				case 1:menu();
				break;
				case 2:
					System.out.println("Thank you!!!!!!!");
					break;
				    
				}
			}
			break;
		}
	}

	void beverages() {
		System.out.println("\n----------------Coffee☕︎ & Beverages🧋--------------\n");
		System.out.println("1.Strawberry Oreo Frappe                   ₹215");
		System.out.println("2.Classic Cold Coffee with Vanilla         ₹236");
		System.out.println("3.Cappuccinno Coffee                       ₹170");
		System.out.println("4.Hot Chocolate                            ₹199");
		System.out.println("5.Latte Coffee                             ₹173");
		System.out.println("6.American Mud Pie Shake                   ₹203");
		int bevch = Integer.parseInt(sc.nextLine());
		switch (bevch) {
		case 1:
			orderItem("Strawberry Oreo Frappe             ", 215);
			break;
		case 2:
			orderItem("Classic Cold Coffee with Vanilla   ", 236);
			break;
		case 3:
			orderItem("Cappuccinno Coffee                 ", 170);
			break;
		case 4:
			orderItem("Hot Chocolate                      ", 199);
			break;
		case 5:
			orderItem("Latte Coffee                       ", 173);
			break;
		case 6:
			orderItem("American Mud Pie Shake             ", 203);
			break;
		default:
			System.out.println("Invalid category");
			System.out.println("1.Go back to menu");
			System.out.println("2.Exit");
			int choice=Integer.parseInt(sc.nextLine());
			switch(choice) {
			case 1:menu();
			break;
			case 2:
				System.out.println("Thank you!!!!!!!");
				break;
			    
			}
		}
	}

	void desserts() {
		System.out.println("---------------🍪Desserts🍧🍨------------\n");
		System.out.println("1.Black Forest McFlurry                  ₹124");
		System.out.println("2.Hot Fudge Sundae                       ₹66");
		System.out.println("3.McFlurry Oreo                          ₹129");
		System.out.println("4.Strawberry Sundae                      ₹66");
		int desCh = Integer.parseInt(sc.nextLine());
		switch (desCh) {
		case 1:
			orderItem("Black Forest McFlurry              ", 124);
			break;
		case 2:
			orderItem("Hot Fudge Sundae                   ", 66);
			break;
		case 3:
			orderItem("McFlurry Oreo                      ", 129);
			break;
		case 4:
			orderItem("Strawberry Sundae                  ", 66);
			break;
		default:
			System.out.println("Invalid category");
			System.out.println("1.Go back to menu");
			System.out.println("2.Exit");
			int choice=Integer.parseInt(sc.nextLine());
			switch(choice) {
			case 1:menu();
			break;
			case 2:
				System.out.println("Thank you!!!!!!!");
				break;
			    
			}

		}
	}

	public static void main(String[] args) {
		McD mcd = new McD();
		mcd.menu();

	}
}
