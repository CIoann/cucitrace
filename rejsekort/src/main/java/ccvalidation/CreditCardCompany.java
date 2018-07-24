package ccvalidation;

/**
 * enum for card company specifics
 * 
 */
public enum CreditCardCompany {

	VISA("^4[0-9]{12}(?:[0-9]{3})?$", "VISA"), MASTERCARD("^5[1-5][0-9]{14}$", "MASTER"), AMEX("^3[47][0-9]{13}$",
			"AMEX"), DINERS("^3(?:0[0-5]|[68][0-9])[0-9]{11}$", "Diners"), DISCOVER("^6(?:011|5[0-9]{2})[0-9]{12}$",
					"DISCOVER"), JCB("^(?:2131|1800|35\\d{3})\\d{11}$", "JCB");

	private String regex;
	private String issuerName;

	CreditCardCompany(String regex, String issuerName) {
		this.regex = regex;
		this.issuerName = issuerName;
	}

	public boolean matches(String card) {
		return card.matches(this.regex);
	}

	public String getIssuerName() {
		return this.issuerName;
	}

	/**
	 * get an enum from a card number
	 * 
	 * @param card
	 * @return
	 */
	public static CreditCardCompany gleanCompany(String card) {
		for (CreditCardCompany cc : CreditCardCompany.values()) {
			if (cc.matches(card)) {
				return cc;
			}
		}
		return null;
	}

	/**
	 * get an enum from an issuerName
	 * 
	 * @param issuerName
	 * @return
	 */
	public static CreditCardCompany gleanCompanyByIssuerName(String issuerName) {
		for (CreditCardCompany cc : CreditCardCompany.values()) {
			if (cc.getIssuerName().equals(issuerName)) {
				return cc;
			}
		}
		return null;
	}

}
