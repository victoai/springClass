package com.acorn.test2;

import java.util.List;

public interface MemberService {	
	
	public int  registerMember( Member member);
	public List<Member>  getMemberList();
	public int  modifyMember( Member member);
	public int  deleteMember(String userId); 
	
	
}
