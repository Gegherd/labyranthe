import java.io.*;

class ProtCom implements Runnable
{
  Serv _serv;
  BufferedReader _br;
  String _strCommande="";
  Thread _t;


  ProtCom(Serv serv)
  {
    _serv=serv;
    _br = new BufferedReader(new InputStreamReader(System.in));
    _t = new Thread(this);
    _t.start();
  }

  public void run()
  {
    try
    {
      while ((_strCommande=_br.readLine())!=null)
      {
        System.out.println("hello");
        if (_strCommande.equalsIgnoreCase("quit"))
          System.exit(0);
        else if(_strCommande.equalsIgnoreCase("total"))
        {
          System.out.println("Nombre de connectes : "+_serv.getNbClients());
          System.out.println("--------");
        }
        else if(_strCommande.equalsIgnoreCase("Genix"))
        {
          System.out.println("Il est le meilleur");
        }
        else
        {
          System.out.println("Cette commande n'est pas supportee");
          System.out.println("Quitter : \"quit\"");
          System.out.println("Nombre de connectes : \"total\"");
          System.out.println("--------");
        }
        System.out.flush();
      }
    }
    catch (IOException e) {}
  }
}