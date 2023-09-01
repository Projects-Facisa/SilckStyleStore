package projetoComercio;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Methods operation = new Methods();
        
        int option = 0;
        System.out.println("                      [--- 🔥 WELCOME TO BYTEBLAZE STORE 🔥 ---]");
        operation.Loading();
        while (option != 6) {
            System.out.println("                                 [--- MAIN MENU ---]\n");
            System.out.println("(1) List All (2) Register Product (3) Add Stock (4) Remove Product (5) Sell Product (6) Exit");
            option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1:
                	operation.Loading();
                    operation.List();
                    break;
                case 2:
                    int productStock = 0;

                    System.out.print("Enter the product name:");
                    String productName = sc.nextLine();

                    System.out.print("Enter the product code:");
                    int productCode = Integer.parseInt(sc.nextLine());

                    if (operation.locatePerCode(productCode) == null) {
                    	
                        System.out.println("Do you want to add stock?\n(1) Yes (2) No");
                        int optionStock = Integer.parseInt(sc.nextLine());
                        
                        if (optionStock == 1) {                   	
                            System.out.println("Enter the stock quantity");
                            productStock = Integer.parseInt(sc.nextLine());
                            
                            operation.registerProduct(productName, productCode, productStock);
                            Products product = operation.locatePerCode(productCode);
                            
                            System.out.print((product.getName() + " added successfully."));
                            System.out.println(" code: " + product.getCode() + ", " + "stock: " + product.getStockQuantity() + "\n");   
                        } else {
                            operation.registerProduct(productName, productCode, productStock);
                            Products product = operation.locatePerCode(productCode);
                            
                            System.out.print((product.getName() + " added successfully."));
                            System.out.println(" code: " + product.getCode() + ", " + "stock: " + product.getStockQuantity()+ "\n");
                        }
                    } else {
                        System.out.println("Product code already in use");
                    }
                    break;
                case 3:
                    System.out.print("Enter the product code:");
                    productCode = Integer.parseInt(sc.nextLine());
                    
                    if (operation.locatePerCode(productCode) == null) {
                    	System.out.println("The code entered does not exist");
                    } else {
                        System.out.print("Enter the stock quantity: ");
                        productStock = Integer.parseInt(sc.nextLine());

                        operation.addStock(productStock, productCode);
                    }
                    break;
                case 4:
                    System.out.print("Enter the product code: ");
                    productCode = Integer.parseInt(sc.nextLine());
                    
                    if (operation.locatePerCode(productCode) == null) {
                    	System.out.println("The code entered does not exist");
                    } 
                    else {
	                    if (operation.locatePerCode(productCode).getStockQuantity() == 0) {
	                        operation.deleteProduct(productCode);
	                    } 
	                    else {
	                        System.out.println("there's still stock of this product in the market");
	                        System.out.println("(1) Remove anyway (2) Cancel operation");               
	                        int optionRemove = Integer.parseInt(sc.nextLine());
	                        
	                        if (optionRemove == 1) {
	                            operation.deleteProduct(productCode);
	                        } 
	                        else {
	                            System.out.println("Returning...");
	                        	}
	                    	}
                    	}
                    break;
                case 5:
                    System.out.print("Enter the product code: ");
                    productCode = Integer.parseInt(sc.nextLine());
                    
                    if (operation.locatePerCode(productCode) == null) {
                    	System.out.println("The code entered does not exist");
                    }
                    else {
	                    System.out.print("Enter the quantity to be sold: ");
	                    productStock = Integer.parseInt(sc.nextLine());
	
	                    if (operation.locatePerCode(productCode).getStockQuantity() - productStock < 0) {
	                        System.out.println("Not Enough Stock to sell");
	                    } 
	                    else {
	                        operation.removeStock(productStock, productCode);
	                    }
                    }
                    break;
                case 6:
                    System.out.println("Exiting ByteBlazeStore Thank You!");
                    break;
                default:
                    System.out.println("Invalid Option, please try again !");
                    break;
            }
        }
        sc.close();
    }
}