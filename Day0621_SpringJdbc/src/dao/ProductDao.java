package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import model.Product;

public class ProductDao implements DaoInterface{
	private JdbcTemplate jTemplate;
	public ProductDao(JdbcTemplate jTemplate) {
		this.jTemplate = jTemplate;
	}
	@Override
	public int addProduct(Product p) {
		String sql = "insert into Product values(?,?,?,?)";
		return jTemplate.update(sql,p.getpNum(),p.getpName(),p.getPrice(),p.getStock());
	}
	@Override
	public int updateProduct(Product p) {
		String sql = "update Product set "
				+ "					pName = ?,"
				+ "					price = ?,"
				+ "					stock = ?"
				+ "		where pNum = '"+p.getpNum()+"'";
		return jTemplate.update(sql,p.getpName(),p.getPrice(),p.getStock());
	}
	@Override
	public int deleteProduct(String pNum) {
		String sql = "delete from Product where pNum = '"+pNum+"'";

		return jTemplate.update(sql);
	}
	@Override
	public Product selectOne(String pNum) {
		String sql = "select * from Product where pNum = '"+pNum+"'";

		return jTemplate.queryForObject(sql, rowMapper);
	}
	@Override
	public List<Map<String, Object>> selectAll() {
		String sql = "select * from Product";
		return jTemplate.query(sql,rowMapper2);
	}

	public RowMapper<Product> rowMapper = new RowMapper<Product>() {
		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			Product p = new Product();
			p.setpNum(rs.getString("pNum"));
			p.setpName(rs.getString("pName"));
			p.setPrice(rs.getInt("price"));
			p.setStock(rs.getInt("stock"));
			return p;
		}
	};
	public RowMapper<Map<String,Object>> rowMapper2 = new RowMapper<Map<String,Object>>(){
		@Override
		public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("pNum", rs.getString("pNum"));
			map.put("pName", rs.getString("pName"));
			map.put("price", rs.getInt("price"));
			map.put("stock", rs.getInt("stock"));
			return map;
		}
		
	};
}
