public class Statistics {
    private Integer Clients;
    private double Money;
    private double InterestRate;

    public Integer getClients() {
        return Clients;
    }

    public void setClients(Integer clients) {
        Clients = clients;
    }

    public double getMoney() {
        return Money;
    }

    public void setMoney(double money) {
        Money = money;
    }

    public double getInterestRate() {
        return InterestRate;
    }

    public void setInterestRate(double interestRate) {
        InterestRate = interestRate;
    }
    private void Info(){
        System.out.println("Liczba klientów:" + getClients() + "\nIlość pieniędzy:" + getMoney() + "\naktualna wartość odsetek:" + getInterestRate() + "%");
    }

    private void AddNewClient(Client client){
        try{
            setClients(getClients()+1);
            setMoney(getMoney()-client.getLoan());
        } catch (Exception e){
            System.out.println("Wystąpił Błąd!\n" + e);
        }
    }
    public void CallAddNewClient(Client client){
        AddNewClient(client);
    }
    private void UpdateInterestRate(Client client){
        double  Loan=client.getLoan();
        client.setInterestRate(client.CallInterestRate(Loan,getInterestRate()));
    }
    public void CallUpdateInterestRate(Client client){
        UpdateInterestRate(client);
    }

    public Statistics(Integer clients, double money, double interestRate) {
        Clients = clients;
        Money = money;
        InterestRate = interestRate;
    }
}
