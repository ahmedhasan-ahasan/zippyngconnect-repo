package com.ngconnect.beans;

import java.util.List;

import lombok.Data;

/**
 * 
 * @author ahmed
 *
 */
@Data
public class MessageWithAttachment extends Message {
	protected String subject;
	protected List<Attachment> attachments;

}
