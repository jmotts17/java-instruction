package motta.business;

import java.io.IOException;
import java.util.List;

public interface DAO<T> {
	T get(String code) throws NoSuchCustomerException, IOException;

	List<T> getAll() throws IOException;

	boolean add(T t) throws IOException;

	boolean update(T t) throws NoSuchCustomerException, IOException;

	boolean delete(T t) throws IOException;
}