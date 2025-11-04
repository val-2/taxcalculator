package taxcalculator;

final class TaxConstants {
    private TaxConstants() {
    }

    static final double SOCIAL_SECURITY_RATE = 0.0976; // 9.76%
    static final double SOCIAL_HEALTH_SECURITY_RATE = 0.015; // 1.5%
    static final double SOCIAL_SICKNESS_SECURITY_RATE = 0.0245; // 2.45%

    static final double HEALTH_SECURITY_9_RATE = 0.09; // 9%
    static final double HEALTH_SECURITY_775_RATE = 0.0775; // 7.75%

    static final double EMPLOYMENT_TAX_DEDUCTIBLE_EXPENSES = 111.25; // PLN
    static final double CIVIL_TAX_DEDUCTIBLE_EXPENSES_RATE = 0.20; // 20%

    static final double ADVANCE_TAX_RATE = 0.18; // 18%

    static final double EXPLOYMENT_TAX_FREE_INCOME = 46.33; // PLN
    static final double CIVIL_TAX_FREE_INCOME = 0.0; // PLN
}
