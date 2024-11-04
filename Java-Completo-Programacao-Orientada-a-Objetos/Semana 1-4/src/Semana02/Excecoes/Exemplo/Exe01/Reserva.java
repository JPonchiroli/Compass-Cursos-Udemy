package Semana02.Excecoes.Exemplo.Exe01;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
    private int numeroQuarto;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reserva(){}

    public Reserva(int numeroQuarto, Date checkIn, Date checkOut) throws DomainException {
        if (!checkOut.after(checkIn)){
            throw new DomainException("Data de check-out deve ser depois da data de check-in");
        }

        this.numeroQuarto = numeroQuarto;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public long duracaoDias(){
        long diff = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public void atualizarDatas(Date checkIn, Date checkOut) throws DomainException{
        Date agora = new Date();
        if (checkIn.before(agora) || checkOut.before(agora)){
            throw new DomainException("As datas de atualização devem ser após a data atual");
        }
        if (!checkOut.after(checkIn)){
            throw new DomainException("Data de check-out deve ser depois da data de check-in");
        }

        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public int getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(int numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public Date getCheckin() {
        return checkIn;
    }

    public Date getCheckout() {
        return checkOut;
    }

    @Override
    public String toString() {
        return "Quarto: " + numeroQuarto +
                ", checkIn: " + sdf.format(checkIn) +
                ", checkOut: " + sdf.format(checkOut) +
                ", " + duracaoDias() + " dias";
    }
}
