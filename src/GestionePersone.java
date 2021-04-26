import java.util.Scanner;
import java.io.File;
public class GestionePersone {
    private Persona []vettore;
    private int numEle=0;

    //costruttore di default
    public GestionePersone(){
        vettore= new Persona[1000];
        numEle=0;
    }

    //costrutore master
    public GestionePersone(int num){
        this();
        vettore=new Persona[num];
    }

    //costruttore master dato vettore
    public GestionePersone(Persona []vet){
        this();
        int i=0;
        boolean cond=false;
        while (i<vettore.length && cond==false) {
            if(vet[i]!=null){
                vettore[i]=new Persona(vet[i]);
                cond=true;
                numEle++;
            }i++;
        }
    }

    //Costruttore di copia
    public GestionePersone(GestionePersone v2){
        int i=0;
        boolean cond=false;
        while (i<vettore.length && cond==false) {
            if(v2.getPersona(i)!=null){
                vettore[i]= new Persona(v2.getPersona(i));
                cond=true;
                numEle++;
            }i++;
        }
}
//get numero elementi
public int getNumPersona() {
    return numEle;
}
//Get numero persona
 public Persona getPersona(int n){
    return vettore[n];
 }
//GetVettore
public String getVettore() {
    String s="";
    for (int i = 0; i < vettore.length; i++) {
        s+=vettore[i];
    }
    return s;
}
//get Altezze
public double[] getAltezza(){
    double[] vAlt = new double[numEle];
    for (int i = 0; i < numEle; i++) {
        vAlt[i] = vettore[i].getAltezza();
    }
    return vAlt;
}

public double[] getPeso(){
    double s[]=new double[numEle];
    for (int i = 0; i < numEle; i++) {
        s[i]=vettore[i].getPeso();
    
    }
    return s;
}


//AddPersona
public boolean addPersona(Persona p){
    boolean cond=false;
    if(vettore[numEle]==null){
        vettore[numEle] = new Persona(p);
        numEle++;
        cond=true;
    }
    return cond;
}

public boolean addPersona(int id,String nome,double altezza,double peso, boolean idoneo){
    boolean cond=false;
        if(vettore[numEle]==null){
            vettore[numEle]= new Persona(id, nome, altezza, peso, idoneo);
            numEle++;
            cond=true;
        }
    

    return cond;
}

//Delete Persona
public boolean delete(String nome){
    int i=0; 
    boolean cond=false;
    while (i<vettore.length && cond==false) {
        if(vettore[i]!=null && vettore[i].getNominativo().equals(nome)){
            vettore[i]=null;
            vettore[i]=vettore[numEle];
            numEle--;
            cond=true;
        }
        i++;
    }
    return cond;
}
public int contaPersone(){
    int contatore=0;
    while(contatore<numEle && vettore[contatore]!=null){
        contatore++;
    }
    return contatore;
}
public int cercaPersona(Persona p){
    int pos=0;
    while(pos<contaPersone() && !vettore[pos].getNominativo().equals(p.getNominativo())){
        pos++;
    }
    if(pos==contaPersone()){
        pos=-1;
    }
    return pos;
}

//EditPersona
public boolean editPersona(Persona p){
    int i=0;
    boolean cond=false;
    while (i<vettore.length && cond==false) {
        if(vettore[i]!=null && vettore[i].getNominativo().equals(p.getNominativo())){
            vettore[i].setAltezza(14);
            vettore[i].setIdoneo(true);
            vettore[i].setNominativo("Giuseppe");
            vettore[i].setPeso(74);
            cond=true;
        }i++;
    }return cond;
}
//Tostring
    public String toString(){
        String s="";
        for (int i = 0; i < vettore.length; i++) {
            s+="| "+vettore[i]+" |"+"\n";
        }
        return s;
    }
    //Cercapersona con String
    public boolean cercaPersona(String nome){
        int i=0;
        boolean cond=false;
        while (i<vettore.length && cond==false) {
            if(vettore[i]!=null){
                if(vettore[i].equals(new Persona(nome))){
                    cond=true;
                }
            }
            i++;
        }
        return cond;
    }

    //LINEARYSEARCH
    public int linearysearch(String nome){
        int i=0;
        int nCicliL=0;
        while(i<vettore.length && vettore[i].getNominativo().compareTo(nome)==0){
            i++;
            nCicliL++;
        }
        if(i==vettore.length){
            return -1;
        }
        else{
            return nCicliL;
        }
    }

   //metodo di sort in ordine alfabetico
   public void ordineAlfabetico()
   {
       boolean scambio=true;
       Persona tmp;
       while(scambio)
       {
           scambio=false;
           for (int i = 0; i < vettore.length-1; i++) 
           {
               if(vettore[i]!=null && vettore[i+1]!=null)
               {
                   if(vettore[i].getNominativo().compareTo(vettore[i+1].getNominativo())>0)
                   {
                       tmp=new Persona(vettore[i]);
                       vettore[i]=vettore[i+1];
                       vettore[i+1]=new Persona(tmp);

                       scambio=true;
                   }
               }
           }
       }
   }

   public boolean loadCSV(String nome){

       try {
           Scanner scanner = new Scanner(new File(nome)).useDelimiter(System.lineSeparator());
            scanner.next();
                while (scanner.hasNext()) {
                    String valori[]=scanner.next().split(";");
                    addPersona(Integer.valueOf(valori[0]), valori[1], Double.valueOf(valori[2]), Double.valueOf(valori[3]), Boolean.valueOf(valori[4]));
                    
                    }
            return true;
            }
        catch (Exception e) {
            System.out.println("Errore: "+e);
            return false;
       }
   }

}
