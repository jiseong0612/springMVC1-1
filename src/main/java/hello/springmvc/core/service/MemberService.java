package hello.springmvc.core.service;

import hello.springmvc.core.domain.Member;

public interface MemberService {
	void join(Member member);
	
	Member findMember(Long memberId);
}
