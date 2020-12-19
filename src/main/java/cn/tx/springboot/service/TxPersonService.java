package cn.tx.springboot.service;

import cn.tx.springboot.model.TxPerson;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
public interface TxPersonService {

    public List<TxPerson> selectPersons();

    public TxPerson getPeronById(int pid);

    public void updatePerson(TxPerson p);


    public void insert(TxPerson p);

    public void delete(int pid);

    public TxPerson getPersonByUserPass(Map<String, String> map);
}
