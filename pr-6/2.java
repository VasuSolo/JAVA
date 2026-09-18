interface Notifier {
    void send(String message);
}

interface Urgent {
}

class Main {
    public static void main(String[] args) {

        Notifier email = message -> System.out.println("Email: " + message);
        Notifier sms = message -> System.out.println("SMS: " + message);

        Notifier[] senders = {email, sms};

        for (Notifier sender : senders) {
            sender.send("Meeting at 10 AM");
        }

        Notifier urgentEmail = new Notifier() {
            public void send(String message) {
                System.out.println("Urgent Email: " + message);
            }
        };

        urgentEmail.send("Meeting at 10 AM");
        urgentEmail.send("Meeting at 10 AM");
    }
}