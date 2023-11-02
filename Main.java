import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        
        //sistema che fa registrare l utente o loggare o esci (1 reg, 2 login 3 esci)
        boolean registrazione = false;
        boolean login = false;


        User user1 = new User("","");
        Scanner input = new Scanner(System.in);
        int scelta;

        do{

            //Stampo le prime 3 funzioni
            System.out.println("\n\n BENVENUTO! \t ");
            System.out.println("1 -> registrati");
            System.out.println("2 -> accedi");
            System.out.println("3 -> esci");
            System.out.print("Scegli una funzione > "); scelta = input.nextInt();
            input.nextLine();


            switch (scelta) {
                case 1:

                    registrazione = registrati(input, user1,registrazione); // la funzione ritorna un booleano che è il valore che 
                                                                            // accerta il compiuto avvenimento della registrazione

                    break;

                case 2:
                //controllo tramite la variabile registrazione che sia stata effettuata prima la registrazione
                if(registrazione == true){
                    login = accedi(input,user1,login);


                }else{
                    System.out.println("Devi prima registrarti".toUpperCase());
                }


                    break;

                case 3:
                     System.exit(0);

                    break;
                default:

                System.out.println("HAI INSERITO UN VALORE NON VALIDO");
                    break;
            }


        }while(login == false);

        System.out.println("\n \n SECONDO MENU");

    }










    public static boolean registrati(Scanner in, User user,boolean registrazione){
        String mail = "";
        String pass = "";
        System.out.println("REGISTRAZIONE: \n");
        System.out.print("inserisci mail > "); 
        mail = in.nextLine();
        in.nextLine(); // serve per pulire il buffer dell input;
        System.out.print("inserisci la password > ");
        pass = in.nextLine();

        if(mail.length() > 0 && pass.length() > 0){
            user.mail = mail;
            user.pass = pass;
            System.out.println("REGISTRATO CON SUCCESSO!!! \n ");
            /*System.out.println("mail: " + user.mail);
            System.out.println("password: " + user.pass);*/
            registrazione = true;
        }else{
            System.out.println("VALORI INSERITI NON VALIDI");
        }

        return registrazione;



    }

    public static boolean accedi(Scanner in,User user,boolean login){
        System.out.println("LOGIN: \n");
        String mail = "";
        String pass = "";

        System.out.print("Inserisci mail > ");
        mail = in.nextLine();
        in.nextLine(); // pulisco il buffer dello scanner, se non lo facessi non mi prenderebbe il secondo valore da Tastiera

        System.out.print("Inserisci password > ");
        pass = in.nextLine();

        if((mail.equals(user.mail)) && (pass.equals(user.pass))){
            System.out.println("\n\n LOGGATO CON SUCCESSO");
            login = true;
            return login;
        }else{
                System.out.println("\nMAIL O PASSWORD ERRATI!");
                login = false;
        }
        return login;




    }
}