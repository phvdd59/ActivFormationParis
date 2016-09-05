package com.formation.phva.beans;

import java.io.IOException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class SoapMessageHandler implements SOAPHandler<SOAPMessageContext> {

	@Override
	public void close(MessageContext arg0) {
	}

	@Override
	public boolean handleFault(SOAPMessageContext arg0) {
		return false;
	}

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		SOAPMessage msg = context.getMessage();
		try {
			msg.writeTo(System.out);
			System.out.println("");
			System.out.println("FIN");
		} catch (SOAPException | IOException e) {
			Logger.getLogger(SoapMessageHandler.class.getName()).log(Level.SEVERE, null, e);
		}
		return true;
	}

	@Override
	public Set<QName> getHeaders() {
		return null;
	}

}
