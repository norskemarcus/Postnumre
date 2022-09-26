package main;

public class Postinfo {

  private String by;
  private int postnummer;

  public Postinfo(int postnummer, String by) {
    this.postnummer = postnummer;
    this.by = by;
  }

  @Override
  public String toString() {
    return  "Postnummer: " + postnummer + " By: " + by;
  }


  public String getBy() {
    return by;
  }

  public void setBy(String by) {
    this.by = by;
  }

  public int getPostnummer() {
    return postnummer;
  }

  public void setPostnummer(int postnummer) {
    this.postnummer = postnummer;
  }
}
