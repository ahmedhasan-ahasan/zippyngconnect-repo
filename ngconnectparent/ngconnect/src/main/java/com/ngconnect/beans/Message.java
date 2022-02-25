package com.ngconnect.beans;

import lombok.Data;

/**
 * 
 * @author ahmed
 *
 */
@Data
public class Message {

	protected String from;
	protected String[] to;
	protected String content;
}
