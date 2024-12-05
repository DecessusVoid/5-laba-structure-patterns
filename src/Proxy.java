interface Database {
    void query(String sql);
}
class RealDatabase implements Database {
    @Override
    public void query(String sql) {
        System.out.println("Executing query: " + sql);
    }
}
 class DatabaseProxy implements Database {
    private RealDatabase realDatabase;
    private boolean hasAccess;

    public DatabaseProxy(boolean hasAccess) {
        this.realDatabase = new RealDatabase();
        this.hasAccess = hasAccess;
    }

    @Override
    public void query(String sql) {
        if (hasAccess) {
            realDatabase.query(sql);
        } else {
            System.out.println("Access denied. Query cannot be executed.");
        }
    }
}
public class Proxy {
    public static void main(String[] args) {
        Database userDb = new DatabaseProxy(false);
        Database adminDb = new DatabaseProxy(true);

        userDb.query("SELECT * FROM users"); 
        adminDb.query("SELECT * FROM users"); 
    }
}