package projetoComercio;

import java.util.ArrayList;

public class Methods {
	ArrayList<Products> products = new ArrayList<Products>();
	
	public void Listar() {
        if (products.isEmpty()) {
            System.out.println("\nNenhum produto cadastrado no sistema!\n");
        } 
        else {
        	int contador = 0;
            for (Products product : products) {
            	contador += 1;
                System.out.println(contador + ") " + product.getName() + " | código: " + product.getCode() + " | estoque: " + product.getStockQuantity() + "\n");
            }
        }
	}
	public void registerProduct(String nomeProduto, int codigoProduto,int estoqueProduto) {
		Products produtoNovo = new Products();
        produtoNovo.setName(nomeProduto);
        produtoNovo.setCode(codigoProduto);
        products.add(produtoNovo);   		 
        addStock(estoqueProduto, codigoProduto);
	}
	public void addStock(int estoqueProduto, int codigoProduto) {
		Products product = locatePerCode(codigoProduto);	
		product.addStockPerCode(estoqueProduto);
	}
		
	
	public Products locatePerCode(int codigoProduto) {
		for (Products product : products) {
			if (product.getCode() == codigoProduto) {
				return product;
			}
		}
		return null;
	}
	public void deleteProduct(int codigoProduto) {
		Products product = locatePerCode(codigoProduto);
		int index = products.indexOf(product);
		products.remove(index);
		
	}
	public void removeStock(int estoqueProduto, int codigoProduto) {
		Products product = locatePerCode(codigoProduto);	
		product.removeStockPerCode(estoqueProduto);
	}
}