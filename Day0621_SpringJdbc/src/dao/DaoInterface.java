package dao;

import java.util.List;
import java.util.Map;

import model.Product;

public interface DaoInterface {
	public int addProduct(Product p);
	public int updateProduct(Product p);
	public int deleteProduct(String pNum);
	public Product selectOne(String pNum);
	public List<Map<String,Object>> selectAll();
}
