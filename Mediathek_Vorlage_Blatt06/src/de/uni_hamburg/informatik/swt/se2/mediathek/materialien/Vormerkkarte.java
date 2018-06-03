package de.uni_hamburg.informatik.swt.se2.mediathek.materialien;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.Medium;

public class Vormerkkarte {
	private final Queue<Kunde> _vormerker;
	
	public Vormerkkarte()
	{
		_vormerker = new LinkedBlockingQueue<Kunde>();
	}
	
	public void kundeHinzufuegen(Kunde kunde)
	{
		assert istVormerkenMoeglich(kunde) : "nope.";
		_vormerker.add(kunde);
	}
	
	public void kundeEntfernen(Kunde kunde)
	{
		assert kunde != null : "Vorbedingung verletzt: null";

		_vormerker.remove(kunde);
	}
	
	public boolean istVormerkenMoeglich(Kunde kunde)
	{
		assert kunde != null : "Vorbedingung verletzt: null";

		return _vormerker.size() < 3 && !_vormerker.contains(kunde);
	}
	
	public Kunde[] getVormerker()
	{
		Kunde[] vormerker = new Kunde[3];
		return (Kunde[]) _vormerker.toArray(vormerker);
	}
	
	public Kunde getErsterVormerker()
	{
		return _vormerker.peek();
	}
}
