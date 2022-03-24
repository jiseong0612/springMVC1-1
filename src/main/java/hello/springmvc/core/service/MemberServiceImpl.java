package hello.springmvc.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hello.springmvc.core.domain.Member;
import hello.springmvc.core.repository.MemberRepository;

@Component
public class MemberServiceImpl implements MemberService {
	// AppConfig.class에서 생성과 주입을 도와준다.
	private final MemberRepository memberRepository;
	
	@Autowired
	public MemberServiceImpl(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	@Override
	public void join(Member member) {
		memberRepository.save(member);
	}

	@Override
	public Member findMember(Long memberId) {
		return memberRepository.findById(memberId);
	}

}
