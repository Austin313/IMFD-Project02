package com.project2.imfd.model;


	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;

	import org.hibernate.annotations.ColumnDefault;



	@Entity
	@Table(name="Orderdetail")
	public class Orderdetail {
		
		
		int customer_id;
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		int orderno;
		
		@ColumnDefault("Pending")
		String status;
		double subtotal;
		double tax;
		double total;
		String employee;
		
		
		public Orderdetail() {
			super();
		}


		public Orderdetail(int customer_id, String status, double subtotal, double tax, double total, String employee) {
			super();
			this.customer_id = customer_id;
			this.status = status;
			this.subtotal = subtotal;
			this.tax = tax;
			this.total = total;
			this.employee = employee;
		}


		public Orderdetail(int customer_id, int orderno, String status, double subtotal, double tax, double total,
				String employee) {
			super();
			this.customer_id = customer_id;
			this.orderno = orderno;
			this.status = status;
			this.subtotal = subtotal;
			this.tax = tax;
			this.total = total;
			this.employee = employee;
		}


		@Override
		public String toString() {
			return "Order [customer_id=" + customer_id + ", orderno=" + orderno + ", status=" + status + ", subtotal="
					+ subtotal + ", tax=" + tax + ", total=" + total + ", employee=" + employee + "]";
		}

}
