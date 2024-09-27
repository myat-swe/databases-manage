package com.jdc.ml.ep2.statement.dao;

import com.jdc.ml.ep2.ConnectionManagerOne;
import com.jdc.ml.ep2.statemene.dto.Member;

public class MemberDao {

	@SuppressWarnings("unused")
	private ConnectionManagerOne one;
	
	public MemberDao(ConnectionManagerOne one) {
		super();
		this.one = one;
	}
	
	public int createMember(Member member) {
		
		
		
		
		
		
		return 0;
	}
	
	public Member findById(String email) {
		return null;
	}
	
	public int chagePassword(int id, String oldPassword, String newPassword) {
		return 0;
	}
}
