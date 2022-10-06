package com.housemanager.pojo;

public class Salary {

    private Integer salary_id;

    private String username;

    private String staffname;

    private String dates;

    private Double base_wage;

    private Double class_fee;

    private Double base_performance;

    private Double age_pay;

    private Double phone_subsidy;

    private Double traffic_subsidy;

    private Double overtime_subsidy;

    private Double labour_insurance;

    private Double unemployment_insurance;

    private Double medical_insurance;

    private Double income_tax;

    private Double accumulation_fund;

    private Double should_wage;

    private Double deduct_wage;

    private Double real_wage;

    public Salary(Integer salary_id,String username, String staffname, String dates, Double base_wage, Double class_fee, Double base_performance, Double age_pay, Double phone_subsidy, Double traffic_subsidy, Double overtime_subsidy, Double labour_insurance, Double unemployment_insurance, Double medical_insurance, Double income_tax, Double accumulation_fund, Double should_wage, Double deduct_wage, Double real_wage) {
        this.salary_id = salary_id;
        this.username = username;
        this.staffname = staffname;
        this.dates = dates;
        this.base_wage = base_wage;
        this.class_fee = class_fee;
        this.base_performance = base_performance;
        this.age_pay = age_pay;
        this.phone_subsidy = phone_subsidy;
        this.traffic_subsidy = traffic_subsidy;
        this.overtime_subsidy = overtime_subsidy;
        this.labour_insurance = labour_insurance;
        this.unemployment_insurance = unemployment_insurance;
        this.medical_insurance = medical_insurance;
        this.income_tax = income_tax;
        this.accumulation_fund = accumulation_fund;
        this.should_wage = should_wage;
        this.deduct_wage = deduct_wage;
        this.real_wage = real_wage;
    }

    public Salary(String username, String staffname, String dates, Double base_wage, Double class_fee, Double base_performance, Double age_pay, Double phone_subsidy, Double traffic_subsidy, Double overtime_subsidy, Double labour_insurance, Double unemployment_insurance, Double medical_insurance, Double income_tax, Double accumulation_fund, Double should_wage, Double deduct_wage, Double real_wage) {
        this.username = username;
        this.staffname = staffname;
        this.dates = dates;
        this.base_wage = base_wage;
        this.class_fee = class_fee;
        this.base_performance = base_performance;
        this.age_pay = age_pay;
        this.phone_subsidy = phone_subsidy;
        this.traffic_subsidy = traffic_subsidy;
        this.overtime_subsidy = overtime_subsidy;
        this.labour_insurance = labour_insurance;
        this.unemployment_insurance = unemployment_insurance;
        this.medical_insurance = medical_insurance;
        this.income_tax = income_tax;
        this.accumulation_fund = accumulation_fund;
        this.should_wage = should_wage;
        this.deduct_wage = deduct_wage;
        this.real_wage = real_wage;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "salary_id=" + salary_id +
                ", username='" + username + '\'' +
                ", staffname='" + staffname + '\'' +
                ", dates='" + dates + '\'' +
                ", base_wage=" + base_wage +
                ", class_fee=" + class_fee +
                ", base_performance=" + base_performance +
                ", age_pay=" + age_pay +
                ", phone_subsidy=" + phone_subsidy +
                ", traffic_subsidy=" + traffic_subsidy +
                ", overtime_subsidy=" + overtime_subsidy +
                ", labour_insurance=" + labour_insurance +
                ", unemployment_insurance=" + unemployment_insurance +
                ", medical_insurance=" + medical_insurance +
                ", income_tax=" + income_tax +
                ", accumulation_fund=" + accumulation_fund +
                ", should_wage=" + should_wage +
                ", deduct_wage=" + deduct_wage +
                ", real_wage=" + real_wage +
                '}';
    }

    public Integer getSalary_id() {
        return salary_id;
    }

    public void setSalary_id(Integer salary_id) {
        this.salary_id = salary_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStaffname() {
        return staffname;
    }

    public void setStaffname(String staffname) {
        this.staffname = staffname;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public Double getBase_wage() {
        return base_wage;
    }

    public void setBase_wage(Double base_wage) {
        this.base_wage = base_wage;
    }

    public Double getClass_fee() {
        return class_fee;
    }

    public void setClass_fee(Double class_fee) {
        this.class_fee = class_fee;
    }

    public Double getBase_performance() {
        return base_performance;
    }

    public void setBase_performance(Double base_performance) {
        this.base_performance = base_performance;
    }



    public Double getAge_pay() {
        return age_pay;
    }

    public void setAge_pay(Double age_pay) {
        this.age_pay = age_pay;
    }

    public Double getPhone_subsidy() {
        return phone_subsidy;
    }

    public void setPhone_subsidy(Double phone_subsidy) {
        this.phone_subsidy = phone_subsidy;
    }

    public Double getTraffic_subsidy() {
        return traffic_subsidy;
    }

    public void setTraffic_subsidy(Double traffic_subsidy) {
        this.traffic_subsidy = traffic_subsidy;
    }

    public Double getOvertime_subsidy() {
        return overtime_subsidy;
    }

    public void setOvertime_subsidy(Double overtime_subsidy) {
        this.overtime_subsidy = overtime_subsidy;
    }

    public Double getLabour_insurance() {
        return labour_insurance;
    }

    public void setLabour_insurance(Double labour_insurance) {
        this.labour_insurance = labour_insurance;
    }

    public Double getUnemployment_insurance() {
        return unemployment_insurance;
    }

    public void setUnemployment_insurance(Double unemployment_insurance) {
        this.unemployment_insurance = unemployment_insurance;
    }

    public Double getMedical_insurance() {
        return medical_insurance;
    }

    public void setMedical_insurance(Double medical_insurance) {
        this.medical_insurance = medical_insurance;
    }

    public Double getIncome_tax() {
        return income_tax;
    }

    public void setIncome_tax(Double income_tax) {
        this.income_tax = income_tax;
    }

    public Double getAccumulation_fund() {
        return accumulation_fund;
    }

    public void setAccumulation_fund(Double accumulation_fund) {
        this.accumulation_fund = accumulation_fund;
    }

    public Double getShould_wage() {
        return should_wage;
    }

    public void setShould_wage(Double should_wage) {
        this.should_wage = should_wage;
    }

    public Double getDeduct_wage() {
        return deduct_wage;
    }

    public void setDeduct_wage(Double deduct_wage) {
        this.deduct_wage = deduct_wage;
    }

    public Double getReal_wage() {
        return real_wage;
    }

    public void setReal_wage(Double real_wage) {
        this.real_wage = real_wage;
    }
}
