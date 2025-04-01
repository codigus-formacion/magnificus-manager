package magnificus.codigus;

class x {
    public static void m(){
        System.out.println("m de X");
    }
    public void n(){
        System.out.println("n de X");
    }
}

class y extends x {

    public static void m(){
        System.out.println("m de Y");
    }
    @Override
    public void n(){
        System.out.println("n de Y");
    }
}

class App {
    public static void main(String[] args){
        x r = new x();
        r.n();

    }
}
