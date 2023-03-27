public class TudoMaiusculo implements ConverterString{

    @Override
    public String converterString(String msg) {
        String msgTratada = msg.toUpperCase();
        return msgTratada;
    }
}
