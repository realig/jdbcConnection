public class MyDB
{ /** This is MyDB Proxy Class */
    String myDbUrl = "jdbc:mysql://MyDB/mySchema";
    String myDbDriver = "com.mysql.jdbc.Driver";
    String myDbUser = "myName";
    String myDbPwd = "myPassword";
    CommDB db = new CommDB();

    public TreeMap<String,HashMap<String,String>> 
    getUsers(String namePattern) 
    { /** This method is specific for USERS data */     
        TreeMap<String,HashMap<String,String>> users = 
                new TreeMap<String,HashMap<String,String>>();           
        String selectUsers = 
         "SELECT userID, firstName, lastName, address, phone FROM USERS " + 
            "WHERE lastName like '%" + namePattern + "%'";

        Connection conn = null;
        try {           
            conn = db.connect(myDbUrl,myDbDriver,myDbUser,myDbPwd);
            users = db.select(conn, selectUsers);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) { conn.close(); }
            } catch (SQLException sqlExc) {
                System.out.println(sqlExc.getMessage());
            } // try-catch
        } // try-catch-finally

        return users;
    } // getUsers()

} // class MyDB
