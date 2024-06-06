package Dates;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;

public class MainDate {
    public static void main(String[] args) {

                System.out.println("********");
                System.out.println("1 Diferencia entre dos fechas\n");
                LocalDate date1 = LocalDate.of(2021, 1, 1);
                LocalDate date2 = LocalDate.of(2022, 12, 31);
                long dateFinal = date1.until(date2, ChronoUnit.DAYS);
                System.out.println("Diferencia en DÍAS de dos fechas: " + dateFinal);

                System.out.println("********");
                System.out.println("2 Convertir fechas a formato ISO\n");
                LocalDate dateFormatLocalDate = LocalDate.of(2024, 8, 30);
                DateTimeFormatter format = DateTimeFormatter.ISO_DATE;

                // * Aplica el formato especificado en DateTimeFormater
                String dateIsoFormat = dateFormatLocalDate.format(format);
                System.out.println("Fecha en formato ISO: " + dateIsoFormat);

                LocalDate dateIsoParse = LocalDate.parse(dateIsoFormat, DateTimeFormatter.ISO_DATE);
                System.out.println("Fecha en formato ISO tipo datatime: " + dateIsoParse);

                System.out.println("********");
                System.out.println("3 Valiar fechas:\n");

                DateTimeFormatter validateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String dateValidate = "12/30/2021";
                try {
                    LocalDate dateValidateParse = LocalDate.parse(dateValidate, validateFormat);
                    System.out.println("Fecha válida: " + dateValidateParse);
                } catch (Exception e) {
                    System.out.println("Fecha inválida");
                }

                System.out.println("********");
                System.out.println("4 Manejo de horarios de Paises diferentes:\n");


                ZonedDateTime zonedDateTime = ZonedDateTime.now();
                System.out.println("Zona horaria actual: " + zonedDateTime);

                ZonedDateTime zonedDateTimeParis = ZonedDateTime.now(ZoneId.of("Europe/Paris"));
                System.out.println("Zona horaria de Paris: " + zonedDateTimeParis);

                ZonedDateTime zonedDateTimeTokyo = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
                System.out.println("Zona horaria de Tokyo: " + zonedDateTimeTokyo);

                long DateTokyoVsParis = zonedDateTimeTokyo.toOffsetDateTime().getHour() - zonedDateTimeParis.toOffsetDateTime().getHour();
                System.out.println("Diferencia de horas entre Tokyo y Paris: " + DateTokyoVsParis);

                long DateParisVsBogota = zonedDateTimeParis.toOffsetDateTime().getHour() - zonedDateTime.toOffsetDateTime().getHour();
                System.out.println("Diferencia de horas entre Paris y Bogota: " + DateParisVsBogota);


    }
}
