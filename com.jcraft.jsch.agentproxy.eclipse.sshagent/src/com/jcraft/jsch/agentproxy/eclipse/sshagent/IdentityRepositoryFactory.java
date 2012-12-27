package com.jcraft.jsch.agentproxy.eclipse.sshagent;

import org.eclipse.jsch.core.IIdentityRepositoryFactory;

import com.jcraft.jsch.IdentityRepository;
import com.jcraft.jsch.agentproxy.AgentProxyException;
import com.jcraft.jsch.agentproxy.Buffer;
import com.jcraft.jsch.agentproxy.Connector;
import com.jcraft.jsch.agentproxy.RemoteIdentityRepository;
import com.jcraft.jsch.agentproxy.USocketFactory;
import com.jcraft.jsch.agentproxy.connector.SSHAgentConnector;
import com.jcraft.jsch.agentproxy.usocket.JNAUSocketFactory;

public class IdentityRepositoryFactory implements IIdentityRepositoryFactory{

	@Override
	public IdentityRepository create() {
		Connector con = null;
		try {
	        USocketFactory usf = new JNAUSocketFactory();
	        con = new SSHAgentConnector(usf);
		} catch (AgentProxyException e) {
		} catch (java.lang.UnsatisfiedLinkError e) {
			// JNA may throw an exception if CLibrary is not available.
		} catch (java.lang.NoClassDefFoundError e) {
			// JNA may throw an exception if CLibrary is not available.
		}
		
		
		if (con == null) {
			con = new Connector() {
				public String getName() {
					return "ssh-agent";
				}

				public boolean isAvailable() {
					return false;
				}

				public void query(Buffer arg0) throws AgentProxyException {
					throw new AgentProxyException("null connector");
				}
			};
		}
		return  new RemoteIdentityRepository(con);
	}

}