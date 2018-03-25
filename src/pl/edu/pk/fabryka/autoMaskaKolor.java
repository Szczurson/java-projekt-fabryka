package pl.edu.pk.fabryka;

public class autoMaskaKolor implements autoMaska
{
    private autoMaska mask;
    String kolor;
    
    public autoMaskaKolor(autoMaska mask, String kolor)
    {
        this.mask = mask;
        this.kolor = kolor;
    }
    
    @Override
    public void info()
    {
        System.out.println("Maska zostala pomalowana na piekny " + kolor + " kolor.");
    }
}
