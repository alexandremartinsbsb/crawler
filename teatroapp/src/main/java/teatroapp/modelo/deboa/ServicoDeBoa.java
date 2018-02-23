package teatroapp.modelo.deboa;

public class ServicoDeBoa {

  private String data = new String();
  private String hora = new String();
  private String local = new String();

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public String getHora() {
    return hora;
  }

  public void setHora(String hora) {
    this.hora = hora;
  }

  public String getLocal() {
    return local;
  }

  public void setLocal(String local) {
    this.local = local;
  }

  @Override
  public String toString() {
    return "ServicoDeBoa [data=" + data + ", hora=" + hora + ", local=" + local + "]";
  }

}
