public class Client {
    private String Name;
    private String Surname;
    private Integer Age;
    private double Loan=0;
    private double InterestRate;

    public String getName() {
        return Name;
    }

    public double getInterestRate() {
        return InterestRate;
    }

    public void setInterestRate(double interestRate) {
        InterestRate = interestRate;
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

    public double getLoan() {
        return Loan;
    }

    public void setLoan(double loan) {
        Loan = loan;
    }

    private void Info(double Interest){
        System.out.println("Imie:" + getName() + "\nNazwisko:" + getSurname() + "\nWiek:" + getAge() + "\nLoan:" + getLoan() + "\nOdsetki na miesiąc:" + InterestRate(getLoan(),Interest));
    }
    public void callInfo(double Interest){
        Info(Interest);
    }
    private double InterestRate(double Loan,double Interest){
        return Loan / (Interest)/12;
    }
    public double CallInterestRate(double Loan,double Interest){
        return InterestRate(Loan,Interest);
    }
    private boolean IsUnderage(Integer age){
        if(age<18){
            return true;
        } else{
            return false;
        }
    }
    public boolean CallIsUnderAge(Integer age){
        return IsUnderage(getAge());
    }
    private void TakeLoan(double value,double Interest){
        if(CallIsUnderAge(getAge())){
            System.out.println("Nie możesz wziąć pożyczki\nJesteś niepełnoletni");
        }else{
            System.out.println("Pomyślnie wziąłeś pożyczkę na " + value + ". Odsetki wynoszą " + Interest + "% i będziesz zwracał " + CallInterestRate(value,Interest) + "zł miesięcznie przez rok");
            setLoan(value);
            setInterestRate(CallInterestRate(value,Interest));
        }
    }

    public Client(String name, String surname, Integer age) {
        Name = name;
        Surname = surname;
        Age = age;
        Loan = 0;
    }
}
