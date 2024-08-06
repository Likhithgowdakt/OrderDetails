package CompanyStore.io.order;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_no;
    private String sku;
    private int shipped_qty;
    private String status;
    private Date ship_date;
    private Date delivered_date;
    private String transporter;
    private int transporter_code;
    private String channel;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

	public int getOrder_no() {
		return order_no;
	}

	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public int getShipped_qty() {
		return shipped_qty;
	}

	public void setShipped_qty(int shipped_qty) {
		this.shipped_qty = shipped_qty;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getShip_date() {
		return ship_date;
	}

	public void setShip_date(Date ship_date) {
		this.ship_date = ship_date;
	}

	public Date getDelivered_date() {
		return delivered_date;
	}

	public void setDelivered_date(Date delivered_date) {
		this.delivered_date = delivered_date;
	}

	public String getTransporter() {
		return transporter;
	}

	public void setTransporter(String transporter) {
		this.transporter = transporter;
	}

	public int getTransporter_code() {
		return transporter_code;
	}

	public void setTransporter_code(int transporter_code) {
		this.transporter_code = transporter_code;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

    
}