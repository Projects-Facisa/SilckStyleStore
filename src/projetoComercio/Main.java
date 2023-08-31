package projetoComercio;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Methods operation = new Methods();

        int option = 0;
        System.out.println("                        ---| WELCOME TO BYTEBLAZE STORE |---");
        while (option != 6) {
            System.out.println("\n                                --- MAIN MENU ---\n");
            System.out.println("(1) List All (2) Register Product (3) Add Stock (4) Remove Product (5) Sell Product (6) Exit");
            option = sc.nextInt();
            sc.nextLine(); // Consumir a quebra de linha pendente

            if (option == 1) {
            	operation.Listar();
            } 
            else if (option == 2) {
            	
            	int productStock = 0;
            	
                System.out.print("Enter the product name:");
                String productName = sc.nextLine();

                System.out.print("Enter the product code:");
                int productCode = Integer.parseInt(sc.nextLine());
                
                System.out.println("Add stock to product ? (1 - YES, 2 - NO):");
                
                int addOption = sc.nextInt();
                
                if (addOption == 1) {
                    System.out.print("Enter the stock quantity: ");
                    productStock = sc.nextInt();
                }
                else {
                	System.out.println("retorno");
                }

                operation.registerProduct(productName,productCode,productStock);
                
            } 
            else if (option == 3) {
            	System.out.print("Enter the product code:");
                int productCode = Integer.parseInt(sc.nextLine());
                
                System.out.print("Enter the stock quantity: ");
                int productStock = Integer.parseInt(sc.nextLine());
                
                operation.addStock(productStock, productCode);
                
            } 
            else if (option == 4) {
            	System.out.print("Enter the product code: ");
                int productCode = Integer.parseInt(sc.nextLine());
                operation.deleteProduct(productCode);

            } 
            else if (option == 5) {
            	System.out.print("Enter the product code: ");
                int productCode = Integer.parseInt(sc.nextLine());
                
                System.out.print("Enter the quantity to be sold: ");
                int productStock = Integer.parseInt(sc.nextLine());
                
                operation.removeStock(productStock, productCode);    
            } 
            else if (option != 6) {
                System.out.println("Invalid Option !");
            }
        }
    }
}
    
