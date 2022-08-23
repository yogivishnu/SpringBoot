package com.amman.finance.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class DaySheet {
	@Id
	private long loanId;
	private long paidAmount;
	private java.sql.Date paidDate;

}
 
