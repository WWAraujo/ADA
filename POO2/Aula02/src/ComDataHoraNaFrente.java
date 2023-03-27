import java.time.LocalDateTime;

public class ComDataHoraNaFrente implements ConverterString{

    @Override
    public String converterString(String msg) {
        ConverterString novamudanca = new TudoMaiusculo();

        String msgTratada = LocalDateTime.now() +" "+ novamudanca.converterString(msg);
        return msgTratada;
    }
}
