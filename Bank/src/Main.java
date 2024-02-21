import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.List;
public class Main {
    static List<Client> clients=new ArrayList<>();
    static Statistics Bank;

    static List<Workers> workers= new ArrayList<>();
    public static void main(String[] args) {
        try{


        Scanner scanner=new Scanner(System.in);
    System.out.println("Na początku podaj informację o banku");
    System.out.println("Ilość klientów:");
        Integer val=scanner.nextInt();
        System.out.println("Podaj ilość pieniędzy:");
        double money= scanner.nextDouble();
        System.out.println("Podaj wartość odsetek:");
        double interest=scanner.nextDouble();
        Bank=new Statistics(val,money,interest);
        System.out.println("Wpisz komendy które chcesz wykonać lub wpisz `zakończ` aby skończyć program.");
        Commands();
        while(true){
            String value=scanner.nextLine();
            Complete(value);
        }}catch (Exception e){
            System.out.println("Wystąpił błąd!\n" + e);
        }
    }
    public static void Commands(){
        System.out.println("Klient:\n" + "Dodaj Klienta:`nk`\nAktualizuj stawkę odsetek zawartej w Banku:`as`'\nWyświetl informacje o kliencie:`ik`\nNiech klient weźmie pożyczkę:`tl`" );
        System.out.println("Bank:\nZmień Stawkę odsetek:`bs`\nWyświetl informacje o banku:`ib`");
        System.out.println("Pokaż pracowników:`sp`\npokaż stawkę roczną pracowników:`wp`");
    }
    public static void Complete(String value){
        Scanner scanner=new Scanner(System.in);
        switch (value){
            case "nk":
                System.out.println("Podaj imie:");
                String name=scanner.nextLine();
                System.out.println("Podaj nazwisko:");
                String surname=scanner.nextLine();
                System.out.println("Podaj wiek:");
                Integer age=scanner.nextInt();
                System.out.println("podaj pesel:");
                Integer pesel=scanner.nextInt();
                Client client=new Client(name,surname,age,pesel);
                clients.add(client);
                break;
            case "as":
                for(int i=0;i<clients.size();i++){
                    clients.get(i).CallInterestRate(clients.get(i).getLoan(),Bank.getInterestRate());
                }
                System.out.println("Pomyślnie wprowadzono zmiany");
                break;
            case "ik":
                for(int i=0;i<clients.size();i++) {
                    clients.get(i).callInfo(clients.get(i).getInterestRate());
                }
                break;
            case "tl":
                System.out.println("Wybierz klienta po peselu:");
                Integer id=scanner.nextInt();
                for(int i=0;i<clients.size();i++) {
                    if(Objects.equals(clients.get(i).getPesel(), id)){
                        System.out.println("Podaj Wysokość pożyczki:");
                        double loan=scanner.nextDouble();
                        Bank.CallAddNewClient(clients.get(i));
                        clients.get(i).CallTakeLoan(loan, Bank.getInterestRate());
                    }
                }
                break;
            case "bs":
                System.out.println("Podaj stawkę:");
                double rate=scanner.nextDouble();
                Bank.setInterestRate(rate);
                break;
            case "ib":
                Bank.CallInfo();
                break;
            case "sp":
                for(int i=0;i<workers.size();i++){
                    workers.get(i).CallInfo();
                }
                break;
            case "wp":
                for(int i=0;i<workers.size();i++){
                    System.out.println("Imie:" + workers.get(i).getName() + "\nNazwisko:" + workers.get(i).getSurname() + "\nStawka roczna:" + workers.get(i).CallYearlyPayment() );
                }
                break;
            case "zakończ":
                return;
            default:
                System.out.println("Nieznana komenda");
        }
    }
}