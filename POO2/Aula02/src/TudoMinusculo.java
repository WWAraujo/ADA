public class TudoMinusculo implements ConverterString{
    @Override
    public String converterString(String msg) {
        String msgTratada = msg.toLowerCase();
        return msgTratada;
    }
}
