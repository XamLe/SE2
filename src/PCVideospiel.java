
public class PCVideospiel extends AbstractVideospiel {

	public PCVideospiel(String titel, String kommentar, String system)
	{
		super(titel, kommentar, system);
	}

	@Override
	int getPreisNachTagen(int tage) {
		if(tage > 7)
		{
			int perioden = 1 +  (tage - 7) / 5;
			return 500 * perioden;
		}
		return 0;
	}
}
