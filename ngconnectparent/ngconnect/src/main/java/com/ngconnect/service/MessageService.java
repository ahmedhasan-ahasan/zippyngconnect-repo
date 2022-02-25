package com.ngconnect.service;

import com.ngconnect.beans.MessageWithAttachment;

/**
 * 
 * @author ahmed
 *
 */
public interface MessageService {
	public void dispatch(MessageWithAttachment messageWithAttachment);
}
