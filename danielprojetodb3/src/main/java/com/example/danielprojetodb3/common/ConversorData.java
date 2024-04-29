package com.example.danielprojetodb3.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConversorData {
    public static String converterDateParaDatahora(Date data){
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/YY HH:mm:ss");
        return formatador.format(data);
    }
}
