package com.jcraft.jsch.agentproxy.eclipse.pageant;

import org.eclipse.jsch.core.IIdentityRepositoryFactory;

import com.jcraft.jsch.IdentityRepository;
import com.jcraft.jsch.agentproxy.AgentProxyException;
import com.jcraft.jsch.agentproxy.Buffer;
import com.jcraft.jsch.agentproxy.Connector;
import com.jcraft.jsch.agentproxy.RemoteIdentityRepository;
import com.jcraft.jsch.agentproxy.connector.PageantConnector;

public class IdentityRepositoryFactory implements IIdentityRepositoryFactory{

	@Override
	public IdentityRepository create() {
		Connector con = null;
		try {
			con = new PageantConnector();
		} catch (AgentProxyException e) {
			// connector is not available on this environment.
		}

		if (con == null) {
			con = new Connector() {
				public String getName() {
					return "pageant";
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
