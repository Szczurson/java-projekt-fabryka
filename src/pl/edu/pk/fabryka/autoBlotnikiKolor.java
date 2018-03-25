package pl.edu.pk.fabryka;

public class autoBlotnikiKolor implements autoBlotniki
{
    private autoBlotniki blot;
    String kolor;
    
    public autoBlotnikiKolor(autoBlotniki blot, String kolor)
    {
        this.blot = blot;
        this.kolor = kolor;
    }
    
    @Override
    public void info()
    {
        System.out.println("Blotniki zostaly pomalowane na piekny " + kolor + " kolor.");
    } 
}
