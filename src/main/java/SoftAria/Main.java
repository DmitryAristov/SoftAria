package SoftAria;

import java.util.Hashtable;

public class Main {
    public static void main(String[] args) {

        Hashtable<String, String> today = new Hashtable<>();
        Hashtable<String, String> yesterday = new Hashtable<>();
        UrlManager manager = new UrlManager(today, yesterday);
        EmailConstructor constructor = new EmailConstructor(manager.UrlsAnalyzer());
        EmailSender sender = new EmailSender(constructor.Email());
        if(sender.Send()){
            System.out.println("Email has been sent!");
        }else{
            System.out.println("Something wrong");
        }
    }
}
