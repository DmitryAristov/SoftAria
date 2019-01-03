package SoftAria;

import java.util.HashMap;
import java.util.HashSet;

public class EmailConstructor {

    private HashMap<String, HashSet<String>> UrlChanges;

    public EmailConstructor(HashMap<String, HashSet<String>> urlChanges) {
        this.UrlChanges = urlChanges;
    }

    public StringBuilder Email(){

        String head = "Здравствуйте, дорогая и.о. секретаря\n" +
                "За последние сутки во вверенных Вам сайтах произошли следующие изменения:\n ";

        StringBuilder body = new StringBuilder();
        StringBuilder removed = new StringBuilder("1.\tИсчезли следующие страницы: {");
        StringBuilder added = new StringBuilder("2.\tПоявились следующие новые страницы: {");
        StringBuilder changed = new StringBuilder("3.\tИзменились следующие страницы: {");

        for (String s : UrlChanges.get("added")
             ) {
            added.append(s);
            added.append(", ");
        }
        for (String s : UrlChanges.get("changed")
        ) {
            changed.append(s);
            changed.append(", ");
        }
        for (String s : UrlChanges.get("removed")
        ) {
            removed.append(s);
            removed.append(", ");
        }
        added.deleteCharAt(added.length()-2);
        added.append("}\n");
        changed.deleteCharAt(changed.length()-2);
        changed.append("}\n");
        removed.deleteCharAt(removed.length()-2);
        removed.append("}\n");

        body.append(removed + "\n" + added + "\n" + changed);

        String footer = "С уважением,\n" +
                "автоматизированная система\n" +
                "мониторинга.\n";

        StringBuilder email = new StringBuilder();
        email.append(head + "\n" + body + "\n" + footer);

        return email;
    }


}
