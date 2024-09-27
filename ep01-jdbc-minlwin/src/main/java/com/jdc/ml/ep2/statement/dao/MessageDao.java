package com.jdc.ml.ep2.statement.dao;

import java.util.List;

import com.google.protobuf.Message;
import com.jdc.ml.ep2.ConnectionManagerOne;
import com.jdc.ml.ep2.statemene.dto.Member;

public class MessageDao {

	@SuppressWarnings("unused")
	private ConnectionManagerOne one;
	
	public MessageDao(ConnectionManagerOne one) {
		super();
		this.one  = one;
	}
	
	public Message create(Message message) {
		return null;
	}
	
	public List<Message> search(String memberName, String keyword){
		return null;
	}
	

	public List<Message> searchMember(Member member){
		return null;
	}
	
	public int save (Message message) {
		return 0;
	}
	
	public Message findById(int id) {
		return null;
	}
}
