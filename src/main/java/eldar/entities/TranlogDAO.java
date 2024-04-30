package eldar.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.jpos.ee.DB;

@Data

public class TranlogDAO {

     private DB db;

     public TranlogDAO(DB db) {
         this.db=db;
     }

     public void saveTranlog(String mti, String panNumber){
        Tranlog tranlog=new Tranlog(mti,panNumber);
        Session session= db.open();
        session.save(tranlog);
        session.flush();
     }

}
