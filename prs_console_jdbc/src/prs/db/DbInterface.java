package prs.db;

import java.util.List;

public interface DbInterface<T> {

	public List<T> getAll();

	public T get(int id);

	public boolean add(T t);

	public boolean delete(int id);

	public boolean update(T t);

}
