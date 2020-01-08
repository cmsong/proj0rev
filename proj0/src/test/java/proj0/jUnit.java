package proj0;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import com.revature.models.Car;
import com.revature.models.Financials;
import com.revature.models.User;
import com.revature.service.CarService;
import com.revature.service.FinancialsService;
import com.revature.service.UserService;
import com.revature.utilities.JDBCConnection;

public class jUnit {
	@Test
	public void addconnection() {
		Connection conn = JDBCConnection.getConnection();
		assertNotNull(conn);
	}
	@Test
	public void addcar() {
		Car p = new Car("Honda Civic", 2000);
		assertTrue(CarService.addCar(p.getModel(), p.getPrice()));
		CarService.removeCar(CarService.getc_id(p.getModel()));
	}
	@Test
	public void adduser() {
		User u = new User("bob", "bobbo", 0);
		assertTrue(UserService.addUser(u.getUname(), u.getPword()));
	}
	@Test
	public void addOffer() {
		Financials o = new Financials(1, "2010 honda", 2000);
		assertTrue(FinancialsService.makeOffer(o.getC_id(), o.getUser(), o.getOfferPrice()));
	}
	@Test
	public void addCar() {
		Car c = new Car("bbb", 20);
		assertTrue(CarService.addCar(c));
		CarService.removeCar(CarService.getc_id(c.getModel()));
	}
}
