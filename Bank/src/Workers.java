public class Workers {
    private String Name;
    private String Surname;
    private Integer Age;
    private double Paycheck;
    private String Employment;
    private String Position;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public double getPaycheck() {
        return Paycheck;
    }

    public void setPaycheck(double paycheck) {
        Paycheck = paycheck;
    }

    public String getEmployment() {
        return Employment;
    }

    public void setEmployment(String employment) {
        Employment = employment;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }
    private void Info(){
        System.out.println("Imie:" + getName() + "\nNazwisko:" + getSurname() + "\nWiek:" + getAge() + "\nWypłata:"+ getPaycheck() + "\nStanowisko:" + getEmployment() + "\nPozycja:" + getPosition());
    }
    public void CallInfo(){
        Info();
    }
    private double YearlyPayment(){
        return getPaycheck()*12;
    }
    public double CallYearlyPayment(){
        return YearlyPayment();
    }

    public Workers(String name, String surname, Integer age, double paycheck, String employment, String position) {
        Name = name;
        Surname = surname;
        Age = age;
        Paycheck = paycheck;
        Employment = employment;
        Position = position;
    }
}
