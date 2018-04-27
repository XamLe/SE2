
public class KonsolenVideospiel extends AbstractVideospiel {
	public KonsolenVideospiel(String titel, String kommentar, String system)
	{
		super(titel, kommentar, system);
	}
	
	int getPreisNachTagen(int tage) {
		int perioden = (tage) / 3;
		return 700 * perioden;
	}
}
