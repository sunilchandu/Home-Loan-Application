package com.example.demo.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "loan_application")
@Table(name = "loan_application")
public class LoanApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "date_of_application")
    private LocalDate dateOfApplication;
    @Column(name="loan_applied_amount")
	private double loanAppliedAmount;
	@Column(name="loan_approved_amount")
	private double loanApprovedAmount;
	@Column(name="land_verification_approval")
	private String landVerificationApproval;
	@Column(name="finance_verification_approval")
	private String financeVerificationApproval;
	@Column(name="admin_approval")
	private String adminApproval;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;
//	@Enumerated(EnumType.STRING)
//	@Column(name="status")
//	private Status status;

	public double getLoanAppliedAmount() {
		return loanAppliedAmount;
	}

	public void setLoanAppliedAmount(double loanAppliedAmount) {
		this.loanAppliedAmount = loanAppliedAmount;
	}

	public double getLoanApprovedAmount() {
		return loanApprovedAmount;
	}

	public void setLoanApprovedAmount(double loanApprovedAmount) {
		this.loanApprovedAmount = loanApprovedAmount;
	}

	public String getLandVerificationApproval() {
		return landVerificationApproval;
	}

	public void setLandVerificationApproval(String landVerificationApproval) {
		this.landVerificationApproval = landVerificationApproval;
	}

	public String getFinanceVerificationApproval() {
		return financeVerificationApproval;
	}

	public void setFinanceVerificationApproval(String financeVerificationApproval) {
		this.financeVerificationApproval = financeVerificationApproval;
	}

	public String getAdminApproval() {
		return adminApproval;
	}

	public void setAdminApproval(String adminApproval) {
		this.adminApproval = adminApproval;
	}

	
    public LoanApplication() {
    	super();

    }

   

   

	

	public LoanApplication(int id, LocalDate dateOfApplication, double loanAppliedAmount, double loanApprovedAmount,
			String landVerificationApproval, String financeVerificationApproval, String adminApproval,
			Customer customer) {
		super();
		this.id = id;
		this.dateOfApplication = dateOfApplication;
		this.loanAppliedAmount = loanAppliedAmount;
		this.loanApprovedAmount = loanApprovedAmount;
		this.landVerificationApproval = landVerificationApproval;
		this.financeVerificationApproval = financeVerificationApproval;
		this.adminApproval = adminApproval;
		this.customer = customer;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getDateOfApplication() {
        return dateOfApplication;
    }

    public void setDateOfApplication(LocalDate dateOfApplication) {
        this.dateOfApplication = dateOfApplication;
    }

    @Override
    public String toString() {
        return "LoanApplication{" +
                "id=" + id +
                ", customer=" + customer +
                ", dateOfApplication=" + dateOfApplication +
                '}';
    }
}
