package jp.t2v.lab.doma.jodatime;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;

@Dao(config = DomaConfig.class)
public interface TestEntityDao {

	@Select
	List<TestEntity> findAll();

	@Insert
	int insert(TestEntity entity);
	
}
