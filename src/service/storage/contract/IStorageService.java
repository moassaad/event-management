package service.storage.contract;

import model.Member;

import java.util.List;

public interface IStorageService<Template> {
    public List<Template> get();
    public void store(Template template);
    public Template find(int id) throws Exception;
    public Template update(int id, Template template) throws Exception;
    public Template delete(int id) throws Exception;
    public int count();
    public boolean isEmpty();
}
