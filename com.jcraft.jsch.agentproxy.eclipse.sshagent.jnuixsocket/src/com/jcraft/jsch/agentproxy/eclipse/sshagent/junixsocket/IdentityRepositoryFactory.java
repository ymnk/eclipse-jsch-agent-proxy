package com.jcraft.jsch.agentproxy.eclipse.sshagent.junixsocket;

import org.eclipse.jsch.core.IIdentityRepositoryFactory;

import com.jcraft.jsch.IdentityRepository;
import com.jcraft.jsch.agentproxy.AgentProxyException;
import com.jcraft.jsch.agentproxy.Buffer;
import com.jcraft.jsch.agentproxy.Connector;
import com.jcraft.jsch.agentproxy.RemoteIdentityRepository;
import com.jcraft.jsch.agentproxy.USocketFactory;
import com.jcraft.jsch.agentproxy.connector.SSHAgentConnector;
import com.jcraft.jsch.agentproxy.usocket.JUnixDomainSocketFactory;

public class IdentityRepositoryFactory implements IIdentityRepositoryFactory{

	@Override
	public IdentityRepository create() {
		Connector con = null;

		if (SSHAgentConnector.isConnectorAvailable() &&
			!System.getProperty("os.name").startsWith("Windows")) {
			try {
				USocketFactory udsf = new JUnixDomainSocketFactory();
				con = new SSHAgentConnector(udsf);
			} 
			catch (AgentProxyException e) {
			} 
			catch (java.lang.UnsatisfiedLinkError e) {
				// junixsocket may throw an exception if CLibrary is not
				// available.
				System.err.println("ssh-agent: IdentityRepositoryFactory " + e);
			} 
			catch (java.lang.NoClassDefFoundError e) {
				// junixsocket may throw an exception if CLibrary is not
				// available.
				System.err.println("ssh-agent: IdentityRepositoryFactory " + e);
			}
		}
		
		if (con == null) {
			con = new Connector() {
				public String getName() {
					return "ssh-agent(using junixsocket)";
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
