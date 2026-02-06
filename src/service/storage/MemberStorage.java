package service.storage;

import model.Member;
import service.storage.contract.IStorageService;

import java.util.ArrayList;
import java.util.List;

public class MemberStorage implements IStorageService<Member> {
    private final List<Member> store;
    public MemberStorage() {
        this.store =  new ArrayList<>();
    }
    @Override
    public List<Member> get() {
        return this.store;
    }

    @Override
    public void store(Member member) {
        this.store.add(member);
    }

    @Override
    public Member find(int id) throws Exception{
        if (this.isEmpty())
        {
            throw new Exception("Not found member");
        }
        for(Member member : this.store) {
            if(member.getId() == id)
            {
                return member;
            }
        }
        return null;
    }

    @Override
    public Member update(int id, Member member) throws Exception {
        if (this.isEmpty())
        {
            throw new Exception("Not found member");
        }
        for(int iterator = 0 ; iterator < this.count(); iterator++) {

            if(this.store.get(iterator).getId() == id)
            {
                return this.store.set(iterator, member);
            }
        }
        return null;
    }

    @Override
    public Member delete(int id) throws Exception{
        if (this.isEmpty())
        {
            throw new Exception("Not found member");
        }
        for(int iterator = 0 ; iterator < this.count(); iterator++) {

            if(this.store.get(iterator).getId() == id)
            {
                return this.store.remove(iterator);
            }
        }
        return null;
    }

    @Override
    public int count() {
        return this.store.size();
    }

    @Override
    public boolean isEmpty() {
        return this.count() <= 0;
    }
}
