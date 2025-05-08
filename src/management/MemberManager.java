package management;

import datastructures.maps.CustomHashMap;
import library.Member;
import library.Transaction;

public class MemberManager {
    CustomHashMap<String,Member> members;

    public MemberManager() {
        members = new CustomHashMap<>();
    }

    public void addMember(Member member) {
        if (member == null) {
            throw new NullPointerException("member cannot be null");
        }
        members.put(member.getMemberId(),member);
    }

    public Member getMember(String memberId) {
        return members.get(memberId);
    }

    public void recordTransaction(String memberId, Transaction transaction) {
        members.get(memberId).addTransaction(transaction);
    }

    public Transaction getLastTransaction(String memberId) {
        return members.get(memberId).getLastTransaction();
    }
}
