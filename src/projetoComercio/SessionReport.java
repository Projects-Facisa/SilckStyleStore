package projetoComercio;

import java.util.ArrayList;

public class SessionReport {

    private ArrayList<String> productsAddedSession = new ArrayList<String>();
    private ArrayList<String> productsRemovedSession = new ArrayList<String>();

    
    public ArrayList<String> getProductsAddedSession() {
        return productsAddedSession;
    }

    public ArrayList<String> getProductsRemovedSession() {
        return productsRemovedSession;
    }

    public void productsAdded(String name, int stock, double cost){
        double MoneySpent = cost * stock;
        String addedProduct = ("Name: "+ name +" Stock Added: "+ stock +" Money Spent: "+ MoneySpent);
        productsAddedSession.add(addedProduct);
        }

    public void productsRemoved(String name, int stock, double sale){
        double MoneyEarned = sale * stock;
        String removedProduct = ("Name: "+ name +" Stock Sold: "+ stock +" Money Earned: "+ MoneyEarned);
        productsRemovedSession.add(removedProduct);
        }    

}    