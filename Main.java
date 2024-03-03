// Abstract Product: Button
interface Button {
    void click();
}

// Concrete Products: WindowsButton and MacOSButton
class WindowsButton implements Button {
    @Override
    public void click() {
        System.out.println("Windows button clicked");
    }
}

class MacOSButton implements Button {
    @Override
    public void click() {
        System.out.println("MacOS button clicked");
    }
}

// Abstract Product: Checkbox
interface Checkbox {
    void check();
}

// Concrete Products: WindowsCheckbox and MacOSCheckbox
class WindowsCheckbox implements Checkbox {
    @Override
    public void check() {
        System.out.println("Windows checkbox checked");
    }
}

class MacOSCheckbox implements Checkbox {
    @Override
    public void check() {
        System.out.println("MacOS checkbox checked");
    }
}

// Abstract Factory
interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// Concrete Factories: WindowsFactory and MacOSFactory
class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

class MacOSFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}

// Client
public class Main {
    public static void main(String[] args) {
        // Create a Windows UI
        GUIFactory windowsFactory = new WindowsFactory();
        Button windowsButton = windowsFactory.createButton();
        windowsButton.click(); // Output: Windows button clicked
        Checkbox windowsCheckbox = windowsFactory.createCheckbox();
        windowsCheckbox.check(); // Output: Windows checkbox checked

        // Create a MacOS UI
        GUIFactory macOSFactory = new MacOSFactory();
        Button macOSButton = macOSFactory.createButton();
        macOSButton.click(); // Output: MacOS button clicked
        Checkbox macOSCheckbox = macOSFactory.createCheckbox();
        macOSCheckbox.check(); // Output: MacOS checkbox checked
    }
}
