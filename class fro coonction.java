public class CommDB
{/** This class contains a generic code for data manipulation */

    public TreeMap<String,HashMap<String,String>> 
    select(Connection conn, String selectQuery) 
    { /** This is a generic method for the select operation */

        TreeMap<String,HashMap<String,String>> selectResult = 
                                    new TreeMap<String,HashMap<String,String>>();
        String[] keys = selectQuery.replace(" ","").replace("SELECT", "").split("FROM")[0].split(",");

        try {
            PreparedStatement stmt = conn.prepareStatement(selectQuery);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                HashMap<String,String> eachResult = new HashMap<String,String>();
                for (int i=1; i<keys.length; i++) { 
                    eachResult.put(keys[i],rs.getString(i+1));              
                } // for
                selectResult.put(rs.getString(1),eachResult);
            } // while

        } catch(SQLException sqlExc) {
            System.out.println(sqlExc.getMessage());
        } // try-catch

        return selectResult;
    } // select()

} // class CommDB
