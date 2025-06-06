// Simple data storing class that represents a message, with it's ID, content, id of the sender, timestamp, id of the chat it was sent it, and User author
package chessBug.network;

import java.sql.Timestamp;

public class Message {
	// IGNORE UNUSED VALUES
	private int id;
	private String content;
	private int senderID; // A little redundant when you have 'author', but can rethink and remove at a later date
	private Timestamp timestamp;
	private int chat;
	private User author;
	
	protected Message(int id, String content, int senderID, Timestamp timestamp, int chat, User author) {
		this.id = id;
		this.content = content;
		this.senderID = senderID;
		this.timestamp = timestamp;
		this.chat = chat;
		this.author = author;
	}

	protected Message(String content){
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public User getAuthor() {
		return author;
	}
}
