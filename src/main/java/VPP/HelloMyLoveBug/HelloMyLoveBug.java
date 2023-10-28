package VPP.HelloMyLoveBug;

public class HelloMyLoveBug {
    public static void main(String[] args) {
        System.out.println(greeting("Mubashir"));
    }

    public static String greeting(String name){
        if(name.equalsIgnoreCase("Mubashir")){
            return "Hello, my Love!";
        }
        else return "Hello, " + name + "!";
    }
}

/*
public class Program {
    public static void main(String[] args) {
        System.out.println(greeting("Mubashir"));
    }

    public static String greeting(String name) {
        return "Hello, " + name + "!";
        if(name == "Mubashir") {
            return "Hello, my Love!";
        }
    }
}
 */