package hello.springmvc.core.repository;

import hello.springmvc.core.domain.Member;

public interface MemberRepository {
	void save(Member member);

	Member findById(Long memberId);
}
