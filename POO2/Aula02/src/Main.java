public class Main {
    public static void main(String[] args) {

        String msg = "Teste De Mensagem";

        ConverterString teste = new ComDataHoraNaFrente();

        String resultado = teste.converterString(msg);
        imprimirNormal(resultado);
    }

    public static void imprimirNormal (String msg){

        System.out.println(msg);
        imprimirAoContrario(msg);
    }

    public static void imprimirAoContrario(String msg){

        int tamanho = msg.length();

        for (int i=tamanho-1; i >=0; i-- ){
            System.out.print(msg.charAt(i));
        }
    }

}
