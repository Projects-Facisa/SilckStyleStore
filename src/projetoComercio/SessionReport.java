package projetoComercio;

public class SessionReport {
    private int productsAddedSession;
    private int productsRemovedSession;
    private int productsSoldSession;
    private int currentStockSession;
    private double moneyEarnedSession;

    private int stockNow;  
    public SessionReport(int productsAddedSession, int productsRemovedSession, int productsSoldSession, int currentStockSession, double moneyEarnedSession, int stockNow) {
        this.productsAddedSession = productsAddedSession;
        this.productsRemovedSession = productsRemovedSession;
        this.productsSoldSession = productsSoldSession;
        this.currentStockSession = currentStockSession;
        this.moneyEarnedSession = moneyEarnedSession;
        this.stockNow = stockNow;  
    }

    @Override
    public String toString() {
        return "Session Report:\n" +
               "Products Added: " + productsAddedSession + "\n" +
               "Products Removed: " + productsRemovedSession + "\n" +
               "Products Sold: " + productsSoldSession + "\n" +
               "Current Stock: " + currentStockSession + "\n" +
               "Money Earned: $" + moneyEarnedSession + "\n" +
               "stock Now: " + stockNow; 
    }
}
