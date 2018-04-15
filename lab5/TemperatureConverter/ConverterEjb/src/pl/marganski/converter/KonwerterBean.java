package pl.marganski.converter;

import javax.ejb.Stateless;

@Stateless
public class KonwerterBean implements Konwerter {
	public double fahrNaCels(double f) {
		return (5.0 / 9.0) * (f - 32);
	}

	public double celsNaFahr(double c) {
		return (9.0 / 5.0) * c + 32;
	}
}
