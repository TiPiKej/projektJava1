package com.company;

public class KartaPlatnicza extends KartaPlatniczaAbstract {
    private final long numerKarty;
    private final short PIN;
    protected double srodki;
    private Producenci producentKarty;

    public KartaPlatnicza(String imie, String nazwisko, long numerKarty, short PIN, double srodki) {
        super(imie, nazwisko);
        this.numerKarty = numerKarty;
        this.PIN = PIN;
        this.srodki = srodki;
    }

    public KartaPlatnicza(String imie, String nazwisko, String numerKarty, short PIN, double srodki) {
        super(imie, nazwisko);
        this.numerKarty = Long.parseLong(numerKarty);
        this.PIN = PIN;
        this.srodki = srodki;
    }

    public KartaPlatnicza() {
        super(null, null);
        this.numerKarty = -1;
        this.PIN = -1;
        this.srodki = -1;
    }

    public String getNumerKarty() {
        return String.format("%16d", numerKarty).replaceAll("\\s", "0");
    }

    public short getPIN() {
        return PIN;
    }

    public double getSrodki() {
        return srodki;
    }

    public Producenci getProducentKarty() {
        return producentKarty;
    }

    protected void setProducentKarty(Producenci producentKarty) {
        this.producentKarty = producentKarty;
    }

    public void wyswietlBalans() {
        System.out.printf("Masz %.2f pieniędzy na koncie!\n", srodki);
    }

    public void wyplacPieniadze(double wyplacanaKwota) throws NiewystarczajaceSrodkiException, ZeroWyplataException {
        if (wyplacanaKwota > srodki) {
            throw new NiewystarczajaceSrodkiException();
        } else if (wyplacanaKwota == 0) {
            throw new ZeroWyplataException();
        } else {
            System.out.println(Polaczenie);
            wyplacanie();
            System.out.printf("Wypłacono %.2f pieniędzy z konta!\n", wyplacanaKwota);
            srodki -= wyplacanaKwota;
        }
    }

    public void doliczSrodki(double noweSrodki) {
        System.out.println(Polaczenie);
        srodki += noweSrodki;
        System.out.printf("Wpłacono %.2f pieniędzy do konta\n", noweSrodki);
    }

    @Override
    public String toString() {
        return String.format("%s %s, %s, %d, %.2f, %s",
                getImie(), getNazwisko(), getNumerKarty(), getPIN(), getSrodki(), getProducentKarty());
    }

}
