package amudhan.liquibase.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import amudhan.liquibase.entities.Customer;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@PostMapping
	public Customer createCustomer(@RequestBody Customer customer) {
		jdbcTemplate.update("insert  into customer(id, customer_number,customer_name) values (?, ?,?)",
				new Object[] { customer.getId(), customer.getCustomerNumber(), customer.getCustomerName() });
		return customer;
	}

	@GetMapping
	public List<Customer> getCustomers() {
		List<Customer> customers = jdbcTemplate.query("select * from customer", new RowMapper<Customer>() {

			@Override
			public Customer mapRow(ResultSet rs, int row) throws SQLException {
				Customer customer = new Customer();
				customer.setId(rs.getLong("id"));
				customer.setCustomerNumber(rs.getInt("customer_number"));
				customer.setCustomerName(rs.getString("customer_name"));
				return customer;
			}
		});
		return customers;
	}

	@GetMapping("/{id}")
	public Customer getCustomer(@PathVariable(name = "id") Long id) {
		Customer customer = jdbcTemplate.query("select * from customer where id = ? ", new Object[] { id },
				new ResultSetExtractor<Customer>() {
					@Override
					public Customer extractData(ResultSet rs) throws SQLException, DataAccessException {
						rs.next();
						Customer customer = new Customer();
						customer.setId(rs.getLong("id"));
						customer.setCustomerNumber(rs.getInt("customer_number"));
						customer.setCustomerName(rs.getString("customer_name"));
						return customer;
					}
				});
		return customer;
	}

}
