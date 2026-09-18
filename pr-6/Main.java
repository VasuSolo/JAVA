interface Switchable {
    void on();
    void off();

    default void toggle() {
        on();
    }
}

class Fan implements Switchable {
    public void on() {
        System.out.println("Fan ON");
    }

    public void off() {
        System.out.println("Fan OFF");
    }
}

class Light implements Switchable {
    public void on() {
        System.out.println("Light ON");
    }

    public void off() {
        System.out.println("Light OFF");
    }
}

@FunctionalInterface
interface SwitchRule {
    boolean maySwitchOn(Switchable device, int hour);
}

public class Main {
    public static void main(String[] args) {
        Fan fan = new Fan();
        Light light = new Light();

        Switchable[] devices = {fan, light};

        for (Switchable device : devices) {
            device.toggle();
        }

        SwitchRule rule1 = new SwitchRule() {
            public boolean maySwitchOn(Switchable device, int hour) {
                return hour >= 6 && hour <= 22;
            }
        };

        System.out.println(rule1.maySwitchOn(fan, 10));

        SwitchRule rule2 = (device, hour) -> hour >= 6 && hour <= 22;

        System.out.println(rule2.maySwitchOn(light, 23));
    }
}