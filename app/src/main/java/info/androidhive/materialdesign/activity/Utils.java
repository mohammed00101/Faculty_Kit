package info.androidhive.materialdesign.activity;

import com.firebase.client.Firebase;

import java.util.HashMap;
import java.util.Map;

import info.androidhive.materialdesign.model.Schedule;

/**
 * Created by Omar on 5/7/2016.
 */
public class Utils {

    public static void sendNotification(String title, String desc, String link, Schedule assistant){
        Map<String, String> m = new HashMap<>();
        m.put(NotificationInFirebase.TITLE,title);
        m.put(NotificationInFirebase.DESCRIPTION, desc);
        m.put(NotificationInFirebase.GROUP,assistant.getGroup() );
        m.put(NotificationInFirebase.SECTION, assistant.getSection());
        m.put(NotificationInFirebase.YEAR, assistant.getYear() + "");
        m.put(NotificationInFirebase.DOCTOR, assistant.getDoctor());
        m.put(NotificationInFirebase.SUBJECT, assistant.getSubject());

        if (link != null && link.length() != 0) {
            m.put("link", link);
        }
        else
        {
            m.put("link", "");
        }
        // m.put("link", "null");

        Firebase firebase = new Firebase("https://torrid-torch-3608.firebaseio.com/notification");
        Firebase newNotification = firebase.push();
        newNotification.setValue(m);
    }
}
