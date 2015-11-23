package com.hkesports.matchticker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.hkesports.matchticker.enums.OauthGrantFlowsEnum;
import com.hkesports.matchticker.model.basic.BasicModel;

@Entity
@Table(name = "client_oauth_grant_flows_mapping")
public class ClientOauthGrantFlowsMapping extends BasicModel {
	private static final long serialVersionUID = 1L;

	private Client client;
	private OauthGrantFlowsEnum grantFlows;

	@ManyToOne
	@JoinColumn(name = "client_id")
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Column(name = "grant_flows", nullable = false)
	public OauthGrantFlowsEnum getGrantFlows() {
		return grantFlows;
	}

	public void setGrantFlows(OauthGrantFlowsEnum grantFlows) {
		this.grantFlows = grantFlows;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("id", getId())
		.append("client", getClient())
		.append("grantFlows", getGrantFlows())
		.build();
	}
}
