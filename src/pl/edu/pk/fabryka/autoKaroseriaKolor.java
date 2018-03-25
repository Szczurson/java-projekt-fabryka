package pl.edu.pk.fabryka;

public class autoKaroseriaKolor implements autoKaroseria
{
    private autoKaroseria kar;
    String kolor;
    
    public autoKaroseriaKolor(autoKaroseria kar, String kolor)
    {
        this.kar = kar;
        this.kolor = kolor;
    }

    @Override
    public void info()
    {
        System.out.println("Karoseria zostala pomalowana na piekny " + kolor + " kolor.");
    }  
}