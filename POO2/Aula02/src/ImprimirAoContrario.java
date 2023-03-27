public class ImprimirAoContrario implements ConverterString{
    @Override
    public String converterString(String msg) {

        int tamanho = msg.length();

        for (int i=tamanho-1; i >=0; i-- ){
            System.out.print(msg.charAt(i));
        }
        return null;
    }
}
