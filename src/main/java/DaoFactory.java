// This DAO class with provide access to our Model data, but will not require accessing the listProductsDao class directly
// Instead, we will reference the Interface

public class DaoFactory {
    private static Ads productsDao; // Interface

    public static Ads getAdsDao() {
        if(productsDao == null) {
            productsDao = new ListAdsDao(); // this is the ONLY reference to the ListProductsDao class

        }
        // if it is not null, return the productsDao that already exists
        // this is an instance of the ListProductsDao class
        return productsDao;
    }
}
