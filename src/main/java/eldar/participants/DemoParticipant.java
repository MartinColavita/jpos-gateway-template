package eldar.participants;

import eldar.entities.TranlogDAO;
import org.hibernate.Session;
import org.jpos.core.Configuration;
import org.jpos.core.ConfigurationException;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.transaction.Context;
import org.jpos.transaction.TxnSupport;
import org.jpos.ee.DB;

import java.io.Serializable;


public class DemoParticipant extends TxnSupport implements Serializable {

    Configuration cfg;

    @Override
    public void setConfiguration(Configuration cfg) throws ConfigurationException {
        this.cfg = cfg;
    }

    @Override
    public int prepare(long id, Serializable context) {

        Context ctx = (Context) context;
        DB db= getDB(ctx);
        Session s=db.open();
        ISOMsg isoMsg= ctx.get("REQUEST");
        TranlogDAO tranlogDAO= new TranlogDAO(db);
        try {
            if(isoMsg.getMTI()!=null && isoMsg.getString("2")!=null) {
                tranlogDAO.saveTranlog(isoMsg.getMTI(), isoMsg.getString("2"));
            }
        } catch (ISOException e) {
            throw new RuntimeException(e);
        }
        return PREPARED;
    }



}
