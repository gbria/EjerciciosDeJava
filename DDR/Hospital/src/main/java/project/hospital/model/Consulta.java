package project.hospital.model;

public class Consulta {
    private String data;
    private int hora;
    private Pacient pacient;
    private int consulta;

    public Consulta() {
        this.data = "";
        this.hora = 0;
        this.pacient = new Pacient();
        this.consulta = 0;
    }

    public Consulta(String data, int hora, Pacient pacient, int consulta) {
        this.data = data;
        this.hora = hora;
        this.pacient = pacient;
        this.consulta = consulta;
    }
}
