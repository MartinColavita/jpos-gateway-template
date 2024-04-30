package eldar.filters;

import org.jpos.core.Configurable;
import org.jpos.core.Configuration;
import org.jpos.core.ConfigurationException;
import org.jpos.iso.ISOChannel;
import org.jpos.iso.ISOFilter;
import org.jpos.iso.ISOMsg;
import org.jpos.util.LogEvent;

public class DemoOutgoingFilter implements ISOFilter, Configurable {
    @Override
    public void setConfiguration(Configuration configuration) throws ConfigurationException {

    }

    @Override
    public ISOMsg filter(ISOChannel isoChannel, ISOMsg isoMsg, LogEvent evt) throws VetoException {
        evt.addMessage("--- filtered message (xml_outgoing) --");
        evt.addMessage(isoMsg);
        ISOMsg isoMsgOut = (ISOMsg) isoMsg.clone();
        isoMsgOut.unset(22);
        isoMsgOut.unset(40);
        return isoMsgOut;
    }
}
