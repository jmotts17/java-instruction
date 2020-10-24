package bmdb.db;

import java.util.List;

public interface BmdbDao<T> {

//	T getConnection() throws SQLException;
//
//	T getFromResultSet(T t) throws SQLException;

	List<T> getAll();

	T get(T t);

	boolean add(T t);

	boolean delete(T t);

	boolean update(T t);

}
